package com.tbptb_b.k16_dosen.retrofit;

import com.tbptb_b.k16_dosen.models.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface StoryClient {

    @POST("login/")
    Call<Response> login(@Field("username") String username, @Field("password")String password);

}
