package com.example.dmitry.hws_android_school.ui.hw2;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.events.OpenNewActivityEvent;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class HW2Fragment extends BaseFragment {


    private HW2FragmentCallbacks callbacks;


    public HW2Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof HW2FragmentCallbacks) {
            callbacks = (HW2FragmentCallbacks) context;
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
        return inflater.inflate(R.layout.fragment_hw2, container, false);
    }


    @OnClick(R.id.new_activity_button)
    public void onNewActivityButtonClick() {
/*        getBus().post(new OpenNewActivityEvent());*/

        if (callbacks != null)
            callbacks.onNewActivityButtonPressed();
    }


    public interface HW2FragmentCallbacks {
        void onNewActivityButtonPressed();

        void onActivityStackButtonPressed();

        void onFragmentStackButtonPressed();
    }
}
