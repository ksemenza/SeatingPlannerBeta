package com.guinproductions.seatingplanner.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.database.DbPresenter;
import com.guinproductions.seatingplanner.database.DbView;

import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;


public class AmtSmFragSetup extends RootFragment {

    public AmtSmFragSetup() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_amt_sm_setup, container, false);

        rootView.findViewById(R.id.setupServerBgTV);

        rootView.findViewById(R.id.nextFragBtn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment1();
            }
        });

        rootView.findViewById(R.id.nextFragBtn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment2();
            }
        });

        rootView.findViewById(R.id.nextFragBtn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment3();
            }
        });

        rootView.findViewById(R.id.nextFragBtn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment4();
            }
        });

        rootView.findViewById(R.id.nextFragBtn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment5();
            }
        });

        rootView.findViewById(R.id.nextFragBtn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment6();
            }
        });

        return rootView;
    }


    private void enterNextFragment1() {
        AmtSmFrag1 amtSmFrag1 = new AmtSmFrag1();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtSmFrag1).commit();
    }

    private void enterNextFragment2() {
        AmtSmFrag2 amtSmFrag2 = new AmtSmFrag2();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtSmFrag2).commit();
    }

    private void enterNextFragment3() {
        AmtSmFrag3 amtSmFrag3 = new AmtSmFrag3();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtSmFrag3).commit();
    }

    private void enterNextFragment4() {
        AmtSmFrag4 amtSmFrag4 = new AmtSmFrag4();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtSmFrag4).commit();
    }

    private void enterNextFragment5() {
        AmtSmFrag5 amtSmFrag5 = new AmtSmFrag5();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtSmFrag5).commit();
    }

    private void enterNextFragment6() {
        AmtSmFrag6 amtSmFrag6 = new AmtSmFrag6();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtSmFrag6).commit();
    }


    //Loading Spinners
    public void loadNameList() {

        String[] queryCols = new String[]{"_id", SERVER_NAME};
        String[] adapterCols = new String[]{SERVER_NAME};
        int[] adapterRowViews = new int[]{android.R.id.text1};

        SQLiteDatabase database = new DbView(getContext()).getReadableDatabase();
        Cursor cursor = database.query(
                DbPresenter.Name.TABLE_NAME,     // The table to query
                queryCols,                                // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // don't sort
        );

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                getContext(), android.R.layout.simple_spinner_item, cursor, adapterCols, adapterRowViews, 0);
        cursorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// binding.employerSpinner.setAdapter(cursorAdapter);

    }


}
