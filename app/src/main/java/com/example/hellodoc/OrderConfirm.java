package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class OrderConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        TextView t1 = findViewById(R.id.orderdetails);
        t1.setText("Your Order for "+getIntent().getStringExtra("title")+" has been recorded.\nYour package will be delivered in 3-4 working days.");
        Button btn = findViewById(R.id.gthomepage1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(OrderConfirm.this, product_list.class);
                secondactivity1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(secondactivity1);
            }

        });
    }
}