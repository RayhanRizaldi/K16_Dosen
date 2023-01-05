package com.tbptb_b.k16_dosen.models;

import com.google.gson.annotations.SerializedName;

public class Nilaitaresponse{

    @SerializedName("grade")
    private String grade;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public String getGrade(){return grade;}

    public String getMessage(){
        return message;
    }

    public String getStatus(){
        return status;
    }
}