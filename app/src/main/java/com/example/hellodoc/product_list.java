package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.hellodoc.HelperClass.HomeAdapter.MAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.MostAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.MHelperClass;

import java.util.ArrayList;

public class product_list extends AppCompatActivity {
    RecyclerView productRecycler;
    RecyclerView.Adapter padapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        productRecycler = findViewById(R.id.product_recycler);
        productRecycler();

        final Button cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(product_list.this, cartview.class);
                startActivity(secondactivity1);
            }

        });
    }
    private void productRecycler() {
        productRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        productRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ArrayList<MHelperClass> pLocations = new ArrayList<>();
        pLocations.add(new MHelperClass(R.drawable.nnfive,"₹5̶0̶0̶","N-95 Mask (Buy 2 get 1 free)","₹300","Save upto 50 by using coupons", (float) 3.5));
        pLocations.add(new MHelperClass(R.drawable.san1,"₹8̶5̶0̶","Oriley Advanced Sanitizer 1000 ml","₹600","Save upto 100 by using coupons",4));
        pLocations.add(new MHelperClass(R.drawable.san2,"₹3̶̶0̶0̶","Dettol Dininfectant Spray With Spring Blossom Essence","₹250","Save upto 30 by using coupons", (float) 4.5));
        pLocations.add(new MHelperClass(R.drawable.volini,"₹2̶̶0̶0̶","Volini Spray With Advanced Relief Formula","₹100","Save upto 10 by using coupons", (float) 3));
        pLocations.add(new MHelperClass(R.drawable.bpmachine,"₹̶1̶5̶0̶0","Blood Pressure Checker","₹1250","Save upto 150 by using coupons", (float) 5));
        pLocations.add(new MHelperClass(R.drawable.himalaya,"₹8̶5̶0","Himalaya LeanCare With Weight Management","₹650","Save upto 20 by using coupons", (float) 3.5));
        pLocations.add(new MHelperClass(R.drawable.dex1,"₹3̶0̶0","DexOrange Syrup 200 ml Hemantinic Syrup with Iron, Folic Acid, Vitamin B12 ","₹250","Save upto 40 by using coupons", (float) 4));
        pLocations.add(new MHelperClass(R.drawable.bpmachine2,"₹1̶7̶5̶0","OMRON Blood Pressure Meter With Advanced Storage","₹1500","Save upto 200 by using coupons", (float) 4));
        pLocations.add(new MHelperClass(R.drawable.dex2,"₹3̶5̶0̶","DexOrange Tablets Hematinic Capsules 30 Capsules","₹300","Save upto 60 by using coupons", (float) 2.5));


        padapter = new MAdapter(pLocations);
        productRecycler.setAdapter(padapter);
    }
}

