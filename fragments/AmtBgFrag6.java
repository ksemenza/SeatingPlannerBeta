package com.guinproductions.seatingplanner.fragments;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.activities.MainActivity;
import com.guinproductions.seatingplanner.database.DbPresenter;
import com.guinproductions.seatingplanner.database.DbView;

import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.ROOM;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SECTION_LETTER;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SPINNER_NAME_SELECTIONS;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.TABLE_NAME;

public class AmtBgFrag6 extends RootFragment implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    Spinner spinnerA, spinnerB, spinnerC, spinnerD, spinnerE, spinnerF;
    TextView tvSecA, tvSecB, tvSecC, tvSecD, tvSecE, tvSecF,
            tvBgRm, tvSmRm;

    FloatingActionButton fabSetServer;

    public static String SELECTED_SERVER = "server";

    public AmtBgFrag6() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_amt_bg_6, container, false);

        tvSmRm = rootView.findViewById(R.id.itemRoomTV);
        tvBgRm = rootView.findViewById(R.id.itemRoomTV);

        spinnerA = rootView.findViewById(R.id.name_bg_a_spinner);
        spinnerB = rootView.findViewById(R.id.name_bg_b_spinner);
        spinnerC = rootView.findViewById(R.id.name_bg_c_spinner);
        spinnerD = rootView.findViewById(R.id.name_bg_d_spinner);
        spinnerE = rootView.findViewById(R.id.name_bg_e_spinner);
        spinnerF = rootView.findViewById(R.id.name_bg_f_spinner);

        tvSecA = rootView.findViewById(R.id.sec_sm_a_title_tv);
        tvSecB = rootView.findViewById(R.id.sec_sm_b_title_tv);
        tvSecC = rootView.findViewById(R.id.sec_sm_c_title_tv);
        tvSecD = rootView.findViewById(R.id.sec_sm_d_title_tv);
        tvSecE = rootView.findViewById(R.id.sec_sm_e_title_tv);
        tvSecF = rootView.findViewById(R.id.sec_sm_f_title_tv);

        loadNameList();

        rootView.findViewById(R.id.nextFragBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNextFragment();
            }
        });

        return rootView;
    }


    private void enterNextFragment() {
        AmtBgFragSetup amtBgFragSetup = new AmtBgFragSetup();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        // Store the Fragment in stack
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, amtBgFragSetup).commit();
    }

    public void loadNameList() {

        String[] queryCols = new String[]{"_id", SERVER_NAME};
        String[] adapterCols = new String[]{SERVER_NAME};
        int[] adapterRowViews = new int[]{android.R.id.text1};
        spinnerA.setSelection(0);

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

        spinnerA.setAdapter(cursorAdapter);
        spinnerB.setAdapter(cursorAdapter);
        spinnerC.setAdapter(cursorAdapter);
        spinnerD.setAdapter(cursorAdapter);
        spinnerE.setAdapter(cursorAdapter);
        spinnerF.setAdapter(cursorAdapter);
    }

    private void saveToDB() {
        SQLiteDatabase database = new DbView(getContext()).getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(SECTION_LETTER, tvSecA.getText().toString());
        values.put(SECTION_LETTER, tvSecB.getText().toString());
        values.put(SECTION_LETTER, tvSecC.getText().toString());
        values.put(SECTION_LETTER, tvSecD.getText().toString());
        values.put(SECTION_LETTER, tvSecE.getText().toString());
        values.put(SECTION_LETTER, tvSecF.getText().toString());

        values.put(SELECTED_SERVER,
                ((Cursor) spinnerA.getSelectedItem()).getInt(0));
        values.put(SELECTED_SERVER,
                ((Cursor) spinnerB.getSelectedItem()).getInt(0));
        values.put(SELECTED_SERVER,
                ((Cursor) spinnerC.getSelectedItem()).getInt(0));
        values.put(SELECTED_SERVER,
                ((Cursor) spinnerD.getSelectedItem()).getInt(0));
        values.put(SELECTED_SERVER,
                ((Cursor) spinnerE.getSelectedItem()).getInt(0));
        values.put(SELECTED_SERVER,
                ((Cursor) spinnerF.getSelectedItem()).getInt(0));

        Log.d("getINT", ((Cursor) spinnerA.getSelectedItem()).getInt(0) + "");
        Log.d("getColumnName", ((Cursor) spinnerA.getSelectedItem()).getColumnName(0));

        Log.d("getINT", ((Cursor) spinnerB.getSelectedItem()).getInt(0) + "");
        Log.d("getColumnName", ((Cursor) spinnerB.getSelectedItem()).getColumnName(0));

        Log.d("getINT", ((Cursor) spinnerC.getSelectedItem()).getInt(0) + "");
        Log.d("getColumnName", ((Cursor) spinnerC.getSelectedItem()).getColumnName(0));

        Log.d("getINT", ((Cursor) spinnerD.getSelectedItem()).getInt(0) + "");
        Log.d("getColumnName", ((Cursor) spinnerD.getSelectedItem()).getColumnName(0));

        Log.d("getINT", ((Cursor) spinnerE.getSelectedItem()).getInt(0) + "");
        Log.d("getColumnName", ((Cursor) spinnerE.getSelectedItem()).getColumnName(0));

        Log.d("getINT", ((Cursor) spinnerF.getSelectedItem()).getInt(0) + "");
        Log.d("getColumnName", ((Cursor) spinnerF.getSelectedItem()).getColumnName(0));

        values.put(ROOM, tvSmRm.getText().toString());
        values.put(ROOM, tvBgRm.getText().toString());


        Log.d("getINT", ((Cursor) spinnerA.getSelectedItem()).getInt(0) + "");
        Log.d("getColumnName", ((Cursor) spinnerA.getSelectedItem()).getColumnName(0));

        long newRowId = database.insert(TABLE_NAME, null, values);

//        Toast.makeText(getContext(), "The new Row Id is " + newRowId, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        sendSectionDB();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getContext(), SECTION_LETTER + ROOM + SPINNER_NAME_SELECTIONS, Toast.LENGTH_SHORT);


    }

    /**
     * private void sendData(){Intent i = new Intent(getActivity().getBaseContext(),
     * MainActivity.class);
     * <p>
     * i.putExtra(SELECTED_SERVER, Integer.valueOf(spinnerA.getSelectedItem().toString()));
     * }
     */
    private void sendSectionDB() {

        Intent i = new Intent(getActivity().getBaseContext(), MainActivity.class);

        String SEC_A_BG_SET = tvSecA.getText().toString();
        String SEC_B_BG_SET = tvSecB.getText().toString();
        String SEC_C_BG_SET = tvSecC.getText().toString();
        String SEC_D_BG_SET = tvSecD.getText().toString();
        String SEC_E_BG_SET = tvSecE.getText().toString();
        String SEC_F_BG_SET = tvSecF.getText().toString();

        String NAME_A_BG_SET = spinnerA.getSelectedItem().toString();
        String NAME_B_BG_SET = spinnerB.getSelectedItem().toString();
        String NAME_C_BG_SET = spinnerC.getSelectedItem().toString();
        String NAME_D_BG_SET = spinnerD.getSelectedItem().toString();
        String NAME_E_BG_SET = spinnerE.getSelectedItem().toString();
        String NAME_F_BG_SET = spinnerF.getSelectedItem().toString();

        i.putExtra("BG_KEY", "AmtBgFrag6");
        i.putExtra("SEC_A_BG_DATA", SEC_A_BG_SET);
        i.putExtra("SEC_B_BG_DATA", SEC_B_BG_SET);
        i.putExtra("SEC_C_BG_DATA", SEC_C_BG_SET);
        i.putExtra("SEC_D_BG_DATA", SEC_D_BG_SET);
        i.putExtra("SEC_E_BG_DATA", SEC_E_BG_SET);
        i.putExtra("SEC_F_BG_DATA", SEC_F_BG_SET);

        i.putExtra("NAME_A_BG_SPIN", NAME_A_BG_SET);
        i.putExtra("NAME_B_BG_SPIN", NAME_B_BG_SET);
        i.putExtra("NAME_C_BG_SPIN", NAME_C_BG_SET);
        i.putExtra("NAME_D_BG_SPIN", NAME_D_BG_SET);
        i.putExtra("NAME_E_BG_SPIN", NAME_E_BG_SET);
        i.putExtra("NAME_F_BG_SPIN", NAME_F_BG_SET);

        String roomSize = tvBgRm.getText().toString();

        SQLiteDatabase database = new DbView(getContext()).getReadableDatabase();
        String[] selectionArgs = {"%" + roomSize + "%" + SEC_A_BG_SET + SEC_B_BG_SET + SEC_C_BG_SET + SEC_D_BG_SET + SEC_E_BG_SET + SEC_F_BG_SET + "%" + "%" + NAME_A_BG_SET + NAME_B_BG_SET + NAME_C_BG_SET + NAME_D_BG_SET + NAME_E_BG_SET + NAME_F_BG_SET + "%"};
    }
}
