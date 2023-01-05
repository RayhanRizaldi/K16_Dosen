package com.tbptb_b.k16_dosen.models;

import com.google.gson.annotations.SerializedName;

public class BatalTaResponse{

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