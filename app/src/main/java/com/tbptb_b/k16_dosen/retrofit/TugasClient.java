package com.tbptb_b.k16_dosen.retrofit;

import com.tbptb_b.k16_dosen.models.LoginResponse;
import com.tbptb_b.k16_dosen.models.LogoutResponse;
import com.tbptb_b.k16_dosen.models.ProfilResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TugasClient {
    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @POST("api/logout")
    Call<LogoutResponse> logout(@Header("token") String token);

    @GET("api/me")
    Call<ProfilResponse> profil(@Header("token") String token);
}
