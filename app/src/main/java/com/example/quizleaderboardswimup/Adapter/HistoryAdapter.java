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

public class HistoryAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public HistoryAdapter(Context context) {
        this.context = context;
    }

    public String [] slide_year ={
            "1828",
            "1830",
            "1837",
            "1844",
            "1875",
            "1880",
            "1892",
            "1896",
            "1902",
            "1908",
            "1930",
            "1962",
            "1968",
    };


    public int [] slide_images ={
            R.drawable.sp1,
            R.drawable.sp2,
            R.drawable.sp3,
            R.drawable.sp4,
            R.drawable.sp5,
            R.drawable.sp6,
            R.drawable.sp7,
            R.drawable.sp8,
            R.drawable.sp9,
            R.drawable.sp10,
            R.drawable.sp11,
            R.drawable.sp12,
            R.drawable.sp13,

    };

    public String[] slide_headings ={
            "First Indoor Pool",
            "Recreational Activity in England",
            "Artificial Pools",
            "History of Front Crawl",
            "First man to Swim the Channel",
            "First National Governing Body",
            "First Women Competition",
            "Olympic Games in Athens",
            "Australian Crawl",
            "FINA",
            "History of Butterfly Stroke",
            "Touch Pads Sensors",
            "Olympic Games",
    };
    public  String [] side_desc = {
            "\t\t\tIn 1828, the first indoor swimming pool, St George's Baths was opened to the public. By 1837, the National Swimming Society was holding regular swimming competitions in six artificial swimming pools, built around London. ",
            "\t\t\tSwimming emerge as a competitive recreational activity in England, mostly using breaststroke.",
            "\t\t\tBy 1837, the National Swimming Society was holding regular swimming competitions in six artificial swimming pools, built around London.",
            "\t\t\tFlying Gull and Tobacco, the two native american participants that were invited in a swimming competition in London. Observers were reported to be shocked by the stroke and its difference to breaststroke which was the only competitive stroke used in the early European swimming clubs.",
            "\t\t\tOn August 24, 1875, Captain Matthew Webb of Great Britain becomes the first man to successfully swim the English Channel without assistance. After the feat, Webb became an international celebrity, admired for both his prowess in the water and his penchant for risk-taking.",
            "\t\t\tThe sport grew in popularity and by 1880, when the first national governing body, the Amateur Swimming Association, was formed, there were already over 300 regional clubs in operation across the country. ",
            "\t\t\tThe world’s first women’s swimming championship was held in Scotland but wasnt introduced to the Olympic Games until 1912.",
            "\t\t\tThe first Olympics to feature swimming as an official sport was in 1896 in Athens,with 100m, 500m, and 1200m races, which feel familiar to us today, though the 100m for sailors may seem a little odd.",
            "\t\t\tAustralian, Richmond “Dick” Cavill, was inspired by Solomon Islander Alick Wickham in the early 1900s. They watched Wickham and experimented, developing a modified Trudgen stroke which ultimately became known as the “Australian Crawl”.",
            "\t\t\tThe “Federation Internationale de Natation” (FINA) was founded in London July 19, 1908 during the Olympic Games in London (GBR). Eight national federations were responsible for the formation of FINA: Belgium, Denmark, Finland, France, Germany, Great Britain, Hungary and Sweden.",
            "\t\t\tThe history of butterfly stroke started in the 1930s when it developed as a style of swimming breaststroke. Swimmers and coaches began to realize that breaststroke was quicker when a swimmer recovered their arms forward above the water and the arm technique – as well as the swimming term 'butterfly' – was born.",
            "\t\t\tIn 1962, the National Collegiate Athletic Association (NCAA) approved the use of touchpads for swimming competitions. The first touchpads that were created were thick and were harder to connect and move around compared to the touchpads today.",
            "\t\t\tThe 1968 Summer Olympic Games were an international multi-sport event held between 12 and 27 October 1968 in Mexico City. These Games were the first to be hosted by a developing country, as well as the first to be hosted by a Spanish-speaking country.",

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
        View view = layoutInflater.inflate(R.layout.activity_history_layout,container,false);


        ImageView slideImage = view.findViewById(R.id.imageHistory);
        TextView slideYear = view.findViewById (R.id.yearHistory);
        TextView slideHeading  = view.findViewById(R.id.titleHistory);
        TextView slideDesc  = view.findViewById(R.id.descHistory);


        slideImage.setImageResource(slide_images[position]);
        slideYear.setText(slide_year[position]);
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
