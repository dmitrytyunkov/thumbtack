package com.example.dmitry.hws_android_school.ui.stack_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Stack1Activity extends BaseActivity {

    @Bind(R.id.activity2_button)
    Button activity2Button;
    @Bind(R.id.activity3_button)
    Button activity3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack1);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.activity2_button)
    public void onActivity2ButtonClick() {
        startActivity(new Intent(this, Stack2Activity.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
    }

    @OnClick(R.id.activity3_button)
    public void onActivity3ButtonClick() {
        startActivity(new Intent(this, Stack3Activity.class).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
    }
}
