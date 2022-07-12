package com.example.quizleaderboardswimup.ui.account;

import static com.example.quizleaderboardswimup.DbQuery.g_userList;
import static com.example.quizleaderboardswimup.DbQuery.g_usersCount;
import static com.example.quizleaderboardswimup.DbQuery.performanceR;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quizleaderboardswimup.BookmarkActivity;
import com.example.quizleaderboardswimup.DbQuery;
import com.example.quizleaderboardswimup.EditProfileActivity;
import com.example.quizleaderboardswimup.Interface.CompleteListener;
import com.example.quizleaderboardswimup.Login;
import com.example.quizleaderboardswimup.R;
import com.example.quizleaderboardswimup.ui.leaderboard.LeaderboardFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class AccountFragment extends Fragment {

    private  LinearLayout logoutB;
    private TextView profileImageT, name, score, rank, dialogText;
    private LinearLayout profileA, bookmarkA;
    private Dialog progressDialog;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        initView(view);

        progressDialog = new Dialog(getContext());
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogText = progressDialog.findViewById(R.id.diaglog_text);
        dialogText.setText("Loading....");



        String userName = DbQuery.userProfile.getName();
        profileImageT.setText(userName.toUpperCase().substring(0,1));


        name.setText(userName);

        score.setText(String.valueOf(DbQuery.performanceR.getScore()));

        if (DbQuery.g_userList.size() == 0)
        {
            progressDialog.show();
            DbQuery.getTopUsers(new CompleteListener() {
                @Override
                public void onSuccess() {


                    if (performanceR.getScore() !=0)
                    {
                        if ( ! DbQuery.onTopList)
                        {
                            calculateRank();
                        }
                        score.setText("Score: " + performanceR.getScore());
                        rank.setText("Rank: " + performanceR.getRank());

                    }
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure() {
                    Toast.makeText(getContext(), "Something went wrong, Try again", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            });

        }
        else {
            score.setText("Score: " + performanceR.getScore());
            if (performanceR.getScore() != 0)
              rank.setText("Rank: " + performanceR.getRank());

        }


        logoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build();

                GoogleSignInClient mGoogleClient = GoogleSignIn.getClient(getContext(), gso);
                mGoogleClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Intent intent = new Intent(getContext(), Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                        getActivity().finish();




                    }
                });



            }
        });

        profileA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }
    private void initView(View view){
        logoutB = view.findViewById(R.id.logoutB);
        profileImageT = view.findViewById(R.id.profileImg);
        name = view.findViewById(R.id.profileNameAccount);
        score = view.findViewById(R.id.totalScoreAccount);
        rank = view.findViewById(R.id.rankingAccount);
        profileA = view.findViewById(R.id.profileBAccount);


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