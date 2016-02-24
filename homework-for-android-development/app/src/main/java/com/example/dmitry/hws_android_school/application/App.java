package com.example.dmitry.hws_android_school.application;

import android.app.Application;

import com.squareup.otto.Bus;

/**
 * Created by dmitry on 24.02.16.
 */
public class App extends Application {

    private Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        bus = new Bus();
    }


    public Bus getBus() {
        return bus;
    }

}
