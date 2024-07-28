package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SigninActivity extends Signin__Activity implements Signin_Activity {
    private FirebaseAuth mAuth;
    private FirebaseDatabase data_base;

    public SigninActivity(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        data_base = FirebaseDatabase.getInstance();
        Button next = findViewById(R.id.button3);
        next.setOnClickListener(this::onClick);
        EditText major2 = findViewById(R.id.major2);
        EditText university = findViewById(R.id.university);
        EditText degree = findViewById(R.id.degree);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void onClick(View view){
        Button next = findViewById(R.id.button3);
        next.setOnClickListener((View.OnClickListener) this);
        EditText email = findViewById(R.id.edit_email);
        EditText password = findViewById(R.id.edit_password);
        if(view==next){
            AuthEmailPassword(email.getText().toString(), password.getText().toString());
        }
    }

    public void AuthEmailPassword( String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            User user = new User(major2.getText().toString(), degree.getText.toString(), university.getText.toString, true);
                            String uid = mAuth.getCurrentUser().getUid().toString();
                            database.getReference("Users").child(uid).setValue(user);
                            Intent intent1 = new Intent(SigninActivity.this,HomeActivity.class);
                            startActivity(intent1);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SigninActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

}