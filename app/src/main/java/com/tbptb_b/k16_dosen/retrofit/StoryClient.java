package com.tbptb_b.k16_dosen.retrofit;

import com.tbptb_b.k16_dosen.datamodels.GetInputNSResponse;
import com.tbptb_b.k16_dosen.datamodels.GetListSidangResponse;
import com.tbptb_b.k16_dosen.models.Response;

import retrofit2.Call;
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

    @GET("/api/admin/thesis/trial-submissions")
    Call<GetListSidangResponse> getThesis(@Header("Authorization") String token);

    @PATCH ("/api/thesis/grades/277")
    Call<GetInputNSResponse> patchnilai(
            @Path("id") Integer idTheses,
            @Field("grade") String grade,
            @Header("Authorization")String token);

}
