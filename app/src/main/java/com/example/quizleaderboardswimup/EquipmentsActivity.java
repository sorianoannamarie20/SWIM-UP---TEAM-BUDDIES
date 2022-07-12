package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.quizleaderboardswimup.ui.home.HomeFragment;

public class EquipmentsActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton swim_cap, goggles, fins, drag_suit, hand_paddles, kick_board, pull_buoy, ankle_bands,
            snorkel, tempo_trainer, zoomer, swim_suit;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipments);

        back = findViewById(R.id.comebackHome);

        swim_cap = findViewById ( R.id.swim_cap );
        goggles = findViewById ( R.id.goggles );
        fins = findViewById ( R.id.fins );
        drag_suit = findViewById ( R.id.drag_suit );
        hand_paddles = findViewById ( R.id.hand_paddles );
        kick_board =findViewById ( R.id.kick_board );
        pull_buoy =  findViewById ( R.id.pull_buoy );
        ankle_bands =  findViewById ( R.id.ankle_bands );
        snorkel = findViewById ( R.id.snorkel );
        tempo_trainer = findViewById ( R.id.tempo_trainer );
        zoomer = findViewById ( R.id.zoomer );
        swim_suit =  findViewById ( R.id.swim_suit );

        swim_cap.setOnClickListener(this);
        goggles.setOnClickListener ( this );
        fins.setOnClickListener ( this );
        drag_suit.setOnClickListener ( this );
        hand_paddles.setOnClickListener ( this );
        kick_board.setOnClickListener ( this );
        pull_buoy.setOnClickListener ( this );
        ankle_bands.setOnClickListener ( this );
        snorkel.setOnClickListener ( this );
        tempo_trainer.setOnClickListener ( this );
        zoomer.setOnClickListener ( this );
        swim_suit.setOnClickListener ( this );

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new HomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containerEquipments, fragment).commit();
            }
        });


    }
    @Override
    public void onClick(View view) {

        Intent toEquipmentContainer = new Intent ( EquipmentsActivity.this, EquipmentContainerActivity.class );

        switch (view.getId ()) {

            case R.id.swim_cap:

                toEquipmentContainer.putExtra ("name", "Swimming Cap" );
                toEquipmentContainer.putExtra ("description", "Swim Cap keeps the swimmers hair out of the way to reduce drag. Caps   maybe made of latex, silicon, spandex or lycra. " );

                startActivity ( toEquipmentContainer );
                break;

            case R.id.goggles:

                toEquipmentContainer.putExtra ("name", "Swimming Goggles");
                toEquipmentContainer.putExtra ("description", "Goggles keeps water and chlorine out of swimmers eyes. Goggles may tinted to counteract glare at outdoor pools. Prescription goggles may be used by swimmers who were corrective lenses.");

                startActivity (toEquipmentContainer);
                break;

            case R.id.fins:

                toEquipmentContainer.putExtra ("name", "Swimming Fins");
                toEquipmentContainer.putExtra ("description", "Swimming Fins are used to help keep faster, but are illegal in a race. They also improve technique by keeping the feet in proper position while kicking. ");

                startActivity (toEquipmentContainer);
                break;

            case R.id.drag_suit:

                toEquipmentContainer.putExtra ("name", "Drag Suit");
                toEquipmentContainer.putExtra ("description", "Swimmers use drag suits to increase resistance. ");

                startActivity (toEquipmentContainer);
                break;

            case R.id.hand_paddles:

                toEquipmentContainer.putExtra ("name", "Hand Paddles");
                toEquipmentContainer.putExtra ("description", "Swimmers use this plastic device to build arm and shoulder strength and refine pulling techniques, hand paddles attached to the hand with rubber tubing elastic material. They come with different shapes and sizes, depending on swimmers preference.");

                startActivity (toEquipmentContainer);
                break;

            case R.id.kick_board:

                toEquipmentContainer.putExtra ("name", "Kick Board");
                toEquipmentContainer.putExtra ("description", "A kick board is a foam board that swimmers use to support the weight of the upper body while they focus on kicking, help build leg muscles. ");

                startActivity (toEquipmentContainer);
                break;

            case R.id.pull_buoy:

                toEquipmentContainer.putExtra ("name", "Pull Buoy");
                toEquipmentContainer.putExtra ("description", "Open used at same time as hand paddles Pull buoys support swimmers legs prevent them kicking while focus on pulling. Pull buoys are made of foam so they float in the  water. Swimmers hold them between the thigh. \n");

                startActivity (toEquipmentContainer);
                break;

            case R.id.ankle_bands:

                toEquipmentContainer.putExtra ("name", "Ankle Bands");
                toEquipmentContainer.putExtra ("description", "Improving balance will minimize the needs for this kick to provide an upward, instead of forward vector and in some cases completely corrects the kicks.");

                startActivity (toEquipmentContainer);
                break;

            case R.id.snorkel:

                toEquipmentContainer.putExtra ("name", "Snorkel");
                toEquipmentContainer.putExtra ("description", "A snorkel is a plastic device that helps swimmers breathe while swimming. The place of equipment helps swimmer practice keeping his/her head in one position.");

                startActivity (toEquipmentContainer);
                break;

            case R.id.tempo_trainer:

                toEquipmentContainer.putExtra ("name", "Tempo Trainer");
                toEquipmentContainer.putExtra ("description", "A beeping clap attached to a swimmers cap or goggles helps them to maintain a certain arm tempo or speed. As each beep is heard, their next strokes should be taken. ");

                startActivity (toEquipmentContainer);
                break;

            case R.id.zoomer:

                toEquipmentContainer.putExtra ("name", "Zoomer");
                toEquipmentContainer.putExtra ("description", " A type of rubber fins, zoomer are cut off with holes in the bottom. They help make swimmer kick faster, but at the cost of working harder.");

                startActivity (toEquipmentContainer);
                break;

            case R.id.swim_suit:

                toEquipmentContainer.putExtra ("name", "Swim Suit");
                toEquipmentContainer.putExtra ("description", "The swim suit cover the skin for modesty. Competitive swimwear seeks approve upon bear human skin for advantages. ");

                startActivity (toEquipmentContainer);
                break;

        }
    }
}