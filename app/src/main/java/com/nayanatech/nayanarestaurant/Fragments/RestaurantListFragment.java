package com.nayanatech.nayanarestaurant.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nayanatech.nayanarestaurant.Adapter.RestaurantListAdapter;
import com.nayanatech.nayanarestaurant.Model.RestaurantModelDemo;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantListFragment extends Fragment {
    private RecyclerView restaurantList_rv;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<RestaurantModelDemo> arrayList=new ArrayList<>();


    public RestaurantListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        restaurantList_rv=view.findViewById(R.id.restaurant_rv);
        setResturantAdapter();
        setRestaurantList();
    }

    private void setResturantAdapter() {
        restaurantList_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        RestaurantListAdapter restaurantListAdapter=new RestaurantListAdapter(getActivity(),arrayList);
        restaurantList_rv.setAdapter(restaurantListAdapter);
        restaurantListAdapter.notifyDataSetChanged();

    }

    private void setRestaurantList() {
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));
        arrayList.add(new RestaurantModelDemo("",R.drawable.restimage_bg));

    }
}
