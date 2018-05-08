package com.guinproductions.seatingplanner.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.guinproductions.seatingplanner.R;


/**
 * Created by guinp on 4/6/2018.
 */

public class MainRmSmFragment extends Fragment implements View.OnClickListener {

    private ToggleButton toggleSmA;
    private ToggleButton toggleSmB;
    private ToggleButton toggleSmC;

    private ToggleButton toggle1, toggle2, toggle3, toggle4, toggle5, toggle6, toggle7, toggle8,
            toggle9, toggle10, toggle11, toggle12, toggle13, toggle14, toggle15, toggle16, toggle17, toggle18;

    public TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10,
            tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18;

    private MainRmSmFragment.OnFragmentInteractionListener mListener;

    private String tableNumber, gvTableSmRm;

    public MainRmSmFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_rm_sm3, container, false);

        tv1 = view.findViewById(R.id.table1);
        tv2 = view.findViewById(R.id.table2);
        tv3 = view.findViewById(R.id.table3);
        tv4 = view.findViewById(R.id.table4);

        /**
         tvBg26 = view.findViewById(R.id.mainTable26TV);
         tvBg27 = view.findViewById(R.id.mainTable27TV);
         tvBg31 = view.findViewById(R.id.mainTable31TV);
         tvBg32 = view.findViewById(R.id.mainTable32TV);
         tvBg33 = view.findViewById(R.id.mainTable33TV);
         tvBg35 = view.findViewById(R.id.mainTable35TV);
         tvBg41 = view.findViewById(R.id.mainTable41TV);
         tvBg42 = view.findViewById(R.id.mainTable42TV);
         tvBg43 = view.findViewById(R.id.mainTable43TV);

         */
        /**Entrance --> Window Tables**/
        toggle1 = view.findViewById(R.id.table1);
        toggle2 = view.findViewById(R.id.table2);
        toggle3 = view.findViewById(R.id.table3);
        /**Window --> Tables**/
        toggle4 = view.findViewById(R.id.table4);
        toggle5 = view.findViewById(R.id.table5);
        toggle6 = view.findViewById(R.id.table6);
        /**Start of Window Side Booths**/
        toggle7 = view.findViewById(R.id.table7);
        toggle8 = view.findViewById(R.id.table8);
        toggle9 = view.findViewById(R.id.table9);
        /**Window Booths**/
        toggle10 = view.findViewById(R.id.table10);
        toggle11 = view.findViewById(R.id.table11);
        toggle12 = view.findViewById(R.id.table12);
        toggle13 = view.findViewById(R.id.table13);
        /**Horse Shoe Booth**/
        toggle14 = view.findViewById(R.id.table14);
        /**Kitchen Side HS --> Entrance Booths**/
        toggle15 = view.findViewById(R.id.table15);
        toggle16 = view.findViewById(R.id.table16);
        toggle17 = view.findViewById(R.id.table17);
        toggle18 = view.findViewById(R.id.table18);


        toggle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tv1.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    mListener.onFragmentInteraction(gvTableSmRm);
                    tv1.setText(R.string.set_text_1);
                    /** Snackbar for 1 filled */
                    Snackbar.make(v, "1 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tv1.setText(R.string.set_text_1);
                    /** Snackbar for 1 empty */
                    Snackbar.make(v, "1 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        toggle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tv2.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tv2.setText(R.string.set_text_2);
                    /** Snackbar for 2 filled */
                    Snackbar.make(v, getId(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tv2.setText(R.string.set_text_2);
                    /** Snackbar for 23 empty */
                    Snackbar.make(v, "2 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainRmSmFragment.OnFragmentInteractionListener) {
            mListener = (MainRmSmFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        boolean on = ((ToggleButton) v).isChecked();

        tableNumber = tv1.getText().toString().trim();
        tableNumber = tv2.getText().toString().trim();

        if (on) {
            /** Passing onClick Data between Fragments */
            tv1.setText(R.string.set_text_1);
            tv2.setText(R.string.set_text_2);

        } else {
            tv1.setText(R.string.set_text_1);
            tv2.setText(R.string.set_text_2);
        }
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String sectionLetter);
    }

}
