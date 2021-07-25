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

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.FeaturedViewHolder>{

    ArrayList<FeatureHelperClass> featureLocations;

    public FeatureAdapter(ArrayList<FeatureHelperClass> featureLocations) {
        this.featureLocations = featureLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeatureHelperClass featureHelperClass = featureLocations.get(position);
        holder.image.setImageResource(featureHelperClass.getImage());
        holder.title.setText(featureHelperClass.getTitle());
        holder.description.setText(featureHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {

        return featureLocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title,description;
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.fimage);
            title = itemView.findViewById(R.id.ftitle);
            description = itemView.findViewById(R.id.fdes);
        }
    }
}
