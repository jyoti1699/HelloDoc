package com.example.hellodoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellodoc.HelperClass.HomeAdapter.DAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.DHelperClass;
import com.example.hellodoc.HelperClass.HomeAdapter.MAdapter;
import com.example.hellodoc.HelperClass.HomeAdapter.MHelperClass;
import com.google.firebase.database.DataSnapshot;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class doc_list extends AppCompatActivity {
    TextView textView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    RecyclerView productRecycler1;
    RecyclerView.Adapter padapter1;
    Query checkUsercred;
    ProgressBar pg;
    Button bbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_list);


        

        Spinner spin = (Spinner) findViewById(R.id.sort);
        String[] options={
                "Choose Specification",
                "Show All",
                "Dermitologist",
                "Cardiologist",
                "Paediatrician",
                "Orthopaedic surgeon",
                "Cardiothoracic surgeon",
                " Neurologist",
                "Endocrinologist",
                "Audiologist",
                "Dentist",
                "Neuro Surgeon"
        };
        ArrayAdapter optionsArray=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,options);
        spin.setAdapter(optionsArray);











        productRecycler1 = findViewById(R.id.product_recycler1);
      pg = findViewById(R.id.pgbar1);
        pg.setVisibility((View.VISIBLE));
        Button bc = (Button) findViewById(R.id.bc);
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg.setVisibility((View.GONE));
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(doc_list.this, Search.class);
                startActivity(secondactivity1);
            }

        });
        final String cit = getIntent().getStringExtra("data").trim();
       //  final ListView listView=(ListView) findViewById(R.id.clist);
      //  listView.setAdapter(arrayAdapter);
        textView = findViewById(R.id.result);
        textView.setText("Top results from '"+cit+"'");
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("city");
        checkUsercred = reference.orderByKey().equalTo(cit);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Choose Specification"))
                {

                }
                else if(selectedItem.equals("Show All")){
                    showAll(reference, cit);

                }

                else{
                    list(selectedItem, reference, cit);
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });







        checkUsercred.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                   // textView.setText("yes");
                   // String address = snapshot.child(cit).child("doc1").child("add1").getValue(String.class);
                   // textView.setText(address);
                    Iterable<DataSnapshot> snapshotIterator = snapshot.child(cit).getChildren();
                    Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                    productRecycler1.setHasFixedSize(true); //contain card views..only visible that user loads
                    productRecycler1.setLayoutManager(new LinearLayoutManager(doc_list.this,LinearLayoutManager.VERTICAL,false));
                    ArrayList<DHelperClass> KLocations = new ArrayList<>();
                    while (iterator.hasNext()) {
                        DataSnapshot next = (DataSnapshot) iterator.next();
                        String spec= (String) next.child("spec").getValue();
                            // listView.("Adrr = " +next.child("add1").getValue());
                            String addr = (String) next.child("addr").getValue();
                            String docname = (String) next.child("name").getValue();
                            String phone = (String) next.child("phone").getValue();
                            String fees = (String) next.child("fees").getValue();
                            Object drbar = next.child("drbar").getValue();
                            float rate = Float.parseFloat(next.child("drbar").getValue().toString());
                          /*  arrayList.add("Name - " + docname +
                                    "\nSpeciality - " + spec +
                                    "\nAddress - " + addr +
                                    "\nPhone - " + phone +
                                    "\nRating - " + drbar); */
                            KLocations.add(new DHelperClass(docname, spec, addr, phone, rate, fees, cit));
                            padapter1 = new DAdapter(KLocations);
                            productRecycler1.setAdapter(padapter1);
                            arrayAdapter = new ArrayAdapter<String>(doc_list.this, android.R.layout.simple_list_item_1, arrayList);
                            // listView.setAdapter(arrayAdapter);
                    }
                   /*String value=snapshot.child(cit).getValue(String.class);
                    arrayList.add(value);
                    arrayAdapter = new ArrayAdapter<String>(doc_list.this, android.R.layout.simple_list_item_1, arrayList);
                    listView.setAdapter(arrayAdapter);*/
                    pg.setVisibility((View.GONE));
                    //textView.setText("no");
                }
                else
                {
                    pg.setVisibility((View.GONE));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void list(String selectedItem, final DatabaseReference reference, final String cit) {

       /* Spinner pricesort = (Spinner) findViewById(R.id.pricesort);
        String[] options1={
                "Choose Price",
                "Show All",
                "Less then 200",
                "Less then 400",
                "Less then 500",
                "Less then 800",
                "Less then 1000",
        };
        ArrayAdapter optionsArray1=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,options1);
        pricesort.setAdapter(optionsArray1);*/


                    refreshList(selectedItem, reference, cit, 10000);


    }

    private void showAll(DatabaseReference reference, final String cit) {
        checkUsercred = reference.orderByKey().equalTo(cit);

        checkUsercred.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // textView.setText("yes");
                    // String address = snapshot.child(cit).child("doc1").child("add1").getValue(String.class);
                    // textView.setText(address);
                    Iterable<DataSnapshot> snapshotIterator = snapshot.child(cit).getChildren();
                    Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                    productRecycler1.setHasFixedSize(true); //contain card views..only visible that user loads
                    productRecycler1.setLayoutManager(new LinearLayoutManager(doc_list.this,LinearLayoutManager.VERTICAL,false));
                    ArrayList<DHelperClass> KLocations = new ArrayList<>();
                    while (iterator.hasNext()) {
                        DataSnapshot next = (DataSnapshot) iterator.next();
                        // listView.("Adrr = " +next.child("add1").getValue());
                        String spec= (String) next.child("spec").getValue();
                        String addr= (String) next.child("addr").getValue();
                        String docname= (String) next.child("name").getValue();

                        String phone= (String) next.child("phone").getValue();
                        String fees= (String) next.child("fees").getValue();
                        Object drbar = next.child("drbar").getValue();
                        float rate = Float.parseFloat(next.child("drbar").getValue().toString());
//                        arrayList.add("Name - "+docname+
//                                "\nSpeciality - "+spec+
//                                "\nAddress - "+addr+
//                                "\nPhone - "+phone+
//                                "\nRating - "+drbar);
                            KLocations.add(new DHelperClass(docname, spec, addr, phone, rate, fees, cit));
                            padapter1 = new DAdapter(KLocations);
                            productRecycler1.setAdapter(padapter1);
                            arrayAdapter = new ArrayAdapter<String>(doc_list.this, android.R.layout.simple_list_item_1, arrayList);
                            // listView.setAdapter(arrayAdapter);
                    }

                    pg.setVisibility((View.GONE));
                    //textView.setText("no");
                }
                else
                {
                    pg.setVisibility((View.GONE));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void refreshList(final String selectedItem, DatabaseReference reference, final String cit, int price) {
        checkUsercred = reference.orderByKey().equalTo(cit);

        checkUsercred.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // textView.setText("yes");
                    // String address = snapshot.child(cit).child("doc1").child("add1").getValue(String.class);
                    // textView.setText(address);
                    Iterable<DataSnapshot> snapshotIterator = snapshot.child(cit).getChildren();
                    Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                    productRecycler1.setHasFixedSize(true); //contain card views..only visible that user loads
                    productRecycler1.setLayoutManager(new LinearLayoutManager(doc_list.this,LinearLayoutManager.VERTICAL,false));
                    ArrayList<DHelperClass> KLocations = new ArrayList<>();
                    while (iterator.hasNext()) {
                        DataSnapshot next = (DataSnapshot) iterator.next();
                        // listView.("Adrr = " +next.child("add1").getValue());
                        String spec= (String) next.child("spec").getValue();
                        String addr= (String) next.child("addr").getValue();
                        String docname= (String) next.child("name").getValue();

                        String phone= (String) next.child("phone").getValue();
                        String fees= (String) next.child("fees").getValue();
                        Object drbar = next.child("drbar").getValue();
                        float rate = Float.parseFloat(next.child("drbar").getValue().toString());
                     //   double finalAmount = int.parseFloat(fees);

//                        arrayList.add("Name - "+docname+
//                                "\nSpeciality - "+spec+
//                                "\nAddress - "+addr+
//                                "\nPhone - "+phone+
//                                "\nRating - "+drbar);
                        if(spec.equals(selectedItem)) {

                            KLocations.add(new DHelperClass(docname, spec, addr, phone, rate, fees, cit));
                            padapter1 = new DAdapter(KLocations);
                            productRecycler1.setAdapter(padapter1);
                            arrayAdapter = new ArrayAdapter<String>(doc_list.this, android.R.layout.simple_list_item_1, arrayList);
                            // listView.setAdapter(arrayAdapter);
                        }
                    }

                    pg.setVisibility((View.GONE));
                    //textView.setText("no");
                }
                else
                {
                    pg.setVisibility((View.GONE));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void books(View view)
 {
     Toast.makeText(doc_list.this, "hello bro", Toast.LENGTH_LONG).show();
 }
}