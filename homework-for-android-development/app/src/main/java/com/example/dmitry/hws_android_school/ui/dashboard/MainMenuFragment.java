package com.example.dmitry.hws_android_school.ui.dashboard;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.events.OpenHW2MenuFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenHW3MenuFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenHW4MainActivityEvent;
import com.example.dmitry.hws_android_school.events.OpenHW7MenuFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenRandomGeneratorFragmentEvent;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends BaseFragment {

    private MainMenuFragmentCallbacks callbacks;


    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainMenuFragmentCallbacks) {
            callbacks = (MainMenuFragmentCallbacks) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }


    @OnClick(R.id.hw1_button)
    public void onHW1ButtonClick() {
        getBus().post(new OpenRandomGeneratorFragmentEvent());

/*        if (callbacks != null)
            callbacks.onHW1ButtonPressed();*/
    }

    @OnClick(R.id.hw2_button)
    public void onHW2ButtonClick() {
        getBus().post(new OpenHW2MenuFragmentEvent());

/*        if (callbacks != null)
            callbacks.onHW2MenuButtonPressed();*/
    }

    @OnClick(R.id.hw3_button)
    public void onHW3ButtonClick() {
        getBus().post(new OpenHW3MenuFragmentEvent());
    }

    @OnClick(R.id.hw4_button)
    public void onHW4ButtonClick() {
        getBus().post(new OpenHW4MainActivityEvent());
    }

    @OnClick(R.id.hw7_button)
    public void onHW7ButtonClick() {
        getBus().post(new OpenHW7MenuFragmentEvent());
    }


    public interface MainMenuFragmentCallbacks {
        void onHW1ButtonPressed();

        void onHW2MenuButtonPressed();
    }
}
