package com.example.mobileappdevassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void BloodDonationInfo(View view) {
        Intent intent = new Intent(this,Eligibility.class);
        startActivity(intent);
    }

    public void Registration(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void Appointment(View view) {
        Intent intent = new Intent(this,Appointment.class);
        startActivity(intent);
    }
}