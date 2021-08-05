package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class advbooking extends AppCompatActivity {
    private Calendar calendar,cal;
    private SimpleDateFormat dateFormat,dF;
    private String date,d;
    Button ab1,ab2,ab3,ab4,ab5,ab6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advbooking);
        calendar = Calendar.getInstance();
        cal = Calendar.getInstance();
        ab1 = findViewById(R.id.ab1);
        ab2 = findViewById(R.id.ab2);
        ab3 = findViewById(R.id.ab3);
        ab4 = findViewById(R.id.ab4);
        ab5 = findViewById(R.id.ab5);
        ab6 = findViewById(R.id.ab6);
        final String time = getIntent().getStringExtra("time");
        final String dname = getIntent().getStringExtra("dname");
        final String city = getIntent().getStringExtra("city");
        final String fees = getIntent().getStringExtra("fees");
        final  String paid = getIntent().getStringExtra("not paid");
        final boolean status = false;
        final String date1,date2,date3,date4,date5,date6;
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dF = new SimpleDateFormat("dd/MM/yyyy");
        {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            date = dateFormat.format(calendar.getTime());
            date1 = date;
            d = dF.format(calendar.getTime());
            SpannableStringBuilder spanSin = new SpannableStringBuilder();
            SpannableString itemasin = new SpannableString("(2/4) SLOTS AVAILABLE\n");
            itemasin.setSpan(new AbsoluteSizeSpan(20, true), 0, itemasin.length(), 0);
            itemasin.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, itemasin.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanSin.append(itemasin);
            SpannableString itemsin = new SpannableString(" " + date);
            itemsin.setSpan(new AbsoluteSizeSpan(15, true), 0, itemsin.length(), 0);
            spanSin.append(itemsin);
            ab1.setText(spanSin, TextView.BufferType.SPANNABLE);
        }    //code for different text size in a button

        ab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(advbooking.this, booking.class);
                secondactivity1.putExtra("time",time);
                String d = date1;
                secondactivity1.putExtra("d",d);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                secondactivity1.putExtra("fees",fees);
                secondactivity1.putExtra("paid",paid);
                secondactivity1.putExtra("status",status);
                startActivity(secondactivity1);
            }
        });

        {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            date = dateFormat.format(calendar.getTime());
            date2 = date;
            SpannableStringBuilder spanSin = new SpannableStringBuilder();
            SpannableString itemasin = new SpannableString("(2/4) SLOTS AVAILABLE\n");
            itemasin.setSpan(new AbsoluteSizeSpan(20, true), 0, itemasin.length(), 0);
            itemasin.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, itemasin.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanSin.append(itemasin);
            SpannableString itemsin = new SpannableString(" " + date);
            itemsin.setSpan(new AbsoluteSizeSpan(15, true), 0, itemsin.length(), 0);
            spanSin.append(itemsin);
            ab2.setText(spanSin, TextView.BufferType.SPANNABLE);
        }   //code for different text size in a button

        ab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(advbooking.this, booking.class);
                secondactivity1.putExtra("time",time);
                String d = date2;
                secondactivity1.putExtra("d",d);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                secondactivity1.putExtra("fees",fees);
                secondactivity1.putExtra("paid",paid);
                secondactivity1.putExtra("status",status);
                startActivity(secondactivity1);
            }
        });

        {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            date = dateFormat.format(calendar.getTime());
            date3 = date;
            SpannableStringBuilder spanSin = new SpannableStringBuilder();
            SpannableString itemasin = new SpannableString("(2/4) SLOTS AVAILABLE\n");
            itemasin.setSpan(new AbsoluteSizeSpan(20, true), 0, itemasin.length(), 0);
            itemasin.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, itemasin.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanSin.append(itemasin);
            SpannableString itemsin = new SpannableString(" " + date);
            itemsin.setSpan(new AbsoluteSizeSpan(15, true), 0, itemsin.length(), 0);
            spanSin.append(itemsin);
            ab3.setText(spanSin, TextView.BufferType.SPANNABLE);
        }   //code for different text size in a button

        ab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(advbooking.this, booking.class);
                secondactivity1.putExtra("time",time);
                String d = date3;
                secondactivity1.putExtra("d",d);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                secondactivity1.putExtra("fees",fees);
                secondactivity1.putExtra("paid",paid);
                secondactivity1.putExtra("status",status);
                startActivity(secondactivity1);
            }
        });

        {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            date = dateFormat.format(calendar.getTime());
            date4 = date;
            SpannableStringBuilder spanSin = new SpannableStringBuilder();
            SpannableString itemasin = new SpannableString("(2/4) SLOTS AVAILABLE\n");
            itemasin.setSpan(new AbsoluteSizeSpan(20, true), 0, itemasin.length(), 0);
            itemasin.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, itemasin.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanSin.append(itemasin);
            SpannableString itemsin = new SpannableString(" " + date);
            itemsin.setSpan(new AbsoluteSizeSpan(15, true), 0, itemsin.length(), 0);
            spanSin.append(itemsin);
            ab4.setText(spanSin, TextView.BufferType.SPANNABLE);
        }   //code for different text size in a button

        ab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(advbooking.this, booking.class);
                secondactivity1.putExtra("time",time);
                String d = date4;
                secondactivity1.putExtra("d",d);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                secondactivity1.putExtra("fees",fees);
                secondactivity1.putExtra("paid",paid);
                secondactivity1.putExtra("status",status);
                startActivity(secondactivity1);
            }
        });

        {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            date = dateFormat.format(calendar.getTime());
            date5 = date;
            SpannableStringBuilder spanSin = new SpannableStringBuilder();
            SpannableString itemasin = new SpannableString("(2/4) SLOTS AVAILABLE\n");
            itemasin.setSpan(new AbsoluteSizeSpan(20, true), 0, itemasin.length(), 0);
            itemasin.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, itemasin.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanSin.append(itemasin);
            SpannableString itemsin = new SpannableString(" " + date);
            itemsin.setSpan(new AbsoluteSizeSpan(15, true), 0, itemsin.length(), 0);
            spanSin.append(itemsin);
            ab5.setText(spanSin, TextView.BufferType.SPANNABLE);
        }   //code for different text size in a button

        ab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(advbooking.this, booking.class);
                secondactivity1.putExtra("time",time);
                String d = date5;
                secondactivity1.putExtra("d",d);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                secondactivity1.putExtra("fees",fees);
                secondactivity1.putExtra("paid",paid);
                secondactivity1.putExtra("status",status);
                startActivity(secondactivity1);
            }
        });

        {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            date = dateFormat.format(calendar.getTime());
            date6 = date;
            SpannableStringBuilder spanSin = new SpannableStringBuilder();
            SpannableString itemasin = new SpannableString("(2/4) SLOTS AVAILABLE\n");
            itemasin.setSpan(new AbsoluteSizeSpan(20, true), 0, itemasin.length(), 0);
            itemasin.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, itemasin.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spanSin.append(itemasin);
            SpannableString itemsin = new SpannableString(" " + date);
            itemsin.setSpan(new AbsoluteSizeSpan(15, true), 0, itemsin.length(), 0);
            spanSin.append(itemsin);
            ab6.setText(spanSin, TextView.BufferType.SPANNABLE);
        }   //code for different text size in a button

        ab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(advbooking.this, booking.class);
                secondactivity1.putExtra("time",time);
                String d = date6;
                secondactivity1.putExtra("d",d);
                secondactivity1.putExtra("dname",dname);
                secondactivity1.putExtra("city",city);
                secondactivity1.putExtra("fees",fees);
                secondactivity1.putExtra("paid",paid);
                secondactivity1.putExtra("status",status);
                startActivity(secondactivity1);
            }
        });

    }
}