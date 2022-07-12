package com.example.quizleaderboardswimup.ui.leaderboard;

import static com.example.quizleaderboardswimup.DbQuery.g_userList;
import static com.example.quizleaderboardswimup.DbQuery.g_usersCount;
import static com.example.quizleaderboardswimup.DbQuery.performanceR;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizleaderboardswimup.Adapter.RankAdapter;
import com.example.quizleaderboardswimup.DbQuery;
import com.example.quizleaderboardswimup.Interface.CompleteListener;
import com.example.quizleaderboardswimup.MainActivity;
import com.example.quizleaderboardswimup.QuizActivity;
import com.example.quizleaderboardswimup.R;

import java.util.Map;

public class LeaderboardFragment extends Fragment {
    private TextView totalUsers, txtImage, leadScore, leadRank, dialogText;
    private RecyclerView usersView;
    private RankAdapter rankAdapter;
    private Dialog progressDialog;



    public LeaderboardFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        initViews(view);

        progressDialog = new Dialog(getContext());
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogText = progressDialog.findViewById(R.id.diaglog_text);
        dialogText.setText("Loading....");

        progressDialog.show();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        usersView.setLayoutManager(layoutManager);

        rankAdapter = new RankAdapter(DbQuery.g_userList);
        usersView.setAdapter(rankAdapter);

        DbQuery.getTopUsers(new CompleteListener() {
            @Override
            public void onSuccess() {
                rankAdapter.notifyDataSetChanged();

                if (performanceR.getScore() !=0)
                {
                    if ( ! DbQuery.onTopList)
                    {
                        calculateRank();
                    }
                    leadScore.setText("Score: " + performanceR.getScore());
                    leadRank.setText("Rank: " + performanceR.getRank());

                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure() {
                Toast.makeText(getContext(), "Something went wrong, Try again", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });






       totalUsers.setText("Total Users :"  + DbQuery.g_usersCount);
        String userName = DbQuery.userProfile.getName();
        txtImage.setText(userName.toUpperCase().substring(0,1));




        return view;
    }

    private void initViews(View view)
    {
        totalUsers = view.findViewById(R.id.totalUsers);
        txtImage = view.findViewById(R.id.imageProfileTxtL);
        leadScore = view.findViewById(R.id.totalScoreLeaderboard);
        leadRank = view.findViewById(R.id.rankNumberLead);
        usersView = view.findViewById(R.id.usersView);

    }
    private void calculateRank()
    {
        int lowTopScore = g_userList.get(g_userList.size() - 1).getScore();
        int remainingSlots = g_usersCount - 20;

        int slot = (performanceR.getScore()*remainingSlots) / lowTopScore;
        int rank;
        if (lowTopScore != performanceR.getScore())
        {
            rank = g_usersCount - slot;
        }
        else {
            rank = 21;
        }

        performanceR.setRank(rank);



    }
}