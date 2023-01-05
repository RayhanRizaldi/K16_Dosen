package com.tbptb_b.k16_dosen.datamodels;

import com.google.gson.annotations.SerializedName;

public class GetInputNSResponse{

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public String getMessage(){
        return message;
    }

    public String getStatus(){
        return status;
    }
}