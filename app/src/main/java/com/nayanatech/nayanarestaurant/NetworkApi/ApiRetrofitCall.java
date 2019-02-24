package com.nayanatech.nayanarestaurant.NetworkApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.nayanatech.nayanarestaurant.NetworkApi.ApiUrls.BASE_URL;

public class ApiRetrofitCall {
    private static Retrofit retrofit=null;

    public  static Retrofit getClient(){
        //interceptor
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //Okhttp
        OkHttpClient okHttpClient=new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build();
        //retrofit client and add okhttp clent to retrofit
        retrofit=new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }
}
