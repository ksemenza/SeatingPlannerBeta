package com.guinproductions.seatingplanner.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.guinproductions.seatingplanner.models.Name;

import java.util.ArrayList;
import java.util.HashMap;

import static android.provider.BaseColumns._ID;

import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Name.TABLE_NAME;


public class DbView extends SQLiteOpenHelper {

    public static final String DB_NAME = "name.db";
    public static final int DATABASE_VERSION = 1;
    private static Name nameModel;

    public DbView(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbPresenter.Name.CREATE_TABLE);
        db.execSQL(DbPresenter.Section.CREATE_TABLE);
        db.execSQL(DbPresenter.Counter.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbPresenter.Name.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DbPresenter.Section.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DbPresenter.Counter.TABLE_NAME);

        onCreate(db);

    }
// **** CRUD (Create, Read, Update, Delete) Operations ***** //

    //Adding new name
    public void insertName() {
        //Get the Data repository in write mode

        SQLiteDatabase db = this.getWritableDatabase();
        /** Create new map of values
         ** Column names are the keys**/
        ContentValues values = new ContentValues();
        values.put(String.valueOf(_ID), nameModel.getId());
        values.put(SERVER_NAME, nameModel.getName());

        /**Inster new row
         * Returning primary key value of new row **/
        long nameId = db.insert(TABLE_NAME, null, values);
        db.close();
    }

    /**
     * Get name details
     **/
    public ArrayList<HashMap<String, String>> GetNames() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> nameList = new ArrayList<>();
        String query = "SELECT name FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> name = new HashMap<>();
            name.put("name", cursor.getString(cursor.getColumnIndex(SERVER_NAME)));
            nameList.add(name);
        }
        return nameList;
    }

    /**
     * Get Name by ID
     **/
    public ArrayList<HashMap<String, String>> GetNameById(int _id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> nameList = new ArrayList<>();
        String query = "SELCT name FROM" + TABLE_NAME;
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{SERVER_NAME},
                _ID + "=?",
                new String[]{String.valueOf(_id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToNext()) {
            HashMap<String, String> name = new HashMap<>();
            name.put("name", cursor.getString(cursor.getColumnIndex(SERVER_NAME)));
            nameList.add(name);
        }
        return nameList;
    }

    /**
     * Delete Name
     **/
    public void deleteName() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, _ID + "=?", new String[]{"name"});
        db.close();
    }

    /**
     * Update Name
     **/
    public int updateName(String name, int _id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SERVER_NAME, name);
        int count = db.update(TABLE_NAME, values, _ID + "=?", new String[]{String.valueOf(_id)});
        return count;
    }

}

