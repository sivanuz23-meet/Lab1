package com.example.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity implements View.OnCapturedPointerListener, View.OnClickListener {

    private TextView Sign;
    private EditText name;
    private EditText email1;
    private EditText password1;
    private Button SignUp;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Sign = findViewById(R.id.Sign);
        mAuth = FirebaseAuth.getInstance();
        email1= findViewById(R.id.email);
        password1= findViewById(R.id.password);
        name = findViewById(R.id.name);
        SignUp= findViewById(R.id.SignUp);
        database = FirebaseDatabase.getInstance();
        SignUp.setOnClickListener(this);
    }

    Intent intentHome = new Intent(this, HomeActivity.class);
    @Override
    public boolean onCapturedPointer(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onClick(View view) {
        if (view == SignUp) {
            create_user(email1.getText().toString(), password1.getText().toString());
        }
    }

    public void create_user(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(name.getText().toString(), email1.getText().toString(), password1.getText().toString());
                            String uid = mAuth.getCurrentUser().getUid().toString();
                            database.getReference("Users").child(uid).setValue(user);
                            // Sign in success, update UI with the signed-in user's information
                            Intent i = new Intent(SignupActivity.this, HomeActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignupActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}