package com.example.quizleaderboardswimup.Adapter;

import static com.example.quizleaderboardswimup.DbQuery.ANSWERED;
import static com.example.quizleaderboardswimup.DbQuery.REVIEW;
import static com.example.quizleaderboardswimup.DbQuery.UNANSWERED;
import static com.example.quizleaderboardswimup.DbQuery.gQuestionList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizleaderboardswimup.DbQuery;
import com.example.quizleaderboardswimup.Model.QuestionModel;
import com.example.quizleaderboardswimup.R;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{
    private  List<QuestionModel> questionModelList;

    public QuestionAdapter(List<QuestionModel> questionModelList) {
        this.questionModelList = questionModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position);

    }

    @Override
    public int getItemCount() {
        return questionModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView ques;
        private TextView optionA, optionB, optionC, optionD, prevSelectedB ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ques = itemView.findViewById(R.id.question);
            optionA = itemView.findViewById(R.id.choiceA);
            optionB = itemView.findViewById(R.id.choiceB);
            optionC = itemView.findViewById(R.id.choiceC);
            optionD = itemView.findViewById(R.id.choiceD);
            prevSelectedB = null;
        }

        private void setData(final int pos){
            ques.setText(questionModelList.get(pos).getQuestion());
            optionA.setText(questionModelList.get(pos).getChoiceA());
            optionB.setText(questionModelList.get(pos).getChoiceB());
            optionC.setText(questionModelList.get(pos).getChoiceC());
            optionD.setText(questionModelList.get(pos).getChoiceD());

            setOption(optionA, 1, pos);
            setOption(optionB, 2, pos);
            setOption(optionC, 3, pos);
            setOption(optionD, 4, pos);



            optionA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    selectOption(optionA,1, pos );
                }
            });

            optionB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectOption(optionB,2, pos );

                }
            });
            optionC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectOption(optionC,3, pos );
                }
            });

            optionD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectOption(optionD,4, pos );
                }
            });
        }

        private void selectOption(TextView btn, int option_num, int quesID){
            if (prevSelectedB == null){
                btn.setBackgroundResource(R.drawable.selected_btn);
                DbQuery.gQuestionList.get(quesID).setSelectedAnswer(option_num);

                changeStatus(quesID, ANSWERED);

                prevSelectedB = btn;


            }else {

                if (prevSelectedB.getId() == btn.getId())
                {
                    btn.setBackgroundResource(R.drawable.unselected_btn);
                    DbQuery.gQuestionList.get(quesID).setSelectedAnswer(-1);

                    changeStatus(quesID, UNANSWERED);
                    prevSelectedB = null;
                }
                else {

                    prevSelectedB.setBackgroundResource(R.drawable.unselected_btn);
                    btn.setBackgroundResource(R.drawable.selected_btn);
                    DbQuery.gQuestionList.get(quesID).setSelectedAnswer(option_num);
                    changeStatus(quesID, ANSWERED);
                    prevSelectedB=btn;
                }



            }

        }
        private void changeStatus(int id, int status)
        {
            if ( gQuestionList.get(id).getStatus() != REVIEW)
            {
                gQuestionList.get(id).setStatus(status);
            }
        }

        private void setOption(TextView btn, int option_num, int quesID){
            if (DbQuery.gQuestionList.get(quesID).getSelectedAnswer() == option_num)
            {
                btn.setBackgroundResource(R.drawable.selected_btn);
            }
            else {
                btn.setBackgroundResource(R.drawable.unselected_btn);

            }


        }
    }

}
