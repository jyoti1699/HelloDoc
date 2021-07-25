package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderSummary extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    TextInputLayout name,adress,pin,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        name = findViewById(R.id.cname);
        adress = findViewById(R.id.cadress);
        pin = findViewById(R.id.cpin);
        contact = findViewById(R.id.ccontact);
        final TextView price  = findViewById(R.id.price);
        final TextView title = findViewById(R.id.prodname);
        Bundle bundle = getIntent().getExtras();
        ImageView prodimage = findViewById(R.id.prodimage);
        final int resId = bundle.getInt("resId");
        prodimage.setImageResource(resId);
        price.setText("Price : "+getIntent().getStringExtra("price"));
        title.setText(" "+getIntent().getStringExtra("title"));


        final Spinner spinnerPay=(Spinner)findViewById(R.id.spinnerpay);

        String[] options={
                "Cash on Delivery",
                "Mobile payments",
                "Ewallets",
                "Bank Transfers",
        };
        ArrayAdapter optionsArray=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,options);
        spinnerPay.setAdapter(optionsArray);

        final Spinner spinnerqnt=(Spinner)findViewById(R.id.spinnerqnt);
        String[] qntoptions={
                "1",
                "2",
                "3",
                "4","5","6","7","8","9","10"
        };
        ArrayAdapter qntoptionsArray=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,qntoptions);
        spinnerqnt.setAdapter(qntoptionsArray);
        Button prodorder = findViewById(R.id.prodorder);
        prodorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(OrderSummary.this, OrderConfirm.class);
                String CName = name.getEditText().getText().toString();
                String CAdress = adress.getEditText().getText().toString();
                String CPin = pin.getEditText().getText().toString();
                String CContact = contact.getEditText().getText().toString();
                String quantity = spinnerqnt.getSelectedItem().toString();
                String payment = spinnerPay.getSelectedItem().toString();
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("orders/product");
                Orderhelperclass orderhelperclass = new Orderhelperclass(getIntent().getStringExtra("title"),CName,CAdress,payment,quantity,CContact,CPin,resId,getIntent().getStringExtra("price"));
                //startActivity(new Intent(getApplicationContext(), cart.class));
                reference.child(CContact).setValue(orderhelperclass);
               // secondactivity1.putExtra("resId",resId);
                secondactivity1.putExtra("title",getIntent().getStringExtra("title"));
                secondactivity1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //secondactivity1.putExtra("price",price);
                startActivity(secondactivity1);
            }

        });

    }
}