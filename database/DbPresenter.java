package com.guinproductions.seatingplanner.database;

import android.provider.BaseColumns;

import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.ROOM;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SECTION_LETTER;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SPINNER_NAME_SELECTIONS;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.TABLE_NAME;


public class DbPresenter {


    /**
     * Assigning Name to Section
     */
    public static final String SELECTED_SERVER_NAME = "SELECT * " +
            "FROM " + TABLE_NAME + " ee INNER JOIN " + Name.TABLE_NAME + " er " +
            "ON ee." + SPINNER_NAME_SELECTIONS + " = er." + Name._ID + " WHERE " +
            "ee." + SECTION_LETTER + " like ?";


    public DbPresenter() {


    }

    public static class Name implements BaseColumns {
        /**
         * Now declared in the CONSTANTS
         */
        public static final String TABLE_NAME = "names";
        public static final String SERVER_NAME = "name";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SERVER_NAME + " TEXT " +
                ")";
    }

    public static class Section implements BaseColumns {

        /**
         * Now declared in CONSTANTS
         */
        public static final String TABLE_NAME = "sections";
        public static final String ROOM = "room";
        public static final String SECTION_LETTER = "letter";
        public static final String SPINNER_NAME_SELECTIONS = "spinner";


        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                ROOM + " TEXT, " +
                SECTION_LETTER + " KEY, " +
                SPINNER_NAME_SELECTIONS + " TEXT, " +
                "FOREIGN KEY(" + SPINNER_NAME_SELECTIONS + ") REFERENCES " +
                Name.TABLE_NAME + "(" + Name._ID + ") " + ")";
    }

    public static class Counter implements BaseColumns {

        /***/
        public static final String TABLE_NAME = "counters";
        public static final String TABLE_NUMBER = "number";
        public static final String TIME_STAMP = "time";
        public static final String TALLY = "tally";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                SERVER_NAME + " KEY, " +
                ROOM + " TEXT, " +
                SECTION_LETTER + " TEXT, " +
                TABLE_NUMBER + " TEXT, " +
                TIME_STAMP + " TEXT, " +
                TALLY + " TEXT " +
                ")";
    }
}

