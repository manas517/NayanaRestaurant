package com.nayanatech.nayanarestaurant.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.nayanatech.nayanarestaurant.Adapter.PopularDinnerNonVegAdapter;
import com.nayanatech.nayanarestaurant.Adapter.PopularDinnerVegAdapter;
import com.nayanatech.nayanarestaurant.Adapter.PopularLunchNonVegAdapter;
import com.nayanatech.nayanarestaurant.Adapter.PopularLunchVegAdapter;
import com.nayanatech.nayanarestaurant.Model.DashboardModel;
import com.nayanatech.nayanarestaurant.Model.Item;
import com.nayanatech.nayanarestaurant.Model.Section;
import com.nayanatech.nayanarestaurant.NetworkApi.ApiInterface;
import com.nayanatech.nayanarestaurant.NetworkApi.ApiRetrofitCall;
import com.nayanatech.nayanarestaurant.R;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularLunchComboMeals extends AppCompatActivity {
    private RecyclerView popular_lunch_veg_rv;
    private RecyclerView popular_lunch_non_veg_rv;
    private RecyclerView popular_dinner_veg_rv;
    private  RecyclerView popular_dinner_non_veg_rv;
    private LinearLayoutManager linearLayoutManager;
    private PopularLunchVegAdapter popularLunchVegAdapter;
    private PopularLunchNonVegAdapter popularLunchNonVegAdapter;
    private PopularDinnerVegAdapter popularDinnerVegAdapter;
    private PopularDinnerNonVegAdapter popularDinnerNonVegAdapter;
    Toolbar toolbar;
    ArrayList<Section> sectionArrayList=new ArrayList<>();
    ProgressDialog progressDialog;
    ArrayList<Item> itemArrayList=new ArrayList<>();
    public static final String city_id="FOODCITYBAM";
    public static final String image_url="https://storage.googleapis.com/foodinns-images/resources/banner/big/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_popular_combo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setFindViewId();
        apiCallForPopularCombo();



    }



    private void apiCallForPopularCombo() {
        ApiInterface apiInterface=ApiRetrofitCall.getClient().create(ApiInterface.class);
        progressDialog.show();
        Call<DashboardModel> call=apiInterface.getDashboardData(city_id,"");
        call.enqueue(new Callback<DashboardModel>() {
            @Override
            public void onResponse(Call<DashboardModel> call, Response<DashboardModel> response) {
                if(response.isSuccessful()){
                    DashboardModel dashboardModel=response.body();
                    sectionArrayList= (ArrayList<Section>) dashboardModel.getSections();
                    if (sectionArrayList.size()>0){
                        itemArrayList= (ArrayList<Item>) sectionArrayList.get(1).getItems();
                        setPopularLunchVeg();
                        setPopularLunchNonVeg();
                        setPopularDinnerVeg();
                        setPopularDinnerNonVeg();
                        progressDialog.dismiss();
                    }
                }

            }

            @Override
            public void onFailure(Call<DashboardModel> call, Throwable t) {
                Log.d("PopularLunchDinnerCombo","api call fails");
                progressDialog.dismiss();


            }
        });
    }

    private void setFindViewId() {
        popular_lunch_veg_rv = findViewById(R.id.popular_lunch_veg_rv);
        popular_lunch_non_veg_rv = findViewById(R.id.popular_lunch_non_veg_rv);
        popular_dinner_veg_rv = findViewById(R.id.popular_dinner_veg_rv);
        popular_dinner_non_veg_rv = findViewById(R.id.popular_dinner_non_veg_rv);
        toolbar=findViewById(R.id.toolbar);
        progressDialog=new ProgressDialog(this);
    }

    private void setPopularLunchVeg() {
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        popular_lunch_veg_rv.setLayoutManager(linearLayoutManager);
        popularLunchVegAdapter=new PopularLunchVegAdapter(getApplicationContext(),itemArrayList);
        popular_lunch_veg_rv.setAdapter(popularLunchVegAdapter);
        popularLunchVegAdapter.notifyDataSetChanged();
    }

    private void setPopularLunchNonVeg() {
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        popular_lunch_non_veg_rv.setLayoutManager(linearLayoutManager);
        popularLunchNonVegAdapter=new PopularLunchNonVegAdapter(getApplicationContext(),itemArrayList);
        popular_lunch_non_veg_rv.setAdapter(popularLunchNonVegAdapter);
        popularLunchNonVegAdapter.notifyDataSetChanged();

    }

    private void setPopularDinnerVeg() {
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        popular_dinner_veg_rv.setLayoutManager(linearLayoutManager);
        popularDinnerVegAdapter=new PopularDinnerVegAdapter(getApplicationContext(),itemArrayList);
        popular_dinner_veg_rv.setAdapter(popularDinnerVegAdapter);
        popularDinnerVegAdapter.notifyDataSetChanged();

    }

    private void setPopularDinnerNonVeg() {
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        popular_dinner_non_veg_rv.setLayoutManager(linearLayoutManager);
        popularDinnerNonVegAdapter=new PopularDinnerNonVegAdapter(getApplicationContext(),itemArrayList);
        popular_dinner_non_veg_rv.setAdapter(popularDinnerNonVegAdapter);
        popularDinnerNonVegAdapter.notifyDataSetChanged();

    }
}
