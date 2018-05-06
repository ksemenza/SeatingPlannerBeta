package com.guinproductions.seatingplanner.models;

import android.database.Cursor;

import java.util.ArrayList;

import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TALLY;
import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.ROOM;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SECTION_LETTER;

public class ServerParentSm {
    String name;
    String room;
    String section;
    String table;
    String time;
    String tally;

    public static ServerParentSm getServerParentSmfromCursor(Cursor cursor) {
        ServerParentSm serverParentSm = new ServerParentSm();
        serverParentSm.setRoom(cursor.getString(cursor.getColumnIndex(ROOM)));
        serverParentSm.setSection(cursor.getString(cursor.getColumnIndex(SECTION_LETTER)));
        serverParentSm.setName(cursor.getString(cursor.getColumnIndex(SERVER_NAME)));
        serverParentSm.setTally(cursor.getString(cursor.getColumnIndex(TALLY)));

        return serverParentSm;
    }

    private ArrayList<ServerChildSm> childListSm = new ArrayList<>();

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
        return section;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTally() {
        return tally;
    }

    public void setTally(String tally) {
        this.tally = tally;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<ServerChildSm> getChildListSm() {
        return childListSm;
    }

    public void setChildListSm(ArrayList<ServerChildSm> childListSm) {
        this.childListSm = childListSm;
    }
}
