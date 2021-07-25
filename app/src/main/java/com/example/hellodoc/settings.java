package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView ab  = findViewById(R.id.ab);
        ab.setText("Developed By : Jyoti Ranjan Rout\n\t\t\t\t\t\t\t\t\t\t  Ippsa Mahana\n\t\t\t\t\t\t\t\t\t\t  Jaekisen Aggarwal\n\t\t\t\t\t\t\t\t\t\t  Dikshant Mohapatra \n\n Version 1.0.1");
    }
}