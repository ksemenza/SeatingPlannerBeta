package com.guinproductions.seatingplanner.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.database.DbView;
import com.guinproductions.seatingplanner.fragments.MainDetailsFragment;
import com.guinproductions.seatingplanner.fragments.MainRmBgFragment;
import com.guinproductions.seatingplanner.fragments.MainRmSmFragment;

import static android.provider.BaseColumns._ID;
import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Name.TABLE_NAME;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainRmBgFragment.OnFragmentInteractionListener, MainRmSmFragment.OnFragmentInteractionListener {

    static MainDetailsFragment mainDetailsFragment;
    static MainRmBgFragment mainRmBgFragment;
    static MainRmSmFragment mainRmSmFragment;
    private MainViewPagerAdapter mainViewPagerAdapter;
    private ViewPager mViewPager;

    private TextInputEditText inputNameEV;
    private Button btnSave;
    private TextView tvNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** Pass Data in ViewPager Fragments */
        mainDetailsFragment = new MainDetailsFragment();
        mainRmBgFragment = new MainRmBgFragment();
        mainRmSmFragment = new MainRmSmFragment();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.mainContainer);
        mViewPager.setAdapter(mainViewPagerAdapter);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Dialog Box Add New Server ServerParent
     * <p>
     * <p>
     * private void addNameDialog() {
     * Dialog dialog = new Dialog(this);
     * <p>
     * <p>
     * dialog.setTitle("Enter New Server ServerParent");
     * dialog.setContentView(R.layout.dialog_main_add_name);
     * <p>
     * <p>
     * /** Intialize Views
     * inputNameEV = dialog.findViewById(R.id.dialog_add_name_input);
     * btnSave = dialog.findViewById(R.id.dialog_add_name_btn);
     * <p>
     * <p>
     * /** Save ServerParent Onclick Event
     * btnSave.setOnClickListener(new View.OnClickListener() {
     *
     * @Override public void onClick(View v) {
     * <p>
     * switch (v.getId()) {
     * <p>
     * case R.id.dialog_add_name_btn:
     * <p>
     * <p>
     * }
     * }
     * });
     * <p>
     * dialog.show();
     * <p>
     * }
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ((item.getItemId())) {
            case R.id.action_add_server_name:


                /** Dialog Method Add New ServerParent
                 addNameDialog(); **/
                /**Toast Confirm ServerParent Added to name_list_lv **/
                Toast.makeText(this, "Enter New Server's ServerParent", Toast.LENGTH_LONG).show();
                break;

            case R.id.ab_name_list:
                /** ServerParent List Intent Activty **/
                Intent i = new Intent(MainActivity.this, NameLstActivity.class);
//                readNameFromDB();
                startActivity(i);
                /**Toast Start of NameListActivity **/
                Toast.makeText(this, "Server ServerParent List", Toast.LENGTH_LONG).show();
                break;

            case R.id.ab_section_setup:

                Intent intent = new Intent(MainActivity.this, AmtSetupActivity.class);

                startActivity(intent);

//                showAmtDialog();

                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Data Passing between Fragments
     */
    @Override
    public void onFragmentInteraction(String sectionLetter) {
        mainViewPagerAdapter.onFragmentInteraction(sectionLetter);


    }

    private void readNameFromDB() {
        String serverName = tvNameInput.getText().toString();
        SQLiteDatabase database = new DbView(this).getReadableDatabase();
        String[] projection = {
                String.valueOf(_ID),
                SERVER_NAME
        };

        String selection =
                SERVER_NAME + "  like ?";

        String[] selectionArgs = {"%" + serverName + "%"};

        Cursor cursor = database.query(
                TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );


    }

    public static class MainViewPagerAdapter extends FragmentPagerAdapter implements MainRmBgFragment.OnFragmentInteractionListener {


        public MainViewPagerAdapter(FragmentManager fm) {
            super(fm);


        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return mainDetailsFragment;
                case 1:
                    return mainRmSmFragment;
                case 2:
                    return mainRmBgFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }


        @Override
        public void onFragmentInteraction(String sectionLetter) {
            mainDetailsFragment.onFragmentInteraction(sectionLetter);


        }
    }

}