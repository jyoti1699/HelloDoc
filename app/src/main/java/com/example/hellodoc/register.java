package com.example.hellodoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    TextInputLayout name, email, phone;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.regName1);
        email = findViewById(R.id.regMail1);
        phone = findViewById(R.id.regPhone1);
        /*Button signup = (Button) findViewById(R.id.buttonsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("User");
                String Name = name.getEditText().getText().toString();
                String Mail = email.getEditText().getText().toString();
                String Phone = phone.getEditText().getText().toString();
                UserHelperclass helperclass = new UserHelperclass(Name, Mail, Phone);
                reference.child(Phone).setValue(helperclass);
                Intent verify = new Intent(getApplicationContext(),Verification.class);
                verify.putExtra("Name",Name);
                verify.putExtra("Mail",Mail);
                verify.putExtra("Phone",Phone);
                startActivity(verify);
            }
        });*/
        AppCompatTextView textView = findViewById(R.id.clickable);
        String text = "Click here to read our privacy policy.";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(register.this, "No privacy policy", Toast.LENGTH_SHORT).show();
            }
        };
        ss.setSpan(clickableSpan,0,38, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private Boolean validateName() {
        String val = name.getEditText().getText().toString();
        if (val.isEmpty()) {
            name.setError("Field cannot be empty");
            return false;
        } else {
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateMail() {
        String val = email.getEditText().getText().toString();
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailpattern)) {
            email.setError("Inavlid mail");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private Boolean validatePhone() {
        String val = phone.getEditText().getText().toString();
        if (val.isEmpty()) {
            phone.setError("Field cannot be empty");
            return false;
        } else {
            phone.setError(null);
            return true;
        }
    }

    public void regUser(View view) {
       if (!validateName() || !validateMail() || !validatePhone()) {
            return;
        }
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("User");
       String Name = name.getEditText().getText().toString();
        String Mail = email.getEditText().getText().toString();
        String Phone = phone.getEditText().getText().toString();
        UserHelperclass helperclass = new UserHelperclass(Name, Mail, Phone);
        reference.child(Phone).setValue(helperclass);
        Intent verify = new Intent(getApplicationContext(),Verification.class);
        verify.putExtra("Name",Name);
        verify.putExtra("Mail",Mail);
        verify.putExtra("Phone",Phone);
        startActivity(verify);

    }
}

