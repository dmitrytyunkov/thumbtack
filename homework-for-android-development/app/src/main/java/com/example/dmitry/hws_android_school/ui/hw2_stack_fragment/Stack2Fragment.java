package com.example.dmitry.hws_android_school.ui.hw2_stack_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.events.OpenFragment1Event;
import com.example.dmitry.hws_android_school.events.OpenFragment3Event;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class Stack2Fragment extends BaseFragment {

    @Bind(R.id.fragment1_button)
    Button fragment1Button;
    @Bind(R.id.fragment3_button)
    Button fragment3Button;


    public Stack2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stack2, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.fragment1_button)
    public void onFragment1ButtonClick() {
        getBus().post(new OpenFragment1Event());
    }

    @OnClick(R.id.fragment3_button)
    public void onFragment3ButtonClick() {
        getBus().post(new OpenFragment3Event());
    }
}
