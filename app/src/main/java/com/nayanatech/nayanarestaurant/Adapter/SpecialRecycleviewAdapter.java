package com.nayanatech.nayanarestaurant.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nayanatech.nayanarestaurant.Activity.RestaurantMenu;
import com.nayanatech.nayanarestaurant.Fragments.DashboardFragment;
import com.nayanatech.nayanarestaurant.Model.Item;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

public class SpecialRecycleviewAdapter extends RecyclerView.Adapter<SpecialRecycleviewAdapter.SpecialViewHolder> {
    Context context;
    ArrayList<Item> itemArrayList;

    public SpecialRecycleviewAdapter(Context context, ArrayList<Item> itemArrayList) {
        this.context = context;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public SpecialViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.special_item_list, viewGroup, false);
        return new SpecialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SpecialViewHolder specialViewHolder, final int i) {


        //specialViewHolder.special_img.setImageResource(R.drawable.sepial_img);
       /* RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);*/
        specialViewHolder.special_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,RestaurantMenu.class);
                intent.putExtra("REST_IMAGE",DashboardFragment.image_url+itemArrayList.get(i).getImagename());
                intent.putExtra("REST_INT",9604);
                intent.putExtra("REST_ITEM_OBJECT",itemArrayList.get(i));
                intent.putExtra("REST_ITEM_ARRAYLIST",itemArrayList);
                context.startActivity(intent);

            }
        });
       // Glide.with(context).load(recipe.getThumbnail()).into(specialViewHolder.thumbnail);

        Glide.with(context).load(DashboardFragment.image_url + itemArrayList.get(i).getImagename()).into(specialViewHolder.special_img);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class SpecialViewHolder extends RecyclerView.ViewHolder {
        ImageView special_img;
        public ImageView thumbnail;

        public SpecialViewHolder(@NonNull View itemView) {
            super(itemView);
            special_img = itemView.findViewById(R.id.special_item_iv);
            thumbnail = itemView.findViewById(R.id.thumbnail);
           /* special_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, RestaurantMenu.class);
                    intent.putExtra("REST_IMAGE", DashboardFragment.image_url + itemArrayList.get(getLayoutPosition()).getImagename());
                    intent.putExtra("REST_INT", 9604);
                    context.startActivity(intent);
                }
            });*/
        }
    }
}
