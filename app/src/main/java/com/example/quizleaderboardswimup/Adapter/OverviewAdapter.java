package com.example.quizleaderboardswimup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.quizleaderboardswimup.R;

public class OverviewAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public OverviewAdapter(Context context) {
        this.context = context;
    }


    public int [] slide_images ={
            R.drawable.vec4,
            R.drawable.vec2,
            R.drawable.vec3,
            R.drawable.vec1,
            R.drawable.vec5,
            R.drawable.vec6,
    };
    public String[] slide_headings ={
            "WATER",
            "SWIMMING",
            "SWIMMING AS SURVIVAL",
            "SWIMMING AS RECREATION",
            "SWIMMING AS THERAPY",
            "SWIMMING AS COMPETITION",
    };
    public  String [] side_desc = {
            "\t\t\tWater is not habitat, but most people are able to float in it. Once this phenomenon is experienced, appropriate actions of the limbs will bring about the movement known as swimming. This exhilarating activity is for all, from the youngest to the oldest, from the athletic to handicapped.",
            "\t\t\tSwimming is an aquatic sport in which the participant or swimmer aims to cover a given distance in a smallest amount of time. There are basically four competitive strokes used in Olympic swimming: freestyle, breaststroke, butterfly and backstroke. The events are held in all of these strokes at varying distances. The competition for men and women are the same, except that the longest race for men is 1500m while 800m long for women. These events comprise either a combination of the strokes swum by one participant or by a group of four swimmers. There are many good reasons why everyone should learn how to swim. ",
            "\t\t\tThere are ever present danger near any open water, sea, rivers, lake, canals and disuse pits. Every year there are deaths cause through drowning and many occurring within a few meters away. It is important, therefore, that everyone should be able to swim in order to save themselves in an emergency. This same open water provides opportunities for a wide range of activities such as sailing and surfing for which swimming is prerequisite.",

            "\t\t\tIn these days of increased leisure time, the need for involvement in some kind of recreational pursuit, preferably of a physical nature is generally recognized. Swimming provides the means and it has many advantages:\n" +
                    "\u2022\tAmple opportunities are available in swimming pools and leisure centers.\n" +
                    "\u2022\tLittle equipment is required, simply a costume and a towel. \n" +
                    "\u2022\tIt is comparatively inexpensive. \n" +
                    "\u2022\tIt can be enjoyed in company or alone (but the latter only under supervision) \n" +
                    "\u2022\tThe acquisition of swimming skills can lead to training as a lifesaver and lifeguard.\n",

            "\t\t\tSwimming can be in medical treatment and in general therapy for the following reasons:\n" +
                    "\u2022\tThe disabled and physical handicapped may take part because weight bearing is not required. Movement and travel can take place without the use of strength, and the performer is able to experience and enjoy a freedom of movement not possible out water. \n" +
                    "\u2022\tSwimming is enjoyable way of keeping fit. It improves stamina and stimulates the circulatory and respiratory systems, thereby promoting is feeling of general well- being. ",
            "\t\t\tMost people swim for reasons started. Some improve their skill by means of self-imposed challenges, or by preparing for various tests. For those endowed with special abilities and aptitude there are many opportunities for participation in swimming as competitive sports. For such as people, coaching, training and swimming events are provided by the many clubs to be found throughout the country. ",
    };




    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_introduction_layout,container,false);


        ImageView slideImage = view.findViewById(R.id.imageInt );
        TextView slideHeading  = view.findViewById(R.id.titleInt);
        TextView slideDesc  = view.findViewById(R.id.descInt);


        slideImage.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(side_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
