package com.example.dmitry.hws_android_school.ui.hw4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HW4MainActivity extends BaseActivity {


    public static final int REQUEST_CODE_GET_STRING = 100_50;


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
        startActivityForResult(new Intent(this, HW4SecondActivity.class)
                        .putExtra(HW4SecondActivity.CODE_MESSAGE_STRING, transferText.getText().toString()),
                REQUEST_CODE_GET_STRING);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE_GET_STRING)
            if (resultCode==RESULT_OK) {
                long time = data.getLongExtra(HW4SecondActivity.CODE_MESSAGE_STRING, 0);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(time);
                DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
                titleMainHw4Label.setText(formater.format(calendar.getTime()));
            }
            else
                titleMainHw4Label.setText(R.string.no_result);

        super.onActivityResult(requestCode, resultCode, data);
    }
}
