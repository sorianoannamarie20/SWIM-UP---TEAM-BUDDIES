package com.example.quizleaderboardswimup.ui.category;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quizleaderboardswimup.DbQuery;
import com.example.quizleaderboardswimup.QuizActivity;
import com.example.quizleaderboardswimup.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private List<CategoryModel> cat_list;

    public CategoryAdapter(List<CategoryModel> cat_list) {
        this.cat_list = cat_list;
    }

    @Override
    public int getCount() {
        return cat_list.size();
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
        View view1;

        if (view == null){
            view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cat_item_layout, viewGroup, false);


        }

        else {
            view1 = view;
        }

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbQuery.g_selected_cat_index = i;

                Intent intent = new Intent(view.getContext(), QuizActivity.class);

                view.getContext().startActivity(intent);

            }
        });

        TextView catName =  view1.findViewById(R.id.catName);
        TextView noOfQuiz = view1.findViewById(R.id.no_Qiz);

        catName.setText(cat_list.get(i).getName());
        noOfQuiz.setText(String.valueOf(cat_list.get(i).getNoOfQuiz()) + "\n Quiz");





        return view1;
    }
}
