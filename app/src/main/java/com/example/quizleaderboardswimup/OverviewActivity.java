package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quizleaderboardswimup.Adapter.OverviewAdapter;

public class OverviewActivity extends AppCompatActivity {
    private ViewPager mSlideViewpager;
    private LinearLayout mDotLayout;
    private TextView mDots[];
    private OverviewAdapter overviewAdapter;
    private Button mPrev, mNext, mFinish;

    private int mCurrentPage;

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotIndicator(position);
            mCurrentPage = position;

            if (position == 0) {
                mPrev.setVisibility(View.INVISIBLE);
                mNext.setVisibility  (View.VISIBLE);
                mFinish.setVisibility (View.INVISIBLE);

            } else if (position == mDots.length - 1) {
                mPrev.setVisibility(View.VISIBLE);
                mFinish.setVisibility (View.VISIBLE);
                mNext.setVisibility (View.INVISIBLE);

                mFinish.setOnClickListener ( view -> {
                    Intent toHome = new Intent ( OverviewActivity.this, MainActivity.class);
                    startActivity (toHome);
                } );

            } else {
                mPrev.setVisibility(View.VISIBLE);
                mNext.setVisibility (View.VISIBLE);
                mFinish.setVisibility (View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void addDotIndicator(int position) {
        mDots = new TextView[6];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText( Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        mSlideViewpager = findViewById(R.id.vpagerInt);
        mDotLayout = findViewById(R.id.dotsInt);
        mNext = findViewById(R.id.nextBtnInt);
        mPrev = findViewById(R.id.previousBtnInt);
        mFinish = findViewById (R.id.finishBtnInt);

        overviewAdapter = new OverviewAdapter(this);
        mSlideViewpager.setAdapter(overviewAdapter);
        addDotIndicator(0);

        mSlideViewpager.addOnPageChangeListener(viewListener);
    }


    public void prev(View view) {
        mSlideViewpager.setCurrentItem(mCurrentPage - 1);
    }

    public void next(View view) {
        mSlideViewpager.setCurrentItem(mCurrentPage + 1);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent ( OverviewActivity.this, MainActivity.class);
        startActivity (intent);
        finishAffinity ();
    }
}