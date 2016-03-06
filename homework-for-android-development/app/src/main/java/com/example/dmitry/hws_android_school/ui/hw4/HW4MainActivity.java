package com.example.dmitry.hws_android_school.ui.hw4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.extra.CameraHandler;
import com.example.dmitry.hws_android_school.ui.base.BaseActivity;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HW4MainActivity extends BaseActivity {


    public static final String DATE_STRING = "dete string";
    public static final String URI_STRING = "uri string";
    public static final int REQUEST_CODE_GET_STRING = 1;
    public static final int REQUEST_CODE_GALLERY = 2;


    @Bind(R.id.title_main_hw4_label)
    TextView titleMainHw4Label;
    @Bind(R.id.transfer_text)
    EditText transferText;
    @Bind(R.id.transfer_to_second_button)
    Button transferToSecondButton;
    @Bind(R.id.hw4_image_view)
    ImageView hw4ImageView;
    @Bind(R.id.load_image_button)
    Button loadImageButton;


    String dateString = "";
    String uriString = "";
    @Bind(R.id.load_camera_button)
    Button loadCameraButton;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(DATE_STRING, dateString);
        outState.putString(URI_STRING, uriString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            dateString = savedInstanceState.getString(DATE_STRING, "");
            uriString = savedInstanceState.getString(URI_STRING, "");
            titleMainHw4Label.setText(dateString);
            hw4ImageView.setImageURI(null);
            hw4ImageView.setImageURI(Uri.parse(uriString));
        }
    }


    @OnClick(R.id.transfer_to_second_button)
    public void onTransferToSecondButton() {
        startActivityForResult(new Intent(this, HW4SecondActivity.class)
                .putExtra(HW4SecondActivity.CODE_MESSAGE_STRING,
                        transferText.getText().toString()), REQUEST_CODE_GET_STRING);
    }

    @OnClick(R.id.load_image_button)
    public void onLoadImageButtonClick() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, REQUEST_CODE_GALLERY);
    }

    @OnClick(R.id.load_camera_button)
    public void onLoadCameraButtonClick() {
        CameraHandler cameraHandler = new CameraHandler(HW4MainActivity.this);
        String path = cameraHandler.openCamera("");
        cameraHandler.addToGallery(path);
        SystemClock.sleep(5000);
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        uriString = uri.toString();
        hw4ImageView.setImageURI(null);
        hw4ImageView.setImageURI(Uri.parse(uriString));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_GET_STRING:
                if (resultCode == RESULT_OK) {
                    long time = data.getLongExtra(HW4SecondActivity.CODE_MESSAGE_STRING, 0);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(time);
                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
                    dateString = formater.format(calendar.getTime());
                    titleMainHw4Label.setText(dateString);
                } else
                    titleMainHw4Label.setText(R.string.no_result);
                break;
            case REQUEST_CODE_GALLERY:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    uriString = selectedImage.toString();
                    hw4ImageView.setImageURI(null);
                    hw4ImageView.setImageURI(selectedImage);
                }
                break;
            default:
                break;
        }
    }
}
