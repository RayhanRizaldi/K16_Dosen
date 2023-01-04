package com.tbptb_b.k16_dosen.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DSemResponse{

	@SerializedName("count")
	private int count;

	@SerializedName("theses")
	private List<ThesesItem> theses;

	@SerializedName("status")
	private String status;

	public int getCount(){
		return count;
	}

	public List<ThesesItem> getTheses(){
		return theses;
	}

	public String getStatus(){
		return status;
	}
}