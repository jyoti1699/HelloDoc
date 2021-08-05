package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class cofirm_booking extends AppCompatActivity {

    Button gthomepage,makeanotherappnt;
    TextView bookingdetails;
    String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cofirm_booking);
        gthomepage = findViewById(R.id.gthomepage);
       makeanotherappnt = findViewById(R.id.makeanotherappnt);

        gthomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(cofirm_booking.this, logged_in.class);
                secondactivity1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(secondactivity1);
            }

        });

        makeanotherappnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(cofirm_booking.this, Search.class);
                secondactivity1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(secondactivity1);
            }

        });

        bookingdetails = findViewById(R.id.bookingdetails);
        final String time = getIntent().getStringExtra("time");
        final String dname = getIntent().getStringExtra("dname");
        final String date = getIntent().getStringExtra("date");
        final String PName = getIntent().getStringExtra("PName");
        final String PAge = getIntent().getStringExtra("PAge");
        final String PAadhar = getIntent().getStringExtra("PAadhar");
        final String PContact = getIntent().getStringExtra("PContact");
        final boolean status = getIntent().getBooleanExtra("status",true);
      /*  if(stat==true)
        {
            p = "Paid";
        }*/
        /*bookingdetails.setText("  NAME : "+PName
                               +"\n  AGE : "+PAge
                               +"\n  AADHAR NUMBER : "+PAadhar
                               +"\n  DOCTOR NAME : "+dname
                               +"\n  Date & Time : "+date
                               +"\n  TIME : "+time);*/
       // TextView textView = (TextView) findViewById(R.id.mytextview01);
        Spannable word = new SpannableString("Class");
        word.setSpan(new ForegroundColorSpan(Color.GRAY), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bookingdetails.setText(word);
        Spannable wordTwo = new SpannableString("\n\n"+time);
        wordTwo.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bookingdetails.append(wordTwo);
        Spannable wordThree = new SpannableString("\n\nDoctors's Name");
        wordThree.setSpan(new ForegroundColorSpan(Color.GRAY), 0, wordThree.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bookingdetails.append(wordThree);
        Spannable wordFour = new SpannableString("\n\n"+dname);
        wordFour.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordFour.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bookingdetails.append(wordFour);
        Spannable wordFive = new SpannableString("\n\nDate & Time");
        wordFive.setSpan(new ForegroundColorSpan(Color.GRAY), 0, wordFive.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bookingdetails.append(wordFive);
        Spannable wordSix = new SpannableString("\n\n"+date+"\n"+time+" (GMT +5:30)");
        wordSix.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordSix.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bookingdetails.append(wordSix);
        Spannable wordSeven = new SpannableString("\n\nClient Details");
        wordSeven.setSpan(new ForegroundColorSpan(Color.GRAY), 0, wordSeven.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bookingdetails.append(wordSeven);
        Spannable wordEight = new SpannableString("\n\n"+PName+"\nAge : "+PAge+"\nAadhar Number : "+PAadhar+"\nContact No. : "+PContact);
        wordEight.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordEight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bookingdetails.append(wordEight);
        if(status==true)
        {
            Spannable wordNine = new SpannableString("\n\n"+"Amount : Paid");
            wordNine.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordNine.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            bookingdetails.append(wordNine);
        }
        else if(status==false)
        {
            Spannable wordNine = new SpannableString("\n\n"+"Amount : Not Paid");
            wordNine.setSpan(new ForegroundColorSpan(Color.BLACK), 0, wordNine.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            bookingdetails.append(wordNine);
        }
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.doorbell);
        mediaPlayer.start();


    }
}