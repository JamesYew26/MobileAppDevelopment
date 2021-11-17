package com.example.mobileappdevassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Appointment extends AppCompatActivity {

    RecyclerView recyclerView;
    MyDataBaseHelper myDB;
    ArrayList<String> ID, Donor_Name, Donor_Age, Donor_BloodType, Donor_Date, Donating_Location;
    CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        recyclerView = findViewById(R.id.recyclerView);
        myDB = new MyDataBaseHelper(Appointment.this);
        ID = new ArrayList<>();
        Donor_Name = new ArrayList<>();
        Donor_Age = new ArrayList<>();
        Donor_BloodType = new ArrayList<>();
        Donor_Date = new ArrayList<>();
        Donating_Location = new ArrayList<>();

        storeAppointmentDataInArray();

        customAdapter = new CustomAdapter(Appointment.this,ID, Donor_Name,
                Donor_Age, Donor_BloodType, Donor_Date, Donating_Location);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Appointment.this));
    }
    void storeAppointmentDataInArray(){
        myDB = new MyDataBaseHelper(this);
        Cursor cursor = myDB.readAppointmentData();
        if (cursor.getCount() == 0){
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                Donor_Name.add(cursor.getString(1));
                Donor_Age.add(cursor.getString(2));
                Donor_BloodType.add(cursor.getString(3));
                Donor_Date.add(cursor.getString(4));
                Donating_Location.add(cursor.getString(5));
            }
        }
    }
}