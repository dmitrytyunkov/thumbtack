package com.example.dmitry.hws_android_school.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.events.OpenFragment1Event;
import com.example.dmitry.hws_android_school.events.OpenFragment2Event;
import com.example.dmitry.hws_android_school.events.OpenFragment3Event;
import com.example.dmitry.hws_android_school.events.OpenFrameLayoutFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenGridLayoutFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenHW2MenuFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenHW3MenuFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenHW4MainActivityEvent;
import com.example.dmitry.hws_android_school.events.OpenHW7MenuFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenLinearLayoutFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenNewActivityEvent;
import com.example.dmitry.hws_android_school.events.OpenPhoneBookFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenRandomGeneratorFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenRelativeLayoutFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenSaveInFileFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenSaveInSharedPreferencesFragmentEvent;
import com.example.dmitry.hws_android_school.events.OpenStackActivityEvent;
import com.example.dmitry.hws_android_school.events.OpenStackFragmentEvent;
import com.example.dmitry.hws_android_school.ui.base.BaseActivity;
import com.example.dmitry.hws_android_school.ui.hw1_random_generator.RandomGeneratorFragment;
import com.example.dmitry.hws_android_school.ui.hw2_menu.HW2MenuFragment;
import com.example.dmitry.hws_android_school.ui.hw2_new_activity.NewActivity;
import com.example.dmitry.hws_android_school.ui.hw2_stack_activity.Stack1Activity;
import com.example.dmitry.hws_android_school.ui.hw2_stack_fragment.Stack1Fragment;
import com.example.dmitry.hws_android_school.ui.hw2_stack_fragment.Stack2Fragment;
import com.example.dmitry.hws_android_school.ui.hw2_stack_fragment.Stack3Fragment;
import com.example.dmitry.hws_android_school.ui.hw3_fragments_layout.FrameLayoutFragment;
import com.example.dmitry.hws_android_school.ui.hw3_fragments_layout.GridLayoutFragment;
import com.example.dmitry.hws_android_school.ui.hw3_fragments_layout.LinearLayoutFragment;
import com.example.dmitry.hws_android_school.ui.hw3_fragments_layout.RelativeLayoutFragment;
import com.example.dmitry.hws_android_school.ui.hw3_menu.HW3MenuFragment;
import com.example.dmitry.hws_android_school.ui.hw4.HW4MainActivity;
import com.example.dmitry.hws_android_school.ui.hw7_menu.HW7MenuFragment;
import com.example.dmitry.hws_android_school.ui.hw7_phone_book.PhoneBookFragment;
import com.example.dmitry.hws_android_school.ui.hw7_save_text.SaveInFileFragment;
import com.example.dmitry.hws_android_school.ui.hw7_save_text.SaveInSharedPreferencesFragment;
import com.squareup.otto.Subscribe;

public class MainActivity extends BaseActivity implements MainMenuFragment.MainMenuFragmentCallbacks, HW2MenuFragment.HW2FragmentCallbacks {

    public static final String FRAGMENT1 = "FRAGMENT1";
    public static final String FRAGMENT2 = "FRAGMENT2";
    public static final String FRAGMENT3 = "FRAGMENT3";


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = getIntent();

        if (intent.getAction().equals(Intent.ACTION_VIEW)) {

        }

        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MainMenuFragment()).commit();
    }


    @Subscribe
    public void onOpenRandomGeneratorFragmentEvent(OpenRandomGeneratorFragmentEvent event) {
        replaceFragment(new RandomGeneratorFragment(), true);
    }

    @Subscribe
    public void onOpenHW2MenuFragmentEvent(OpenHW2MenuFragmentEvent event) {
        replaceFragment(new HW2MenuFragment(), true);
    }

    @Subscribe
    public void onOpenNewActivityEvent(OpenNewActivityEvent event) {
        startActivity(new Intent(this, NewActivity.class));
    }

    @Subscribe
    public void onOpenStackActivityEvent(OpenStackActivityEvent event) {
        startActivity(new Intent(this, Stack1Activity.class));
    }

    @Subscribe
    public void onOpenStackFragmentEvent(OpenStackFragmentEvent event) {
        replaceFragment(new Stack1Fragment(), true, FRAGMENT1);
    }

    @Subscribe
    public void onOpenFragment1Event(OpenFragment1Event event) {
        returnToBackStack(FRAGMENT1, false);
    }

    @Subscribe
    public void onOpenFragment2Event(OpenFragment2Event event) {
        if (!returnToBackStack(FRAGMENT2, false))
            replaceFragment(new Stack2Fragment(), true, FRAGMENT2);
    }

    @Subscribe
    public void onOpenFragment3Event(OpenFragment3Event event) {
        if (!returnToBackStack(FRAGMENT3, false))
            replaceFragment(new Stack3Fragment(), true, FRAGMENT3);
    }

    @Subscribe
    public void onOpenHW3MenuFragmentEvent(OpenHW3MenuFragmentEvent event) {
        replaceFragment(new HW3MenuFragment(), true);
    }

    @Subscribe
    public void onOpenLinearLayoutFragmentEvent(OpenLinearLayoutFragmentEvent event) {
        replaceFragment(new LinearLayoutFragment(), true);
    }

    @Subscribe
    public void onOpenRelativeLayoutFragmentEvent(OpenRelativeLayoutFragmentEvent event) {
        replaceFragment(new RelativeLayoutFragment(), true);
    }

    @Subscribe
    public void onOpenFrameLayoutFragmentEvent(OpenFrameLayoutFragmentEvent event) {
        replaceFragment(new FrameLayoutFragment(), true);
    }

    @Subscribe
    public void onOpenGridLayoutFragmentEvent(OpenGridLayoutFragmentEvent event) {
        replaceFragment(new GridLayoutFragment(), true);
    }

    @Subscribe
    public void onOpenHW4MainActivityEvent(OpenHW4MainActivityEvent event) {
        startActivity(new Intent(this, HW4MainActivity.class));
    }

    @Subscribe
    public void onOpenHW7FragmentEvent(OpenHW7MenuFragmentEvent event) {
        replaceFragment(new HW7MenuFragment(), true);
    }

    @Subscribe
    public void onOpenSaveInSharedPreferencesFragmentEvent(OpenSaveInSharedPreferencesFragmentEvent event) {
        replaceFragment(new SaveInSharedPreferencesFragment(), true);
    }

    @Subscribe
    public void onOpenSaveInFileFragmentEvent(OpenSaveInFileFragmentEvent event) {
        replaceFragment(new SaveInFileFragment(), true);
    }

    @Subscribe
    public void onOpenPhoneBookFragmentEvent(OpenPhoneBookFragmentEvent event) {
        replaceFragment(new PhoneBookFragment(), true);
    }


    @Override
    public void onHW1ButtonPressed() {
        replaceFragment(new RandomGeneratorFragment(), true);
    }

    @Override
    public void onHW2MenuButtonPressed() {
        replaceFragment(new HW2MenuFragment(), true);
    }

    @Override
    public void onNewActivityButtonPressed() {
        startActivity(new Intent(this, NewActivity.class));
    }

    @Override
    public void onStackActivityButtonPressed() {
        startActivity(new Intent(this, Stack1Activity.class));
    }

    @Override
    public void onStackFragmentButtonPressed() {
        replaceFragment(new Stack1Fragment(), true);
    }
}
