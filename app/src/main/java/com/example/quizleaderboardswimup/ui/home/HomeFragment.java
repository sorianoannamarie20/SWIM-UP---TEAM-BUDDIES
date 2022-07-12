package com.example.quizleaderboardswimup.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quizleaderboardswimup.BasicSkillsActivity;
import com.example.quizleaderboardswimup.BenefitOfSwimingActivity;
import com.example.quizleaderboardswimup.CompetitionPoolActivity;
import com.example.quizleaderboardswimup.DivingActivity;
import com.example.quizleaderboardswimup.EquipmentsActivity;
import com.example.quizleaderboardswimup.FirstAidActivity;
import com.example.quizleaderboardswimup.HistoryActivity;
import com.example.quizleaderboardswimup.OverviewActivity;
import com.example.quizleaderboardswimup.R;
import com.example.quizleaderboardswimup.RulesActivity;
import com.example.quizleaderboardswimup.WaterSurvivalActivity;

public class HomeFragment extends Fragment {
    ListView lv;
    String[] topic = {"Overview", "History", "Equipments","Facilities", "Basic Skills", "Diving", "Rules", "Benefits", "Water Survival", "First Aid"};
    String [] caption = {"Swimming Events", "Important Date and Events in development of the swimming", "Equipment in Swimming", "Standard pools", "Significant events in swimming", "Diving in Swimming",  "Basic Rules in swimming", "Significant events in swimming",
    "Introduction to Water Survival", "Artificial Respiratory and Cardiopulmonary Resuscitation"};
    int[] topicImages ={R.drawable.icon_overview,R.drawable.ic_icon_history, R.drawable.iconequipments, R.drawable.icon_pool, R.drawable.iconskills, R.drawable.diving,
            R.drawable.iconrules, R.drawable.iconbenefits, R.drawable.icon_survival, R.drawable.icon_first_aid};



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        lv = (ListView) view.findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter();
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent(getActivity(), OverviewActivity.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(getActivity(), HistoryActivity.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(getActivity(), EquipmentsActivity.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(getActivity(), CompetitionPoolActivity.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(getActivity(), BasicSkillsActivity.class);
                    startActivity(intent);
                }
                if (i == 5) {
                    Intent intent = new Intent(getActivity(), DivingActivity.class);
                    startActivity(intent);
                }
                if (i == 6) {
                    Intent intent = new Intent(getActivity(), RulesActivity.class);
                    startActivity(intent);
                }
                if (i == 7) {
                    Intent intent = new Intent(getActivity(), BenefitOfSwimingActivity.class);
                    startActivity(intent);
                }
                if (i == 8){
                    Intent intent = new Intent(getActivity(), WaterSurvivalActivity.class);
                    startActivity(intent);
                }
                if (i == 9){
                    Intent intent = new Intent(getActivity(), FirstAidActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    private class ArrayAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return topicImages.length;
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView name = view1.findViewById(R.id.topic);
            ImageView image = view1.findViewById(R.id.images);
            TextView se = view1.findViewById(R.id.significant);

            name.setText(topic[i]);
            image.setImageResource(topicImages[i]);
            se.setText(caption[i]);
            return view1;
        }
    }
}