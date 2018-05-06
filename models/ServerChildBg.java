package com.guinproductions.seatingplanner.models;

import android.database.Cursor;

import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TABLE_NUMBER;
import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TIME_STAMP;

public class ServerChildBg {

    private String table = "table";
    private String time = "time";

    public static ServerChildBg getServerChildBgfromCursor(Cursor cursor) {
        ServerChildBg serverChildBg = new ServerChildBg();
        serverChildBg.setTable(cursor.getString(cursor.getColumnIndex(TABLE_NUMBER)));
        serverChildBg.setTime(cursor.getString(cursor.getColumnIndex(TIME_STAMP)));

        return serverChildBg;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

