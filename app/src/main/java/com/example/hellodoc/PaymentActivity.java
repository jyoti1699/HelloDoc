package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {

    Button paybtn;
    TextView amount;
    String fee,fees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        paybtn=findViewById(R.id.pay);
        amount=findViewById(R.id.amount);

        fees = getIntent().getStringExtra("fees");
        fee=fees.substring(1,4);
        Checkout.preload(getApplicationContext());
        amount.setText("Fees : ₹"+fee);

        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayNow(fee);
            }
        });


    }
    private void PayNow(String amount) {

        final Activity activity = this;

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_gMuAn5CJRPorGI");
        checkout.setImage(R.drawable.ic_launcher_background);

        double finalAmount = Float.parseFloat(amount)*100;

        try {
            JSONObject options = new JSONObject();
            options.put("name", "HelloDoc");
            options.put("description", "Reference No. #123456");
            options.put("image", R.drawable.hd1);
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", finalAmount+"");//300 X 100
            options.put("prefill.email", "kanha.x@example.com");
            options.put("prefill.contact","8279766744");

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }
    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(getApplicationContext(),"Payment Success!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(PaymentActivity.this, booking.class);
        String fees = getIntent().getStringExtra("fees");
        String city = getIntent().getStringExtra("city");
        String time = getIntent().getStringExtra("time");
        String dname = getIntent().getStringExtra("dname");
        String date = getIntent().getStringExtra("date");
        boolean status = true;
        intent.putExtra("fees",fees);
        intent.putExtra("status",status);
        intent.putExtra("city",city);
        intent.putExtra("time",time);
        intent.putExtra("dname",dname);
        intent.putExtra("d",date);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),"Payment Failure!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(PaymentActivity.this, booking.class);
        String fees = getIntent().getStringExtra("fees");
        String city = getIntent().getStringExtra("city");
        String time = getIntent().getStringExtra("time");
        String dname = getIntent().getStringExtra("dname");
        String date = getIntent().getStringExtra("date");
        boolean status = false;
        intent.putExtra("status",status);
        intent.putExtra("fees",fees);
        intent.putExtra("city",city);
        intent.putExtra("time",time);
        intent.putExtra("dname",dname);
        intent.putExtra("d",date);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}