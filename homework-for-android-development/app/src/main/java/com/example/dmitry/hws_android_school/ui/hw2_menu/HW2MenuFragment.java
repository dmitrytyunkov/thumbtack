package com.example.dmitry.hws_android_school.ui.hw2_menu;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.events.OpenStackFragmentEvent;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class HW2MenuFragment extends BaseFragment {

    private HW2FragmentCallbacks callbacks;


    public HW2MenuFragment() {
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
        return inflater.inflate(R.layout.fragment_hw2_menu, container, false);
    }


    @OnClick(R.id.new_activity_button)
    public void onNewActivityButtonClick() {
/*        getBus().post(new OpenNewActivityEvent());*/

        if (callbacks != null)
            callbacks.onNewActivityButtonPressed();
    }

    @OnClick(R.id.stack_activity_button)
    public void onStackActivityButtonClick() {
/*        getBus().post(new OpenStackActivityEvent());*/

        if (callbacks != null)
            callbacks.onStackActivityButtonPressed();
    }

    @OnClick(R.id.stack_fragment_button)
    public void onStackFragmentButtonClick() {
        getBus().post(new OpenStackFragmentEvent());

/*        if (callbacks != null)
            callbacks.onStackFragmentButtonPressed();*/
    }


    public interface HW2FragmentCallbacks {
        void onNewActivityButtonPressed();

        void onStackActivityButtonPressed();

        void onStackFragmentButtonPressed();
    }
}