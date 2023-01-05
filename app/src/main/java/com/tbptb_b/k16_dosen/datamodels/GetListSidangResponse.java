package com.tbptb_b.k16_dosen.datamodels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetListSidangResponse{

    @SerializedName("seminars")
    private List<SeminarsItem> seminars;

    @SerializedName("count")
    private int count;

    @SerializedName("status")
    private String status;

    public List<SeminarsItem> getSeminars(){
        return seminars;
    }

    public int getCount(){
        return count;
    }

    public String getStatus(){
        return status;
    }
}