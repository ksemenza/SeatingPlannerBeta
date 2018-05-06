package com.guinproductions.seatingplanner.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.fragments.CarouselFragment;

public class AmtSetupActivity extends AppCompatActivity {

    private CarouselFragment carouselFragment;
    private FloatingActionButton fabServerSetup;
    public String NAME_A_BG, NAME_B_BG, NAME_C_BG, NAME_D_BG, NAME_E_BG, NAME_F_BG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amt_setup);

//        setSupportActionBar(toolbar);


        fabServerSetup = (FloatingActionButton) findViewById(R.id.serverSetupFAB);
        fabServerSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendDataToMainActivity();

                Snackbar.make(view, "Implement Names to Main Activity", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });


        //Beginning of Dynamic Fragment Implementation
        if (savedInstanceState == null) {

            // withholding the previously created fragment from being created again
            // On orientation change, it will prevent fragment recreation
            // its necessary to reserve the fragment stack inside each tab
            initScreen();

        } else {
            // restoring the previously created fragment
            // and getting the reference
            carouselFragment = (CarouselFragment) getSupportFragmentManager().getFragments().get(0);
        }
    }

    private void initScreen() {
        // Creating the ViewPager container fragment once
        carouselFragment = new CarouselFragment();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, carouselFragment)
                .commit();
    }

    /**
     * Only Activity has this special callback method
     * Fragment doesn't have any onBackPressed callback
     * <p>
     * Logic:
     * Each time when the back button is pressed, this Activity will propagate the call to the
     * container Fragment and that Fragment will propagate the call to its each tab Fragment
     * those Fragments will propagate this method call to their child Fragments and
     * eventually all the propagated calls will get back to this initial method
     * <p>
     * If the container Fragment or any of its Tab Fragments and/or Tab child Fragments couldn't
     * handle the onBackPressed propagated call then this Activity will handle the callback itself
     */

    @Override
    public void onBackPressed() {

        if (!carouselFragment.onBackPressed()) {
            // container Fragment or its associates couldn't handle the back pressed task
            // delegating the task to super class
            super.onBackPressed();

        } else {
            // carousel handled the back pressed task
            // do not call super
        }
    }

    /**
     * @Override protected void onResume() {
     * super.onResume();
     * <p>
     * final String sender = this.getIntent().getExtras().getString("BG_KEY");
     * <p>
     * if (sender != null) {
     * this.receiveData();
     * Toast.makeText(this, "Received", Toast.LENGTH_SHORT).show();
     * <p>
     * }
     * <p>
     * }
     */

    private void receiveData() {

        Intent i = getIntent();
        String secBgA = i.getStringExtra("SEC_A_BG_DATA");
        String secBgB = i.getStringExtra("SEC_B_BG_DATA");
        String secBgC = i.getStringExtra("SEC_C_BG_DATA");
        String secBgD = i.getStringExtra("SEC_D_BG_DATA");
        String secBgE = i.getStringExtra("SEC_E_BG_DATA");
        String secBgF = i.getStringExtra("SEC_F_BG_DATA");

        NAME_A_BG = i.getStringExtra("NAME_A_BG_SPIN");
        NAME_B_BG = i.getStringExtra("NAME_B_BG_SPIN");
        NAME_C_BG = i.getStringExtra("NAME_C_BG_SPIN");
        NAME_D_BG = i.getStringExtra("NAME_D_BG_SPIN");
        NAME_E_BG = i.getStringExtra("NAME_E_BG_SPIN");
        NAME_F_BG = i.getStringExtra("NAME_F_BG_SPIN");
    }

    private void sendDataToMainActivity() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("NAME_A_BG_SPIN", NAME_A_BG);
        i.putExtra("NAME_B_BG_SPIN", NAME_B_BG);
        i.putExtra("NAME_C_BG_SPIN", NAME_C_BG);
        i.putExtra("NAME_D_BG_SPIN", NAME_D_BG);
        i.putExtra("NAME_E_BG_SPIN", NAME_E_BG);
        i.putExtra("NAME_F_BG_SPIN", NAME_F_BG);

        getApplicationContext().startActivity(i);

    }

}


