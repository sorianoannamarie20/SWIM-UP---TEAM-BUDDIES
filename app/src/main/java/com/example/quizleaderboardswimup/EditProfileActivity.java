package com.example.quizleaderboardswimup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizleaderboardswimup.Interface.CompleteListener;

public class EditProfileActivity extends AppCompatActivity {
    private EditText name, email, phone;
    private LinearLayout editB, buttonLayout;
    private TextView cancelE, saveE;
    private TextView profileTxt;
    private String nameStrng, phoneStrng;
    private  Dialog progressDialog;
    private TextView dialogText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.mp_name);
        email = findViewById(R.id.mp_email);
        phone = findViewById(R.id.mp_phone);
        editB = findViewById(R.id.editB);
        cancelE = findViewById(R.id.cacelEdit);
        saveE = findViewById(R.id.saveB);
        profileTxt = findViewById(R.id.profileImageTextEdit);
        buttonLayout = findViewById(R.id.buttonLayout);

        progressDialog = new Dialog(EditProfileActivity.this);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogText = progressDialog.findViewById(R.id.diaglog_text);
        dialogText.setText("Updating Profile....");


        disableEditing();

        editB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enableEditing();



            }
        });

        cancelE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableEditing();
            }
        });
        saveE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate())
                {
                    saveData();
                }
            }
        });


    }

    private void disableEditing(){
        name.setEnabled(false);
        email.setEnabled(false);
        phone.setEnabled(false);

        buttonLayout.setVisibility(View.GONE);

        name.setText(DbQuery.userProfile.getName());
        email.setText(DbQuery.userProfile.getEmil());

        if (DbQuery.userProfile.getPhone() != null)
            phone.setText(DbQuery.userProfile.getPhone());

        String profileName = DbQuery.userProfile.getName();
        profileTxt.setText(profileName.toUpperCase().substring(0,1));

    }

    private void enableEditing(){
        name.setEnabled(true);
//        email.setEnabled(true);
        phone.setEnabled(true);

        buttonLayout.setVisibility(View.VISIBLE);

    }

    private boolean validate(){

        nameStrng = name.getText().toString();
        phoneStrng = phone.getText().toString();

        if (nameStrng.isEmpty())
        {
            name.setError("Name Can not be empty");
            return false;
        }

        if ( ! phoneStrng.isEmpty())
        {
            if ( ! ((phoneStrng.length() == 12) && (TextUtils.isDigitsOnly(phoneStrng))) )
            {
                phone.setError("Enter Valid Phone Number");
                return false;
            }
        }

        return  true;

    }

    private  void saveData()
    {

        progressDialog.show();

        if (phoneStrng.isEmpty())
            phoneStrng = null;

        DbQuery.saveProfileData(nameStrng, phoneStrng, new CompleteListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(EditProfileActivity.this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show();
                disableEditing();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure() {

                Toast.makeText(EditProfileActivity.this, "Something went wrong, Try Again", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home)
        {
            EditProfileActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}