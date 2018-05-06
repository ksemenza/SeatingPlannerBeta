package com.guinproductions.seatingplanner.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.adapters.CounterListBgAdapter;
import com.guinproductions.seatingplanner.adapters.CounterListSmAdapter;
import com.guinproductions.seatingplanner.database.DbPresenter;
import com.guinproductions.seatingplanner.database.DbView;
import com.guinproductions.seatingplanner.models.Counter;
import com.guinproductions.seatingplanner.models.Section;
import com.guinproductions.seatingplanner.models.ServerChild;
import com.guinproductions.seatingplanner.models.ServerChildBg;
import com.guinproductions.seatingplanner.models.ServerParent;
import com.guinproductions.seatingplanner.models.ServerParentBg;
import com.guinproductions.seatingplanner.models.ServerParentSm;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TABLE_NUMBER;
import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TALLY;
import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TIME_STAMP;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.ROOM;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SECTION_LETTER;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SPINNER_NAME_SELECTIONS;


/**
 * Created by guinp on 4/6/2018.
 */

public class MainDetailsFragment extends Fragment implements MainRmBgFragment.OnFragmentInteractionListener, View.OnClickListener {

    Context mContext;
    private static final String DATA_FILE_NAME = "tally";
    //    public LinkedHashMap<String, Integer> tally;
    private SharedPreferences data;
    private int priorSelectedPos;
    TextInputEditText inputNameEV;

    private GridView gvSmRm;
    private GridView gvBgRm;
    private TextView tvLastSat, tvNextUp, tvSecA, tvSecB, tvSecC;

    String selectedTableBgRmGV;
    String selectedTableSmRmGV;

    Section sectionModel;
    Counter counterModel;
    /**
     * public static final String ROOM = DbPresenter.Section.ROOM;
     * public static final String SECTION = DbPresenter.Section.SECTION_LETTER;
     */
    String room, section, name, tables, count, table, time;


    /**
     * Small Room GV String array
     */
    final static String[] tablesSmRm = new String[]{
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18"};
    /**
     * Big Room GV String array
     */
    final static String[] tablesBgRm = new String[]{
            "22", "23", "24", "25", "26",
            "27", "31", "32", "33", "35",
            "41", "42", "43", "44", "50",
            "51", "52", "53", "54", "55",
            "56"};

    final List<String> tblBgRmList = new ArrayList<String>(Arrays.asList(tablesBgRm));
    final List<String> tblSmRmList = new ArrayList<String>(Arrays.asList(tablesSmRm));


    private TextView tvRoom, tvSetion, tvName, tvTally, tvTableNumber, tvTimeStamp;

    ServerParentBg serverParentBg;
    ServerParentSm serverParentSm;

    private LinkedHashMap<String, ServerParentBg> mySectionBg = new LinkedHashMap<>();
    private LinkedHashMap<String, ServerParentSm> mySectionSm = new LinkedHashMap<>();
    private ArrayList<ServerParentBg> parentListBg = new ArrayList<>();
    private ArrayList<ServerParentSm> parentListSm = new ArrayList<>();
    private CounterListBgAdapter counterListBgAdapter;
    private CounterListSmAdapter counterListSmAdapter;
    private ExpandableListView expListBgRm, expListSmRm;

    Calendar calander;
    SimpleDateFormat simpledateformat;

    public MainDetailsFragment() {

        /**Required Empty Constructor */

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = inflater.getContext();
        return inflater.inflate(R.layout.frag_main_details, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        tvLastSat = view.findViewById(R.id.mainDetailsLastSat);
        tvSetion = view.findViewById(R.id.itemSecLetterTV);


        /**VIEW PARENT N
         * ame tv
         * Table
         * Time
         *
         tvName = view.findViewById(R.id.itemNameParentTV);
         tvName.setText(SERVER_NAME);
         tvRoom = view.findViewById(R.id.itemRoomTV);
         tvRoom.setText(ROOM);
         tvTally = view.findViewById(R.id.itemTallyParentTV);
         tvTally.setText(TABLE_NUMBER);
         tvTimeStamp = view.findViewById(R.id.itemTimeChildTV);
         tvTimeStamp.setText(TIME_STAMP);
         tvTableNumber = view.findViewById(R.id.itemTableChildTV);
         tvTableNumber.setText(TABLE_NUMBER);
         */

        /** Expandable ListView Sm and Bg Rm View Implementation*/
        counterListBgAdapter = new CounterListBgAdapter(mContext, parentListBg);
        counterListSmAdapter = new CounterListSmAdapter(mContext, parentListSm);
        expandAll();
/** ExpandListView Bg Rm Implementation */
        expListBgRm = view.findViewById(R.id.mainDetailsBgExpLV);
        expListBgRm.setAdapter(counterListBgAdapter);
        //listener for group heading click
        expListBgRm.setOnGroupClickListener(myListGroupClicked);
        //listener for child row click
        expListBgRm.setOnChildClickListener(myListItemClicked);

/** ExpandListView Sm Rm Implementation */
        expListSmRm = view.findViewById(R.id.mainDetailsSmExpLV);
        expListSmRm.setAdapter(counterListBgAdapter);
        //listener for group heading click
        expListSmRm.setOnGroupClickListener(myListGroupClicked);
        //listener for child row click
        expListSmRm.setOnChildClickListener(myListItemClicked);

/** GridView Sm Rm Start of Implementation of View */
        gvSmRm = view.findViewById(R.id.mainDetailsSmGV);
/** GridView Bg Rm setAdapter */
        gvSmRm.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, tblSmRmList) {
            public View getView(int position, View convertView, ViewGroup parent) {
/** Return GridView Current Item as a View */
                View viewSmGV = super.getView(position, convertView, parent);
// Convert the view as a TextView widget
                TextView tvSmGV = (TextView) viewSmGV;
// set the TextView text color (GridView item color)
                tvSmGV.setTextColor(Color.BLACK);
                tvSmGV.setGravity(Gravity.CENTER);
// Set the TextView text font family and text size
                tvSmGV.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                tvSmGV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
// Set the TextView text (GridView item text)
                tvSmGV.setText(tblSmRmList.get(position));
// Set the TextView background color
                tvSmGV.setBackgroundColor(Color.parseColor("#E3F2FD"));
// Return the TextView widget as GridView item
                return tvSmGV;
            }
        });

/** GridView Big Room OnItemClickListener */
        gvSmRm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
// Get the selected item Pos text
                selectedTableSmRmGV = parent.getItemAtPosition(position).toString();
// Get current selected view as TextView
                TextView tvSmTableGV = (TextView) view;
// Set the current selected item background color
                tvSmTableGV.setBackgroundColor(Color.parseColor("#64B5F6"));
// Set the current selected item text color
                tvSmTableGV.setTextColor(Color.LTGRAY);
// Get the last selected View from GridView
                TextView priorSelectedView = (TextView) gvSmRm.getChildAt(priorSelectedPos);
// If there is a previous selected view exists
                if (priorSelectedPos != -1) {
// Set the last selected View to deselect
                    priorSelectedView.setSelected(true);
// Set the last selected View background color as deselected item
                    priorSelectedView.setBackgroundColor(Color.parseColor("#E3F2FD"));
// Set the last selected View text color as deselected item
                    priorSelectedView.setTextColor(Color.DKGRAY);
                }
// Set the current selected view position as previousSelectedPosition
                priorSelectedPos = position;
                Toast.makeText(getContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

            }


        });
