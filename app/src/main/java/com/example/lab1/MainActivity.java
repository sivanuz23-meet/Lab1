package com.example.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnCapturedPointerListener, View.OnClickListener {
    private TextView SignIn;
    private EditText email;
    private EditText password;
    private Button login;
    private Button SignUp;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignIn = findViewById(R.id.SignIn);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        login= findViewById(R.id.login);
        SignUp= findViewById(R.id.SignUp);
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(this);
        SignUp.setOnClickListener(this);
    }

    Intent intentSignUp = new Intent(this, SignupActivity.class);
    Intent intentHome = new Intent(this, HomeActivity.class);
    Intent intentMain = new Intent(this, MainActivity.class);



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
            startActivity(intentHome);
        }
        else if (view==SignUp){
            startActivity(intentSignUp);
        }
    }

    public void signin_user(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}