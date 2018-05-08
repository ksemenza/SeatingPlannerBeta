package com.guinproductions.seatingplanner.models;

import android.database.Cursor;

import java.util.ArrayList;

import static com.guinproductions.seatingplanner.database.DbPresenter.Counter.TALLY;
import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.ROOM;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SECTION_LETTER;

public class ServerParentBg {

    String name;
    String room;
    String section;
    String table;
    String time;
    String tally;

    private ArrayList<ServerChildBg> childListBg = new ArrayList<>();
    private ArrayList<ServerChildSm> childListSm = new ArrayList<>();

    public static ServerParentBg getServerParentBgfromCursor(Cursor cursor) {
        ServerParentBg serverParentBg = new ServerParentBg();
        serverParentBg.setRoom(cursor.getString(cursor.getColumnIndex(ROOM)));
        serverParentBg.setSection(cursor.getString(cursor.getColumnIndex(SECTION_LETTER)));
        serverParentBg.setName(cursor.getString(cursor.getColumnIndex(SERVER_NAME)));
        serverParentBg.setTally(cursor.getString(cursor.getColumnIndex(TALLY)));

        return serverParentBg;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ArrayList<ServerChildBg> getChildListBg() {
        return childListBg;
    }

    public ArrayList<ServerChildSm> getChildListSm() {
        return childListSm;
    }

    public void setChildListBg(ArrayList<ServerChildBg> childListBg) {
        this.childListBg = childListBg;
    }
}

