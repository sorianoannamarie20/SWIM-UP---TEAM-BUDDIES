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

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {
    private List<QuestionModel> quesListModel;

    public AnswersAdapter(List<QuestionModel> quesListModel) {
        this.quesListModel = quesListModel;
    }

    @NonNull
    @Override
    public AnswersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answers_item_layout,parent, false);
        return new AnswersAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AnswersAdapter.ViewHolder holder, int position) {

        String ques = quesListModel.get(position).getQuestion();
        String a = quesListModel.get(position).getChoiceA();
        String b = quesListModel.get(position).getChoiceB();
        String c = quesListModel.get(position).getChoiceC();
        String d = quesListModel.get(position).getChoiceD();

        int selected = quesListModel.get(position).getSelectedAnswer();
        int ans = quesListModel.get(position).getCorrectAnswer();

        holder.setData(position, ques, a, b, c, d, selected, ans);



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
        private void setData(int pos, String ques, String a, String b, String c, String d, int selected, int correctAns)
        {
            quesNo.setText("Question No. : " + String.valueOf(pos+1));
            question.setText(ques);
            optionA.setText("A. " + a);
            optionB.setText("B. " + b);
            optionC.setText("C. " + c);
            optionD.setText("D. " + d);

            if (selected == -1)
            {
                result.setText("UN-ANSWERED");
                result.setTextColor(itemView.getContext().getResources().getColor(R.color.black));
                setOptionColor(selected , R.color.grey);
            }
            else{
                if ( selected == correctAns)
                {
                    result.setText("CORRECT");
                    result.setTextColor(itemView.getContext().getResources().getColor(R.color.blue2));
                    setOptionColor(selected, R.color.blue2);
                }
                else {
                    result.setText("WRONG");
                    result.setTextColor(itemView.getContext().getResources().getColor(R.color.red));
                    setOptionColor(selected, R.color.red);
                }
            }



        }

        private void setOptionColor(int selected, int color)
        {
           if (selected == 1)
           {
               optionA.setTextColor(itemView.getContext().getResources().getColor(color));
           }
           else {
               optionA.setTextColor(itemView.getContext().getResources().getColor(R.color.grey));

           }

            if (selected == 2)
            {
                optionB.setTextColor(itemView.getContext().getResources().getColor(color));
            }
            else {
                optionB.setTextColor(itemView.getContext().getResources().getColor(R.color.grey));

            }

            if (selected == 3)
            {
                optionC.setTextColor(itemView.getContext().getResources().getColor(color));
            }
            else {
                optionC.setTextColor(itemView.getContext().getResources().getColor(R.color.grey));

            }

            if (selected == 4)
            {
                optionD.setTextColor(itemView.getContext().getResources().getColor(color));
            }
            else {
                optionD.setTextColor(itemView.getContext().getResources().getColor(R.color.grey));

            }



        }


    }
}
