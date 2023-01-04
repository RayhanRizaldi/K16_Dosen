package com.tbptb_b.k16_dosen.retrofit;

import com.tbptb_b.k16_dosen.models.DSemResponse;
import com.tbptb_b.k16_dosen.models.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface StoryClient {

     @FormUrlEncoded
    @POST("api/login")
    Call<Response> login(@Field("username") String username, @Field("password")String password);

    @GET ("api/thesis/advisors")
    Call<DSemResponse> getdetailSmr(@Header("Authorization")String token);
}
