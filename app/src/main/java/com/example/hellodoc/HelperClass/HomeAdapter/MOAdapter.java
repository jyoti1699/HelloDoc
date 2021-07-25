package com.example.hellodoc.HelperClass.HomeAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hellodoc.MyOrders;
import com.example.hellodoc.R;
import com.example.hellodoc.ViewProduct;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MOAdapter extends RecyclerView.Adapter<MOAdapter.MostViewHolder> {
    ArrayList<MOHelperClass> mostLocations;

    public MOAdapter(ArrayList<MOHelperClass> mostLocations) {
        this.mostLocations = mostLocations;
    }

    @NonNull
    @Override
    public MOAdapter.MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_orders_design,parent,false);
        MOAdapter.MostViewHolder mostViewHolder = new MOAdapter.MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MostViewHolder holder, int position) {

        final MOHelperClass dHelperClass = mostLocations.get(position);
        holder.title.setText(dHelperClass.getTitle());
        holder.price.setText(dHelperClass.getPrice());
        holder.adress.setText("Name : "+dHelperClass.getName()+"\nAddress : "+dHelperClass.getAdress()+"\n PIN : "+dHelperClass.getPin()+"\nContact : "+dHelperClass.getContact());
        holder.quantity.setText("Quantity : "+dHelperClass.getQuantity());
        holder.imageView.setImageResource(dHelperClass.getRedId());

        holder.cancelorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent(holder.cancelorder.getContext(), MyOrders.class);
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("orders/product").child(dHelperClass.getContact());
                ref.removeValue();
                Toast.makeText(holder.cancelorder.getContext(), "Order Cancelled", Toast.LENGTH_SHORT).show();
                holder.cancelorder.getContext().startActivity(secondactivity1);
            }
        });

    }

    @Override
    public int getItemCount() {

        return mostLocations.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title,price,adress,quantity;
        Button cancelorder;
        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            imageView = itemView.findViewById(R.id.moimage);
            price = itemView.findViewById(R.id.moprice);
            title = itemView.findViewById(R.id.motitle);
            adress = itemView.findViewById(R.id.moadress);
            quantity = itemView.findViewById(R.id.moqnt);
            cancelorder = itemView.findViewById(R.id.cancelorder);


        }
    }
}


