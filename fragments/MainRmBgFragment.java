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

import java.util.List;

/**
 * Created by guinp on 4/6/2018.
 */

public class MainRmBgFragment extends Fragment {

    Context mContext;
    List<String> arrayListBgRmTableNum;
    List<String> arrayListSmRmTableNum;

    String tableNumber, gvTableBgRm;

    public TextView tvBg22, tvBg23, tvBg24, tvBg25, tvBg26, tvBg27, tvBg31, tvBg32, tvBg33, tvBg35,
            tvBg41, tvBg42, tvBg43, tvBg44, tvBg47, tvBg48, tvBg49, tvBg50, tvBg51, tvBg52, tvBg53,
            tvBg54, tvBg55, tvBg56;

    public ToggleButton toggleBg22, toggleBg23, toggleBg24, toggleBg25, toggleBg26, toggleBg27,
            toggleBg31, toggleBg32, toggleBg33, toggleBg35, toggleBg41, toggleBg42, toggleBg43,
            toggleBg44, toggleBg47, toggleBg48, toggleBg49, toggleBg50, toggleBg51, toggleBg52,
            toggleBg53, toggleBg54, toggleBg55, toggleBg56;

    private OnFragmentInteractionListener mListener;

    public MainRmBgFragment() {

    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = inflater.getContext();
        return inflater.inflate(R.layout.frag_rm_bg3, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        tvBg22 = view.findViewById(R.id.mainTable22TV);
        tvBg23 = view.findViewById(R.id.mainTable23TV);
        tvBg24 = view.findViewById(R.id.mainTable24TV);
        tvBg25 = view.findViewById(R.id.mainTable25TV);
        tvBg26 = view.findViewById(R.id.mainTable26TV);
        tvBg27 = view.findViewById(R.id.mainTable27TV);
        tvBg31 = view.findViewById(R.id.mainTable31TV);
        tvBg32 = view.findViewById(R.id.mainTable32TV);
        tvBg33 = view.findViewById(R.id.mainTable33TV);
        tvBg35 = view.findViewById(R.id.mainTable35TV);
        tvBg41 = view.findViewById(R.id.mainTable41TV);
        tvBg42 = view.findViewById(R.id.mainTable42TV);
        tvBg43 = view.findViewById(R.id.mainTable43TV);
        tvBg44 = view.findViewById(R.id.mainTable44TV);
        tvBg50 = view.findViewById(R.id.mainTable50TV);
        tvBg51 = view.findViewById(R.id.mainTable51TV);
        tvBg52 = view.findViewById(R.id.mainTable52TV);
        tvBg53 = view.findViewById(R.id.mainTable53TV);
        tvBg54 = view.findViewById(R.id.mainTable54TV);
        tvBg55 = view.findViewById(R.id.mainTable55TV);
        tvBg56 = view.findViewById(R.id.mainTable56TV);


        /**Sm Booths Hallway**/
        toggleBg22 = view.findViewById(R.id.table22);
        toggleBg23 = view.findViewById(R.id.table23);
        toggleBg24 = view.findViewById(R.id.table24);
        /**Reg Booths**/
        toggleBg25 = view.findViewById(R.id.table25);
        toggleBg26 = view.findViewById(R.id.table26);
        toggleBg27 = view.findViewById(R.id.table27);
        toggleBg35 = view.findViewById(R.id.table35);
        /**Horse Shoe Booth**/
        toggleBg44 = view.findViewById(R.id.table44);
        /** Round Tables**/
        toggleBg31 = view.findViewById(R.id.table31);
        toggleBg32 = view.findViewById(R.id.table32);
        toggleBg33 = view.findViewById(R.id.table33);
        /**Buffet Rm Wall Tables**/
        toggleBg41 = view.findViewById(R.id.table41);
        toggleBg42 = view.findViewById(R.id.table42);
        toggleBg43 = view.findViewById(R.id.table43);
        /**Bar Side Tables**/
        toggleBg47 = view.findViewById(R.id.table47);
        toggleBg48 = view.findViewById(R.id.table48);
        toggleBg49 = view.findViewById(R.id.table49);
        toggleBg50 = view.findViewById(R.id.table50);
        toggleBg51 = view.findViewById(R.id.table51);
        /**Bar Wall Side Tables**/
        toggleBg52 = view.findViewById(R.id.table52);
        toggleBg53 = view.findViewById(R.id.table53);
        toggleBg54 = view.findViewById(R.id.table54);
        toggleBg55 = view.findViewById(R.id.table55);
        /**Bar Side Booth**/
        toggleBg56 = view.findViewById(R.id.table56);


        /** TOGGLE 22 OnClickListener  */
        toggleBg22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg22.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    mListener.onFragmentInteraction(gvTableBgRm);
                    tvBg22.setText(R.string.set_text_22);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "22 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg22.setText(R.string.unset_text_22);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "22 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 23 OnClickListener */
        toggleBg23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg23.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg23.setText(R.string.set_text_23);
                    /** Snackbar for 23 filled */
                    Snackbar.make(v, "23 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg23.setText(R.string.set_text_23);
                    /** Snackbar for 23 empty */
                    Snackbar.make(v, "23 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 24 OnClickListener  */
        toggleBg24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg24.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg24.setText(R.string.set_text_24);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "24 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg24.setText(R.string.set_text_24);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "24 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        /** TOGGLE 25 OnClickListener  */
        toggleBg25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg25.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg25.setText(R.string.set_text_25);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "25 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg25.setText(R.string.set_text_25);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "25 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        /** TOGGLE 26 OnClickListener  */
        toggleBg26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg26.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg26.setText(R.string.set_text_26);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "26 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg26.setText(R.string.set_text_26);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "26 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        /** TOGGLE 27 OnClickListener  */
        toggleBg27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg27.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg27.setText(R.string.set_text_27);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "27 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg27.setText(R.string.set_text_27);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "27 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 31 OnClickListener  */
        toggleBg31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg31.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg31.setText(R.string.set_text_31);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "31 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg31.setText(R.string.set_text_31);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "31 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        /** TOGGLE 32 OnClickListener  */
        toggleBg32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg32.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg32.setText(R.string.set_text_32);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "32 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg32.setText(R.string.set_text_32);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "32 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 33 OnClickListener  */
        toggleBg33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg33.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg33.setText(R.string.set_text_33);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "33 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg33.setText(R.string.set_text_33);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "33 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 35 OnClickListener  */
        toggleBg35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg35.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg35.setText(R.string.set_text_35);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "35 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg35.setText(R.string.set_text_35);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "35 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 41 OnClickListener  */
        toggleBg41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg41.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg41.setText(R.string.set_text_41);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "41 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg41.setText(R.string.set_text_41);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "41 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 42 OnClickListener  */
        toggleBg42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg42.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg42.setText(R.string.set_text_42);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "42 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg42.setText(R.string.set_text_42);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "42 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 42 OnClickListener  */
        toggleBg42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg42.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg42.setText(R.string.set_text_42);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "42 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg42.setText(R.string.set_text_42);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "42 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 43 OnClickListener  */
        toggleBg43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg43.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg43.setText(R.string.set_text_43);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "43 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg43.setText(R.string.set_text_43);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "43 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 44 OnClickListener  */
        toggleBg44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg44.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg44.setText(R.string.set_text_44);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "44 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg44.setText(R.string.set_text_44);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "44 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 47 OnClickListener  */
        toggleBg47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg47.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg47.setText(R.string.set_text_47);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "47 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg47.setText(R.string.set_text_47);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "47 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 48 OnClickListener  */
        toggleBg48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg48.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg48.setText(R.string.set_text_48);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "48 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg48.setText(R.string.set_text_48);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "48 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 49 OnClickListener  */
        toggleBg49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg49.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg49.setText(R.string.set_text_49);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "49 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg49.setText(R.string.set_text_49);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "49 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 50 OnClickListener  */
        toggleBg50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg50.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg50.setText(R.string.set_text_50);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "50 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg50.setText(R.string.set_text_50);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "50 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 51 OnClickListener  */
        toggleBg51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg51.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg51.setText(R.string.set_text_51);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "51 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg51.setText(R.string.set_text_51);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "51 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 52 OnClickListener  */
        toggleBg52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg52.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg52.setText(R.string.set_text_52);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "52 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg52.setText(R.string.set_text_52);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "52 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 53 OnClickListener  */
        toggleBg53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg53.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg53.setText(R.string.set_text_53);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "53 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg53.setText(R.string.set_text_53);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "53 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 54 OnClickListener  */
        toggleBg54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg54.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg54.setText(R.string.set_text_54);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "54 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg54.setText(R.string.set_text_54);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "54 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 55 OnClickListener  */
        toggleBg55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg55.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg55.setText(R.string.set_text_55);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "55 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg55.setText(R.string.set_text_55);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "55 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        /** TOGGLE 56 OnClickListener  */
        toggleBg56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                tableNumber = tvBg56.getText().toString().trim();

                if (on) {
                    /** Passing onClick Data between Fragments */
                    mListener.onFragmentInteraction(tableNumber);
                    tvBg56.setText(R.string.set_text_56);
                    /** Snackbar for activated toggle */
                    Snackbar.make(v, "56 has been taken", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    /** Conditions on Second press of toggle */
                } else {
                    tvBg56.setText(R.string.set_text_56);
                    /** Snackbar for unactivated toggle*/
                    Snackbar.make(v, "56 is empty", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String sectionLetter);
    }

}
