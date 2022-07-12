package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizleaderboardswimup.ui.home.HomeFragment;

public class CompetitionPoolActivity extends AppCompatActivity {
    Button title1, title2, title3, title4, title5, title6, title7, title8, title9, title10, title11, title12;
    TextView content1, content2, content3, content4, content5, content6, content7, content8, content9, content10,
            content11, content12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_pool);

        title1 = findViewById(R.id.titleSize);
        content1 = findViewById(R.id.contentSize);
        title2 = findViewById(R.id.titleDepth);
        content2 = findViewById(R.id.contentDepth);
        title3 = findViewById(R.id.titleWalls);
        content3 = findViewById(R.id.contentWalls);
        title4 = findViewById(R.id.titleWaterTemperature);
        content4 = findViewById(R.id.contentWaterTemperature);
        title5 = findViewById(R.id.titleLanes);
        content5 = findViewById(R.id.contentLanes);
        title6 = findViewById(R.id.titleLaneRopes);
        content6 = findViewById(R.id.contentLaneRopes);
        title7 = findViewById(R.id.titleLaneMarkings);
        content7 = findViewById(R.id.contentLaneMarkings);
        title8 = findViewById(R.id.titleStartingPlatforms);
        content8 = findViewById(R.id.contentStartingPlatforms);
        title9 = findViewById(R.id.titleRules);
        content9 = findViewById(R.id.contentRules);
        title10 = findViewById(R.id.titleVolume);
        content10 = findViewById(R.id.contentVolume);
        title11 = findViewById(R.id.titleFeatures);
        content11 = findViewById(R.id.contentFeatures);
        title12 = findViewById(R.id.titleExtras);
        content12 = findViewById(R.id.contentExtras);

        content1.setVisibility(View.GONE);
        content2.setVisibility(View.GONE);
        content3.setVisibility(View.GONE);
        content4.setVisibility(View.GONE);
        content5.setVisibility(View.GONE);
        content6.setVisibility(View.GONE);
        content7.setVisibility(View.GONE);
        content8.setVisibility(View.GONE);
        content9.setVisibility(View.GONE);
        content10.setVisibility(View.GONE);
        content11.setVisibility(View.GONE);
        content12.setVisibility(View.GONE);

        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content1.getVisibility() == View.GONE){
                    content1.setVisibility(View.VISIBLE);
                }
                else{
                    content1.setVisibility(View.GONE);
                }
            }
        });

        title2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content2.getVisibility() == View.GONE){
                    content2.setVisibility(View.VISIBLE);
                }
                else{
                    content2.setVisibility(View.GONE);
                }
            }
        });

        title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content3.getVisibility() == View.GONE){
                    content3.setVisibility(View.VISIBLE);
                }
                else{
                    content3.setVisibility(View.GONE);
                }
            }
        });

        title4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content4.getVisibility() == View.GONE){
                    content4.setVisibility(View.VISIBLE);
                }
                else{
                    content4.setVisibility(View.GONE);
                }
            }
        });

        title5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content5.getVisibility() == View.GONE){
                    content5.setVisibility(View.VISIBLE);
                }
                else{
                    content5.setVisibility(View.GONE);
                }
            }
        });

        title6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content6.getVisibility() == View.GONE){
                    content6.setVisibility(View.VISIBLE);
                }
                else{
                    content6.setVisibility(View.GONE);
                }
            }
        });

        title7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content7.getVisibility() == View.GONE){
                    content7.setVisibility(View.VISIBLE);
                }
                else{
                    content7.setVisibility(View.GONE);
                }
            }
        });

        title8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content8.getVisibility() == View.GONE){
                    content8.setVisibility(View.VISIBLE);
                }
                else{
                    content8.setVisibility(View.GONE);
                }
            }
        });

        title9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content9.getVisibility() == View.GONE){
                    content9.setVisibility(View.VISIBLE);
                }
                else{
                    content9.setVisibility(View.GONE);
                }
            }
        });

        title10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content10.getVisibility() == View.GONE){
                    content10.setVisibility(View.VISIBLE);
                }
                else{
                    content10.setVisibility(View.GONE);
                }
            }
        });

        title11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content11.getVisibility() == View.GONE){
                    content11.setVisibility(View.VISIBLE);
                }
                else{
                    content11.setVisibility(View.GONE);
                }
            }
        });

        title12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content12.getVisibility() == View.GONE){
                    content12.setVisibility(View.VISIBLE);
                }
                else{
                    content12.setVisibility(View.GONE);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (CompetitionPoolActivity.this, HomeFragment.class);
        startActivity (intent);
        finishAffinity ();
    }
}