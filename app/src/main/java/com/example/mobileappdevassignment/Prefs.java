package com.example.mobileappdevassignment;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Prefs {

    private static String LOCATION_1 = "location1";
    private static String LOCATION_2 = "location2";
    private static String LOCATION_3 = "location3";
    private static String LOCATION_4 = "location4";
    private static String LOCATION_5 = "location5";

    private final SharedPreferences mPrefsRead;
    private final SharedPreferences.Editor mPrefsWrite;

    public Prefs(Context context) {
        final String PREFS = "preference";
        mPrefsRead = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        mPrefsWrite = mPrefsRead.edit();
    }

    public void setLocation1(int i) {
        mPrefsWrite.putInt(LOCATION_1, i);
        mPrefsWrite.apply();
    }

    public int getLocation1() {
        int value = mPrefsRead.getInt(LOCATION_1, 0);
        return value;
    }

    public void setLocation2(int i) {
        mPrefsWrite.putInt(LOCATION_2, i);
        mPrefsWrite.apply();
    }

    public int getLocation2() {
        int value = mPrefsRead.getInt(LOCATION_2, 0);
        return value;
    }

    public void setLocation3(int i) {
        mPrefsWrite.putInt(LOCATION_3, i);
        mPrefsWrite.apply();
    }

    public int getLocation3() {
        int value = mPrefsRead.getInt(LOCATION_3, 0);
        return value;
    }

    public void setLocation4(int i) {
        mPrefsWrite.putInt(LOCATION_4, i);
        mPrefsWrite.apply();
    }

    public int getLocation4() {
        int value = mPrefsRead.getInt(LOCATION_4, 0);
        return value;
    }

    public void setLocation5(int i) {
        mPrefsWrite.putInt(LOCATION_5, i);
        mPrefsWrite.apply();
    }

    public int getLocation5() {
        int value = mPrefsRead.getInt(LOCATION_5, 0);
        return value;
    }

}
