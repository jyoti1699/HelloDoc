package com.example.hellodoc.HelperClass.HomeAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hellodoc.R;

import java.util.ArrayList;

public class MBAdapter extends RecyclerView.Adapter<MBAdapter.MostViewHolder> {
    ArrayList<MBHelperClass> mostLocations;

    public MBAdapter(ArrayList<MBHelperClass> mostLocations) {
        this.mostLocations = mostLocations;
    }

    @NonNull
    @Override
    public MBAdapter.MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_design,parent,false);
        MBAdapter.MostViewHolder mostViewHolder = new MBAdapter.MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MostViewHolder holder, int position) {

        final MBHelperClass dHelperClass = mostLocations.get(position);
        String paystat = null;
        if(dHelperClass.isStatus()==true)
        {
            paystat = "Paid";
        }
        else if(dHelperClass.isStatus()==false)
        {
            paystat = "Not Paid";
        }
        holder.name.setText(" Doctor Name : "+dHelperClass.getDname());
        holder.pdetails.setText(" Pateint Name : "+dHelperClass.getPname()+"\n Pateint Age : "+dHelperClass.getAge()+"\n Contact Number : "+dHelperClass.getContact()
        +"\n Aadhar Number : "+dHelperClass.getAadhar()+"\n Date : "+dHelperClass.getDate()+"\n Time : "+dHelperClass.getTime()+"\n Payment Status : "+paystat);

    }

    @Override
    public int getItemCount() {

        return mostLocations.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder {
        TextView name,pdetails;
        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
           name = itemView.findViewById(R.id.mbname);
           pdetails = itemView.findViewById(R.id.mbdetails);



        }
    }
}


