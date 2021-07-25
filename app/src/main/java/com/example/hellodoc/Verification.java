package com.example.hellodoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Verification extends AppCompatActivity {
Button ver;
String verificationcodebysystem;
EditText phonenumber;
ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
          ver = (Button) findViewById(R.id.submit);
          phonenumber = findViewById(R.id.pnumber);
          progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility((View.GONE));
          String phoneNo = getIntent().getStringExtra("Phone");
          sendVerificationtoUser(phoneNo);
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String code = phonenumber.getText().toString();
               if(code.isEmpty() || code.length()<6)
               {
                   phonenumber.setError("Wrong OTP");
                   phonenumber.requestFocus();
                   return;
               }
               progressBar.setVisibility((View.VISIBLE));
               verifyCode(code);
            }

        });
    }
    private void sendVerificationtoUser(String phoneNo) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + phoneNo,        // Phone number to verify
                60,                 // Timeout duration`
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    } //SEND THE CODE
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationcodebysystem = s;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if(code!=null) {
                progressBar.setVisibility(View.VISIBLE);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(Verification.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }; //CODE SENT , CALLING BY ALL MEANS,
    private void verifyCode(String verificationCode) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationcodebysystem,verificationCode);
        signInthUserByCredentials(credential);
    } //CREATE A CREDENTIAL ..AND PASS THIS CREDENTIAL TO SIGNINTHEUSER METHOD
    private void signInthUserByCredentials(PhoneAuthCredential credential ) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(Verification.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()) {
                       Intent pass1 = new Intent(getApplicationContext(),passw.class);
                       String v = getIntent().getStringExtra("Name");
                       String vv = getIntent().getStringExtra("Mail");
                       String vvv = getIntent().getStringExtra("Phone");
                       pass1.putExtra("v",v);
                       pass1.putExtra("vv",vv);
                       pass1.putExtra("vvv",vvv);
                       pass1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(pass1);
                   }
                   else
                   {
                       Toast.makeText(Verification.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                   }
                    }
                });

    } //FIREBASE AUTHENTICATION.. IT WILL MATCH THE CODE SENT TO PHONE WITH THE FIREBASE
}