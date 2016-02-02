package com.example.dmitry.hw_android_school;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    @Bind(R.id.min_value_label)
    TextView minValueLabel;
    @Bind(R.id.max_value_label)
    TextView maxValueLabel;
    @Bind(R.id.current_value_label)
    TextView currentValueLabel;

    int min = 0;
    int max = 0;
    int current = 0;


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
        currentValueLabel.setText(String.format("Current value: %d", ++current));
    }

    @OnClick(R.id.decrement_button)
    public void onDecrementButtonClick() {
        currentValueLabel.setText(String.format("Current value: %d", --current));
    }

    @OnClick(R.id.set_min_value_button)
    public void onSetMinValueButtonClick() {
        min = current;
        minValueLabel.setText(String.format("Min value: %d", min));
    }

    @OnClick(R.id.set_max_value_button)
    public void onSetMaxValueButtonClick() {
        max = current;
        maxValueLabel.setText(String.format("Max value: %d", max));
    }

    @OnClick(R.id.random_button)
    public void onToastButtonClick() {
        String toastString;
        if (min < max) {
            int randomValue = new Random().nextInt(max - min + 1) + min;
            toastString = String.format("Random value: %d", randomValue);
        }
        else
            toastString = String.format("ERROR!!!%nMin value > Max value");
        Toast.makeText(getActivity(), toastString, Toast.LENGTH_LONG).show();
    }
}
