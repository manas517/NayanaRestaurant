package com.nayanatech.nayanarestaurant.NetworkApi;

import com.nayanatech.nayanarestaurant.Model.DashboardModel;
import com.nayanatech.nayanarestaurant.Model.GroceryCatagories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.nayanatech.nayanarestaurant.NetworkApi.ApiUrls.APP_CONFIG_URL;
import static com.nayanatech.nayanarestaurant.NetworkApi.ApiUrls.CATAGORIES_URL;

public interface ApiInterface {

    @GET(APP_CONFIG_URL)
    Call<DashboardModel> getDashboardData(@Query("city_id") String city_id,@Query("veg") String veg);

    @GET(CATAGORIES_URL)
    Call<GroceryCatagories> getGroceryCategoriesData();

}
