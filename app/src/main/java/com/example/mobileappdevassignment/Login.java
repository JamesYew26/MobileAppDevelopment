package com.example.mobileappdevassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    LogInDatabaseHelper DBHelper;
    EditText PhoneNum,Password;
    Button Login, Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DBHelper = new LogInDatabaseHelper(this);
        PhoneNum = findViewById(R.id.et_LoginPhoneNum);
        Password = findViewById(R.id.et_LoginPassword);
        Login = findViewById(R.id.btn_LoginLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonenum = PhoneNum.getText().toString();
                String password = Password.getText().toString();

                Boolean loginSucess = DBHelper.checkLogin(phonenum,password);
                if (loginSucess){
                    displayToast("Login Successful !");
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else {
                    displayToast("Invalid phone number or password !");
                    PhoneNum.setText("");
                    Password.setText("");
                }
            }
        });

        Signup = findViewById(R.id.btn_LoginSignUp);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });


    }
    public void displayToast(String message){
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
}