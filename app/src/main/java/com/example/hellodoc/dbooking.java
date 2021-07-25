package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dbooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbooking);


        TextView textView1 = findViewById(R.id.t1);
        TextView textView2 = findViewById(R.id.t2);
        textView1.setText(" "+getIntent().getStringExtra("name"));

        textView2.setText(" "+getIntent().getStringExtra("specs")+
                "\n Address : "+getIntent().getStringExtra("addr")+
                "\n Phone : "+getIntent().getStringExtra("phone")+
                "\n Fee : "+getIntent().getStringExtra("fees"));
        float r = getIntent().getFloatExtra("drbar",4);
        RatingBar rb = findViewById(R.id.dbar);
        rb.setRating(r);
        Button b1,b2,b3,b4,b5,b6;
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(dbooking.this, advbooking.class);
                String time = "9 AM - 10 AM";
                String dname = getIntent().getStringExtra("name");
                String city = getIntent().getStringExtra("cit");
                secondactivity1.putExtra("time",time);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                startActivity(secondactivity1);
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(dbooking.this, advbooking.class);
                String time = "10 AM - 11 AM";
                String dname = getIntent().getStringExtra("name");
                String city = getIntent().getStringExtra("cit");
                secondactivity1.putExtra("time",time);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                startActivity(secondactivity1);
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(dbooking.this, advbooking.class);
                String time = "11 AM - 12 PM";
                String dname = getIntent().getStringExtra("name");
                String city = getIntent().getStringExtra("cit");
                secondactivity1.putExtra("time",time);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                startActivity(secondactivity1);
            }

        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(dbooking.this, advbooking.class);
                String time = "4 PM - 5 PM";
                String dname = getIntent().getStringExtra("name");
                String city = getIntent().getStringExtra("cit");
                secondactivity1.putExtra("time",time);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                startActivity(secondactivity1);
            }

        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(dbooking.this, advbooking.class);
                String time = "5 PM - 6 PM";
                String dname = getIntent().getStringExtra("name");
                String city = getIntent().getStringExtra("cit");
                secondactivity1.putExtra("time",time);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                startActivity(secondactivity1);
            }

        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(dbooking.this, advbooking.class);
                String time = "6 PM - 7 PM";
                String dname = getIntent().getStringExtra("name");
                String city = getIntent().getStringExtra("cit");
                secondactivity1.putExtra("time",time);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                startActivity(secondactivity1);
            }

        });

    }
}