package com.guinproductions.seatingplanner.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.database.DbView;

import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;

public class AmtSmFrag6 extends RootFragment {

    public AmtSmFrag6() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_amt_sm_6, container, false);

        rootView.findViewById(R.id.nextFragBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment();
            }
        });

        return rootView;
    }

    private void enterNextFragment() {
        AmtSmFragSetup amtSmFragSetup = new AmtSmFragSetup();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtSmFragSetup).commit();
    }


}
