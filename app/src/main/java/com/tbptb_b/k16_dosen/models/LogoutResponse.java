package com.tbptb_b.k16_dosen.models;

import com.google.gson.annotations.SerializedName;
public class LogoutResponse {

    @SerializedName("message")
    private String message;

    public String getMessage(){
        return message;
    }
}
