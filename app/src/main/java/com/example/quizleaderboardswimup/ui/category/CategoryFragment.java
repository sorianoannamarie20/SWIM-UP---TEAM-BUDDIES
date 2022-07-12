package com.example.quizleaderboardswimup.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quizleaderboardswimup.DbQuery;
import com.example.quizleaderboardswimup.MainActivity;
import com.example.quizleaderboardswimup.R;
import com.example.quizleaderboardswimup.databinding.FragmentCategoryBinding;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {
    private ListView catView;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);



        catView = view.findViewById(R.id.cat_Grid);

        //loadCategories();
        CategoryAdapter adapter = new CategoryAdapter(DbQuery.gcatList);
        catView.setAdapter(adapter);


        return view;
    }
}