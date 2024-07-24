package com.example.devtask2;

import static com.example.devtask2.R.id.users_list;
import static com.example.devtask2.R.layout.activity_main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);


        Button signup = findViewById(R.id.button3);
        signup.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HomeActivity.class)));

        Button submit4;
        submit4 = findViewById(R.id.button);
        submit4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SignUpActivity.class)));
    }
}