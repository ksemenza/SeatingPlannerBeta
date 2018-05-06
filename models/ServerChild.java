package com.guinproductions.seatingplanner.models;

import android.database.Cursor;

import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TABLE_NUMBER;
import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TIME_STAMP;

/**
 * Created by guinp on 4/8/2018.
 */

public class ServerChild {
    private String table = "table";
    private String time = "time";

    public static ServerChild getServerChildfromCursor(Cursor cursor) {
        ServerChild serverChild = new ServerChild();
        serverChild.setTable(cursor.getString(cursor.getColumnIndex(TABLE_NUMBER)));
        serverChild.setTime(cursor.getString(cursor.getColumnIndex(TIME_STAMP)));

        return serverChild;
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
