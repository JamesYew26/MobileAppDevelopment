package com.example.mobileappdevassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String TABLE_NAME = "DonorAppointment";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NAME = "Donor_Name";
    private static final String COLUMN_AGE = "Donor_Age";
    private static final String COLUMN_BLOODTYPE = "Donor_BloodType";
    private static final String COLUMN_DATE = "Donor_Date";
    private static final String COLUMN_LOCATION = "Donating_Location";



    public MyDataBaseHelper(@Nullable Context context) {
        super(context, "UserAppointment.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " + COLUMN_AGE + " TEXT, " + COLUMN_BLOODTYPE + " TEXT, " +
                COLUMN_DATE + " TEXT," + COLUMN_LOCATION + " TEXT )";
        DB.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(DB);
    }

    void addInfo(String name, String age, String blood_type, String date, String location){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues CV = new ContentValues();

        CV.put(COLUMN_NAME, name);
        CV.put(COLUMN_AGE, age);
        CV.put(COLUMN_BLOODTYPE, blood_type);
        CV.put(COLUMN_DATE, date);
        CV.put(COLUMN_LOCATION, location);


        long result = DB.insert(TABLE_NAME, null, CV);
        if (result == -1){
            Toast.makeText(context,"Error !", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"SUCCESS !",Toast.LENGTH_SHORT).show();
        }
    }

}

