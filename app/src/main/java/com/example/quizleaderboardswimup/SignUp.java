package com.example.quizleaderboardswimup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizleaderboardswimup.Interface.CompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText name, email, pass, confirmPass;
    TextView signUpB;
    TextView goLogin;
    FirebaseAuth mAuth;
    private String emailStrg, passStrg, condfirmPassStrg, nameStrg;
    Dialog progressDialog;
    TextView dialogText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.username);
        email = findViewById(R.id.emailAd);
        pass = findViewById(R.id.passwordS);
        confirmPass = findViewById(R.id.confirm_pass);
        signUpB = findViewById(R.id.signupS);
        goLogin = findViewById(R.id.loginS);

        dialogText = findViewById(R.id.diaglog_text);

        progressDialog = new Dialog(SignUp.this);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogText = progressDialog.findViewById(R.id.diaglog_text);
        dialogText.setText("Creating Account....");
        mAuth = FirebaseAuth.getInstance();


        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

        signUpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    signUpNewUser();

                }



            }
        });

    }

    private boolean validate() {

        nameStrg = name.getText().toString().trim();
        passStrg = pass.getText().toString().trim();
        emailStrg = email.getText().toString().trim();
        condfirmPassStrg = confirmPass.getText().toString().trim();

        if (nameStrg.isEmpty())
        {
            name.setError("Enter Your Name");
            return false;
        }
        if (emailStrg.isEmpty())
        {
            email.setError("Enter Email Address");
            return false;
        }
        if (passStrg.isEmpty()) {
            pass.setError("Enter Password");
            return false;
        }
        if (condfirmPassStrg.isEmpty())
        {
            confirmPass.setError("Confirm Password");
            return false;
        }
        if (passStrg.compareTo(condfirmPassStrg) !=0)
        {
            Toast.makeText(SignUp.this, "Password and Confirm Password should be same", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    private void signUpNewUser() {
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(emailStrg, passStrg)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUp.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();

                            DbQuery.createUserData(emailStrg, nameStrg, new CompleteListener() {
                                @Override
                                public void onSuccess() {

                                    DbQuery.loadData(new CompleteListener() {
                                        @Override
                                        public void onSuccess() {
                                            progressDialog.dismiss();
                                            Intent intent = new Intent(SignUp.this, MainActivity.class);
                                            startActivity(intent);
                                            SignUp.this.finish();

                                        }

                                        @Override
                                        public void onFailure() {
                                            Toast.makeText(SignUp.this, "Something went Wrong, Try Again!", Toast.LENGTH_SHORT).show();
                                            progressDialog.dismiss();

                                        }
                                    });


                                }

                                @Override
                                public void onFailure() {
                                    Toast.makeText(SignUp.this, "Something went Wrong, Try Again!", Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();

                                }
                            });





                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(SignUp.this, "Authentication Failed.", Toast.LENGTH_SHORT).show();


                        }
                    }
                });

    }
}