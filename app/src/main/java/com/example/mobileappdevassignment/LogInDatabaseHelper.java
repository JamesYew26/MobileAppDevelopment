package com.example.mobileappdevassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LogInDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "login.db";

    public LogInDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE user (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " phonenum TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS user");
    }

    public boolean insert (String phonenum, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put("phonenum",phonenum);
        CV.put("Password",password);
        long result = DB.insert("user", null,CV);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkPhoneNum(String phonenum){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM user WHERE phonenum=?", new String[]{phonenum});

        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkLogin(String phonenum, String password){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM user WHERE phonenum=? AND password=?",new String[]{phonenum,password});

        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }


}
