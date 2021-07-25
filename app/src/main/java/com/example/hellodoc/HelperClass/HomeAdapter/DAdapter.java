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
import com.example.hellodoc.dbooking;

import java.text.BreakIterator;
import java.util.ArrayList;

public class DAdapter extends RecyclerView.Adapter<DAdapter.MostViewHolder> {
    ArrayList<DHelperClass> mostLocations;

    public DAdapter(ArrayList<DHelperClass> mostLocations) {
        this.mostLocations = mostLocations;
    }

    @NonNull
    @Override
    public DAdapter.MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_list,parent,false);
        DAdapter.MostViewHolder mostViewHolder = new DAdapter.MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MostViewHolder holder, int position) {

        final DHelperClass dHelperClass = mostLocations.get(position);
        holder.name.setText(dHelperClass.getName());
        holder.specs.setText(dHelperClass.getSpecs());
        holder.addr.setText(dHelperClass.getAddr());
        holder.phone.setText(dHelperClass.getPhone());
        holder.drbar.setRating((float) dHelperClass.getDrbar());



        holder.bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent(holder.bbtn.getContext(), dbooking.class);
                secondactivity1.putExtra("name",dHelperClass.getName());
                secondactivity1.putExtra("specs",dHelperClass.getSpecs());
                secondactivity1.putExtra("addr",dHelperClass.getAddr());
                secondactivity1.putExtra("phone",dHelperClass.getPhone());
                secondactivity1.putExtra("drbar",dHelperClass.getDrbar());
                secondactivity1.putExtra("fees",dHelperClass.getFees());
                secondactivity1.putExtra("cit",dHelperClass.getCity());
                holder.bbtn.getContext().startActivity(secondactivity1);
            }
        });

    }

    @Override
    public int getItemCount() {

        return mostLocations.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder {

        TextView name,specs,addr,phone;
        RatingBar drbar;
        Button bbtn;
        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            name = itemView.findViewById(R.id.name);
            specs = itemView.findViewById(R.id.speciality);
            addr = itemView.findViewById(R.id.address);
            phone = itemView.findViewById(R.id.phone);
            drbar = itemView.findViewById(R.id.drbar);
            bbtn = itemView.findViewById(R.id.bbtn);
        }
    }
}


