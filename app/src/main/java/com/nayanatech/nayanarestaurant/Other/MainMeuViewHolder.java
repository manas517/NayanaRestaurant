package com.nayanatech.nayanarestaurant.Other;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.nayanatech.nayanarestaurant.Model.MainMenuItemModel;
import com.nayanatech.nayanarestaurant.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;


public class MainMeuViewHolder extends GroupViewHolder {
    private TextView mTextView;
    private ImageView imageView;
    public MainMeuViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.item_title_tv);
        imageView=itemView.findViewById(R.id.arrow_iv);
    }
    public void bind(MainMenuItemModel mainMenuItemModel){
        mTextView.setText(mainMenuItemModel.getTitle());

    }

    @Override
    public void expand() {
        animatedExpand();
    }

    @Override
    public void collapse() {
        animatedCollapse();
    }
    private void animatedExpand(){
        RotateAnimation rotateAnimation=new RotateAnimation
                (360,180, Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        imageView.setAnimation(rotateAnimation);
    }
    private void animatedCollapse(){
        RotateAnimation rotateAnimation=new RotateAnimation
                (180,360, Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        imageView.setAnimation(rotateAnimation);
    }
}
