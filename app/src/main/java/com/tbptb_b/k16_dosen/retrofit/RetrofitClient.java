package com.tbptb_b.k16_dosen.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static StoryClient service;
    public static StoryClient getService(){

        if (service == null){
            String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().build())
                    .build();

            service = retrofit.create(StoryClient.class);

        }
        return service;
    }



}
