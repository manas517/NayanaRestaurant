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
import com.nayanatech.nayanarestaurant.R;

import java.util.ArrayList;

public class CategoriesPatanjaliAdapter extends RecyclerView.Adapter<CategoriesPatanjaliAdapter.CategoriesViewHolder> {
    private Context context;
    private ArrayList<Category> categoryArrayList;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }



    public CategoriesPatanjaliAdapter(Context context, ArrayList<Category> categoryArrayList) {
        this.context = context;
        this.categoryArrayList = categoryArrayList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.patanjali_categories_item,viewGroup,false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder categoriesViewHolder,final  int i) {
        Glide.with(context).load(DashboardFragment.patanjali_sub_category_image_url+categoryArrayList.get(i).getImage()).into(categoriesViewHolder.catagories_img);
        categoriesViewHolder.category_tv.setText(categoryArrayList.get(i).getName());
        categoriesViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view,i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder {
        ImageView catagories_img;
        TextView category_tv;
        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            catagories_img=itemView.findViewById(R.id.categories_iv);
            category_tv=itemView.findViewById(R.id.category_tv);
        }
    }
}
