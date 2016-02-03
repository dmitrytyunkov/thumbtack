package com.example.dmitry.hw_android_school;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public static final String RESULT = "result";
    public static final String RESULT_CLIP = "result_clip";
    private final Random random = new Random();
    @Bind(R.id.min_value_text)
    EditText minValueText;
    @Bind(R.id.max_value_text)
    EditText maxValueText;
    @Bind(R.id.quantity_label)
    TextView quantityLabel;
    @Bind(R.id.quantity_seek_bar)
    SeekBar quantitySeekBar;
    @Bind(R.id.result_label)
    TextView resultLabel;
    @Bind(R.id.not_repeating_check_box)
    CheckBox notRepeatingCheckBox;
    @Bind(R.id.decimal_places_label)
    TextView decimalPlacesLabel;
    @Bind(R.id.decimal_places_seek_bar)
    SeekBar decimalPlacesSeekBar;

    private int quantity = 0;
    private int decimalPlaces = 0;
    private StringBuilder stringBuilder;
    private StringBuilder resultString = new StringBuilder();
    private List<Double> listRandomValue = new ArrayList<>();


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            resultString = new StringBuilder(savedInstanceState.getString(RESULT, ""));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(RESULT, resultString.toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        stringBuilder = new StringBuilder(getString(R.string.quantity_label).concat(" "));
        stringBuilder.append(quantitySeekBar.getProgress() + 1);
        quantityLabel.setText(stringBuilder);
        quantitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                quantity = progress;
                stringBuilder = new StringBuilder(getString(R.string.quantity_label).concat(" "));
                stringBuilder.append(quantity + 1);
                quantityLabel.setText(stringBuilder);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        stringBuilder = new StringBuilder(getString(R.string.decimal_places_label).concat(" "));
        stringBuilder.append(decimalPlacesSeekBar.getProgress());
        decimalPlacesLabel.setText(stringBuilder);
        decimalPlacesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                decimalPlaces = progress;
                stringBuilder = new StringBuilder(getString(R.string.decimal_places_label).concat(" "));
                stringBuilder.append(decimalPlaces);
                decimalPlacesLabel.setText(stringBuilder);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        resultLabel.setText(resultString);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    Double roundDouble(Double d, int precise) {
        precise = (int) Math.pow(10, precise);
        d = d * precise;
        int i = (int) Math.round(d);
        return (double) i / precise;
    }


    @OnClick(R.id.random_button)
    public void onRandomButtonClick() {
        if (minValueText.getText().length() != 0 && maxValueText.getText().length() != 0) {
            boolean isErrorParse = false;
            int min = 0;
            int max = 0;
            Double randomValue;
            try {
                min = Integer.parseInt(minValueText.getText().toString());
                max = Integer.parseInt(maxValueText.getText().toString());
            } catch (NumberFormatException ex) {
                isErrorParse = true;
                Toast toast = Toast.makeText(getActivity(),
                        R.string.error_parse_toast, Toast.LENGTH_SHORT);
                LinearLayout linearLayout = (LinearLayout) toast.getView();
                if (linearLayout.getChildCount() > 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                }
                toast.show();
            }
            resultString = new StringBuilder();
            if (!isErrorParse)
                if (min < max) {
                    for (int i = 0; i < quantity + 1; ++i) {
                        randomValue = roundDouble(random.nextDouble() * (max - min) + min, decimalPlaces);
                        if (notRepeatingCheckBox.isChecked()) {
                            if ((decimalPlaces == 0 && max - min < quantity) || (decimalPlaces > 0 && quantity * decimalPlaces > (max - min) * 10 * decimalPlaces)) {
                                Toast toast = Toast.makeText(getActivity(),
                                        R.string.error_quantity_generate_toast, Toast.LENGTH_SHORT);
                                LinearLayout linearLayout = (LinearLayout) toast.getView();
                                if (linearLayout.getChildCount() > 0) {
                                    TextView textView = (TextView) linearLayout.getChildAt(0);
                                    textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                                }
                                toast.show();
                                break;
                            }
                            if (!listRandomValue.isEmpty() && listRandomValue.contains(randomValue)) {
                                --i;
                                continue;
                            }
                        }
                        listRandomValue.add(randomValue);
                    }
                    for (Double d : listRandomValue)
                        resultString.append(String.format(Locale.ENGLISH, "%." + decimalPlaces + "f; ", d));
                    if (resultString.length() > 0)
                        resultString.delete(resultString.length() - 2, resultString.length() - 1);
                    listRandomValue.clear();
                    resultLabel.setText(resultString);
                } else {
                    Toast toast = Toast.makeText(getActivity(), R.string.error_generate_toast,
                            Toast.LENGTH_SHORT);
                    LinearLayout linearLayout = (LinearLayout) toast.getView();
                    if (linearLayout.getChildCount() > 0) {
                        TextView textView = (TextView) linearLayout.getChildAt(0);
                        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                    }
                    toast.show();
                }
        }
    }

    @OnClick(R.id.copy_button)
    public void onCopyButtonClick() {
        if (resultLabel.getText().length() != 0) {
            ClipboardManager clipboard =
                    (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText(RESULT_CLIP, resultLabel.getText().toString());
            clipboard.setPrimaryClip(clip);
            Toast.makeText(getActivity(), R.string.copy_toast, Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getActivity(), R.string.error_copy_toast, Toast.LENGTH_SHORT).show();
    }
}
