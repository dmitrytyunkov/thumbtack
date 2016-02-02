package com.example.dmitry.hw_android_school;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    @Bind(R.id.counter_label)
    TextView counterLabel;

    int counter = 0;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.increment_button)
    public void onIncrementButtonClick() {
        counterLabel.setText(String.format("Value: %d", ++counter));
    }


    @OnClick(R.id.decrement_button)
    public void onDecrementButtonClick() {
        counterLabel.setText(String.format("Value: %d", --counter));
    }


    @OnClick(R.id.toast_button)
    public void onToastButtonClick() {
        Toast.makeText(getActivity(), R.string.toast_message, Toast.LENGTH_LONG).show();
    }
}
