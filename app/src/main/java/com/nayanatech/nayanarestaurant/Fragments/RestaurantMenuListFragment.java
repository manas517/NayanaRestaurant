package com.nayanatech.nayanarestaurant.Fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.nayanatech.nayanarestaurant.Activity.PaymentActivity;
import com.nayanatech.nayanarestaurant.Activity.PaymentPage;
import com.nayanatech.nayanarestaurant.Adapter.ExpandableMenuItemAdapter;
import com.nayanatech.nayanarestaurant.Adapter.RestaurantMenuItemAdapter;
import com.nayanatech.nayanarestaurant.Model.ExpandableMenuListData;
import com.nayanatech.nayanarestaurant.Model.MainMenuItemModel;
import com.nayanatech.nayanarestaurant.Model.RestaurantMenuListModel;
import com.nayanatech.nayanarestaurant.Model.SubItemDemo;
import com.nayanatech.nayanarestaurant.Other.MenuItemAdapter;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantMenuListFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<RestaurantMenuListModel> arrayList = new ArrayList<>();
    private ExpandableListView expandableListView;
    private ExpandableMenuItemAdapter expandableMenuItemAdapter;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;
    private ArrayList<MainMenuItemModel> mainMenuItemModelArrayList=new ArrayList<>();
    private Button add_btn,plus_minus_btn,add_button;
    private FloatingActionButton floatingActionButton;
    private ElegantNumberButton elegantNumberButton;
    private TextView payment_oder_tv;
    int minNumber=0;
    private TextView bottom_added_cart_item_tv;



    public RestaurantMenuListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_menu_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //expandableListView = view.findViewById(R.id.expanded_menu_listView);
        add_btn=view.findViewById(R.id.add_item_btn);
        plus_minus_btn=view.findViewById(R.id.add_remove_btn);
        recyclerView=view.findViewById(R.id.item_recyclerView);
        bottom_added_cart_item_tv=view.findViewById(R.id.bottom_added_cart_item_tv);
        payment_oder_tv=view.findViewById(R.id.paymet_order);
        payment_oder_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), PaymentPage.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.left_to_right,R.anim.right_to_left);
            }
        });
        setItemMenu();
        //setMenuItem();
        //add_button=view.findViewById(R.id.add_button);
       // elegantNumberButton=view.findViewById(R.id.number_button);
        //setElegantButton();
       // floatingActionButton= view.findViewById(R.id.floating_btn);
        //setExpandableListView();
      /*  floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar=Snackbar.make(view,"Item Added Sucessfully",Snackbar.LENGTH_LONG);
                snackbar.setAction("CheckOut", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(),"Order Sucessfully",Toast.LENGTH_SHORT).show();

                    }
                });
                snackbar.setActionTextColor(Color.parseColor("#ffffff"));

                // Change the Snackbar default text color
                View snackbarView = snackbar.getView();
                TextView tv = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(Color.WHITE);

                // Change the Snackbar default background color
                snackbarView.setBackgroundColor(Color.parseColor("#31d411"));

                // Display the Snackbar
                snackbar.show();


            }
        });*/
       /* setMenuItemAdapter();
        setMenuItem();*/
    }

    private void setItemMenu() {

        ArrayList<SubItemDemo> biriyani=new ArrayList<>();
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));
        biriyani.add(new SubItemDemo("Veg Biriyani"," ₹ 120"));

        MainMenuItemModel biriyaniItem=new MainMenuItemModel("Biriyani",biriyani);
        mainMenuItemModelArrayList.add(biriyaniItem);

        ArrayList<SubItemDemo> chicken=new ArrayList<>();
        chicken.add(new SubItemDemo("Chicken Masala"," ₹ 120"));
        chicken.add(new SubItemDemo("Chicken Curry"," ₹ 130"));
        chicken.add(new SubItemDemo("Chicken Butter"," ₹ 140"));
        chicken.add(new SubItemDemo("Chicken Chilly"," ₹ 150"));
        chicken.add(new SubItemDemo("Chicken Gaola"," ₹ 120"));
        chicken.add(new SubItemDemo("Chicken phir"," ₹ 160"));
        chicken.add(new SubItemDemo("Chicken Dopiaza"," ₹ 120"));
        chicken.add(new SubItemDemo("Chicken Biriyani"," ₹ 180"));

        MainMenuItemModel chickenItem=new MainMenuItemModel("Chicken",chicken);
        mainMenuItemModelArrayList.add(chickenItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MenuItemAdapter itemAdapter=new MenuItemAdapter(mainMenuItemModelArrayList,bottom_added_cart_item_tv,getContext());
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();



    }


   /* private void setElegantButton() {
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    add_button.setVisibility(View.INVISIBLE);
                    elegantNumberButton.setVisibility(View.VISIBLE);




            }
        });
        elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                String count=elegantNumberButton.getNumber();
                Toast.makeText(getActivity(),"Item Added",Toast.LENGTH_SHORT).show();
            }
        });
    }*/

   /* private void setExpandableListView() {
        expandableListDetail = ExpandableMenuListData.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableMenuItemAdapter = new ExpandableMenuItemAdapter(getActivity(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableMenuItemAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(), expandableListTitle.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(), expandableListTitle.get(groupPosition) + " List collapsed.", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(),"Item Added",Toast.LENGTH_SHORT).show();
               *//* Toast.makeText(
                        getActivity(), expandableListTitle.get(groupPosition) + " -> "
                                + expandableListDetail.get(expandableListTitle.get(groupPosition))
                                .get(childPosition), Toast.LENGTH_SHORT).show();*//*
                return false;
            }
        });

    }*/



  /*  private void setMenuItem() {
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Paneer Biriyani", "Rs 130"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mushroom Biriyani", "Rs 140"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Chicken Biriyani", "Rs 150"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Veg Biriyani", "Rs 120"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Non Veg Biriyani", "Rs 160"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
        arrayList.add(new RestaurantMenuListModel("Biriyani", "Mutton Biriyani", "Rs 180"));
    }*/
}
