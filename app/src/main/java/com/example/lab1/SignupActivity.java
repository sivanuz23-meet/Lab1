package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    private TextView Sign;
    private EditText email;
    private EditText password;
    private Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Sign = findViewById(R.id.Sign);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        SignUp= findViewById(R.id.SignUp);
    }
}