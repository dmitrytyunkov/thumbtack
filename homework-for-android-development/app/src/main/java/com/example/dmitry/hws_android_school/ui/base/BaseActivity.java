package com.example.dmitry.hws_android_school.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.application.App;
import com.squareup.otto.Bus;

/**
 * Created by dmitry on 24.02.16.
 */
public class BaseActivity extends AppCompatActivity {


    private Bus bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = ((App) getApplication()).getBus();
    }


    @Override
    protected void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        bus.unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // TODO: 10/02/16 Не нужно вызывать эти методы напрямую из фрагментов, используйте коллбэки или шину
    public void replaceFragment(Fragment fragment) {
        replaceFragment(fragment, true, null);
    }

    // TODO: 10/02/16 Не нужно вызывать эти методы напрямую из фрагментов, используйте коллбэки или шину
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        replaceFragment(fragment, addToBackStack, null);
    }

    // TODO: 10/02/16 Не нужно вызывать эти методы напрямую из фрагментов, используйте коллбэки или шину
    public void replaceFragment(Fragment fragment, boolean addToBackStack, @Nullable String key) {
        FragmentTransaction replaceTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment);

        if (addToBackStack)
            replaceTransaction
                    .addToBackStack(key);

        replaceTransaction
                .commit();
    }

    // TODO: 10/02/16 Не нужно вызывать эти методы напрямую из фрагментов, используйте коллбэки или шину
    public void returnToBackStack(String stackKey, boolean inclusive) {
        //FragmentManager.POP_BACK_STACK_INCLUSIVE (1) - вытолкнуть из стэка и закрыть не только фрагменты выше
        //добавленного по ключу, но и сам фрагмент, добавленный по ключу
        //0 - вытолкнуть и закрыть только те, что выше
        getSupportFragmentManager()
                .popBackStackImmediate(stackKey, inclusive ? FragmentManager.POP_BACK_STACK_INCLUSIVE : 0);
    }

    public Bus getBus() {
        return bus;
    }
}
