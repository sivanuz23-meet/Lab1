/*package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView SignIn;
    private EditText email;
    private EditText password;
    private Button login;
    private Button SignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignIn = findViewById(R.id.SignIn);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        SignUp = findViewById(R.id.SignUp);
        login.setOnClickListener(this)
        SignUp.setOnClickListener(this)}*/






package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnCapturedPointerListener, View.OnClickListener {
    private TextView SignIn;
    private EditText email;
    private EditText password;
    private Button login;
    private Button SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignIn = findViewById(R.id.SignIn);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        login= findViewById(R.id.login);
        SignUp= findViewById(R.id.SignUp);
        login.setOnClickListener(this);
        SignUp.setOnClickListener(this);
    }

    @Override
    public boolean onCapturedPointer(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onClick(View view) {
        if(view==login)
        {
            email.setText(email.getTooltipText());
            password.setText(password.getTooltipText());
        }


    }
}