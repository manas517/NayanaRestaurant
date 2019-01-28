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

public class AdditionalFeaturesRecycleViewAdapter extends RecyclerView.Adapter<AdditionalFeaturesRecycleViewAdapter.AdditionalFeatureViewHolder> {
    Context context;

    ArrayList<Item> itemArrayList;

    public AdditionalFeaturesRecycleViewAdapter(Context context, ArrayList<Item> itemArrayList) {
        this.context = context;
        this.itemArrayList = itemArrayList;
    }
    @NonNull
    @Override
    public AdditionalFeatureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.additional_feature_item_list,viewGroup,false);
        return new AdditionalFeatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdditionalFeatureViewHolder additionalFeatureViewHolder, int i) {
       // additionalFeatureViewHolder.additional_img.setImageResource(R.drawable.feat_img);
        Glide.with(context).load(DashboardFragment.additional_feature_image_url+itemArrayList.get(i).getImagename()).into(additionalFeatureViewHolder.additional_img);


    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class AdditionalFeatureViewHolder extends RecyclerView.ViewHolder {
        ImageView additional_img;
        public AdditionalFeatureViewHolder(@NonNull View itemView) {
            super(itemView);
            additional_img=itemView.findViewById(R.id.additional_item_iv);
        }
    }
}
