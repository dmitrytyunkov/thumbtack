package com.example.dmitry.hws_android_school.ui.stack_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Stack3Activity extends BaseActivity {

    @Bind(R.id.activity1_button)
    Button activity1Button;
    @Bind(R.id.activity2_button)
    Button activity2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack3);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.activity1_button)
    public void onActivity1ButtonClick() {
        startActivity(new Intent(this, Stack1Activity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    @OnClick(R.id.activity2_button)
    public void onActivity2ButtonClick() {
        startActivity(new Intent(this, Stack2Activity.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
    }
}
