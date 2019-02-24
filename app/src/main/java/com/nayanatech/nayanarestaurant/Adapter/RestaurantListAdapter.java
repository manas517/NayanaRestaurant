package com.nayanatech.nayanarestaurant.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nayanatech.nayanarestaurant.Activity.RestaurantMenuList;
import com.nayanatech.nayanarestaurant.Model.RestaurantModelDemo;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {
    private Context context;
    private ArrayList<RestaurantModelDemo> restaurantModelDemoArrayList;


    public RestaurantListAdapter(Context context, ArrayList<RestaurantModelDemo> restaurantModelDemoArrayList) {
        this.context = context;
        this.restaurantModelDemoArrayList = restaurantModelDemoArrayList;
    }




    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurant_list,viewGroup,false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int i) {
        RestaurantModelDemo restaurantModelDemo=restaurantModelDemoArrayList.get(i);
        restaurantViewHolder.rest_image.setImageResource(restaurantModelDemo.getRestaurant_image());
        restaurantViewHolder.rest_text.setText(restaurantModelDemo.getRestaurant_name());
        restaurantViewHolder.rest_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, RestaurantMenuList.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return restaurantModelDemoArrayList.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        ImageView rest_image;
        TextView rest_text;
        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            rest_image=itemView.findViewById(R.id.restaurant_imageView);
            rest_text=itemView.findViewById(R.id.restaurantName_tv);


        }
    }
}
