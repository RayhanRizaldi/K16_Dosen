package com.tbptb_b.k16_dosen.datamodels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetDetailTAResponse{

    @SerializedName("room_id")
    private Object roomId;

    @SerializedName("end_at")
    private String endAt;

    @SerializedName("thesis_id")
    private int thesisId;

    @SerializedName("file_slide")
    private String fileSlide;

    @SerializedName("registered_at")
    private String registeredAt;

    @SerializedName("method")
    private int method;

    @SerializedName("examiners")
    private List<ExaminersItem> examiners;

    @SerializedName("file_report")
    private Object fileReport;

    @SerializedName("description")
    private Object description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("thesis_rubric_id")
    private int thesisRubricId;

    @SerializedName("start_at")
    private String startAt;

    @SerializedName("file_journal")
    private String fileJournal;

    @SerializedName("score")
    private Object score;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("grade")
    private String grade;

    @SerializedName("trial_at")
    private String trialAt;

    @SerializedName("id")
    private int id;

    @SerializedName("online_url")
    private Object onlineUrl;

    @SerializedName("status")
    private int status;

    public Object getRoomId(){
        return roomId;
    }

    public String getEndAt(){
        return endAt;
    }

    public int getThesisId(){
        return thesisId;
    }

    public String getFileSlide(){
        return fileSlide;
    }

    public String getRegisteredAt(){
        return registeredAt;
    }

    public int getMethod(){
        return method;
    }

    public List<ExaminersItem> getExaminers(){
        return examiners;
    }

    public Object getFileReport(){
        return fileReport;
    }

    public Object getDescription(){
        return description;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public int getThesisRubricId(){
        return thesisRubricId;
    }

    public String getStartAt(){
        return startAt;
    }

    public String getFileJournal(){
        return fileJournal;
    }

    public Object getScore(){
        return score;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public String getGrade(){
        return grade;
    }

    public String getTrialAt(){
        return trialAt;
    }

    public int getId(){
        return id;
    }

    public Object getOnlineUrl(){
        return onlineUrl;
    }

    public int getStatus(){
        return status;
    }
}