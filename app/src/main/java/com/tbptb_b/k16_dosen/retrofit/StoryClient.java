package com.tbptb_b.k16_dosen.retrofit;

import com.tbptb_b.k16_dosen.models.LogbookResponse;
import com.tbptb_b.k16_dosen.models.LogoutResponse;
import com.tbptb_b.k16_dosen.models.Nilaitareq;
import com.tbptb_b.k16_dosen.models.Nilaitaresponse;
import com.tbptb_b.k16_dosen.models.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StoryClient {

     @FormUrlEncoded
    @POST("api/login")
    Call<Response> login(@Field("username") String username, @Field("password")String password);

    @POST("api/logout")
    Call<LogoutResponse> logout (
            @Header("Authorization") String token
    );

    @GET("api/theses/{id}/logbooks")
    Call<LogbookResponse> getLogbook(
            @Path("id") Integer idTheses,
            @Header("Authorization")String token);

    @FormUrlEncoded
    @PATCH("api/thesis/grades/{id}")
    Call<Nilaitaresponse> patchnilai(
            @Path("id") Integer idTheses,
            @Field("grade") String grade,
            @Header("Authorization")String token);

}