/** GridView Start of Implementation of View */
        gvBgRm = view.findViewById(R.id.mainDetailsBgGV);
/** GridView Bg Rm setAdapter */
        gvBgRm.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, tblBgRmList) {
            public View getView(int position, View convertView, ViewGroup parent) {
/** Return GridView Current Item as a View */
                View viewBgGV = super.getView(position, convertView, parent);
// Convert the view as a TextView widget
                TextView tvBgGV = (TextView) viewBgGV;
// set the TextView text color (GridView item color)
                tvBgGV.setTextColor(Color.BLACK);
                tvBgGV.setGravity(Gravity.CENTER);
// Set the TextView text font family and text size
                tvBgGV.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                tvBgGV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
// Set the TextView text (GridView item text)
                tvBgGV.setText(tblBgRmList.get(position));
// Set the TextView background color
                tvBgGV.setBackgroundColor(Color.parseColor("#E3F2FD"));
// Return the TextView widget as GridView item
                return tvBgGV;
            }
        });
/** GridView Big Room OnItemClickListener */
        gvBgRm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text
                selectedTableBgRmGV = parent.getItemAtPosition(position).toString();
                // Get current selected view as TextView
                TextView tvBgTableGV = (TextView) view;
                // Set the current selected item background color
                tvBgTableGV.setBackgroundColor(Color.parseColor("#64B5F6"));
                // Set the current selected item text color
                tvBgTableGV.setTextColor(Color.LTGRAY);
                // Get the last selected View from GridView
                TextView priorSelectedView = (TextView) gvBgRm.getChildAt(priorSelectedPos);
                // If there is a previous selected view exists
                if (priorSelectedPos != -1) {
                    // Set the last selected View to deselect
                    priorSelectedView.setSelected(false);
                    // Set the last selected View background color as deselected item
                    priorSelectedView.setBackgroundColor(Color.parseColor("#E3F2FD"));
                    // Set the last selected View text color as deselected item
                    priorSelectedView.setTextColor(Color.DKGRAY);
                }
                // Set the current selected view position as previousSelectedPosition
                priorSelectedPos = position;
                Toast.makeText(getContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

            }


        });
    }

    @Override
    public void onFragmentInteraction(String tableNumber) {

        tvLastSat.setText(tableNumber);
    }

    @Override
    public void onClick(View v) {

        calander = Calendar.getInstance();
        simpledateformat = new SimpleDateFormat("HH:mm:ss");

/** NEEDS TO BE CORRECTED
 *
 section = tvSecA.getText().toString();
 name = inputNameEV.getText().toString();
 table = tvLastSat.getText().toString();
 time = simpledateformat.format(calander.getTime());

 serverParentBg.setSection(SECTION_LETTER);
 serverParentBg.setName(SPINNER_NAME_SELECTIONS);
 serverParentBg.setTable(TABLE_NUMBER);
 serverParentBg.setTime(TIME_STAMP);

 serverParentSm.setSection(SECTION_LETTER);
 serverParentSm.setName(SPINNER_NAME_SELECTIONS);
 serverParentSm.setTable(TABLE_NUMBER);
 serverParentSm.setTime(TIME_STAMP);
 *****/

        int groupPosition = addServer();

        counterListBgAdapter.notifyDataSetChanged();
        counterListSmAdapter.notifyDataSetChanged();
        collapseAll();

        expListBgRm.expandGroup(groupPosition);
        expListSmRm.expandGroup(groupPosition);

        expListBgRm.setSelectedGroup(groupPosition);
        expListSmRm.setSelectedGroup(groupPosition);

    }

    //method to expand all groups
    private void expandAll() {
        int count = counterListBgAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            expListBgRm.expandGroup(i);
            expListSmRm.expandGroup(i);
        }
    }

    //method to collapse all groups
    private void collapseAll() {
        int count = counterListBgAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            expListBgRm.collapseGroup(i);
            expListSmRm.collapseGroup(i);
        }
    }

    private void AddServerExample() {

        addServer();

    }

    //our child listener
    private ExpandableListView.OnChildClickListener myListItemClicked = new ExpandableListView.OnChildClickListener() {

        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {
            //get the group header
            ServerParentBg serverParentBg = parentListBg.get(groupPosition);
            ServerParent serverParentSm = parentListSm.get(groupPosition);
            //get the child info
            ServerChild serverChildBg = serverParentBg.getChildList().get(childPosition);
            ServerChild serverChildSm = serverParentBg.getChildList().get(childPosition);
            //display it or do something with it
            Toast.makeText(mContext, "Clicked on Detail " + serverParentBg.getName() + serverParentSm.getName()
                    + "/" + serverChildSm.getTable() + serverChildBg.getTable(), Toast.LENGTH_LONG).show();
            return false;
        }
    };

    /**
     * Parent Group Listener
     */
    private ExpandableListView.OnGroupClickListener myListGroupClicked = new ExpandableListView.OnGroupClickListener() {
        public boolean onGroupClick(ExpandableListView parent, View v,
                                    int groupPosition, long id) {
            //get the group header
            ServerParent serverParentBg = parentListBg.get(groupPosition);
            ServerParent serverParentSm = parentListSm.get(groupPosition);
            //display it or do something with it
            Toast.makeText(mContext, serverParentBg.getSection() + serverParentSm.getSection(),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    };


    //here we maintain our products in various names
    private int addServer(String header, String details) {
        int groupPosition = 0;

        ServerParentBg serverParentBg = mySectionBg.get(header);
        ServerParentSm serverParentSm = mySectionSm.get(header);

        /** Model implemented Data
         //check the hash map if the group already exists
         ServerParent serverParent = linkedHashMap.get(SECTION_LETTER);
         //add the group if doesn't exists
         if(serverParent == null){
         serverParent = new ServerParent();
         serverParent.setRoom(ROOM);
         serverParent.setSection(SECTION_LETTER);
         serverParent.setName(SPINNER_NAME_SELECTIONS);
         serverParent.setTable(TABLE_NUMBER);
         serverParent.setTally(TALLY);
         serverParent.setTime(TIME_STAMP);
         linkedHashMap.put(SECTION_LETTER, serverParent);
         parentListBg.add(serverParent);
         parentListSm.add(serverParent);
         }

         */
        //get the children for the group
        ArrayList<ServerChildBg> childListBg = serverParentBg.getChildListBg();
        //size of the children list
        int listSizeBg = childListBg.size();
        //add to the counter
        listSizeBg++;

        //create a new child and add that to the group
        ServerChildBg serverChildBg = new ServerChildBg();

        serverChildBg.setTable(TABLE_NUMBER);
        serverChildBg.setTime(TIME_STAMP);

        childListBg.add(serverChildBg);
        serverParentBg.setChildListBg(childListBg);

        //find the group position inside the list
        groupPositionBg = parentListBg.indexOf(serverParentBg);
        groupPositionSm = parentListSm.indexOf(serverParentSm);
        return groupPositionBg;
    }

    private void readFromDB() {
        String firstname = tvName.getText().toString();
        String sectionletter = tvSecA.getText().toString();

        SQLiteDatabase database = new DbView(getContext()).getReadableDatabase();

        String[] selectionArgs = {"%" + firstname + "%", "%" + sectionletter + "%"};

        Cursor cursor = database.rawQuery(DbPresenter.SELECTED_SERVER_NAME, selectionArgs);
        expListBgRm.setAdapter(new CounterListBgAdapter(getContext(), (ArrayList<ServerParent>) cursor));
        expListSmRm.setAdapter(new CounterListSmAdapter(getContext(), (ArrayList<ServerParent>) cursor));
    }


    /** END of ExpandListView */
}

