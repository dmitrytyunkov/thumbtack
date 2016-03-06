package com.example.dmitry.hws_android_school.ui.hw4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HW4MainActivity extends BaseActivity {


    @Bind(R.id.title_main_hw4_label)
    TextView titleMainHw4Label;
    @Bind(R.id.transfer_text)
    EditText transferText;
    @Bind(R.id.transfer_to_second_button)
    Button transferToSecondButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.transfer_to_second_button)
    public void onTransferToSecondButton() {
        startActivity(new Intent(this, HW4SecondActivity.class).putExtra(HW4SecondActivity.CODE_MESSAGE_STRING, transferText.getText().toString()));
    }
}
