package com.example.quizleaderboardswimup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizleaderboardswimup.Adapter.QuizAdapter;
import com.example.quizleaderboardswimup.Interface.CompleteListener;
import com.example.quizleaderboardswimup.Model.QuizModel;
import com.example.quizleaderboardswimup.ui.category.CategoryFragment;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private RecyclerView quizView;
    private Toolbar toolbar;
    private QuizAdapter adapter;
    private Dialog progressDialog;
    private TextView dialogText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        getSupportActionBar().setTitle(DbQuery.gcatList.get(DbQuery.g_selected_cat_index).getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        quizView = findViewById(R.id.quiz_recycle_view);

        progressDialog = new Dialog(QuizActivity.this);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogText = progressDialog.findViewById(R.id.diaglog_text);
        dialogText.setText("Loading....");

        progressDialog.show();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        quizView.setLayoutManager(layoutManager);


        DbQuery.loadQuizData(new CompleteListener() {
            @Override
            public void onSuccess() {

                DbQuery.loadScore(new CompleteListener() {
                    @Override
                    public void onSuccess() {

                        adapter = new QuizAdapter(DbQuery.g_quizList);
                        quizView.setAdapter(adapter);

                        progressDialog.dismiss();


                    }

                    @Override
                    public void onFailure() {

                        progressDialog.dismiss();
                        Toast.makeText(QuizActivity.this, "Something Went Wrong, Try Again!", Toast.LENGTH_SHORT).show();


                    }
                });

            }

            @Override
            public void onFailure() {
                progressDialog.dismiss();
                Toast.makeText(QuizActivity.this, "Something Went Wrong, Try Again!", Toast.LENGTH_SHORT).show();


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home)
        {
            QuizActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}