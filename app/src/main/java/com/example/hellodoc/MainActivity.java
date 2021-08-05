package com.example.hellodoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
TextInputLayout email1,passwd1;
ProgressBar pg;
CheckBox rememberme;
    HashMap<String,String> userCred = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pg = findViewById(R.id.progressbar);
        rememberme=findViewById(R.id.rememberme);

        pg.setVisibility((View.GONE));
        email1 = findViewById(R.id.email);
        passwd1 = findViewById(R.id.passwd);
        TextInputEditText phone=findViewById(R.id.phone);
        TextInputEditText pass=findViewById(R.id.pass);
        Button reg = (Button) findViewById(R.id.regist);
        Button skipbtn=(Button)findViewById(R.id.skip);
        Button fp=(Button)findViewById(R.id.fp);

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setVisibility((View.GONE));
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(MainActivity.this, logged_in.class);
                startActivity(secondactivity1);
            }

        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setVisibility((View.GONE));
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(MainActivity.this, register.class);
                startActivity(secondactivity1);
            }

        });
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setVisibility((View.GONE));
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(MainActivity.this, logged_in.class);
                startActivity(secondactivity1);
            }
        });
        /*TextView textView = findViewById(R.id.textView);
        String text = "Forgot your login details? Get help with signing in.";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(MainActivity.this, Search.class);
                startActivity(secondactivity1);
            }
        };
         //ss.setSpan(clickableSpan,27,51, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
          ///textView.setText(ss);
          //textView.setMovementMethod(LinkMovementMethod.getInstance());*/ //CLICKABLE TEXT LINK
    }
    private Boolean validatePhone() {
        String val = email1.getEditText().getText().toString();
        String phonepattern = "[0-9]{10}";
        if (val.isEmpty()) {
            email1.setError("Field cannot be empty");
            return false;
        } else   if(!val.matches(phonepattern)) {
           {
                email1.setError("Inavlid phone");
                return false;
            }

        } else {
            email1.setError(null);
            return true;
        }
    }
    private Boolean validatePass() {
        String val = passwd1.getEditText().getText().toString();
        if (val.isEmpty()) {
            passwd1.setError("Field cannot be empty");
            return false;
        } else {
            passwd1.setError(null);
            passwd1.setErrorEnabled(false);
            return true;
        }
    }
    public void sin(View view) {
        if(!validatePhone() || !validatePass()) {
            return;
        }
        pg.setVisibility((View.VISIBLE));
        isUser();
    }
    private void isUser() {
       final String userphone = email1.getEditText().getText().toString().trim();
        final String userpass = passwd1.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Usercred");
        Query checkUsercred = reference.orderByChild("phone").equalTo(userphone);

        checkUsercred.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    email1.setError(null);
                    email1.setErrorEnabled(false);
                    String passwordfromDB = snapshot.child(userphone).child("pass").getValue(String.class);

                    if (passwordfromDB.equals(userpass)) {
                        email1.setError(null);
                        email1.setErrorEnabled(false);

                            //String mailfromDB = snapshot.child(userphone).child("mail").getValue(String.class);
                            //String phonefromDB = snapshot.child(userphone).child("phone").getValue(String.class);
                            Intent secondactivity1 = new Intent();
                            secondactivity1.setClass(MainActivity.this, logged_in.class);
                        if(rememberme.isChecked()) {
                            userCred.put(userphone,userpass);
                        }
                        secondactivity1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(secondactivity1);


                    } else {
                        pg.setVisibility((View.GONE));
                        passwd1.setError("Wrong password");
                        passwd1.requestFocus();
                    }
                }
                else
                {
                    pg.setVisibility((View.GONE));
                    email1.setError("No such user exist");
                    email1.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}