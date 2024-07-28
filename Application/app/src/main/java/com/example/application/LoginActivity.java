package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText email = findViewById(R.id.edit_email);
        EditText password = findViewById(R.id.edit_password);

        Button login_submit = findViewById(R.id.button7);
        login_submit.setOnClickListener(this);

        Button signup = findViewById(R.id.button8);
        signup.setOnClickListener(this);

    }


    @Override
    public void onClick(View view){
        Button login_submit = findViewById(R.id.button7);
        Button signup = findViewById(R.id.button8);

        if (login_submit == view){
            login_user(email.getText().toString(), password.getText().toString());
        }
        else if( view == signup){
            signup.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, SigninActivity.class)));

        }
    }

    public void login_user(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent1 = new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(intent1);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }


    }
