package com.guinproductions.seatingplanner.models;

import java.util.ArrayList;

/**
 * Created by guinp on 4/8/2018.
 */

public class Servers {

    private String name;
    private String table;
    private String time;
    private String tally;
    private ArrayList<Servers> serverHashMap = new ArrayList<Servers>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTally() {
        return tally;
    }

    public void setTally(String tally) {
        this.tally = tally;
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


    public ArrayList<Servers> getServerHashMap() {
        return serverHashMap;
    }

    public void setServerHashMap(ArrayList<Servers> serverHashMap) {
        this.serverHashMap = serverHashMap;
    }

}

