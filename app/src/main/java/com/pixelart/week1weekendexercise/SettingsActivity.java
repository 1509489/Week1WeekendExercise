package com.pixelart.week1weekendexercise;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText firstName, secondName, email, newPassword, retypePassword, address, phoneNumber;
    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        firstName = findViewById(R.id.etFirstName);
        secondName = findViewById(R.id.etSecondName);
        email = findViewById(R.id.etEmail);
        newPassword = findViewById(R.id.etNewPassword);
        retypePassword = findViewById(R.id.etRetypePassword);
        address = findViewById(R.id.etAddress);
        phoneNumber = findViewById(R.id.etPhoneNumber);

        updateButton =findViewById(R.id.btnUpdate);
    }

}
