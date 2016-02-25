package com.example.dmitry.hws_android_school.ui.hw3_fragments_layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinearLayoutFragment extends BaseFragment {

    public static final String CHATMAIN = "chat_main";

    @Bind(R.id.new_message_text)
    EditText newMessageText;
    @Bind(R.id.submit_button)
    Button submitButton;
    @Bind(R.id.linear_main)
    LinearLayout linearMain;

    public LinearLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_linear_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.submit_button)
    public void onSubmitButtonClick() {
        TextView textView = new TextView(getActivity());
        textView.setText(newMessageText.getText());
        linearMain.addView(textView);
    }
}
