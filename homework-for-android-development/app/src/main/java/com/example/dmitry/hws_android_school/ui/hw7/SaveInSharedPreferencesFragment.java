package com.example.dmitry.hws_android_school.ui.hw7;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaveInSharedPreferencesFragment extends BaseFragment {


    public static final String APP_PREFERENCES = "myPreferences";
    public static final String APP_PREFERENCES_TEXT = "Text";

    SharedPreferences sharedPreferences;

    @Bind(R.id.edit_text_for_save)
    EditText editTextForSave;


    public SaveInSharedPreferencesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save_in_shared_preferences, container, false);
        ButterKnife.bind(this, view);
        sharedPreferences = getContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(APP_PREFERENCES_TEXT, editTextForSave.getText().toString());
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (sharedPreferences.contains(APP_PREFERENCES_TEXT)) {
            editTextForSave.setText(sharedPreferences.getString(APP_PREFERENCES_TEXT, ""));
        }
    }
}
