package com.example.hellodoc.HelperClass.HomeAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellodoc.R;

import java.util.ArrayList;

public class MostAdapter extends RecyclerView.Adapter<MostAdapter.MostViewHolder>{

    ArrayList<MostHelperClass> mostLocations;

    public MostAdapter(ArrayList<MostHelperClass> mostLocations) {
        this.mostLocations = mostLocations;
    }

    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        MostViewHolder mostViewHolder = new MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewHolder holder, int position) {

        MostHelperClass mostHelperClass = mostLocations.get(position);
        holder.image.setImageResource(mostHelperClass.getImage());
        holder.offer.setText(mostHelperClass.getOffer());
        holder.title.setText(mostHelperClass.getTitle());
        holder.price.setText(mostHelperClass.getPrice());
    }

    @Override
    public int getItemCount() {

        return mostLocations.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView offer,title,price;
        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.mimage);
            offer = itemView.findViewById(R.id.moffer);
            title = itemView.findViewById(R.id.mtext);
            price = itemView.findViewById(R.id.mprice);
        }
    }


}
