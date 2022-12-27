package com.tbptb_b.k16_dosen.models;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Authorisation{

	@SerializedName("type")
	private String type;

	@SerializedName("token")
	@Nullable
	private String token;

	public String getType(){
		return type;
	}

	public String getToken(){
		return token;
	}
}