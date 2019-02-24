package com.nayanatech.nayanarestaurant.Other;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nayanatech.nayanarestaurant.Model.SubItemDemo;
import com.nayanatech.nayanarestaurant.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class SubItemViewHolder extends ChildViewHolder {
    private TextView mTextView,itemPrice_tv;
    Button add_button;
    ImageView add,minus;
    TextView count_item;
    RelativeLayout rel_add_section;
    public SubItemViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.subItem_tv);
        itemPrice_tv=itemView.findViewById(R.id.item_price_tv);
        add=itemView.findViewById(R.id.add_iv);
        minus=itemView.findViewById(R.id.minus_iv);
        add_button=itemView.findViewById(R.id.add_button);
        count_item=itemView.findViewById(R.id.count_text);
        rel_add_section=itemView.findViewById(R.id.rel_add_section);
    }
    public void bind(SubItemDemo subItemDemo){
        mTextView.setText(subItemDemo.name);
        itemPrice_tv.setText(subItemDemo.itemPrice);
    }
}
