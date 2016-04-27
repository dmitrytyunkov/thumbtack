package com.example.dmitry.hws_android_school.ui.hw7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.events.OpenSaveInSharedPreferencesFragmentEvent;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HW7MenuFragment extends BaseFragment {


    public HW7MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hw7_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.save_in_shared_preferences_button)
    public void onSaveinSharedPreferencesButtonClick() {
        getBus().post(new OpenSaveInSharedPreferencesFragmentEvent());
    }
}
