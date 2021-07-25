package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class passw extends AppCompatActivity {
    AppCompatTextView welcum,welcum1;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    TextInputLayout pass,cpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passw);
        Toast.makeText(passw.this, "Phone Verifictaion Successful", Toast.LENGTH_LONG).show();
        pass = findViewById(R.id.password);
        cpass = findViewById(R.id.cpassword);
        welcum = findViewById(R.id.wel);
       welcum1 = findViewById(R.id.wel1);
        welcum.setText("Hello "+getIntent().getStringExtra("v")+",");
       /*Button getin = (Button) findViewById(R.id.gn);
        getin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Usercred");
                String mail = getIntent().getStringExtra("vv");
                String phone = getIntent().getStringExtra("vvv");
                String Pass = pass.getEditText().getText().toString();
                Userhelper helper = new Userhelper(mail,phone,Pass);
                reference.child(phone).setValue(helper);
                Toast.makeText(passw.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

     private Boolean validatePass() {
         welcum1.setText(null);
        String val = pass.getEditText().getText().toString();
        String val1 = cpass.getEditText().getText().toString();
        String passval = "^"
                +"(?=.*[a-zA-Z])" //any letter
                +"(?=.*[@#$%^&+=])" //atleast on special character
                +"(?=.\\S+$)" //no_white spaces
                +".{6,}" //at least 6 char
                + "$";

        if (val.isEmpty()) {
            pass.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passval)) {
            pass.setError("Password too weak");
            return false;
        } else if (!val.matches(val1)) {
            welcum1.setTextColor(Color.parseColor("#FF0000"));
            welcum1.setText("Password not matched");
            return false;
        } else if (val.matches(val1)) {
            welcum1.setTextColor(Color.parseColor("#32C12D"));
            welcum1.setText("Password matched");
            return true;
        }
        else {
            pass.setError(null);
            pass.setErrorEnabled(false);
            return true;
        }
    }

    public void gin(View view) {
        if (!validatePass()) {

            return;
        }
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Usercred");
        String name = getIntent().getStringExtra("v");
        String mail = getIntent().getStringExtra("vv");
        String phone = getIntent().getStringExtra("vvv");
        String Pass = pass.getEditText().getText().toString();
        Userhelper helper = new Userhelper(name,mail,phone,Pass);
        reference.child(phone).setValue(helper);
        Toast.makeText(passw.this, "Success", Toast.LENGTH_SHORT).show();
        Intent logdin = new Intent(getApplicationContext(),logged_in.class);
        logdin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(logdin);
    }
}