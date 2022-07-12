package com.example.quizleaderboardswimup;

import static com.example.quizleaderboardswimup.DbQuery.ANSWERED;
import static com.example.quizleaderboardswimup.DbQuery.NOT_VISITED;
import static com.example.quizleaderboardswimup.DbQuery.REVIEW;
import static com.example.quizleaderboardswimup.DbQuery.UNANSWERED;
import static com.example.quizleaderboardswimup.DbQuery.gQuestionList;
import static com.example.quizleaderboardswimup.DbQuery.g_quizList;
import static com.example.quizleaderboardswimup.DbQuery.g_selected_cat_index;
import static com.example.quizleaderboardswimup.DbQuery.g_selected_quiz_index;
import static com.example.quizleaderboardswimup.DbQuery.gcatList;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.quizleaderboardswimup.Adapter.QuestionAdapter;
import com.example.quizleaderboardswimup.Adapter.QuestionGridAdapter;
import com.example.quizleaderboardswimup.Adapter.QuizAdapter;

import java.util.concurrent.TimeUnit;


public class QuestionActivity extends AppCompatActivity {

    private RecyclerView questionsView;
    private TextView qaQuestionID, qaTimer, qacatName;
    private TextView submitA;
    private ImageView questionListG, highlightMark ;
    QuestionAdapter quesAdapter;
    private int quesID;
    private DrawerLayout drawer;
    private GridView quesGridView;
    private QuestionGridAdapter gridAdapter;
    private CountDownTimer timer;
    private long timeLeft;
    private ImageView bookMarkBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_list_layout);

        init();


        quesAdapter = new QuestionAdapter(gQuestionList);
        questionsView.setAdapter(quesAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        questionsView.setLayoutManager(layoutManager);

        gridAdapter = new QuestionGridAdapter(this, gQuestionList.size());
        quesGridView.setAdapter(gridAdapter);

        setSnapHelper();

        setClickListener();

        startTime();





    }


    private void init() {
        questionsView = findViewById(R.id.questions_view);
        qaQuestionID = findViewById(R.id.tv_quesID);
        qaTimer = findViewById(R.id.tvTimer);
        submitA = findViewById(R.id.submitB);
        qacatName = findViewById(R.id.qaCatName);
        questionListG = findViewById(R.id.quesListGrid);
        drawer = findViewById(R.id.drawer_layout);
        highlightMark =findViewById(R.id.highlightMarker);
        quesGridView = findViewById(R.id.quesGridView);
        bookMarkBtn = findViewById(R.id.qaBookmark);

        quesID = 0;
        qaQuestionID.setText("1/" + String.valueOf(gQuestionList.size()));
        qacatName.setText(gcatList.get(g_selected_cat_index).getName());

        gQuestionList.get(0).setStatus(UNANSWERED);

        if (gQuestionList.get(0).isBookmarkDone())
        {
            bookMarkBtn.setImageResource(R.drawable.ic_bookmark_selected);
        }else {
            bookMarkBtn.setImageResource(R.drawable.ic_baseline_bookmark_border_24);
        }


    }

    private void setSnapHelper() {

        final SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(questionsView);

        questionsView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                View view = snapHelper.findSnapView(recyclerView.getLayoutManager());
                quesID = recyclerView.getLayoutManager().getPosition(view);

                if (gQuestionList.get(quesID).getStatus() == NOT_VISITED)
                    gQuestionList.get(quesID).setStatus(UNANSWERED);

                if (gQuestionList.get(quesID).getStatus() == REVIEW)
                {
                    highlightMark.setVisibility(View.VISIBLE);
                }else {
                    highlightMark.setVisibility(View.GONE);
                }

                qaQuestionID.setText(String.valueOf(quesID + 1) + "/" + String.valueOf(gQuestionList.size()));

                if (gQuestionList.get(quesID).isBookmarkDone())
                {
                    bookMarkBtn.setImageResource(R.drawable.ic_bookmark_selected);
                }else {
                    bookMarkBtn.setImageResource(R.drawable.ic_baseline_bookmark_border_24);
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    private void setClickListener(){


        questionListG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (! drawer.isDrawerOpen(GravityCompat.END))
                {
                    gridAdapter.notifyDataSetChanged();
                    drawer.openDrawer(GravityCompat.END);
                }

            }
        });


        submitA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitQuiz();
            }
        });

        bookMarkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToBookmark();
            }
        });

    }
    private void submitQuiz(){
        AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this);
        builder.setCancelable(true);

        View view = getLayoutInflater().inflate(R.layout.alert_dialog_layout, null);
        TextView cancelB = view.findViewById(R.id.cancelB);
        TextView confirmB = view.findViewById(R.id.confirmB);

        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        cancelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        confirmB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                alertDialog.dismiss();
                Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
                long totalTime = g_quizList.get(g_selected_quiz_index).getTime()*60*1000;
                intent.putExtra("TIME_TAKEN", totalTime - timeLeft);
                startActivity(intent);
                QuestionActivity.this.finish();
            }
        });

        alertDialog.show();


    }

    public void goToQuestion(int position )
    {
        questionsView.smoothScrollToPosition(position);

        if (drawer.isDrawerOpen(GravityCompat.END))
            drawer.closeDrawer(GravityCompat.END);
    }


    private  void startTime()
    {
        long totalTime = g_quizList.get(g_selected_quiz_index).getTime()*60*1000;
        timer = new CountDownTimer(totalTime + 1000, 1000) {
            @Override
            public void onTick(long remainingTime) {
                timeLeft = remainingTime;
                String time = String.format("%02d:%02d min",
                        TimeUnit.MILLISECONDS.toMinutes(remainingTime),
                        TimeUnit.MILLISECONDS.toSeconds(remainingTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(remainingTime))

                        );

                qaTimer.setText(time);


            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
                long totalTime = g_quizList.get(g_selected_quiz_index).getTime()*60*1000;
                intent.putExtra("TIME_TAKEN", totalTime - timeLeft);
                startActivity(intent);
                QuestionActivity.this.finish();



            }
        };
        timer.start();
    }

    private void addToBookmark()
    {
        if (gQuestionList.get(quesID).isBookmarkDone())
        {
            gQuestionList.get(quesID).setBookmarkDone(false);
            bookMarkBtn.setImageResource(R.drawable.ic_baseline_bookmark_border_24);
        }
        else {
            gQuestionList.get(quesID).setBookmarkDone(true);
            bookMarkBtn.setImageResource(R.drawable.ic_bookmark_selected);
        }
    }



}

