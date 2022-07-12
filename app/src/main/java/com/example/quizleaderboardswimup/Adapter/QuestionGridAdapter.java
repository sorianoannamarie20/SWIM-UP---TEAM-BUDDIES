package com.example.quizleaderboardswimup.Adapter;

import static com.example.quizleaderboardswimup.DbQuery.ANSWERED;
import static com.example.quizleaderboardswimup.DbQuery.NOT_VISITED;
import static com.example.quizleaderboardswimup.DbQuery.REVIEW;
import static com.example.quizleaderboardswimup.DbQuery.UNANSWERED;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.quizleaderboardswimup.DbQuery;
import com.example.quizleaderboardswimup.QuestionActivity;
import com.example.quizleaderboardswimup.R;

public class QuestionGridAdapter extends BaseAdapter {
    private int numOfQues;
    private Context context;

    public QuestionGridAdapter(Context context, int numOfQues) {
        this.numOfQues = numOfQues;
        this.context = context;
    }

    @Override
    public int getCount() {
        return numOfQues;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View gaView;

        if (view == null)
        {
            gaView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ques_grid_item, viewGroup, false);


        }else {
            gaView = view;

        }

        gaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (context instanceof QuestionActivity)
                    ((QuestionActivity)context).goToQuestion(i);


            }
        });
        TextView quesGrid = gaView.findViewById(R.id.quesNum);
        quesGrid.setText(String.valueOf(i + 1));

        Log.d("LOGGGGGGGGGGGG", String.valueOf(DbQuery.gQuestionList.get(i).getStatus()));
        switch (DbQuery.gQuestionList.get(i).getStatus())
        {
            case NOT_VISITED:
                     quesGrid.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(gaView.getContext(), R.color.grey)));
                     break;

            case UNANSWERED:
                quesGrid.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(gaView.getContext(), R.color.red)));
                break;

            case ANSWERED:
                quesGrid.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(gaView.getContext(), R.color.purple_200)));
                break;

            case REVIEW:
                quesGrid.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(gaView.getContext(), R.color.royalBlue)));
                break;

            default:
                break;
        }

        return gaView;
    }
}
