package com.example.dmitry.hws_android_school.ui.stack_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.events.OpenFragment1Event;
import com.example.dmitry.hws_android_school.events.OpenFragment2Event;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class Stack3Fragment extends BaseFragment {

    @Bind(R.id.fragment1_button)
    Button fragment1Button;
    @Bind(R.id.fragment2_button)
    Button fragment2Button;


    public Stack3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stack3, container, false);
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

    @OnClick(R.id.fragment2_button)
    public void onFragment2ButtonClick() {
        getBus().post(new OpenFragment2Event());
    }
}
