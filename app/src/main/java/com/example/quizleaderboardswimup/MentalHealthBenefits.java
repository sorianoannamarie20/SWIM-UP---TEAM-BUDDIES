package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MentalHealthBenefits extends AppCompatActivity {
    CardView name1, name2, name3, name4, name5;
    TextView caption1, caption2, caption3, caption4, caption5;
    ImageView backtoyou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_benefits);

        backtoyou = findViewById(R.id.backtoMental);
        name1 = findViewById(R.id.mindful);
        caption1 = findViewById(R.id.capMindful);
        name2 = findViewById(R.id.anxiety);
        caption2 = findViewById(R.id.capAnxiety);
        name3 = findViewById(R.id.mood);
        caption3 = findViewById(R.id.capMood);
        name4 = findViewById(R.id.self);
        caption4 = findViewById(R.id.capSelf);
        name5 = findViewById(R.id.out);
        caption5 = findViewById(R.id.capTime);



        caption1.setVisibility(View.GONE);
        caption2.setVisibility(View.GONE);
        caption3.setVisibility(View.GONE);
        caption4.setVisibility(View.GONE);
        caption5.setVisibility(View.GONE);


        name1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caption1.getVisibility() == View.GONE) {
                    caption1.setVisibility(View.VISIBLE);
                } else {
                    caption1.setVisibility(View.GONE);
                }

            }
        });

        name2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caption2.getVisibility() == View.GONE) {
                    caption2.setVisibility(View.VISIBLE);
                } else {
                    caption2.setVisibility(View.GONE);
                }

            }
        });

        name3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caption3.getVisibility() == View.GONE) {
                    caption3.setVisibility(View.VISIBLE);
                } else {
                    caption3.setVisibility(View.GONE);
                }

            }
        });

        name4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caption4.getVisibility() == View.GONE) {
                    caption4.setVisibility(View.VISIBLE);
                } else {
                    caption4.setVisibility(View.GONE);
                }

            }
        });

        name5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (caption5.getVisibility() == View.GONE) {
                    caption5.setVisibility(View.VISIBLE);
                } else {
                    caption5.setVisibility(View.GONE);
                }

            }
        });

        backtoyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recreate =  new Intent(MentalHealthBenefits.this, BenefitOfSwimingActivity.class);
                startActivity(recreate);
                finish();
            }
        });

    }
}