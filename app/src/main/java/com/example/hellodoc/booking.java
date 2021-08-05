package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class booking extends AppCompatActivity {
    TextInputLayout pname,page,paadhar,pcontact;
    TextView textVieww;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private Calendar calendar;
    private SimpleDateFormat dateFormat,dF;
    Button paynow;
    TextView paymentstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        TextView textView2 = findViewById(R.id.t2);
        String fees = getIntent().getStringExtra("fees");
        String pay = getIntent().getStringExtra("paid");
        final boolean status = getIntent().getBooleanExtra("status",true);

        paymentstatus=findViewById(R.id.paymentstatus);
        //Toast.makeText(booking.this,paid+" "+notpaid+" "+pay,Toast.LENGTH_LONG).show();
       if( status==true )
        {
            paymentstatus.setText("Amount : "+fees+" \n"
                    +"Payment Status : Paid");



        }
        else if( status==false )
        {
            paymentstatus.setText("Amount : "+fees+" \n"
                    +"Payment Status : Not Paid");

        }



        textView2.setText("Please fill out these details.");
        Button bapnt=(Button)findViewById(R.id.bapnt);
        pname = findViewById(R.id.patientname);
        page = findViewById(R.id.age);
        paadhar = findViewById(R.id.aadhar);
        pcontact = findViewById(R.id.contact);
        //dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        calendar = Calendar.getInstance();
       final String time = getIntent().getStringExtra("time");
        final String dname = getIntent().getStringExtra("dname");
        final String city = getIntent().getStringExtra("city");
        final String date = getIntent().getStringExtra("d");
       // Toast.makeText(booking.this,time+" "+dname+" "+city+" "+date,Toast.LENGTH_LONG).show();
        bapnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dF = new SimpleDateFormat("dd-MM-yyyy");
                //String date = dF.format(calendar.getTime());
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("booking").child(city);
            String PName = pname.getEditText().getText().toString();
            String PAge = page.getEditText().getText().toString();
            String PAadhar = paadhar.getEditText().getText().toString();
            String PContact = pcontact.getEditText().getText().toString();
              UserClass helperclass = new UserClass(PName, PAge, PAadhar,dname, date, time, PContact,status);
                //textVieww.setText(date);
                reference.child(PAadhar).setValue(helperclass);
                Intent secondactivity1 = new Intent();
                secondactivity1.putExtra("time",time);
                secondactivity1.putExtra("dname",dname);
               secondactivity1.putExtra("date",date);
                secondactivity1.putExtra("PName",PName);
                secondactivity1.putExtra("PAadhar",PAadhar);
                secondactivity1.putExtra("PAge",PAge);
                secondactivity1.putExtra("PContact",PContact);
                secondactivity1.putExtra("status",status);
                secondactivity1.setClass(booking.this, cofirm_booking.class);
                secondactivity1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(secondactivity1);
            }

        });

        paynow=findViewById(R.id.paynow);

        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(booking.this, PaymentActivity.class);
                String fees = getIntent().getStringExtra("fees");
                intent.putExtra("fees",fees);
                intent.putExtra("city",city);
                intent.putExtra("time",time);
                intent.putExtra("dname",dname);
                intent.putExtra("date",date);
                startActivity(intent);
            }
        });
    }
}