package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.tbptb_b.k16_dosen.adapter.uaspsem_adapter;
import com.tbptb_b.k16_dosen.models.DSemResponse;
import com.tbptb_b.k16_dosen.models.ThesesItem;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class list_seminar extends AppCompatActivity {

    private RecyclerView rvseminar;
    private uaspsem_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seminar);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        rvseminar = findViewById(R.id.rvlistsem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvseminar.setLayoutManager(layoutManager);
        adapter = new uaspsem_adapter();
        rvseminar.setAdapter(adapter);

        //Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryClient client = retrofit.create(StoryClient.class);

        Call<DSemResponse> call = client.getdetailSmr("Bearer " + token);
        call.enqueue(new Callback<DSemResponse>() {
            @Override
            public void onResponse(Call<DSemResponse> call, Response<DSemResponse> response) {
                DSemResponse semResponse = response.body();
                if(semResponse != null){
                    List<ThesesItem> theses = semResponse.getTheses();
                    adapter.setItemList(theses);
                }
            }

            @Override
            public void onFailure(Call<DSemResponse> call, Throwable t) {

            }
        });
    }
}