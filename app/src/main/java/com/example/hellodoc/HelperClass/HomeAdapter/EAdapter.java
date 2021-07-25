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

public class EAdapter extends RecyclerView.Adapter<EAdapter.MostViewHolder> {
    ArrayList<EHelperClass> mostLocations;

    public EAdapter(ArrayList<EHelperClass> mostLocations) {
        this.mostLocations = mostLocations;
    }

    @NonNull
    @Override
    public EAdapter.MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_design,parent,false);
        EAdapter.MostViewHolder mostViewHolder = new EAdapter.MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MostViewHolder holder, int position) {

        final EHelperClass dHelperClass = mostLocations.get(position);
        holder.title.setText(dHelperClass.getTitle());
        holder.price.setText(dHelperClass.getPrice());
        holder.oldprice.setText(dHelperClass.getOldprice());
        holder.imageView.setImageResource(dHelperClass.getRedID());


    }

    @Override
    public int getItemCount() {

        return mostLocations.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title,price,oldprice;
        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            imageView = itemView.findViewById(R.id.mimage);
            price = itemView.findViewById(R.id.mprice);
            title = itemView.findViewById(R.id.mtext);
            oldprice = itemView.findViewById(R.id.moffer);

        }
    }
}

