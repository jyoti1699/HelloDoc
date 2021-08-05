package com.example.hellodoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hellodoc.R;
import com.example.hellodoc.HelperClass.HomeAdapter.FeatureAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.FeatureHelperClass;
import com.example.hellodoc.HelperClass.HomeAdapter.MostAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.MostHelperClass;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


import java.util.ArrayList;

import static android.os.SystemClock.sleep;

public class logged_in extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView featuredRecycler,mRecycler;
    RecyclerView.Adapter adapter,madapter;
    Button book,v1,v2;
    private ViewPager cpager;
    private int[] clayouts = {R.layout.child1,R.layout.child2,R.layout.child3,R.layout.child4,R.layout.child5};
    private MpagerAdapter cpagerAdapter;
    private LinearLayout Dots_Layout1;
    private ImageView[] dots1;
    private ViewPager mpager;
    private int[] layouts = {R.layout.first_slide,R.layout.sec_slide,R.layout.third_slide,R.layout.fourth_slide,R.layout.fifth_slide,R.layout.sixth_slide,R.layout.sev_slide,};
    private MpagerAdapter mpagerAdapter;
    private LinearLayout Dots_Layout;
    private ImageView[] dots;
    ImageButton imageButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_logged_in);


        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);

        toolbar=findViewById(R.id.toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_myacc);

        imageButton = (ImageButton) findViewById(R.id.button);
        v1 = (Button) findViewById(R.id.vall1);
        v2 = (Button) findViewById(R.id.vall2);


        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, product_list.class);
                startActivity(secondactivity1);
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, product_list.class);
                startActivity(secondactivity1);
            }

        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(logged_in.this, "Ruk na be pehle app pura to ban ne de ", Toast.LENGTH_SHORT).show();
            }

        });

        featuredRecycler = findViewById(R.id.featured_recycler);
        mRecycler = findViewById(R.id.mrecycler);
        mRecycler();
        featuredRecycler();
        book = (Button) findViewById(R.id.book);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, Search.class);
                startActivity(secondactivity1);

            }

        });
        mpager = (ViewPager) findViewById(R.id.viewpager);
        mpagerAdapter=new MpagerAdapter(layouts,this);
        mpager.setAdapter(mpagerAdapter);

        Dots_Layout = (LinearLayout) findViewById(R.id.dotsLayout);
        createDots(0);
        mpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        cpager = (ViewPager) findViewById(R.id.viewpager1);
        cpagerAdapter=new MpagerAdapter(clayouts,this);
        cpager.setAdapter(cpagerAdapter);

        Dots_Layout1 = (LinearLayout) findViewById(R.id.dotsLayout1);
        createDots1(0);
        cpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots1(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true); //contain card views..only visible that user loads
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeatureHelperClass> featureLocations = new ArrayList<>();
        featureLocations.add(new FeatureHelperClass(R.drawable.proteinpwder,"JustHer Protein","7 Ayurvedic Blends, 7 clean nutrition promises, Zero Added Sugar, Preservatives Frees."));
        featureLocations.add(new FeatureHelperClass(R.drawable.proteinpwder2,"MuscleBlaze", "MuscleBlaze Beginner's Whey Protein Supplement (Chocolate, 1 Kg), For gym, workout, men."));
        featureLocations.add(new FeatureHelperClass(R.drawable.proteinpwder3,"Zenith Nutrition","Ultra Probiotic-10, 25 Billion CFU’s (For Healthy Digestion) - 60 Veg Capsules, Healthy life Happy life."));
        featureLocations.add(new FeatureHelperClass(R.drawable.proteinpwder4,"WOW Probiotics","WOW Probiotics 20 Billion CFU (14 Probiotic Strains) 500mg - 60 Vegetarian Capsules, Stay healthy Stay fit."));
        featureLocations.add(new FeatureHelperClass(R.drawable.proteinpwder5,"Threptin Lite","Threptin Lite - 275 g, 7 clean nutrition promises, 25 Billion CFU’s (For Healthy Digestion) - 60 Veg Capsules, healthy life."));

        adapter = new FeatureAdapter(featureLocations);
        featuredRecycler.setAdapter(adapter);

    }


    private  void createDots(int current_position)
    {
        if(Dots_Layout!=null)
            Dots_Layout.removeAllViews();

        dots = new ImageView[layouts.length];

        for(int i=0;i<layouts.length;i++)
        {
            dots[i] = new ImageView(this);
            if(i==current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,0,4,0);
            Dots_Layout.addView(dots[i],params);
        }
    }
    private  void createDots1(int current_position)
    {
        if(Dots_Layout1!=null)
            Dots_Layout1.removeAllViews();

        dots1 = new ImageView[clayouts.length];

        for(int i=0;i<clayouts.length;i++)
        {
            dots1[i] = new ImageView(this);
            if(i==current_position) {
                dots1[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            }
            else
            {
                dots1[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(13,0,4,0);
            Dots_Layout1.addView(dots1[i],params);
        }
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_myacc: break;
            case R.id.nav_fav:
                Toast.makeText(this, "byeee", Toast.LENGTH_SHORT).show();

                break;
            case R.id.nav_order:
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(logged_in.this, MyOrders.class);
                startActivity(secondactivity1);

                break;
            case R.id.nav_bookings:
                Intent secondactivity2 = new Intent();
                secondactivity2.setClass(logged_in.this, EnterBookingDetails.class);
                startActivity(secondactivity2);

                break;
            case R.id.nav_cart:
                Intent secondactivity3 = new Intent();
                secondactivity3.setClass(logged_in.this, cartview.class);
                startActivity(secondactivity3);

                break;
            case R.id.nav_aboutus:
                Intent secondactivity4 = new Intent();
                secondactivity4.setClass(logged_in.this, settings.class);
                startActivity(secondactivity4);

                break;

            case R.id.nav_signout:
                FirebaseAuth.getInstance().signOut();
                Intent secondactivity5 = new Intent();
                secondactivity5.setClass(logged_in.this, MainActivity.class);
                secondactivity5.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                Toast.makeText(logged_in.this,"Sign Out Successfully",Toast.LENGTH_LONG).show();
                startActivity(secondactivity5);
                break;




        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }
}