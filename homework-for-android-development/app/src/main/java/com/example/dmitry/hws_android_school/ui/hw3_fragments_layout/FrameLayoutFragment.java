package com.example.dmitry.hws_android_school.ui.hw3_fragments_layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FrameLayoutFragment extends BaseFragment {

    @Bind(R.id.hw3_image_view)
    ImageView imageView;
    @Bind(R.id.next_button)
    ImageButton nextButton;
    int[] ids = {R.drawable.volkswagen_png1773, R.drawable.volkswagen_png1774, R.drawable.volkswagen_png1775};
    private int count = 0;


    public FrameLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frame_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.next_button)
    public void onNextButtonClick() {
        //todo REVU you might want to use array for ids:         imageView.setImageResource(ids[imgCounter++]%ids.length);
        imageView.setImageResource(ids[++count % ids.length]);
    }
}