package com.example.quizleaderboardswimup;

import static com.example.quizleaderboardswimup.DbQuery.gcatList;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizleaderboardswimup.Interface.CompleteListener;

public class StartQuizActivity extends AppCompatActivity {
    TextView catName, quizNo, totalQ, bestScore, time;
    TextView startQuiz;
    ImageView backB;
    private Dialog progressDialog;
    private TextView dialogText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        init();

        progressDialog = new Dialog(StartQuizActivity.this);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogText = progressDialog.findViewById(R.id.diaglog_text);
        dialogText.setText("Loading....");

        progressDialog.show();

        DbQuery.loadQuestions(new CompleteListener() {
            @Override
            public void onSuccess() {
                setData();
                progressDialog.dismiss();

            }


            @Override
            public void onFailure() {
                progressDialog.dismiss();
                Toast.makeText(StartQuizActivity.this, "Something Went Wrong, Try Again!", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void init()
    {
        catName = findViewById(R.id.stCatname);
        quizNo = findViewById(R.id.stQuizno);
        totalQ = findViewById(R.id.stTotalQuestion);
        bestScore = findViewById(R.id.stBestScore);
        time = findViewById(R.id.stTime);
        startQuiz = findViewById(R.id.startQuiz);
        backB = findViewById(R.id.st_back);

        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartQuizActivity.this.finish();
            }
        });

        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartQuizActivity.this, QuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void setData() {
        catName.setText(gcatList.get(DbQuery.g_selected_cat_index).getName());
        quizNo.setText("Quiz No." + String.valueOf(DbQuery.g_selected_quiz_index + 1));
        totalQ.setText(String.valueOf(DbQuery.gQuestionList.size()));
        bestScore.setText(String.valueOf(DbQuery.g_quizList.get(DbQuery.g_selected_quiz_index).getTopscore()));
        time.setText(String.valueOf(DbQuery.g_quizList.get(DbQuery.g_selected_quiz_index).getTime()));


    }
}