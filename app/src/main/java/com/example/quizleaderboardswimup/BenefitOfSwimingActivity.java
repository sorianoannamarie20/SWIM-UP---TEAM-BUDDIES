package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quizleaderboardswimup.ui.home.HomeFragment;

public class BenefitOfSwimingActivity extends AppCompatActivity {
    CardView bodyBen, mentalBen, skillBen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefit_of_swiming);

        bodyBen = findViewById(R.id.cardViewBody);
        mentalBen = findViewById(R.id.cardViewMental);
        skillBen = findViewById(R.id.cardViewSkill);


        bodyBen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent read =  new Intent(BenefitOfSwimingActivity.this, BodyBenefits.class);
                startActivity(read);
                finish();
            }
        });

        mentalBen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent early =  new Intent(BenefitOfSwimingActivity.this, MentalHealthBenefits.class);
                startActivity(early);
                finish();

            }
        });

        skillBen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent first =  new Intent(BenefitOfSwimingActivity.this, SkillsBenefit.class);
                startActivity(first);
                finish();
            }
        });



    }
}