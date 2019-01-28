package com.nayanatech.nayanarestaurant.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.nayanatech.nayanarestaurant.Adapter.CategoriesPatanjaliAdapter;
import com.nayanatech.nayanarestaurant.Adapter.SubCategoriesPatanjaliAdapter;
import com.nayanatech.nayanarestaurant.Model.Category;
import com.nayanatech.nayanarestaurant.Model.ChildSubcat;
import com.nayanatech.nayanarestaurant.Model.GroceryCatagories;
import com.nayanatech.nayanarestaurant.Model.SubCategory;
import com.nayanatech.nayanarestaurant.NetworkApi.ApiInterface;
import com.nayanatech.nayanarestaurant.NetworkApi.ApiRetrofitCall;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatanjaliWorldFragment extends Fragment {
    ArrayList<Category> categoryArrayList=new ArrayList<>();
    ArrayList<SubCategory> subCategoryArrayList=new ArrayList<>();
    ArrayList<ChildSubcat> childSubcatArrayList=new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private CategoriesPatanjaliAdapter categoriesPatanjaliAdapter;
    private SubCategoriesPatanjaliAdapter subCategoriesPatanjaliAdapter;
    private ConstraintLayout mConstraintLayout;
    private ShimmerFrameLayout mShimmerViewContainer;
    private RecyclerView categories_RecyclerView;
    private RecyclerView sub_categories_rv;
    private TextView categories_tv;

    public PatanjaliWorldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patanjali_world, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categories_RecyclerView=view.findViewById(R.id.categories_rv);
        sub_categories_rv=view.findViewById(R.id.sub_categories_rv);
        categories_tv=view.findViewById(R.id.categories_tv);
        mShimmerViewContainer=view.findViewById(R.id.shimmer_view_container);
        mConstraintLayout=view.findViewById(R.id.patanjali_con_lay);
        networkCallForGetPatanjaliWorld();
        //initEventListener();
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
        categoriesPatanjaliAdapter.setOnItemClickListener(new CategoriesPatanjaliAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                subCategoryArrayList= (ArrayList<SubCategory>) categoryArrayList.get(i).getSubCategories();
                setSubCategoriesPatanjaliAdapter();
            }
        });
    }

    private void networkCallForGetPatanjaliWorld() {
        ApiInterface apiInterface=ApiRetrofitCall.getClient().create(ApiInterface.class);
        Call<GroceryCatagories> groceryCatagoriesCall=apiInterface.getGroceryCategoriesData();
        groceryCatagoriesCall.enqueue(new Callback<GroceryCatagories>() {
            @Override
            public void onResponse(Call<GroceryCatagories> call, Response<GroceryCatagories> response) {
                if(response.isSuccessful()){
                    GroceryCatagories groceryCatagories=response.body();
                    categoryArrayList= (ArrayList<Category>) groceryCatagories.getCategories();
                    if(categoryArrayList.size()>0){
                        if (mConstraintLayout!=null){
                            mConstraintLayout.setVisibility(View.VISIBLE);
                        }
                        setCategoriesPatanjaliAdapter();
                        subCategoryArrayList= (ArrayList<SubCategory>) categoryArrayList.get(0).getSubCategories();
                        setSubCategoriesPatanjaliAdapter();
                        mShimmerViewContainer.stopShimmerAnimation();
                        mShimmerViewContainer.setVisibility(View.GONE);
                        initEventListener();
                    }
                }
            }



            @Override
            public void onFailure(Call<GroceryCatagories> call, Throwable t) {
                Log.d("PatanjaliWorld", "api call fails");


            }
        });
    }

    private void setCategoriesPatanjaliAdapter() {
        linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        categories_RecyclerView.setLayoutManager(linearLayoutManager);
        categoriesPatanjaliAdapter=new CategoriesPatanjaliAdapter(getActivity(),categoryArrayList);
        categories_RecyclerView.setAdapter(categoriesPatanjaliAdapter);
        categoriesPatanjaliAdapter.notifyDataSetChanged();
    }
    private void setSubCategoriesPatanjaliAdapter() {
        linearLayoutManager=new LinearLayoutManager(getActivity());
        sub_categories_rv.setLayoutManager(linearLayoutManager);
        subCategoriesPatanjaliAdapter=new SubCategoriesPatanjaliAdapter(getActivity(),subCategoryArrayList);
        sub_categories_rv.setAdapter(subCategoriesPatanjaliAdapter);
        subCategoriesPatanjaliAdapter.notifyDataSetChanged();
    }
}
