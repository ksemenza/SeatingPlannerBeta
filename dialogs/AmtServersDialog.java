package com.guinproductions.seatingplanner.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.activities.AmtSetupActivity;
import com.guinproductions.seatingplanner.activities.MainActivity;
import com.guinproductions.seatingplanner.fragments.CarouselFragment;

public class AmtServersDialog extends DialogFragment {

    public static final String TAG = "AmtServersDialog";
    Context mContext;
    ArrayAdapter spinnerAdapter;
    Intent intentAmtSm, intentAmtBg;
    private CarouselFragment carouselFragment;
    private AmtSetupActivity amtSetupActivity;

    public AmtServersDialog() {

    }

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        final MainActivity activity = (MainActivity) getActivity();


        final View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_setup_server_amt, null);
        final Spinner spinSmAmt = dialogView.findViewById(R.id.dialogSmRmAmtSpinner);
        final Spinner spinBgAmt = dialogView.findViewById(R.id.dialogBgRmAmtSpinner);

        spinnerAdapter = ArrayAdapter.createFromResource(getContext(), R.array.amt_spinner, R.layout.item_amt_spinner);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinSmAmt.setAdapter(spinnerAdapter);
        spinBgAmt.setAdapter(spinnerAdapter);

        spinSmAmt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                position = spinSmAmt.getSelectedItemPosition();
                switch (position) {
                    case (0):

                        intentAmtSm = new Intent(getContext(), AmtSetupActivity.class);

                        break;

                    case (1):
                        intentAmtSm = new Intent(getContext(), AmtSetupActivity.class);
                        break;
                    case (2):
                        intentAmtSm = new Intent(getContext(), AmtSetupActivity.class);

                        break;
                    case (3):

                    case (4):

                        break;

                    case (5):

                        break;

                    case (6):

                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Toast.makeText(activity, getResources().getText(R.string.toast_no_spinner_amt_value)
                        , Toast.LENGTH_LONG).show();
            }
        });

        Dialog dialog = new AlertDialog.Builder(getActivity()).setView(dialogView)
                .setTitle(getString(R.string.dialog_amt_title))
                .setPositiveButton(getResources().getText(R.string.dialog_amt_pos_btn),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                spinSmAmt.getSelectedItemPosition();

                                if (spinSmAmt == null) {

                                    Toast.makeText(getActivity(), "You Select One", Toast.LENGTH_LONG).show();
                                } else {

                                    spinSmAmt.getSelectedItem();
                                    startActivity(intentAmtSm);

                                }

                            }
                        })

                .setNegativeButton(getResources().getText(R.string.dialog_amt_neg_btn), null).create();

        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        return dialog;
    }
/**
 AmtSmFrag1 amtSmFrag1 = new AmtSmFrag1();
 LayoutInflater fragmentView = amtSmFrag1.getLayoutInflater();
 final ViewGroup container = (ViewGroup) amtSmFrag1.getView();
 amtSmFrag1.getFragmentManager();

 final View rootView = fragmentView.inflate(R.layout.fragment_amt_sm_1, container);

 AmtSetupActivity amtSetupActivity = new AmtSetupActivity();
 amtSetupActivity.getSupportFragmentManager();

 if (savedInstanceState == null) {

 // withholding the previously created fragment from being created again
 // On orientation change, it will prevent fragment recreation
 // its necessary to reserve the fragment stack inside each tab
 initScreen();

 } else {
 // restoring the previously created fragment
 // and getting the reference
 carouselFragment = (CarouselFragment) amtSetupActivity.getSupportFragmentManager().getFragments().get(0);
 }
 private void enterSmAmt1() {

 AmtSmFrag1 amtSmFrag1 = new AmtSmFrag1();
 FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

 // Store the Fragment in stack
 transaction.addToBackStack(null);
 transaction.replace(R.id.fragment_mainLayout, amtSmFrag1).commit();
 }

 private void enterSmAmt2() {
 AmtSmFrag1 amtSmFrag2 = new AmtSmFrag1();
 FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

 // Store the Fragment in stack
 transaction.addToBackStack(null);
 transaction.replace(R.id.fragment_mainLayout, amtSmFrag2).commit();
 }

 private void initScreen() {
 // Creating the ViewPager container fragment once
 carouselFragment = new CarouselFragment();

 final FragmentManager fragmentManager = amtSetupActivity.getSupportFragmentManager();
 fragmentManager.beginTransaction()
 .replace(R.id.container, carouselFragment)
 .commit();
 }

 */

}

