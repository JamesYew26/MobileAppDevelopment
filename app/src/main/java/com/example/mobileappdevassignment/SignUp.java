package com.example.mobileappdevassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    LogInDatabaseHelper DBHelper;
    EditText PhoneNumber, Password, ConfirmPassword;
    Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        DBHelper = new LogInDatabaseHelper(this);
        PhoneNumber = findViewById(R.id.et_SignUpPhoneNum);
        Password = findViewById(R.id.et_SignUpPassword);
        ConfirmPassword = findViewById(R.id.et_SignUpConfirmPassword);
        SignUp = findViewById(R.id.btn_SignUpSignUp);
    }



    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }



    public void SignUp (View view){
        String phonenum = PhoneNumber.getText().toString();
        String pw = Password.getText().toString();
        String cpw = ConfirmPassword.getText().toString();

        if (phonenum.equals("") || pw.equals("") || cpw.equals("")){
            displayToast("Credentials Required");
        }
        else {
            if (pw.equals(cpw)){
                Boolean taken = DBHelper.checkPhoneNum(phonenum);
                if (!taken){
                    Boolean insertSuccessfully = DBHelper.insert(phonenum,pw);
                    if (insertSuccessfully){
                        displayToast("Registered Successfully");
                        PhoneNumber.setText("");
                        Password.setText("");
                        ConfirmPassword.setText("");
                        Intent intent = new Intent(this,Login.class);
                        startActivity(intent);
                    }
                }
                else {
                    displayToast("Phone number has been taken");
                }
            }
            else {
                displayToast("Password is not correct");
            }
        }
    }
}