package com.example.quizleaderboardswimup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizleaderboardswimup.Interface.CompleteListener;
import com.example.quizleaderboardswimup.Model.QuestionModel;

import java.util.concurrent.TimeUnit;

public class ScoreActivity extends AppCompatActivity {
    private TextView scoreS, timeS, totalQS, correctS, wrongS, unattemptedS, viewAnswerS;
    private Button  reattemptB;
    private long timeTaken;
    private Dialog progressDialog;
    private TextView dialogText;
    private int finalScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        getSupportActionBar().setTitle("Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressDialog = new Dialog(ScoreActivity.this);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogText = progressDialog.findViewById(R.id.diaglog_text);
        dialogText.setText("Loading....");
        progressDialog.show();

        init();

        loadData();

        setBookmarks();

        viewAnswerS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this, AnswersActivity.class);
                startActivity(intent);



            }
        });

        reattemptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reAttempt();


            }
        });

        saveResult();


    }

    private void init()
    {
        scoreS =  findViewById(R.id.score);
        timeS = findViewById(R.id.timeTa);
        totalQS =  findViewById(R.id.totalQues);
        correctS = findViewById(R.id.correctS);
        wrongS = findViewById(R.id.wrong);
        unattemptedS = findViewById(R.id.un_attempt);
        reattemptB =  findViewById(R.id.reattempt);
        viewAnswerS = findViewById(R.id.viewAnswer);
    }

    private void loadData(){
        int correctQ = 0, wrongQ = 0, unattemptQ = 0;

        for ( int i = 0; i < DbQuery.gQuestionList.size(); i++)
        {
            if (DbQuery.gQuestionList.get(i).getSelectedAnswer() == -1)
            {
                unattemptQ ++;
            }else
            {
                if ( DbQuery.gQuestionList.get(i).getSelectedAnswer() == DbQuery.gQuestionList.get(i).getCorrectAnswer())
                {
                    correctQ++;
                }
                else
                {
                    wrongQ++;
                }

            }

        }
        correctS.setText(String.valueOf(correctQ));
        wrongS.setText(String.valueOf(wrongQ));
        unattemptedS.setText(String.valueOf(unattemptQ));

        totalQS.setText(String.valueOf(DbQuery.gQuestionList.size()));

        finalScore = (correctQ*100) / DbQuery.gQuestionList.size();
        scoreS.setText(String.valueOf(finalScore));

        timeTaken = getIntent().getLongExtra("TIME_TAKEN", 0);

        String time = String.format("%02d:%02d min",
                TimeUnit.MILLISECONDS.toMinutes(timeTaken),
                TimeUnit.MILLISECONDS.toSeconds(timeTaken) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTaken))

        );

        timeS.setText(time);

    }

    private void reAttempt()
    {
        for (int i=0; i < DbQuery.gQuestionList.size(); i++ )
        {
            DbQuery.gQuestionList.get(i).setSelectedAnswer(-1);
            DbQuery.gQuestionList.get(i).setStatus(DbQuery.NOT_VISITED);
        }
        Intent intent = new Intent(ScoreActivity.this, StartQuizActivity.class);
        startActivity(intent);
        finish();
    }

    private void saveResult()
    {
        DbQuery.saveResult(finalScore, new CompleteListener() {
            @Override
            public void onSuccess() {
                progressDialog.dismiss();
            }

            @Override
            public void onFailure() {
                Toast.makeText(ScoreActivity.this, "Something went wrong, Try Again ", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
    private void setBookmarks()
    {
        for (int i=0; i < DbQuery.gQuestionList.size(); i++ )
        {
            QuestionModel question = DbQuery.gQuestionList.get(i);

            if (question.isBookmarkDone())
            {
                if ( ! DbQuery.g_bmIdList.contains(question.getqID()))
                {
                    DbQuery.g_bmIdList.add(question.getqID());
                    DbQuery.userProfile.setBookMarksCount(DbQuery.g_bmIdList.size());
                }
            }
            else
            {
                if (DbQuery.g_bmIdList.contains(question.getqID()))
                {
                    DbQuery.g_bmIdList.remove(question.getqID());
                    DbQuery.userProfile.setBookMarksCount(DbQuery.g_bmIdList.size());
                }

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home)
        {
            ScoreActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}