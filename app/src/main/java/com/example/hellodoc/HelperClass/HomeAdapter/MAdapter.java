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
import com.example.hellodoc.ViewProduct;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MAdapter extends RecyclerView.Adapter<MAdapter.MostViewHolder> {
    ArrayList<MHelperClass> mostLocations;

    public MAdapter(ArrayList<MHelperClass> mostLocations) {
        this.mostLocations = mostLocations;
    }

    @NonNull
    @Override
    public MAdapter.MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card,parent,false);
        MAdapter.MostViewHolder mostViewHolder = new MAdapter.MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MostViewHolder holder, int position) {

        final MHelperClass mHelperClass = mostLocations.get(position);
        holder.image.setImageResource(mHelperClass.getImage());
        holder.offer.setText(mHelperClass.getOffer());
        holder.title.setText(mHelperClass.getTitle());
        holder.price.setText(mHelperClass.getPrice());
        holder.oldprice.setText(mHelperClass.getOldprice());
        holder.rbar.setRating((float) mHelperClass.getRbar());

        holder.bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondactivity1 = new Intent(holder.bbtn.getContext(), ViewProduct.class);
                secondactivity1.putExtra("title",mHelperClass.getTitle());
                secondactivity1.putExtra("price",mHelperClass.getPrice());
                secondactivity1.putExtra("oldprice",mHelperClass.getOldprice());
                secondactivity1.putExtra("rbar",mHelperClass.getRbar());
                secondactivity1.putExtra("offer",mHelperClass.getOffer());
                secondactivity1.putExtra("resId", mHelperClass.getImage());
                holder.bbtn.getContext().startActivity(secondactivity1);
            }
        });


    }

    @Override
    public int getItemCount() {

        return mostLocations.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView offer,title,price,oldprice;
        RatingBar rbar;
        Button bbtn;
        public MostViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            bbtn = itemView.findViewById(R.id.bbtn);
            image = itemView.findViewById(R.id.mimage);
            offer = itemView.findViewById(R.id.moffer);
            title = itemView.findViewById(R.id.mtext);
            price = itemView.findViewById(R.id.mprice);
            oldprice = itemView.findViewById(R.id.moldprice);
            rbar = itemView.findViewById(R.id.rbar1);
        }
    }


}
