package com.example.mobileappdevassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    TextView tv_hospital, tv_name, tv_age, tv_blood, tv_date;
    Button btn_finish;
    Prefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        prefs = new Prefs(this);

        setLayout();
    }

    private void setLayout() {

        tv_hospital = findViewById(R.id.tv_hospital);
        tv_name = findViewById(R.id.tv_name);
        tv_age = findViewById(R.id.tv_age);
        tv_blood = findViewById(R.id.tv_blood);
        tv_date = findViewById(R.id.tv_date);

        tv_hospital.setText(getIntent().getStringExtra("LOCATION"));
        tv_name.setText(getIntent().getStringExtra("NAME"));
        tv_age.setText(getIntent().getStringExtra("AGE"));
        tv_blood.setText(getIntent().getStringExtra("BLOOD"));
        tv_date.setText(getIntent().getStringExtra("DATE"));

        btn_finish = findViewById(R.id.button_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDataBaseHelper myDataBaseHelper = new MyDataBaseHelper(ConfirmActivity.this);
                myDataBaseHelper.addInfo(tv_name.getText().toString(), tv_age.getText().toString(), tv_blood.getText().toString(), tv_date.getText().toString(), tv_hospital.getText().toString());

                int num = getIntent().getIntExtra("NUMBER", 0);
                if (num == 1) {
                    prefs.setLocation1(1);
                } else if (num == 2) {
                    prefs.setLocation2(1);
                } else if (num == 3) {
                    prefs.setLocation3(1);
                } else if (num == 4) {
                    prefs.setLocation4(1);
                } else if (num == 5) {
                    prefs.setLocation5(1);
                }
                Intent intent = new Intent(ConfirmActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}