package com.example.mewarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        Intent home=new Intent(SplashActivity2.this,MainActivity1.class);

       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(home);
                finish();
            }
        }, 4000);
    }
}