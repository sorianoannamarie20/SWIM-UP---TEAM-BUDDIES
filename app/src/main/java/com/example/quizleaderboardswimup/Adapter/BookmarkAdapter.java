package com.example.quizleaderboardswimup.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizleaderboardswimup.Model.QuestionModel;
import com.example.quizleaderboardswimup.R;

import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder> {
    private List<QuestionModel> quesListModel;

    public BookmarkAdapter(List<QuestionModel> quesListModel) {
        this.quesListModel = quesListModel;
    }

    @NonNull
    @Override
    public BookmarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answers_item_layout,parent, false);
        return new BookmarkAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkAdapter.ViewHolder holder, int position) {

        String ques = quesListModel.get(position).getQuestion();
        String a = quesListModel.get(position).getChoiceA();
        String b = quesListModel.get(position).getChoiceB();
        String c = quesListModel.get(position).getChoiceC();
        String d = quesListModel.get(position).getChoiceD();


        int ans = quesListModel.get(position).getCorrectAnswer();

        holder.setData(position, ques, a, b, c, d, ans);



    }

    @Override
    public int getItemCount() {
        return quesListModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView quesNo, question, optionA, optionB, optionC, optionD, result;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            quesNo = itemView.findViewById(R.id.questionNumberA);
            question = itemView.findViewById(R.id.questionAnswer);
            optionA = itemView.findViewById(R.id.optionA);
            optionB = itemView.findViewById(R.id.optionB);
            optionC = itemView.findViewById(R.id.optionC);
            optionD = itemView.findViewById(R.id.optionD);
            result = itemView.findViewById(R.id.resultA);
        }
        private void setData(int pos, String ques, String a, String b, String c, String d, int correctAns)
        {
            quesNo.setText("Question No. : " + String.valueOf(pos+1));
            question.setText(ques);
            optionA.setText("A. " + a);
            optionB.setText("B. " + b);
            optionC.setText("C. " + c);
            optionD.setText("D. " + d);

            if ( correctAns == 1){
                result.setText("ANSWER : " + a);
            }
            else if ( correctAns == 2){
                result.setText("ANSWER : " + b);
            }
            else if ( correctAns == 3){
                result.setText("ANSWER : " + c);
            }
            else
                result.setText("ANSWER : " + d);
            }




        }

}
