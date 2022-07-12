package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EquipmentContainerActivity extends AppCompatActivity {
    TextView equipment_name, equipment_description;
    ImageView equipment_image, backBtn;

    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_container);

        equipment_name =  findViewById ( R.id.equipment_name );
        equipment_description =  findViewById ( R.id.equipment_description );

        equipment_image = findViewById ( R.id.equipment_image );

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent toEquipmentMenu = new Intent (EquipmentContainerActivity.this, EquipmentsActivity.class);
                startActivity (toEquipmentMenu);
                finish ();
            }
        } );

        bundle = getIntent ().getExtras ();

        if (bundle != null) {
            String name = bundle.getString ( "name" );
            String description = bundle.getString ( "description" );

            setUp ( name, description );
        }

    }

    private void setUp(String name, String description) {

        if (name.equals ( "Swimming Cap" )) {
            equipment_image.setImageResource ( R.drawable.swimming_cap );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Swimming Goggles" )) {
            equipment_image.setImageResource ( R.drawable.swimming_goggles );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Swimming Fins" )) {
            equipment_image.setImageResource ( R.drawable.swimming_fins );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Drag Suit" )) {
            equipment_image.setImageResource ( R.drawable.swimming_drag_suit );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Hand Paddles" )) {
            equipment_image.setImageResource ( R.drawable.swimming_hand_paddles );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Kick Board" )) {
            equipment_image.setImageResource ( R.drawable.swimming_kick_board );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Pull Buoy" )) {
            equipment_image.setImageResource ( R.drawable.swimming_pull_buoy );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Ankle Bands" )) {
            equipment_image.setImageResource ( R.drawable.swimming_ankle_bands );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Snorkel" )) {
            equipment_image.setImageResource ( R.drawable.swimming_snorkel );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Tempo Trainer" )) {
            equipment_image.setImageResource ( R.drawable.swimming_tempo_trainer );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Zoomer" )) {
            equipment_image.setImageResource ( R.drawable.swimming_zoomer );
            equipment_name.setText ( name );
            equipment_description.setText ( description );
        } else if (name.equals ( "Swim Suit" )) {
            equipment_image.setImageResource ( R.drawable.swimming_bathing_suit );
            equipment_name.setText ( name );
            equipment_description.setText ( description );

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (EquipmentContainerActivity.this, EquipmentsActivity.class);
        startActivity (intent);
        finishAffinity ();

    }
}