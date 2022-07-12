package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SkillsBenefit extends AppCompatActivity {
    CardView sBen1, sBen2, sBen3;
    TextView definition1, definition2, definition3;
    ImageView backtoS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_benefit);

        backtoS = findViewById(R.id.backtoS);

        sBen1 = findViewById(R.id.survival);
        definition1 = findViewById(R.id.defSurvival);
        sBen2 = findViewById(R.id.motor);
        definition2 = findViewById(R.id.defMotor);
        sBen3 = findViewById(R.id.social);
        definition3 = findViewById(R.id.defSocial);


        definition1.setVisibility(View.GONE);
        definition2.setVisibility(View.GONE);
        definition3.setVisibility(View.GONE);

        sBen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (definition1.getVisibility() == View.GONE) {
                    definition1.setVisibility(View.VISIBLE);
                } else {
                    definition1.setVisibility(View.GONE);
                }

            }
        });

        sBen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (definition2.getVisibility() == View.GONE) {
                    definition2.setVisibility(View.VISIBLE);
                } else {
                    definition2.setVisibility(View.GONE);
                }

            }
        });

        sBen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (definition3.getVisibility() == View.GONE) {
                    definition3.setVisibility(View.VISIBLE);
                } else {
                    definition3.setVisibility(View.GONE);
                }

            }
        });

        backtoS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recreate =  new Intent(SkillsBenefit.this, BenefitOfSwimingActivity.class);
                startActivity(recreate);
                finish();
            }
        });

    }
}