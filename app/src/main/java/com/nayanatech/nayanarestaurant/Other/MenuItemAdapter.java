package com.nayanatech.nayanarestaurant.Other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nayanatech.nayanarestaurant.Model.MainMenuItemModel;
import com.nayanatech.nayanarestaurant.Model.SubItemDemo;
import com.nayanatech.nayanarestaurant.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class MenuItemAdapter extends ExpandableRecyclerViewAdapter<MainMeuViewHolder,SubItemViewHolder> {
    Context context;
    String count_no;
    int count_int_value;
    TextView bottom_added_cart_item_tv;
    int total_item=1;
    public MenuItemAdapter(List<? extends ExpandableGroup> groups,TextView bottom_added_cart_item_tv,Context context) {
        super(groups);
        this.bottom_added_cart_item_tv=bottom_added_cart_item_tv;
        this.context=context;
    }

    @Override
    public MainMeuViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        return new MainMeuViewHolder(view);
    }

    @Override
    public SubItemViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_sub_item_list,parent,false);
        return new SubItemViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(final SubItemViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
       final   SubItemDemo subItemDemo= (SubItemDemo) group.getItems().get(childIndex);
        holder.bind(subItemDemo);
        holder.add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((holder.rel_add_section.getVisibility()==View.INVISIBLE) || (holder.rel_add_section.getVisibility() == View.GONE)){
                    holder.rel_add_section.setVisibility(View.VISIBLE);
                    holder.add_button.setVisibility(View.GONE);
                    Toast.makeText(context,"Item Added Sucessfully",Toast.LENGTH_SHORT).show();

                }
            }
        });
        count_no=holder.count_item.getText().toString();
        count_int_value=Integer.parseInt(count_no);
        bottom_added_cart_item_tv.setText(String.format(context.getResources().getString(R.string.total_item_text), total_item));
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count_int_value>=0 && count_int_value<13){
                    count_int_value++;
                    total_item= total_item+1;
                    holder.count_item.setText(String.valueOf(count_int_value));
                    bottom_added_cart_item_tv.setText(String.format(context.getResources().getString(R.string.total_item_text), total_item));
                    Toast.makeText(context,"Item Added Sucessfully",Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count_int_value>0){
                    count_int_value--;
                    if(count_int_value==0){
                        holder.add_button.setVisibility(View.VISIBLE);
                        holder.rel_add_section.setVisibility(View.GONE);
                    }else {
                        holder.count_item.setText(String.valueOf(count_int_value));
                    }
                    total_item= total_item-1;
                    bottom_added_cart_item_tv.setText(String.format(context.getResources().getString(R.string.total_item_text), total_item));
                    Toast.makeText(context,"Item Removed",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @Override
    public void onBindGroupViewHolder(MainMeuViewHolder holder, int flatPosition, ExpandableGroup group) {
        final MainMenuItemModel mainMenuItemModel= (MainMenuItemModel) group;
        holder.bind(mainMenuItemModel);

    }
}
