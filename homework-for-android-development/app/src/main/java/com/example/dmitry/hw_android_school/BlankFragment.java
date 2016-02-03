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


    public static final String MAX = "max";
    public static final String MIN = "min";
    public static final String CURRENT = "current";
    @Bind(R.id.min_value_label)
    TextView minValueLabel;
    @Bind(R.id.max_value_label)
    TextView maxValueLabel;
    @Bind(R.id.current_value_label)
    TextView currentValueLabel;

    private int min = 0;
    private int max = 0;
    private int current = 0;
    private StringBuilder stringBuilder;
    private final Random random = new Random();


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            current = savedInstanceState.getInt(CURRENT, 0);
            min = savedInstanceState.getInt(MIN, 0);
            max = savedInstanceState.getInt(MAX, 0);
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(CURRENT, current);
        outState.putInt(MIN, min);
        outState.putInt(MAX, max);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        ButterKnife.bind(this, view);

        stringBuilder = new StringBuilder(getString(R.string.current_value_label).concat(" "));
        stringBuilder.append(current);
        currentValueLabel.setText(stringBuilder);

        stringBuilder = new StringBuilder(getString(R.string.min_value_label).concat(" "));
        stringBuilder.append(min);
        minValueLabel.setText(stringBuilder);

        stringBuilder = new StringBuilder(getString(R.string.max_value_label).concat(" "));
        stringBuilder.append(max);
        maxValueLabel.setText(stringBuilder);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.increment_button)
    public void onIncrementButtonClick() {
        stringBuilder = new StringBuilder(getString(R.string.current_value_label).concat(" "));
        stringBuilder.append(++current);
        currentValueLabel.setText(stringBuilder);
    }

    @OnClick(R.id.decrement_button)
    public void onDecrementButtonClick() {
        stringBuilder = new StringBuilder(getString(R.string.current_value_label).concat(" "));
        stringBuilder.append(--current);
        currentValueLabel.setText(stringBuilder);
    }

    @OnClick(R.id.set_min_value_button)
    public void onSetMinValueButtonClick() {
        min = current;
        stringBuilder = new StringBuilder(getString(R.string.min_value_label).concat(" "));
        stringBuilder.append(min);
        minValueLabel.setText(stringBuilder);
    }

    @OnClick(R.id.set_max_value_button)
    public void onSetMaxValueButtonClick() {
        max = current;
        stringBuilder = new StringBuilder(getString(R.string.max_value_label).concat(" "));
        stringBuilder.append(max);
        maxValueLabel.setText(stringBuilder);
    }

    @OnClick(R.id.random_button)
    public void onToastButtonClick() {
        String toastString;
        if (min > max)
            Toast.makeText(getActivity(), R.string.error_toast, Toast.LENGTH_LONG).show();
        else {
            int randomValue = random.nextInt(max - min + 1) + min;
            stringBuilder = new StringBuilder(getString(R.string.random_value_toast).concat(" "));
            stringBuilder.append(randomValue);
            Toast.makeText(getActivity(), stringBuilder, Toast.LENGTH_LONG).show();
        }

    }
}
