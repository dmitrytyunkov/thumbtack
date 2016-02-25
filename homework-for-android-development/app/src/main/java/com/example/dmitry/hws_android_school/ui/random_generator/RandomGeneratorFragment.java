package com.example.dmitry.hws_android_school.ui.random_generator;


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

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import java.math.BigDecimal;
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
public class RandomGeneratorFragment extends BaseFragment {

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
    private String resultString = "";
    private List<BigDecimal> listRandomValue = new ArrayList<>();


    public RandomGeneratorFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            resultString = savedInstanceState.getString(RESULT, "");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(RESULT, resultString);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_random_generator, container, false);
        ButterKnife.bind(this, view);

        quantityLabel.setText(String.format(Locale.US, "%s %d",
                getString(R.string.quantity_label), quantitySeekBar.getProgress() + 1));
        quantitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                quantity = progress;
                quantityLabel.setText(String.format(Locale.US, "%s %d",
                        getString(R.string.quantity_label), quantity + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        decimalPlacesLabel.setText(String.format(Locale.US, "%s %d",
                getString(R.string.decimal_places_label), decimalPlacesSeekBar.getProgress()));
        decimalPlacesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                decimalPlaces = progress;
                decimalPlacesLabel.setText(String.format(Locale.US, "%s %d",
                        getString(R.string.decimal_places_label), decimalPlaces));
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


    private Toast toastTextAlignment(Toast toast) {
        LinearLayout linearLayout = (LinearLayout) toast.getView();
        if (linearLayout.getChildCount() > 0) {
            TextView textView = (TextView) linearLayout.getChildAt(0);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }
        return toast;
    }

    private void copyToClipboard(String label, String text) {
        ClipboardManager clipboard =
                (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, text);
        clipboard.setPrimaryClip(clip);
    }

    private StringBuilder stringBuilderFormation(List<BigDecimal> listSource, int decimalPlaces) {
        StringBuilder stringBuilder = new StringBuilder();
        for (BigDecimal bigDecimal : listSource)
            stringBuilder.append(String.format(Locale.US, "%." + decimalPlaces + "f, ", bigDecimal));
        if (stringBuilder.length() > 0)
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
        return stringBuilder;
    }

            //todo REVU really long and unreadable method. Should be splitted up.
    @OnClick(R.id.random_button)
    public void onRandomButtonClick() {
        if (minValueText.getText().length() != 0 && maxValueText.getText().length() != 0) {
            boolean isErrorParse = false;
            long min = 0;
            long max = 0;
            BigDecimal randomValue;
            try {
                min = Long.parseLong(minValueText.getText().toString());
                max = Long.parseLong(maxValueText.getText().toString());
            } catch (NumberFormatException ex) {
                isErrorParse = true;
                toastTextAlignment(Toast.makeText(getActivity(),
                        R.string.error_parse_toast, Toast.LENGTH_SHORT)).show();
            }
            resultString = "";
            if (!isErrorParse)
                if (min < max) {
                    for (int i = 0; i < quantity + 1; ++i) {
                        randomValue = new BigDecimal(random.nextDouble() * (max - min) + min);
                        randomValue = randomValue.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
                        if (notRepeatingCheckBox.isChecked()) {
                            if ((decimalPlaces == 0 && max - min < quantity) || (decimalPlaces > 0 && quantity * decimalPlaces > (max - min) * Math.pow(10, decimalPlaces))) {
                                toastTextAlignment(Toast.makeText(getActivity(),
                                        R.string.error_quantity_generate_toast, Toast.LENGTH_SHORT)).show();
                                break;
                            }
                            if (!listRandomValue.isEmpty() && listRandomValue.contains(randomValue)) {
                                --i;
                                continue;
                            }
                        }
                        listRandomValue.add(randomValue);
                    }
                    resultString = stringBuilderFormation(listRandomValue, decimalPlaces).toString();
                    resultLabel.setText(resultString);
                    listRandomValue.clear();
                } else {
                    toastTextAlignment(Toast.makeText(getActivity(),
                            R.string.error_generate_toast, Toast.LENGTH_SHORT)).show();
                }
        }
    }

    @OnClick(R.id.copy_button)
    public void onCopyButtonClick() {
        if (resultLabel.getText().length() != 0) {
            copyToClipboard(RESULT_CLIP, resultLabel.getText().toString());
            toastTextAlignment(Toast.makeText(getActivity(),
                    R.string.copy_toast, Toast.LENGTH_SHORT)).show();
        } else
            toastTextAlignment(Toast.makeText(getActivity(),
                    R.string.error_copy_toast, Toast.LENGTH_SHORT)).show();
    }
}
