package com.guinproductions.seatingplanner.models;

import android.database.Cursor;

import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.ROOM;
import static com.guinproductions.seatingplanner.database.DbPresenter.Section.SECTION_LETTER;

public class Section {


    private String name;
    private String section;
    private String room;


    public static Section getSectionSetupfromCursor(Cursor cursor) {
        Section section = new Section();
        section.setName(cursor.getString(cursor.getColumnIndex(SERVER_NAME)));
        section.setSection(cursor.getString(cursor.getColumnIndex(SECTION_LETTER)));
        section.setRoom(cursor.getString(cursor.getColumnIndex(ROOM)));

        return section;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }


}
