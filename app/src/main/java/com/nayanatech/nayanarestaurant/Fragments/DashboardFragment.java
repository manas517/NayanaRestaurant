package com.nayanatech.nayanarestaurant.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.nayanatech.nayanarestaurant.Activity.PatanjaliWorld;
import com.nayanatech.nayanarestaurant.Activity.PopularLunchComboMeals;
import com.nayanatech.nayanarestaurant.Adapter.AdditionalFeaturesRecycleViewAdapter;
import com.nayanatech.nayanarestaurant.Adapter.FeaturesGridAdapter;
import com.nayanatech.nayanarestaurant.Adapter.PopularComboRecyclerviewAdapter;
import com.nayanatech.nayanarestaurant.Adapter.SpecialRecycleviewAdapter;
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

public class DashboardFragment extends Fragment {

    public static final String city_id = "FOODCITYBAM";
    public static final String image_url = "https://storage.googleapis.com/foodinns-images/resources/banner/big/";
    public static final String popular_combo_url = "https://storage.googleapis.com/foodinns-images/resources/mealcombo/thumb/";
    public static final String additional_feature_image_url = "https://storage.googleapis.com/foodinns-images/resources/appconfig/big/";
    public static final String features_image_url = "https://storage.googleapis.com/foodinns-images/resources/appconfig/small/";
    public static final String patanjali_category_image_url = "https://storage.googleapis.com/foodinns-images/resources/patanjali/category_image/thumb/";
    public static final String patanjali_sub_category_image_url = "https://storage.googleapis.com/foodinns-images/resources/patanjali/category_image/main_image/";

    ArrayList<Section> sectionArrayList = new ArrayList<>();
    ArrayList<Item> itemArrayList = new ArrayList<>();
    private RecyclerView specialRecyclerview;
    private ShimmerFrameLayout mShimmerViewContainer;
    private TextView see_all_textView;
    private RecyclerView features_grid_view;
    private ImageView patanjali_rel_lay;
    private ImageView catering_img_view;
    private RecyclerView popular_combo_Recyclerview;
    private RecyclerView additional_recyclerview;
    private LinearLayoutManager linearLayoutManager;
    private SpecialRecycleviewAdapter specialRecycleviewAdapter;
    private PopularComboRecyclerviewAdapter popularComboRecyclerviewAdapter;
    private AdditionalFeaturesRecycleViewAdapter additionalFeaturesRecycleViewAdapter;
    private ConstraintLayout constraintLayout_data;
    public DashboardFragment() {
        // Required empty public constructor
    }
    //ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // progressDialog=new ProgressDialog(getActivity());
        specialRecyclerview = (RecyclerView) view.findViewById(R.id.special_rv);
        patanjali_rel_lay = (ImageView) view.findViewById(R.id.patanjali_rel_lay);
        catering_img_view = (ImageView) view.findViewById(R.id.catering_iv);
        popular_combo_Recyclerview = (RecyclerView) view.findViewById(R.id.popular_meal_combo_rv);
        additional_recyclerview = (RecyclerView) view.findViewById(R.id.additional_feature_rv);
        features_grid_view = (RecyclerView) view.findViewById(R.id.features_grid_rv);
        see_all_textView = view.findViewById(R.id.see_all_tv);
        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);
        constraintLayout_data=view.findViewById(R.id.dashboard_cl);
        initEventListener();
        networkCallForDashboard();

    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }

    private void initEventListener() {
        see_all_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopularLunchComboMeals.class);
/*
                intent.putExtra("COMBO_ITEM_IMAGE",DashboardFragment.popular_combo_url+itemArrayList.get(0).getImagename());
*/
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
            }
        });
        patanjali_rel_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), PatanjaliWorld.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

            }
        });
    }

    private void networkCallForDashboard() {
        ApiInterface apiInterface = ApiRetrofitCall.getClient().create(ApiInterface.class);
        //progressDialog.show();
        Call<DashboardModel> call = apiInterface.getDashboardData(city_id, "");
        call.enqueue(new Callback<DashboardModel>() {
            @Override
            public void onResponse(Call<DashboardModel> call, Response<DashboardModel> response) {
                if (response.isSuccessful()) {
                    DashboardModel dashboardModel = response.body();
                    sectionArrayList = (ArrayList<Section>) dashboardModel.getSections();
                    if (sectionArrayList.size() > 0) {
                        if (constraintLayout_data!=null){
                            constraintLayout_data.setVisibility(View.VISIBLE);
                        }

                        itemArrayList = (ArrayList<Item>) sectionArrayList.get(0).getItems();
                        setAdapter();
                        itemArrayList = (ArrayList<Item>) sectionArrayList.get(1).getItems();
                        setPopularComboAdapter();
                        itemArrayList = (ArrayList<Item>) sectionArrayList.get(4).getItems();
                        setAdditionalFeatureAdapter();
                        itemArrayList = (ArrayList<Item>) sectionArrayList.get(3).getItems();
                        Glide.with(getActivity()).load(DashboardFragment.additional_feature_image_url + itemArrayList.get(0).getImagename()).into(patanjali_rel_lay);
                        itemArrayList = (ArrayList<Item>) sectionArrayList.get(5).getItems();
                        Glide.with(getActivity()).load(DashboardFragment.additional_feature_image_url + itemArrayList.get(0).getImagename()).into(catering_img_view);
                        itemArrayList = (ArrayList<Item>) sectionArrayList.get(2).getItems();
                        setFeaturesGridAdapter();
                        mShimmerViewContainer.stopShimmerAnimation();
                        mShimmerViewContainer.setVisibility(View.GONE);
                        //progressDialog.dismiss();

                    }
                }
            }

            @Override
            public void onFailure(Call<DashboardModel> call, Throwable t) {

                //progressDialog.dismiss();
            }
        });

    }

    private void setFeaturesGridAdapter() {
        features_grid_view.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        FeaturesGridAdapter featuresGridAdapter = new FeaturesGridAdapter(getActivity(), itemArrayList);
        features_grid_view.setAdapter(featuresGridAdapter);
        featuresGridAdapter.notifyDataSetChanged();

    }

    private void setAdditionalFeatureAdapter() {
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        additional_recyclerview.setLayoutManager(linearLayoutManager);
        additionalFeaturesRecycleViewAdapter = new AdditionalFeaturesRecycleViewAdapter(getActivity(), itemArrayList);
        additional_recyclerview.setAdapter(additionalFeaturesRecycleViewAdapter);
        additionalFeaturesRecycleViewAdapter.notifyDataSetChanged();

    }

    private void setPopularComboAdapter() {
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        popular_combo_Recyclerview.setLayoutManager(linearLayoutManager);
        popularComboRecyclerviewAdapter = new PopularComboRecyclerviewAdapter(getActivity(), itemArrayList);
        popular_combo_Recyclerview.setAdapter(popularComboRecyclerviewAdapter);
        popularComboRecyclerviewAdapter.notifyDataSetChanged();

    }

    private void setAdapter() {
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        specialRecyclerview.setLayoutManager(linearLayoutManager);
        specialRecycleviewAdapter = new SpecialRecycleviewAdapter(getActivity(), itemArrayList);
        specialRecyclerview.setAdapter(specialRecycleviewAdapter);

    }


}
