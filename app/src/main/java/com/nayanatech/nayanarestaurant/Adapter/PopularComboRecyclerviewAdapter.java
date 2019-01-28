package com.nayanatech.nayanarestaurant.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nayanatech.nayanarestaurant.Fragments.DashboardFragment;
import com.nayanatech.nayanarestaurant.Model.Item;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

public class PopularComboRecyclerviewAdapter extends RecyclerView.Adapter<PopularComboRecyclerviewAdapter.PopularComboViewHolder> {
    Context context;
    ArrayList<Item> itemArrayList;

    public PopularComboRecyclerviewAdapter(Context context, ArrayList<Item> itemArrayList) {
        this.context = context;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public PopularComboViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.popular_meal_combo_item_list,viewGroup,false);
        return new PopularComboViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularComboViewHolder popularComboViewHolder, int i) {

    //popularComboViewHolder.popular_combo_img.setImageResource(R.drawable.combo);
        Glide.with(context).load(itemArrayList.get(i).getImageURL()).into(popularComboViewHolder.popular_combo_img);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class PopularComboViewHolder extends RecyclerView.ViewHolder {
        ImageView popular_combo_img;
        public PopularComboViewHolder(@NonNull View itemView) {
            super(itemView);
            popular_combo_img=itemView.findViewById(R.id.popular_combo_iv);
        }
    }
}
