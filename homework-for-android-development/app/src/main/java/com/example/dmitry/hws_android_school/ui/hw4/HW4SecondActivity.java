package com.example.dmitry.hws_android_school.ui.hw4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseActivity;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HW4SecondActivity extends BaseActivity {


    public static final String CODE_MESSAGE_STRING = "CODE_MESSAGE_STRING";


    @Bind(R.id.title_hw4_second_label)
    TextView titleHw4SecondLabel;
    @Bind(R.id.date_picker)
    DatePicker datePicker;
    @Bind(R.id.time_picker)
    TimePicker timePicker;
    @Bind(R.id.transfer_to_main_button)
    Button transferToMainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4_second);
        ButterKnife.bind(this);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        final Intent intent = getIntent();

        if (intent.hasExtra(CODE_MESSAGE_STRING))
            titleHw4SecondLabel.setText(intent.getStringExtra(CODE_MESSAGE_STRING));
        else
            titleHw4SecondLabel.setText(R.string.no_extra);
    }


    @OnClick(R.id.transfer_to_main_button)
    public void onTransferToMainButtonClick() {
        final Intent intent = new Intent();
        Calendar calendar = Calendar.getInstance();
        calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                timePicker.getCurrentHour(), timePicker.getCurrentMinute());
        long time = calendar.getTimeInMillis();
        intent.putExtra(CODE_MESSAGE_STRING, time);

        setResult(RESULT_OK, intent);
        finish();
    }
}
