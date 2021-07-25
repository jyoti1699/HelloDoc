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
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellodoc.HelperClass.HomeAdapter.MostAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.MostHelperClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ViewProduct extends AppCompatActivity {
    ImageView imageView;
    TextView prtitle,prpice,proldprice,proffer;
    RatingBar prrbar;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Button addedtocart,order;
    RecyclerView featuredRecycler,mRecycler;
    RecyclerView.Adapter adapter,madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);
        Bundle bundle = getIntent().getExtras();
        final int resId = bundle.getInt("resId");
        final String title = getIntent().getStringExtra("title");
        final String price = getIntent().getStringExtra("price");
       final String oldprice = getIntent().getStringExtra("offer");
        final String offer = getIntent().getStringExtra("oldprice");
        final float productrbar = getIntent().getFloatExtra("rbar",3);
        prrbar = findViewById(R.id.productrbar);
        prrbar.setRating(productrbar);
        imageView = findViewById(R.id.productimage);
        prtitle = findViewById(R.id.producttitle);
        prpice = findViewById(R.id.productprice);
        proldprice = findViewById(R.id.productoldprice);
        proffer = findViewById(R.id.productoffer);
        mRecycler = findViewById(R.id.mrecycler);
        mRecycler();

        imageView.setImageResource(resId);
        prtitle.setText(title);
        prpice.setText(price);
        proldprice.setText(oldprice);
        proffer.setText(offer);
        addedtocart = findViewById(R.id.productaddtocart);
        addedtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
               // secondactivity1.setClass(ViewProduct.this, Search.class);
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("addtocart/product");
                //startActivity(new Intent(getApplicationContext(), cart.class));
                AddtocartUserhelperclass helperclass = new  AddtocartUserhelperclass(title,price,oldprice,resId);
                reference.child(title).setValue(helperclass);
                Toast.makeText(ViewProduct.this, "Added to cart", Toast.LENGTH_LONG).show();
                //startActivity(secondactivity1);
            }

        });
        order  = findViewById(R.id.productorder);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                 secondactivity1.setClass(ViewProduct.this, OrderSummary.class);
                //startActivity(new Intent(getApplicationContext(), cart.class));
                secondactivity1.putExtra("resId",resId);
                secondactivity1.putExtra("title",title);
                secondactivity1.putExtra("price",price);
                startActivity(secondactivity1);
            }

        });
    }
    private void mRecycler() {
        mRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        mRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<MostHelperClass> mLocations = new ArrayList<>();
        mLocations.add(new MostHelperClass(R.drawable.nnfive,"60% 0ff","N-95 Mask (Buy 2 get 1 free)","₹300"));
        mLocations.add(new MostHelperClass(R.drawable.san1,"50% 0ff","Oriley Advanced Sanitizer 1000 ml","₹600"));
        mLocations.add(new MostHelperClass(R.drawable.san2,"30% 0ff","Dettol Dininfectant Spray With Spring Blossom Essence","₹750"));
        mLocations.add(new MostHelperClass(R.drawable.volini,"60% 0ff","Volini Spray With Advanced Relief Formula","₹100"));
        mLocations.add(new MostHelperClass(R.drawable.bpmachine,"45% 0ff","Blood Pressure Checker","₹1250"));
        mLocations.add(new MostHelperClass(R.drawable.himalaya,"20% 0ff","Himalaya LeanCare With Weight Management","₹650"));
        mLocations.add(new MostHelperClass(R.drawable.dex1,"20% 0ff","DexOrange Syrup 200 ml Hemantinic Syrup with Iron, Folic Acid, Vitamin B12 ","₹250"));
        mLocations.add(new MostHelperClass(R.drawable.bpmachine2,"50% 0ff","OMRON Blood Pressure Meter With Advanced Storage","₹1500"));
        mLocations.add(new MostHelperClass(R.drawable.dex2,"10% 0ff","DexOrange Tablets Hematinic Capsules 30 Capsules","₹300"));


        madapter = new MostAdapter(mLocations);
        mRecycler.setAdapter(madapter);

    }
}