package com.nayanatech.nayanarestaurant.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nayanatech.nayanarestaurant.Fragments.DashboardFragment;
import com.nayanatech.nayanarestaurant.Fragments.PatanjaliWorldFragment;
import com.nayanatech.nayanarestaurant.R;

public class PatanjaliWorld extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patanjali_world);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setPatanjaliWorldFragment();
    }
    private void setPatanjaliWorldFragment() {
        FragmentManager fragmentManager=this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment fragment=new PatanjaliWorldFragment();
        fragmentTransaction.replace(R.id.patanjali_world_lay,fragment);
        fragmentTransaction.commit();
    }

}
