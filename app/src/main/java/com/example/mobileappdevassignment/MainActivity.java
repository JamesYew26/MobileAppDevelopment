package com.example.mobileappdevassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mLocation1;
    private TextView mLocation2;
    private TextView mLocation3;
    private TextView mLocation4;
    private TextView mLocation5;
    Prefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = new Prefs(this);

        setLayout();

        mLocation1 = findViewById(R.id.location1);
        mLocation2 = findViewById(R.id.location2);
        mLocation3 = findViewById(R.id.location3);
        mLocation4 = findViewById(R.id.location4);
        mLocation5 = findViewById(R.id.location5);
    }

    private void setLayout() {

        Button location1_register = findViewById(R.id.location1_register);
        Button location2_register = findViewById(R.id.location2_register);
        Button location3_register = findViewById(R.id.location3_register);
        Button location4_register = findViewById(R.id.location4_register);
        Button location5_register = findViewById(R.id.location5_register);

        if (prefs.getLocation1() == 1) {
            location1_register.setText("REGISTERED");
            location1_register.setBackgroundColor(Color.DKGRAY);
            location1_register.setTextColor(Color.WHITE);
            location1_register.setClickable(false);
        }

        if (prefs.getLocation2() == 1) {
            location2_register.setText("REGISTERED");
            location2_register.setBackgroundColor(Color.DKGRAY);
            location2_register.setTextColor(Color.WHITE);
            location2_register.setClickable(false);
        }

        if (prefs.getLocation3() == 1) {
            location3_register.setText("REGISTERED");
            location3_register.setBackgroundColor(Color.DKGRAY);
            location3_register.setTextColor(Color.WHITE);
            location3_register.setClickable(false);
        }

        if (prefs.getLocation4() == 1) {
            location4_register.setText("REGISTERED");
            location4_register.setBackgroundColor(Color.DKGRAY);
            location4_register.setTextColor(Color.WHITE);
            location4_register.setClickable(false);
        }

        if (prefs.getLocation5() == 1) {
            location5_register.setText("REGISTERED");
            location5_register.setBackgroundColor(Color.DKGRAY);
            location5_register.setTextColor(Color.WHITE);
            location5_register.setClickable(false);
        }
    }

    public void request(View view) {

        Intent intent = new Intent(MainActivity.this, RequestActivity.class);

        switch (view.getId()) {
            case R.id.location1_register: {
                intent.putExtra("LOCATION", mLocation1.getText().toString());
                intent.putExtra("NUMBER", 1);
                break;
            }
            case R.id.location2_register: {
                intent.putExtra("LOCATION", mLocation2.getText().toString());
                intent.putExtra("NUMBER", 2);
                break;
            }
            case R.id.location3_register: {
                intent.putExtra("LOCATION", mLocation3.getText().toString());
                intent.putExtra("NUMBER", 3);
                break;
            }
            case R.id.location4_register: {
                intent.putExtra("LOCATION", mLocation4.getText().toString());
                intent.putExtra("NUMBER", 4);
                break;
            }
            case R.id.location5_register: {
                intent.putExtra("LOCATION", mLocation5.getText().toString());
                intent.putExtra("NUMBER", 5);
                break;
            }
        }

        startActivity(intent);

    }

    public void openLocation1(View view) {
        String loc = mLocation1.getText().toString();
        Uri addressUri=Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openLocation2(View view) {
        String loc = mLocation2.getText().toString();
        Uri addressUri=Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openLocation3(View view) {
        mLocation3 = findViewById(R.id.location3);
        String loc = mLocation3.getText().toString();
        Uri addressUri=Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openLocation4(View view) {
        mLocation4 = findViewById(R.id.location4);
        String loc = mLocation4.getText().toString();
        Uri addressUri=Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openLocation5(View view) {
        mLocation5 = findViewById(R.id.location5);
        String loc = mLocation5.getText().toString();
        Uri addressUri=Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}