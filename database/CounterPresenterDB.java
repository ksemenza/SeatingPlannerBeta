package com.guinproductions.seatingplanner.database;

import android.provider.BaseColumns;

public class CounterPresenterDB {

    public CounterPresenterDB() {

        class Counters implements BaseColumns {
            public static final String TABLE_NAME = "counter";
            public static final String SERVER_NAME = "server";
            public static final String ROOM = "room";
            public static final String SECTION_LETTER = "letter";
            public static final String TABLE_NUMBER = "table";
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
}

