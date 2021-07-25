package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.FirebaseDatabase;

public class EnterBookingDetails extends AppCompatActivity {
    TextInputLayout mbcity,mbaadhar;
    Button booksearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_booking_details);
        mbcity = findViewById(R.id.mbcity);
        mbaadhar = findViewById(R.id.mbaadhar);
        booksearch  = findViewById(R.id.mbsearch);
        booksearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(EnterBookingDetails.this, MyBookings.class);
                secondactivity1.putExtra("mbcity", mbcity.getEditText().getText().toString().toLowerCase());
                secondactivity1.putExtra("mbaadhar", mbaadhar.getEditText().getText().toString());
                //secondactivity1.putExtra("price",price);
                startActivity(secondactivity1);
            }

        });

    }
}