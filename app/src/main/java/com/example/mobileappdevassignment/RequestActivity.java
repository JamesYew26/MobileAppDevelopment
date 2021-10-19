package com.example.mobileappdevassignment;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class RequestActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] blood = { "A", "B", "AB", "O"};
    Spinner spinner;
    ArrayAdapter aa;
    String selected_blood, selected_date, hospital;
    DatePicker datePicker;
    Button button_confirm;
    TextView hospital_addr;
    EditText et_name, et_age;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        setLayout();
        setSpinner();
        setDatePicker();
        setButton();
    }

    private void setLayout() {

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);

        hospital = getIntent().getStringExtra("LOCATION");
        hospital_addr = findViewById(R.id.tv_hospital);
        hospital_addr.setText(hospital);
    }

    private void setSpinner() {
        spinner = findViewById(R.id.spin_blood);
        spinner.setOnItemSelectedListener(this);
        aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, blood);
        spinner.setAdapter(aa);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setDatePicker() {
        datePicker = findViewById(R.id.datePicker);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                selected_date = i + "/" + i1 + "/" + i2;
            }
        });
    }

    private void setButton() {
        button_confirm = findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_name.getText().toString().isEmpty()) {
                    Toast.makeText(RequestActivity.this, "Name must not be empty", Toast.LENGTH_LONG).show();
                } else if (et_age.getText().toString().isEmpty()) {
                    Toast.makeText(RequestActivity.this, "Age must not be empty", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(RequestActivity.this, ConfirmActivity.class);
                    intent.putExtra("LOCATION", hospital);
                    intent.putExtra("NAME", et_name.getText().toString());
                    intent.putExtra("AGE", et_age.getText().toString());
                    intent.putExtra("BLOOD", selected_blood);
                    intent.putExtra("DATE", selected_date);
                    intent.putExtra("NUMBER", getIntent().getIntExtra("NUMBER", 0));
                    startActivity(intent);
                }


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selected_blood = blood[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        selected_blood = blood[0];
    }
}