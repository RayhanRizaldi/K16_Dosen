package com.tbptb_b.k16_dosen.retrofit;

import com.tbptb_b.k16_dosen.models.Response;
import com.tbptb_b.k16_dosen.retrofit.detailta.DetailTAResponse;
import com.tbptb_b.k16_dosen.retrofit.detailta.SupervisorsItem;
import com.tbptb_b.k16_dosen.retrofit.listmahasiswa.ListMhsMenuResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
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

    @GET("api/thesis/advisors")
    Call<ListMhsMenuResponse> menuListmahasiswa (
            @Header("Authorization") String token
    );

    @GET("api/theses/{id}")
    Call<DetailTAResponse> detailTAmahasiswa(
            @Header("Authorization") String token
            ,@Path("id") int IdMhs
    );

    @GET("api/theses/309")
    Call<SupervisorsItem> detailSv (
            @Header("Authorization") String token
    );

}
