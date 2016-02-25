package com.example.dmitry.hws_android_school.ui.hw3_menu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.events.OpenFrameLayoutFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenGridLayoutFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenLinearLayoutFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenRelativeLayoutFragmentEvent;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HW3MenuFragment extends BaseFragment {

    @Bind(R.id.linear_button)
    Button linearButton;
    @Bind(R.id.relative_button)
    Button relativeButton;
    @Bind(R.id.frame_button)
    Button frameButton;
    @Bind(R.id.grid_button)
    Button gridButton;


    public HW3MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hw3_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.linear_button)
    public void onLinearButtonClick() {
        getBus().post(new OpenLinearLayoutFragmentEvent());
    }

    @OnClick(R.id.relative_button)
    public void onRelativeButtonClick() {
        getBus().post(new OpenRelativeLayoutFragmentEvent());
    }

    @OnClick(R.id.frame_button)
    public void onFrameButtonClick() {
        getBus().post(new OpenFrameLayoutFragmentEvent());
    }

    @OnClick(R.id.grid_button)
    public void onGridButtonClick() {
        getBus().post(new OpenGridLayoutFragmentEvent());
    }
}
