package com.tbptb_b.k16_dosen.datamodels;

import com.google.gson.annotations.SerializedName;

public class Pivot{

    @SerializedName("examiner_id")
    private int examinerId;

    @SerializedName("id")
    private int id;

    @SerializedName("position")
    private int position;

    @SerializedName("thesis_trial_id")
    private int thesisTrialId;

    public int getExaminerId(){
        return examinerId;
    }

    public int getId(){
        return id;
    }

    public int getPosition(){
        return position;
    }

    public int getThesisTrialId(){
        return thesisTrialId;
    }
}