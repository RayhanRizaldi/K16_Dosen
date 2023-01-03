package com.tbptb_b.k16_dosen.retrofit;

import com.tbptb_b.k16_dosen.models.LogbookResponse;
import com.tbptb_b.k16_dosen.models.LogoutResponse;
import com.tbptb_b.k16_dosen.models.Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface StoryClient {

     @FormUrlEncoded
    @POST("api/login")
    Call<Response> login(@Field("username") String username, @Field("password")String password);

    @POST("api/logout")
    Call<LogoutResponse> logout (
            @Header("Authorization") String token
    );

    @GET("api/theses/309/logbooks")
    Call<LogbookResponse> getLogbook(@Header("Authorization")String token);

}
