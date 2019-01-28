package com.nayanatech.nayanarestaurant.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nayanatech.nayanarestaurant.Fragments.DashboardFragment;
import com.nayanatech.nayanarestaurant.Model.Item;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

public class FeaturesGridAdapter extends RecyclerView.Adapter<FeaturesGridAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Item> itemArrayList;

    public FeaturesGridAdapter(Context context, ArrayList<Item> itemArrayList) {
        this.context = context;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.features_grid_item, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        Glide.with(context).load(DashboardFragment.features_image_url+itemArrayList.get(i).getImagename()).into(gridViewHolder.grid_image);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView grid_image;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            grid_image=(ImageView)itemView.findViewById(R.id.feature_item_iv);
        }
    }
}
