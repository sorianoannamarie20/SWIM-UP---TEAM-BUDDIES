package com.example.quizleaderboardswimup.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizleaderboardswimup.DbQuery;
import com.example.quizleaderboardswimup.Model.QuizModel;
import com.example.quizleaderboardswimup.QuestionActivity;
import com.example.quizleaderboardswimup.QuizActivity;
import com.example.quizleaderboardswimup.R;
import com.example.quizleaderboardswimup.StartQuizActivity;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {
    private List<QuizModel> quizList;

    public QuizAdapter(List<QuizModel> quizList) {
        this.quizList = quizList;
    }

    @NonNull
    @Override
    public QuizAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item_layout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizAdapter.ViewHolder holder, int position) {
        int progress =  quizList.get(position).getTopscore();
        holder.setData(position, progress);

    }

    @Override
    public int getItemCount() {
        return quizList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView quizNo;
        private TextView topscore;
        private ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            quizNo = itemView.findViewById(R.id.quizNo);
            topscore = itemView.findViewById(R.id.score);
            progressBar = itemView.findViewById(R.id.quizProgressBar);


        }

        public void setData(int pos, int progress) {
            quizNo.setText("Quiz No:" + String.valueOf(pos + 1));
            topscore.setText(String.valueOf(progress) + "%");

            progressBar.setProgress(progress);


            itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  DbQuery.g_selected_quiz_index = pos;

                 Intent intent = new Intent(view.getContext(), StartQuizActivity.class);
                 view.getContext().startActivity(intent);
               }
           });




        }
    }
}
