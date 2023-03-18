package com.example.mewarapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
CardView card1,card2,card3,card4,card5,card6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        card5=findViewById(R.id.card5);
        card6=findViewById(R.id.card6);


        //action on card click=>>

        card1.setOnClickListener(view -> {

            Toast.makeText(MainActivity.this, "Course and Fee Structure Tab Opening", Toast.LENGTH_SHORT).show();
            String url="http://www.mewaruniversity.org/pages/Course_Fee_Structure.aspx";
            Intent  i= new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);});
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Training And Placement Tab Opening", Toast.LENGTH_SHORT).show();
                String url="http://www.mewaruniversity.org/pages/Training_and_Placement.aspx";
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }

        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Admission Form Tab Opening", Toast.LENGTH_SHORT).show();
                String url="http://www.mewaruniversity.org/pages/Admission_Form.aspx";
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Admission Enquiry Tab Opening", Toast.LENGTH_SHORT).show();
                String url="http://www.mewaruniversity.org/pages/OnlineEntranceExam.aspx";
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        card5.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Website Details opening", Toast.LENGTH_SHORT).show();
        String url="https://www.mewaruniversity.org/pages/default.aspx";
        Intent i= new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Contact Details opening", Toast.LENGTH_SHORT).show();
                String url="http://www.mewaruniversity.org/pages/Contact_Details.aspx";
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });



    }
}