package com.example.quizleaderboardswimup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quizleaderboardswimup.Interface.CompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mAuth=FirebaseAuth.getInstance();

        DbQuery.gFirestore = FirebaseFirestore.getInstance();



        logo = findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.myanim);
        logo.setAnimation(animation);

        new Thread(){

            @Override
            public void run(){
                try {
                    sleep(2500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }


                if (mAuth.getCurrentUser() !=null){

                    DbQuery.loadData(new CompleteListener() {
                        @Override
                        public void onSuccess() {

                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);
                            SplashActivity.this.finish();


                        }

                        @Override
                        public void onFailure() {

                            Toast.makeText(SplashActivity.this, "Something went wrong! Please Try again..", Toast.LENGTH_SHORT).show();

                        }
                    });


                }else {
                    Intent intent = new Intent(SplashActivity.this, Login.class);
                    startActivity(intent);
                    SplashActivity.this.finish();

                }

            }
        }.start();
    }
}