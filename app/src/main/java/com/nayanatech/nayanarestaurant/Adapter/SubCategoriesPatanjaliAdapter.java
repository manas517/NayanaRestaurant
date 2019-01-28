package com.nayanatech.nayanarestaurant.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nayanatech.nayanarestaurant.Fragments.DashboardFragment;
import com.nayanatech.nayanarestaurant.Model.Category;
import com.nayanatech.nayanarestaurant.Model.SubCategory;
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

public class SubCategoriesPatanjaliAdapter extends RecyclerView.Adapter<SubCategoriesPatanjaliAdapter.SubCategoriesViewHolder> {
Context context;
ArrayList<SubCategory> subCategoryArrayList;

    public SubCategoriesPatanjaliAdapter(Context context, ArrayList<SubCategory> subCategoryArrayList) {
        this.context = context;
        this.subCategoryArrayList = subCategoryArrayList;
    }

    @NonNull
    @Override
    public SubCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.subcategories_item,viewGroup,false);
        return new SubCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoriesViewHolder SubCategoriesViewHolder, int i) {
        Glide.with(context).load(DashboardFragment.patanjali_sub_category_image_url+subCategoryArrayList.get(i).getImage()).into(SubCategoriesViewHolder.sub_categories_img);
        SubCategoriesViewHolder.sub_category_tv.setText(subCategoryArrayList.get(i).getName());
        SubCategoriesViewHolder.sub_category_footer_tv.setText(subCategoryArrayList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return subCategoryArrayList.size();
    }

    public class SubCategoriesViewHolder extends RecyclerView.ViewHolder {
        ImageView sub_categories_img;
        TextView sub_category_tv;
        TextView sub_category_footer_tv;
        public SubCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            sub_categories_img=itemView.findViewById(R.id.sub_categories_iv);
            sub_category_tv=itemView.findViewById(R.id.atta_tv);
            sub_category_footer_tv=itemView.findViewById(R.id.atta_footer_tv);
        }
    }
}
