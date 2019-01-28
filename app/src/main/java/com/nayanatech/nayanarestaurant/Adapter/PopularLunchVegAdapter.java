package com.nayanatech.nayanarestaurant.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nayanatech.nayanarestaurant.Model.Item;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

public class PopularLunchVegAdapter extends RecyclerView.Adapter<PopularLunchVegAdapter.PopularLunchVegViewHolder> {
    Context context;
    ArrayList<Item> itemArrayList;

    public PopularLunchVegAdapter(Context context, ArrayList<Item> itemArrayList) {
        this.context = context;
        this.itemArrayList = itemArrayList;
    }

    @NonNull

    @Override
    public PopularLunchVegViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.popular_lunch_dinner_combo_item,viewGroup,false);
        return new PopularLunchVegViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularLunchVegViewHolder popularLunchVegViewHolder, int i) {
        Glide.with(context).load(itemArrayList.get(i).getImageURL()).into(popularLunchVegViewHolder.popular_lunch_dinner_combo_img);

    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class PopularLunchVegViewHolder extends RecyclerView.ViewHolder {
        ImageView popular_lunch_dinner_combo_img;
        public PopularLunchVegViewHolder(@NonNull View itemView) {
            super(itemView);
            popular_lunch_dinner_combo_img=itemView.findViewById(R.id.popular_lunch_dinner_iv);
        }
    }
}
