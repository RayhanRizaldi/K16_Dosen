package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

import com.tbptb_b.k16_dosen.models.Listlogbook;
import com.tbptb_b.k16_dosen.models.LogbookResponse;
import com.tbptb_b.k16_dosen.models.LogbooksItem;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LogbookActivity extends AppCompatActivity {
Button buttondetaillb;

private RecyclerView rvLogbook;
private Adapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);

        SharedPreferences sharedPref = getSharedPreferences("prefs",Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        rvLogbook = findViewById(R.id.rv_lb);

//        Adapter3 adapter = new Adapter3(getLislogbook());
//        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        adapter = new Adapter3();
        rvLogbook.setAdapter(adapter);

        //Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryClient client = retrofit.create(StoryClient.class);

        Call<LogbookResponse> call = client.getLogbook("Bearer " + token);
        call.enqueue(new Callback<LogbookResponse>() {
            @Override
            public void onResponse(Call<LogbookResponse> call, Response<LogbookResponse> response) {

//                Log.d("LogbookActivity-Debug", response.toString());

                LogbookResponse logbookResponse = response.body();
                if(logbookResponse != null){
                    ArrayList<LogbooksItem> logbooks = logbookResponse.getLogbooks();
                    adapter.setItemList(logbooks);
                }
            }

            @Override
            public void onFailure(Call<LogbookResponse> call, Throwable t) {

            }
        });

//        buttondetaillb = findViewById(R.id.buttondetaillogbook);
//        buttondetaillb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDetailLogbook();
//            }
//        });
    }
//     public ArrayList<Listlogbook> getLislogbook(){
//        ArrayList<Listlogbook> ListLogbook = new ArrayList<>();
//        ListLogbook.add(new Listlogbook(
//                "Jumat, 30/9/2022",
//                "Melakukan riset",
//                1
//        ));
//         ListLogbook.add(new Listlogbook(
//                 "Sabtu, 1/10/2022",
//                 "Melakukan riset",
//                 1
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Minggu, 2/10/2022",
//                 "Melengkapi riset",
//                 1
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Senin, 3/10/2022",
//                 "Membuat Pendahuluan",
//                 1
//         ));ListLogbook.add(new Listlogbook(
//                 "Selasa, 4/10/2022",
//                 "Membuat Pendahuluan",
//                 0
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Rabu, 5/10/2022",
//                 "Melengkapi Pendahuluan",
//                 0
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Kamis, 6/10/2022",
//                 "Melakukan Tinjauan Pustaka",
//                 0
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Jumat, 7/10/2022",
//                 "Membuat Tinjauan Pustaka",
//                 0
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Sabtu, 8/10/2022",
//                 "Membuat Tinjauan Pustaka",
//                 0
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Minggu, 9/10/2022",
//                 "Membuat Tinjauan Pustaka",
//                 0
//         ));ListLogbook.add(new Listlogbook(
//                 "Senin, 10/10/2022",
//                 "Membuat Tinjauan Pustaka",
//                 0
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Selasa, 11/10/2022",
//                 "Membuat Metodologi",
//                 0
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Rabu, 12/10/2022",
//                 "Melengkapi data",
//                 0
//         ));
//         ListLogbook.add(new Listlogbook(
//                 "Kamis, 13/10/2022",
//                 "Revisi Bab Pendahuluan",
//                 0
//         ));
//        return ListLogbook;
//         return null;
//     }

//    @Override
//    public void onListLogbookClick(Listlogbook listlogbook) {
//        Intent intentdetaillb = new Intent(this,DetailLogbookActivity.class);
//        intentdetaillb.putExtra("TGLLB",listlogbook.getTanggallb());
//        intentdetaillb.putExtra("DSKRLB",listlogbook.getDeskripsilb());
//        startActivity(intentdetaillb);
//    }
//
//    public void openDetailLogbook(){
//        Intent intentdetaillogbook = new Intent(this,DetailLogbookActivity.class);
//        startActivity(intentdetaillogbook);
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_profile, menu);
//        return true;
//    }


}