package com.nayanatech.nayanarestaurant.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

import com.nayanatech.nayanarestaurant.Fragments.RestaurantListFragment;
import com.nayanatech.nayanarestaurant.Fragments.RestaurantMenuListFragment;
import com.nayanatech.nayanarestaurant.R;

public class RestaurantMenuList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu_list);
        setRestaurantMenuListFragment();
    }




    private void setRestaurantMenuListFragment() {
        Fragment fragment = new RestaurantMenuListFragment();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.restaurant_menu_list, fragment);
        fragmentTransaction.commit();

    }
}
