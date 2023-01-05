package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tbptb_b.k16_dosen.adapter.jsid_adapter;
import com.tbptb_b.k16_dosen.adapter.psid_adapter;
import com.tbptb_b.k16_dosen.datamodels.GetListSidangResponse;
import com.tbptb_b.k16_dosen.datamodels.SeminarsItem;
import com.tbptb_b.k16_dosen.models.psid_model;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SidangPersetujuanActivity extends AppCompatActivity implements psid_adapter.ItempsidClickListener{

    private RecyclerView rv_psid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidang_persetujuan);

        //recycle view
        rv_psid = findViewById(R.id.rv_psid);
        psid_adapter psidadapter = new psid_adapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_psid.setLayoutManager(layoutManager);
        rv_psid.setAdapter(psidadapter);

        //API
        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN","");

        //minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryClient client = retrofit.create(StoryClient.class);

        Call<GetListSidangResponse> call = client.getThesis("Bearer" + token);
        call.enqueue(new Callback<GetListSidangResponse>() {
            @Override
            public void onResponse(Call<GetListSidangResponse> call, Response<GetListSidangResponse> response) {
                Log.d("psid-Debug", response.toString());

                GetListSidangResponse getListSidangResponse = response.body();
                if(getListSidangResponse != null){
                    List<SeminarsItem> listThesis = getListSidangResponse.getSeminars();
                    Log.d("psid-Debug", String.valueOf(listThesis.size()));
                    psidadapter.setitemSetuju(listThesis);
                }
            }

            @Override
            public void onFailure(Call<GetListSidangResponse> call, Throwable t) {
//                Toast.makeText(.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void SetujuSidang() {
        Intent intentpsid = new Intent(this, DSidang2Activity.class);
        startActivity(intentpsid);
    }

    public ArrayList<psid_model> getpsid_model(){
        ArrayList<psid_model> listpsid_model = new ArrayList<>();

        listpsid_model.add(new psid_model(
                null,
                "Kamis, 22 Desember 2022",
                "Winanda afrilia harisya",
                "2011522016"

        ));

        listpsid_model.add(new psid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla saraswati",
                "2011523012"

        ));

        listpsid_model.add(new psid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001"

        ));
        listpsid_model.add(new psid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016"

        ));

        listpsid_model.add(new psid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla saraswati",
                "2011523012"

        ));

        listpsid_model.add(new psid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001"

        ));
        listpsid_model.add(new psid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016"

        ));

        listpsid_model.add(new psid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla saraswati",
                "2011523012"

        ));

        listpsid_model.add(new psid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001"

        ));

        return listpsid_model;
    }

    @Override
    public void onitempsidClick(SeminarsItem psidmodel) {

    }

    public void Bterima_psid(View view){
        Intent Bterima_psid = new Intent(SidangPersetujuanActivity.this, SidangPersetujuanActivity.class);
        startActivity(Bterima_psid);
    }

    public void Btolak_psid(View view){
        Intent Btolak_psid = new Intent(SidangPersetujuanActivity.this, SidangPersetujuanActivity.class);
        startActivity(Btolak_psid);
    }

//    @Override
//    public void onitempsidClick(SeminarsItem psidmodel) {
//        Intent intentpsid = new Intent(this, inputnilaisidangActivity.class);
//        intentpsid.putExtra("Peserta Sidang", psidmodel.getThesis().getStudent().getName());
//        intentpsid.putExtra("Id Thesis", psidmodel.getThesisId());
//        startActivity(intentpsid);
//    }
}