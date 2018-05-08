package com.guinproductions.seatingplanner.fragments;

import android.support.v4.app.Fragment;

import com.guinproductions.seatingplanner.activities.BackPressImpl;
import com.guinproductions.seatingplanner.utils.OnBackPressListener;

public class RootFragment extends Fragment implements OnBackPressListener {

    @Override
    public boolean onBackPressed() {
        return new BackPressImpl(this).onBackPressed();
    }
}
