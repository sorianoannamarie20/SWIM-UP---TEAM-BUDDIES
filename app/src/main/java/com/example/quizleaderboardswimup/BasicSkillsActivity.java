package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class BasicSkillsActivity extends AppCompatActivity {
    CardView title1, title2, title3, title4, title5, title6, title7, title8, title9, title10, title11, title12;
    TextView content1, content2, content3, content4, content5, content6, content7, content8, content9, content10, content11, content12;
    View header1, header2, header3, header4, header5, header6, header7, header8, header9, header10, header11, header12;
    ImageView image1, image2, image3;
    GifImageView gif1, gif2, gif3, gif4, gif5, gif6, gif7, gif8, gif9 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_skills);

        title1 = findViewById(R.id.bubble);
        content1 = findViewById(R.id.contentBubble);
        header1 = findViewById(R.id.header);
        image1 = findViewById(R.id.imageBubble);
        title2 = findViewById(R.id.back);
        content2 = findViewById(R.id.contentBack);
        header2 = findViewById(R.id.headerBack);
        gif1 = findViewById(R.id.gifBack);
        title3 = findViewById(R.id.deadbody);
        content3 = findViewById(R.id.contentDeadbody);
        header3 = findViewById(R.id.headerDeadbody);
        gif2 = findViewById(R.id.gifDeadbody);
        title4 = findViewById(R.id.jellyFish);
        content4 = findViewById(R.id.contentjellyFish);
        header4 = findViewById(R.id.headerjellyFish);
        image2 = findViewById(R.id.imagejellyFish);
        title5 = findViewById(R.id.tucked);
        content5 = findViewById(R.id.contenttucked);
        header5 = findViewById(R.id.headertucked);
        image3 = findViewById(R.id.imagetucked);
        title6 = findViewById(R.id.dolphin);
        content6 = findViewById(R.id.contentDolphin);
        header6 = findViewById(R.id.headerDolphin);
        gif3 = findViewById(R.id.gifDolphin);
        title7 = findViewById(R.id.flutter);
        content7 = findViewById(R.id.contentFlutter);
        header7 = findViewById(R.id.headerFlutter);
        gif4 = findViewById(R.id.gifFlutter);
        title8 = findViewById(R.id.frog);
        content8 = findViewById(R.id.contentFrog);
        header8 = findViewById(R.id.headerFrog);
        gif5 = findViewById(R.id.gifFrog);
        title9 = findViewById(R.id.backstroke);
        content9 = findViewById(R.id.contentBackstroke);
        header9 = findViewById(R.id.headerBackstroke);
        gif6 = findViewById(R.id.gifBackstroke);
        title10 = findViewById(R.id.breaststroke);
        content10 = findViewById(R.id.contentBreaststroke);
        header10 = findViewById(R.id.headerBreaststroke);
        gif7 = findViewById(R.id.gifBreaststroke);
        title11 = findViewById(R.id.butterfly);
        content11 = findViewById(R.id.contentButterfly);
        header11 = findViewById(R.id.headerButterfly);
        gif8 = findViewById(R.id.gifButterfly);
        title12 = findViewById(R.id.crawl);
        content12 = findViewById(R.id.contentCrawl);
        header12 = findViewById(R.id.headerCrawl);
        gif9 = findViewById(R.id.gifCrawl);



        content1.setVisibility(View.GONE);
        header1.setVisibility(View.GONE);
        image1.setVisibility(View.GONE);
        content2.setVisibility(View.GONE);
        header2.setVisibility(View.GONE);
        gif1.setVisibility(View.GONE);
        content3.setVisibility(View.GONE);
        header3.setVisibility(View.GONE);
        gif2.setVisibility(View.GONE);
        content4.setVisibility(View.GONE);
        header4.setVisibility(View.GONE);
        image2.setVisibility(View.GONE);
        content5.setVisibility(View.GONE);
        header5.setVisibility(View.GONE);
        image3.setVisibility(View.GONE);
        content6.setVisibility(View.GONE);
        header6.setVisibility(View.GONE);
        gif3.setVisibility(View.GONE);
        content7.setVisibility(View.GONE);
        header7.setVisibility(View.GONE);
        gif4.setVisibility(View.GONE);
        content8.setVisibility(View.GONE);
        header8.setVisibility(View.GONE);
        gif5.setVisibility(View.GONE);
        content9.setVisibility(View.GONE);
        header9.setVisibility(View.GONE);
        gif6.setVisibility(View.GONE);
        content10.setVisibility(View.GONE);
        header10.setVisibility(View.GONE);
        gif7.setVisibility(View.GONE);
        content11.setVisibility(View.GONE);
        header11.setVisibility(View.GONE);
        gif8.setVisibility(View.GONE);
        content12.setVisibility(View.GONE);
        header12.setVisibility(View.GONE);
        gif9.setVisibility(View.GONE);



        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content1.getVisibility() == View.GONE){
                    content1.setVisibility(View.VISIBLE) ;
                }
                else{
                    content1.setVisibility(View.GONE);
                }
                if(header1.getVisibility() == View.GONE){
                    header1.setVisibility(View.VISIBLE) ;
                }
                else{
                    header1.setVisibility(View.GONE);
                }
                if(image1.getVisibility() == View.GONE){
                    image1.setVisibility(View.VISIBLE) ;
                }
                else{
                    image1.setVisibility(View.GONE);
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
                if(header2.getVisibility() == View.GONE){
                    header2.setVisibility(View.VISIBLE) ;
                }
                else{
                    header2.setVisibility(View.GONE);
                }
                if(gif1.getVisibility() == View.GONE){
                    gif1.setVisibility(View.VISIBLE) ;
                }
                else{
                    gif1.setVisibility(View.GONE);
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
                if(header3.getVisibility() == View.GONE){
                    header3.setVisibility(View.VISIBLE) ;
                }
                else{
                    header3.setVisibility(View.GONE);
                }
                if(gif2.getVisibility() == View.GONE){
                    gif2.setVisibility(View.VISIBLE) ;
                }
                else{
                    gif2.setVisibility(View.GONE);
                }

            }
        });

        title4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content4.getVisibility() == View.GONE){
                    content4.setVisibility(View.VISIBLE) ;
                }
                else{
                    content4.setVisibility(View.GONE);
                }
                if(header4.getVisibility() == View.GONE){
                    header4.setVisibility(View.VISIBLE) ;
                }
                else{
                    header4.setVisibility(View.GONE);
                }
                if(image2.getVisibility() == View.GONE){
                    image2.setVisibility(View.VISIBLE) ;
                }
                else{
                    image2.setVisibility(View.GONE);
                }
            }
        });

        title5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(content5.getVisibility() == View.GONE){
                    content5.setVisibility(View.VISIBLE) ;
                }
                else{
                    content5.setVisibility(View.GONE);
                }
                if(header5.getVisibility() == View.GONE){
                    header5.setVisibility(View.VISIBLE) ;
                }
                else{
                    header5.setVisibility(View.GONE);
                }
                if(image3.getVisibility() == View.GONE){
                    image3.setVisibility(View.VISIBLE) ;
                }
                else{
                    image3.setVisibility(View.GONE);
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
                if(header6.getVisibility() == View.GONE){
                    header6.setVisibility(View.VISIBLE) ;
                }
                else{
                    header6.setVisibility(View.GONE);
                }
                if(gif3.getVisibility() == View.GONE){
                    gif3.setVisibility(View.VISIBLE) ;
                }
                else{
                    gif3.setVisibility(View.GONE);
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
                if(header7.getVisibility() == View.GONE){
                    header7.setVisibility(View.VISIBLE) ;
                }
                else{
                    header7.setVisibility(View.GONE);
                }
                if(gif4.getVisibility() == View.GONE){
                    gif4.setVisibility(View.VISIBLE) ;
                }
                else{
                    gif4.setVisibility(View.GONE);
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
                if(header8.getVisibility() == View.GONE){
                    header8.setVisibility(View.VISIBLE) ;
                }
                else{
                    header8.setVisibility(View.GONE);
                }
                if(gif5.getVisibility() == View.GONE){
                    gif5.setVisibility(View.VISIBLE) ;
                }
                else{
                    gif5.setVisibility(View.GONE);
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
                if(header9.getVisibility() == View.GONE){
                    header9.setVisibility(View.VISIBLE) ;
                }
                else{
                    header9.setVisibility(View.GONE);
                }
                if(gif6.getVisibility() == View.GONE){
                    gif6.setVisibility(View.VISIBLE) ;
                }
                else{
                    gif6.setVisibility(View.GONE);
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
                if(header10.getVisibility() == View.GONE){
                    header10.setVisibility(View.VISIBLE) ;
                }
                else{
                    header10.setVisibility(View.GONE);
                }
                if(gif7.getVisibility() == View.GONE){
                    gif7.setVisibility(View.VISIBLE) ;
                }
                else{
                    gif7.setVisibility(View.GONE);
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
                if(header11.getVisibility() == View.GONE){
                    header11.setVisibility(View.VISIBLE) ;
                }
                else{
                    header11.setVisibility(View.GONE);
                }
                if(gif8.getVisibility() == View.GONE){
                    gif8.setVisibility(View.VISIBLE) ;
                }
                else{
                    gif8.setVisibility(View.GONE);
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
                if(header12.getVisibility() == View.GONE){
                    header12.setVisibility(View.VISIBLE) ;
                }
                else{
                    header12.setVisibility(View.GONE);
                }
                if(gif9.getVisibility() == View.GONE){
                    gif9.setVisibility(View.VISIBLE) ;
                }
                else{
                    gif9.setVisibility(View.GONE);
                }

            }
        });
    }
}