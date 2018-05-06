package com.guinproductions.seatingplanner.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guinproductions.seatingplanner.R;

public class AmtBgFragSetup extends RootFragment {

    public AmtBgFragSetup() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_amt_bg_setup, container, false);

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
        AmtBgFrag1 amtBgFrag1 = new AmtBgFrag1();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtBgFrag1).commit();
    }

    private void enterNextFragment2() {
        AmtBgFrag2 amtBgFrag2 = new AmtBgFrag2();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtBgFrag2).commit();
    }

    private void enterNextFragment3() {
        AmtBgFrag3 amtBgFrag3 = new AmtBgFrag3();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtBgFrag3).commit();
    }

    private void enterNextFragment4() {
        AmtBgFrag4 amtBgFrag4 = new AmtBgFrag4();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtBgFrag4).commit();
    }

    private void enterNextFragment5() {
        AmtBgFrag5 amtBgFrag5 = new AmtBgFrag5();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtBgFrag5).commit();
    }

    private void enterNextFragment6() {
        AmtBgFrag6 amtBgFrag6 = new AmtBgFrag6();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtBgFrag6).commit();
    }
/**
 private void saveToDB() {
 SQLiteDatabase database = new DbView(getContext()).getWritableDatabase();
 ContentValues values = new ContentValues();
 values.put(SECTION_LETTER, tvSecA.getText().toString());
 values.put(SECTION_LETTER, tvSecB.getText().toString());
 values.put(SECTION_LETTER, tvSecC.getText().toString());
 values.put(SECTION_LETTER, tvSecD.getText().toString());
 values.put(SECTION_LETTER, tvSecE.getText().toString());
 values.put(SECTION_LETTER, tvSecF.getText().toString());
 values.put(ROOM, tvSmRm.getText().toString());
 values.put(ROOM, tvBgRm.getText().toString());
 ((Cursor)spinnerA.getSelectedItem()).getInt(0);
 ((Cursor)spinnerB.getSelectedItem()).getInt(0);
 ((Cursor)spinnerC.getSelectedItem()).getInt(0);
 ((Cursor)spinnerE.getSelectedItem()).getInt(0);
 ((Cursor)spinnerF.getSelectedItem()).getInt(0);

 Log.d("getINT", ((Cursor)spinnerA.getSelectedItem()).getInt(0) + "");
 Log.d("getColumnName", ((Cursor)spinnerA.getSelectedItem()).getColumnName(0));

 long newRowId = database.insert(DbPresenter.Section.TABLE_NAME, null, values);

 //        Toast.makeText(getContext(), "The new Row Id is " + newRowId, Toast.LENGTH_LONG).show();
 }
 */
}


