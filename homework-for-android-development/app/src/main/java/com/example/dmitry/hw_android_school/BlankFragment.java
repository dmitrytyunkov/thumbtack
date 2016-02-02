package com.example.dmitry.hw_android_school;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    @Bind(R.id.min_value_text)
    EditText minValueText;
    @Bind(R.id.max_value_text)
    EditText maxValueText;
    @Bind(R.id.random_value_text)
    EditText randomValueText;

    int min = 0;
    int max = 0;
    int random = 0;


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


    @OnClick(R.id.random_button)
    public void onRandomButtonClick() {
        if (minValueText.getText().length() != 0 && maxValueText.getText().length() != 0) {
            min = Integer.parseInt(minValueText.getText().toString());
            max = Integer.parseInt(maxValueText.getText().toString());
            if (min > max)
                Toast.makeText(getActivity(), R.string.error_toast, Toast.LENGTH_LONG).show();
            else {
                random = new Random().nextInt(max - min + 1) + min;
                randomValueText.setText(String.valueOf(random));
                Toast.makeText(getActivity(), R.string.message_toast, Toast.LENGTH_LONG).show();
            }
        }
    }
}
