package com.guinproductions.seatingplanner.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.database.DbPresenter;
import com.guinproductions.seatingplanner.database.DbView;

import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Name.TABLE_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.ROOM;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SECTION_LETTER;


public class AmtBgFrag5 extends RootFragment {

    Spinner spinnerA, spinnerB, spinnerC, spinnerD, spinnerE;
    TextView tvSecA, tvSecB, tvSecC, tvSecD, tvSecE,
            tvBgRm, tvSmRm;

    public AmtBgFrag5() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_amt_bg_5, container, false);


        tvSmRm = rootView.findViewById(R.id.itemRoomTV);

        spinnerA = rootView.findViewById(R.id.name_bg_a_spinner);
        spinnerB = rootView.findViewById(R.id.name_bg_b_spinner);
        spinnerC = rootView.findViewById(R.id.name_bg_c_spinner);
        spinnerD = rootView.findViewById(R.id.name_bg_d_spinner);
        spinnerE = rootView.findViewById(R.id.name_bg_e_spinner);


        tvSecA = rootView.findViewById(R.id.sec_sm_a_title_tv);
        tvSecB = rootView.findViewById(R.id.sec_sm_b_title_tv);
        tvSecC = rootView.findViewById(R.id.sec_sm_c_title_tv);
        tvSecD = rootView.findViewById(R.id.sec_sm_d_title_tv);
        tvSecE = rootView.findViewById(R.id.sec_sm_e_title_tv);


        loadNameList();

        rootView.findViewById(R.id.nextFragBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment();
            }
        });

        return rootView;
    }

    public void loadNameList() {

        String[] queryCols = new String[]{"_id", SERVER_NAME};
        String[] adapterCols = new String[]{SERVER_NAME};
        int[] adapterRowViews = new int[]{android.R.id.text1};

        SQLiteDatabase database = new DbView(getContext()).getReadableDatabase();
        Cursor cursor = database.query(
                TABLE_NAME,     // The table to query
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

        spinnerA.setAdapter(cursorAdapter);
        spinnerB.setAdapter(cursorAdapter);
        spinnerC.setAdapter(cursorAdapter);
        spinnerD.setAdapter(cursorAdapter);
        spinnerE.setAdapter(cursorAdapter);

    }

    private void saveToDB() {
        SQLiteDatabase database = new DbView(getContext()).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SECTION_LETTER, tvSecA.getText().toString());
        values.put(SECTION_LETTER, tvSecB.getText().toString());
        values.put(SECTION_LETTER, tvSecC.getText().toString());
        values.put(SECTION_LETTER, tvSecD.getText().toString());
        values.put(SECTION_LETTER, tvSecE.getText().toString());

        values.put(ROOM, tvSmRm.getText().toString());
        values.put(ROOM, tvBgRm.getText().toString());

        ((Cursor) spinnerA.getSelectedItem()).getInt(0);
        ((Cursor) spinnerB.getSelectedItem()).getInt(0);
        ((Cursor) spinnerC.getSelectedItem()).getInt(0);
        ((Cursor) spinnerE.getSelectedItem()).getInt(0);


        Log.d("getINT", ((Cursor) spinnerA.getSelectedItem()).getInt(0) + "");
        Log.d("getColumnName", ((Cursor) spinnerA.getSelectedItem()).getColumnName(0));

        long newRowId = database.insert(DbPresenter.Section.TABLE_NAME, null, values);

//        Toast.makeText(getContext(), "The new Row Id is " + newRowId, Toast.LENGTH_LONG).show();
    }


    private void enterNextFragment() {
        AmtBgFragSetup amtBgFragSetup = new AmtBgFragSetup();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtBgFragSetup).commit();
    }
}
