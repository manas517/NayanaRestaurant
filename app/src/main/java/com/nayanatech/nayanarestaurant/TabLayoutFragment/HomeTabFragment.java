package com.nayanatech.nayanarestaurant.TabLayoutFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nayanatech.nayanarestaurant.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTabFragment extends Fragment {


    public HomeTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_tab, container, false);
    }

}
