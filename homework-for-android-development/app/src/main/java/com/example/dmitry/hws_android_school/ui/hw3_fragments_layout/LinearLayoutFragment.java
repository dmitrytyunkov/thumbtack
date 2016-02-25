package com.example.dmitry.hws_android_school.ui.hw3_fragments_layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinearLayoutFragment extends BaseFragment {


    public LinearLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_linear_layout, container, false);
    }


}
