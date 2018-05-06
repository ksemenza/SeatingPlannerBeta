package com.guinproductions.seatingplanner.models;

import android.database.Cursor;

import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TABLE_NUMBER;
import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TALLY;
import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TIME_STAMP;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.ROOM;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SECTION_LETTER;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SPINNER_NAME_SELECTIONS;

public class Counter {

    String name;
    String room;
    String section;
    String tally;

    String table;
    String time;


    public Counter getCounterDetails(Cursor cursor) {

        Counter counter = new Counter();
        counter.setName(cursor.getString((cursor.getColumnIndex(SPINNER_NAME_SELECTIONS))));
        counter.setRoom(cursor.getString((cursor.getColumnIndex(ROOM))));
        counter.setSection(cursor.getString(cursor.getColumnIndex(SECTION_LETTER)));
        counter.setTable(cursor.getString(cursor.getColumnIndex(TABLE_NUMBER)));
        counter.setTally(cursor.getString(cursor.getColumnIndex(TALLY)));
        counter.setTime(cursor.getString(cursor.getColumnIndex(TIME_STAMP)));

        return counter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection() {
        /**
         *
         */
        return section;
    }


    public void setTable(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    public void setTally(String tally) {
        this.tally = tally;
    }

    public String getTally() {
        return tally;
    }

    public void setTime(String time) {
        this.name = time;
    }

    public String getTime() {
        return time;
    }


}


