package com.aearphen.calculatrice.ui.navigator;

import android.support.v4.app.FragmentManager;

import com.aearphen.calculatrice.R;
import com.aearphen.calculatrice.ui.fragment.KeyboardFragment;

/**
 * Created by Aearphen on 26/04/18.
 */
public class HomeNavigator {

    private static final String KEYBOARD_FRAGMENT = "keyboard_fragment";
    private static final String GRAPHE_FRAGMENT = "graphe_fragment";
    private final FragmentManager fragmentManager;
    private String currentFragment;

    public HomeNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void launchKeyboardFragment(int keyboardType) {
        KeyboardFragment fragment = KeyboardFragment.newInstance(keyboardType);
        fragmentManager
                .beginTransaction()
                .replace(R.id.activity_home_coordinator_layout, fragment)
                .commit();
        currentFragment = KEYBOARD_FRAGMENT;
    }

    public interface HomeNavigatorListener {
        void launchKeyboardFragment(int keyboardType);

        void launchGraphFragment();
    }
}
