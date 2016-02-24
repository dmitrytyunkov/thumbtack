package com.example.dmitry.hws_android_school.ui.dashboard;

import android.os.Bundle;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.events.OpenHW2FragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenRandomGeneratorFragmentEvent;
import com.example.dmitry.hws_android_school.ui.base.BaseActivity;
import com.example.dmitry.hws_android_school.ui.hw2.HW2Fragment;
import com.example.dmitry.hws_android_school.ui.random_generator.RandomGeneratorFragment;
import com.squareup.otto.Subscribe;

public class MainActivity extends BaseActivity implements MainMenuFragment.MainFragmentCallbacks {


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MainMenuFragment()).commit();
    }


    @Subscribe
    public void onOpenRandomGeneratorFragmentEvent(OpenRandomGeneratorFragmentEvent event) {
        replaceFragment(new RandomGeneratorFragment(), true);
    }

    @Subscribe
    public void onOpenHW2FragmentEvent(OpenHW2FragmentEvent event) {
        replaceFragment(new HW2Fragment(), true);
    }


    @Override
    public void onHW1ButtonPressed() {
        replaceFragment(new RandomGeneratorFragment(), true);
    }

    @Override
    public void onHW2ButtonPressed() {
        replaceFragment(new HW2Fragment(), true);
    }
}
