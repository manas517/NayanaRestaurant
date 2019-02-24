package com.nayanatech.nayanarestaurant.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nayanatech.nayanarestaurant.Model.RestaurantMenuListModel;
import com.nayanatech.nayanarestaurant.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RestaurantMenuItemAdapter extends RecyclerView.Adapter<RestaurantMenuItemAdapter.MenuItemViewHolder> {
    private Context context;
    String count_no;
    int count_int_value;
    TextView bottom_added_cart_item_tv;
    int total_item=1;

    public RestaurantMenuItemAdapter(Context context, ArrayList<RestaurantMenuListModel> modelArrayList,TextView bottom_added_cart_item_tv) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.bottom_added_cart_item_tv = bottom_added_cart_item_tv;
    }

    private ArrayList<RestaurantMenuListModel> modelArrayList;







    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_item,viewGroup,false);

        return new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MenuItemViewHolder menuItemViewHolder, final int i) {
        RestaurantMenuListModel restaurantMenuListModel=modelArrayList.get(i);
        menuItemViewHolder.menu_title_tv.setText(restaurantMenuListModel.getMenuItem());
        menuItemViewHolder.menu_text.setText(restaurantMenuListModel.getSubItem());
        menuItemViewHolder.menu_price.setText(restaurantMenuListModel.getItemPrice());

        menuItemViewHolder.add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((menuItemViewHolder.rel_add_section.getVisibility()==View.INVISIBLE) || (menuItemViewHolder.rel_add_section.getVisibility() == View.GONE)){
                   menuItemViewHolder.rel_add_section.setVisibility(View.VISIBLE);
                   menuItemViewHolder.add_button.setVisibility(View.GONE);
                }
            }
        });
        count_no=menuItemViewHolder.count_item.getText().toString();
        count_int_value=Integer.parseInt(count_no);
        bottom_added_cart_item_tv.setText(String.format(context.getResources().getString(R.string.total_item_text), total_item));
        menuItemViewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count_int_value>=0 && count_int_value<13){
                    count_int_value++;
                    total_item= total_item+1;
                    menuItemViewHolder.count_item.setText(String.valueOf(count_int_value));
                    bottom_added_cart_item_tv.setText(String.format(context.getResources().getString(R.string.total_item_text), total_item));
                }
            }
        });

        menuItemViewHolder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count_int_value>0){
                    count_int_value--;
                    if(count_int_value==0){
                        menuItemViewHolder.add_button.setVisibility(View.VISIBLE);
                        menuItemViewHolder.rel_add_section.setVisibility(View.GONE);
                    }else {
                        menuItemViewHolder.count_item.setText(String.valueOf(count_int_value));
                    }
                    total_item= total_item-1;
                    bottom_added_cart_item_tv.setText(String.format(context.getResources().getString(R.string.total_item_text), total_item));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder {
        TextView menu_title_tv,menu_text,menu_price;
        Button add_button;
        ImageView add,minus;
        TextView count_item;
        RelativeLayout rel_add_section;
        public MenuItemViewHolder(@NonNull View itemView) {
            super(itemView);
            menu_title_tv=itemView.findViewById(R.id.item_title_tv);
            menu_text=itemView.findViewById(R.id.subItem_tv);
            menu_price=itemView.findViewById(R.id.item_price_tv);
            add=itemView.findViewById(R.id.add_iv);
            minus=itemView.findViewById(R.id.minus_iv);
            add_button=itemView.findViewById(R.id.add_button);
            count_item=itemView.findViewById(R.id.count_text);
            rel_add_section=itemView.findViewById(R.id.rel_add_section);
        }
    }
}
