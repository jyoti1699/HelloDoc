package com.example.hellodoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hellodoc.HelperClass.HomeAdapter.EAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.EHelperClass;
import com.example.hellodoc.HelperClass.HomeAdapter.MBAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.MBHelperClass;
import com.example.hellodoc.HelperClass.HomeAdapter.MOAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.MOHelperClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class MyBookings extends AppCompatActivity {
    RecyclerView productRecycler1;
    RecyclerView.Adapter padapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);
        String mbcity = getIntent().getStringExtra("mbcity");
        final String mbaadhar = getIntent().getStringExtra("mbaadhar");
        productRecycler1 = findViewById(R.id.mbrecycler);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("booking").child(mbcity);
        Query checkUsercred = reference.orderByChild("paadhar").equalTo(mbaadhar);
        checkUsercred.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Iterable<DataSnapshot> snapshotIterator = snapshot.getChildren();
                    Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                    productRecycler1.setHasFixedSize(true); //contain card views..only visible that user loads
                    productRecycler1.setLayoutManager(new LinearLayoutManager(MyBookings.this, LinearLayoutManager.VERTICAL, false));
                    ArrayList<MBHelperClass> KLocations = new ArrayList<>();
                    while (iterator.hasNext()) {
                        DataSnapshot next = (DataSnapshot) iterator.next();
                        // listView.("Adrr = " +next.child("add1").getValue());
                        String dname = (String) next.child("dname").getValue();
                        String pname = (String) next.child("pname").getValue();
                        String page = (String) next.child("page").getValue();
                        String pcontact = (String) next.child("pcontact").getValue();
                        String paadhar = (String) next.child("paadhar").getValue();
                        String time = (String) next.child("time").getValue();
                        String date = (String) next.child("date").getValue();

                   /* arrayList.add("Name - "+docname+
                            "\nSpeciality - "+spec+
                            "\nAddress - "+addr+
                            "\nPhone - "+phone+
                            "\nRating - "+drbar);*/

                        KLocations.add(new MBHelperClass(dname,pname,page,time,date,paadhar,pcontact));
                        padapter1 = new MBAdapter(KLocations);
                        productRecycler1.setAdapter(padapter1);
                        //arrayAdapter = new ArrayAdapter<String>(doc_list.this, android.R.layout.simple_list_item_1, arrayList);
                        // listView.setAdapter(arrayAdapter);
                    }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }
}