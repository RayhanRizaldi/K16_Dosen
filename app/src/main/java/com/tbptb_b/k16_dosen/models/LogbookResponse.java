package com.tbptb_b.k16_dosen.models;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class LogbookResponse{

    @SerializedName("count")
    private int count;

    @SerializedName("logbooks")
    private ArrayList<LogbooksItem> logbooks;

    @SerializedName("status")
    private String status;

    public int getCount(){
        return count;
    }

    public ArrayList<LogbooksItem> getLogbooks(){
        return logbooks;
    }

    public String getStatus(){
        return status;
    }
}