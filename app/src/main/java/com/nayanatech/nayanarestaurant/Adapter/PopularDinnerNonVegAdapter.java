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

public class PopularDinnerNonVegAdapter extends RecyclerView.Adapter<PopularDinnerNonVegAdapter.PopularDinnerNonVegViewHolder> {
    Context context;
    ArrayList<Item> itemArrayList;

    public PopularDinnerNonVegAdapter(Context context, ArrayList<Item> itemArrayList) {
        this.context = context;
        this.itemArrayList = itemArrayList;
    }

    @NonNull

    @Override
    public PopularDinnerNonVegViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.popular_lunch_dinner_combo_item,viewGroup,false);
        return new PopularDinnerNonVegViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularDinnerNonVegViewHolder PopularDinnerNonVegViewHolder, int i) {
        Glide.with(context).load(itemArrayList.get(i).getImageURL()).into(PopularDinnerNonVegViewHolder.popular_lunch_dinner_combo_img);

    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class PopularDinnerNonVegViewHolder extends RecyclerView.ViewHolder {
        ImageView popular_lunch_dinner_combo_img;
        public PopularDinnerNonVegViewHolder(@NonNull View itemView) {
            super(itemView);
            popular_lunch_dinner_combo_img=itemView.findViewById(R.id.popular_lunch_dinner_iv);
        }
    }
}
