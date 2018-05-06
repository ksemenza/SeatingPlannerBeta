package com.guinproductions.seatingplanner.models;

import android.database.Cursor;

import static android.provider.BaseColumns._ID;
import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;


public class Name {

    private int _id;
    private String name;

    public Name() {

    }

    public static Name getNamefromCursor(Cursor cursor) {
        Name name = new Name();
        name.setId(cursor.getInt(cursor.getColumnIndex((_ID))));
        name.setName(cursor.getString(cursor.getColumnIndex(SERVER_NAME)));

        return name;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getId() {
        return _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void Name(int _id, String name) {
        this.name = name;
        this._id = _id;

    }
}