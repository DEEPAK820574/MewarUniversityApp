package com.example.mewarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity1 extends AppCompatActivity {
CardView card1,card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main1);
        card1=findViewById(R.id.cardmenu);
        card2=findViewById(R.id.cardchatbot);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home=new Intent(MainActivity1.this,MainActivity.class);
                startActivity(home);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home=new Intent(MainActivity1.this,MainActivity3.class);
                startActivity(home);
            }
        });
    }
}