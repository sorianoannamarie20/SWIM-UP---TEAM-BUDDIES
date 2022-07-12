package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BodyBenefits extends AppCompatActivity {
    CardView benName1, benName2, benName3, benName4, benName5, benName6;
    TextView description1, description2, description3, description4, description5, description6;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_benefits);

        back = findViewById(R.id.backtoBodyBenefit);

        benName1 = findViewById(R.id.healthyHeart);
        description1 = findViewById(R.id.contentHealthyheart);
        benName2 = findViewById(R.id.betterSleep);
        description2 = findViewById(R.id.contentBettersleep);
        benName3 = findViewById(R.id.weightLoss);
        description3 = findViewById(R.id.contentWeightLoss);
        benName4 = findViewById(R.id.jointsHealth);
        description4 = findViewById(R.id.contentJointsHealth);
        benName5 = findViewById(R.id.strong);
        description5 = findViewById(R.id.contentStrong);
        benName6 = findViewById(R.id.clearBrain);
        description6 = findViewById(R.id.contentBrain);

        description1.setVisibility(View.GONE);
        description2.setVisibility(View.GONE);
        description3.setVisibility(View.GONE);
        description4.setVisibility(View.GONE);
        description5.setVisibility(View.GONE);
        description6.setVisibility(View.GONE);


        benName1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (description1.getVisibility() == View.GONE) {
                    description1.setVisibility(View.VISIBLE);
                } else {
                    description1.setVisibility(View.GONE);
                }

            }
        });

        benName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (description2.getVisibility() == View.GONE) {
                    description2.setVisibility(View.VISIBLE);
                } else {
                    description2.setVisibility(View.GONE);
                }

            }
        });

        benName3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (description3.getVisibility() == View.GONE) {
                    description3.setVisibility(View.VISIBLE);
                } else {
                    description3.setVisibility(View.GONE);
                }

            }
        });

        benName4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (description4.getVisibility() == View.GONE) {
                    description4.setVisibility(View.VISIBLE);
                } else {
                    description4.setVisibility(View.GONE);
                }

            }
        });

        benName5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (description5.getVisibility() == View.GONE) {
                    description5.setVisibility(View.VISIBLE);
                } else {
                    description5.setVisibility(View.GONE);
                }

            }
        });

        benName6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (description6.getVisibility() == View.GONE) {
                    description6.setVisibility(View.VISIBLE);
                } else {
                    description6.setVisibility(View.GONE);
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recreate =  new Intent(BodyBenefits.this, BenefitOfSwimingActivity.class);
                startActivity(recreate);
                finish();
            }
        });

    }
}