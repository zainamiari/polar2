package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    Button clk;
    VideoView video;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        clk = (Button) findViewById(R.id.button6);
        video = (VideoView) findViewById(R.id.VideoView);

        Button go_back = findViewById(R.id.button5);
        go_back.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, MainActivity.class)));



    }

    public void videoplay(View v)
    {
        String videopath = "android.resource://com.example.application/"+R.raw.Bridgers;
        Uri uri = Uri.parse(videopath);
        video.setVideoURI(uri);
        video.start();


    }
}

