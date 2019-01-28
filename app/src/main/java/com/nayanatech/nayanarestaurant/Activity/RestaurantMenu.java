package com.nayanatech.nayanarestaurant.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nayanatech.nayanarestaurant.Model.Item;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

public class RestaurantMenu extends AppCompatActivity {

    Item item=new Item();
    ArrayList<Item> itemArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent=getIntent();
        String image_url=intent.getStringExtra("REST_IMAGE");
        int rest_number=intent.getIntExtra("REST_INT",0);
        Glide.with(getBaseContext()).load(image_url).into((ImageView)findViewById(R.id.rest_menu_iv));
        ((TextView)findViewById(R.id.dummy_int_tv)).setText(rest_number+"");
        item= (Item) intent.getSerializableExtra("REST_ITEM_OBJECT");
        itemArrayList= (ArrayList<Item>) intent.getSerializableExtra("REST_ITEM_ARRAYLIST");
        ((TextView)findViewById(R.id.dummy_object_tv)).setText(item.toString());
        if(itemArrayList.size()>0 && itemArrayList.get(5)!=null){

            ((TextView)findViewById(R.id.dummy_array_tv)).setText(itemArrayList.get(5).toString());
        }
    }
}
