package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tbptb_b.k16_dosen.adapter.AdapterListMahasiswaMenu;
import com.tbptb_b.k16_dosen.retrofit.ListMhsMenuResponse;
import com.tbptb_b.k16_dosen.retrofit.RetrofitClient;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;
import com.tbptb_b.k16_dosen.retrofit.ThesesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainMenu extends AppCompatActivity implements AdapterListMahasiswaMenu.MhsBimbinganClickListener {

    Button setujubbmTA, JadwalSem, JadwalSid;
    //    private Boolean isLoggedIn = false;
    private RecyclerView rvListmahasiswa;
//    private Boolean isLoggedIn = false;
    private AdapterListMahasiswaMenu adapter;
    String tokenboi, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


//        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
//        String token = sharedPref.getString("TOKEN","");

        rvListmahasiswa = findViewById(R.id.rv_listbbm);
        rvListmahasiswa.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterListMahasiswaMenu();
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvListmahasiswa.setAdapter(adapter);

        StoryClient mainInterface = RetrofitClient.getService();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("prefs",MODE_PRIVATE);
        tokenboi = sharedPreferences.getString("TOKEN","");
        token = "Bearer" + tokenboi;
//        Toast.makeText(MainMenu.this, token, Toast.LENGTH_SHORT).show();

        Call<ListMhsMenuResponse> call = mainInterface.menuListmahasiswa(token);
        call.enqueue(new Callback<ListMhsMenuResponse>() {
            @Override
            public void onResponse(Call<ListMhsMenuResponse> call, Response<ListMhsMenuResponse> response) {
                Log.d("menuListmahasiswa-Debug",response.toString());
                ListMhsMenuResponse listmhsM = response.body();
                if (listmhsM != null) {
                    List<ThesesItem> tesis = listmhsM.getTheses();
                    adapter.setListMahasiswa((ArrayList<ThesesItem>) tesis);
                }

            }

            @Override
            public void onFailure(Call<ListMhsMenuResponse> call, Throwable t) {

            }
        });

        setujubbmTA = findViewById(R.id.more_bimbingan);
        setujubbmTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBimbinganta();
            }
        });
        JadwalSem = findViewById(R.id.more_seminar);
        JadwalSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSeminar();
            }
        });
        JadwalSid = findViewById(R.id.more_sidang);
        JadwalSid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSidang();
            }
        });
//        if(isLoggedIn == false){
//            Intent loginintent = new Intent(this, LoginActivity.class);
//            startActivity(loginintent);
//        }

//        dpbtt = findViewById(R.id.imageButtonListDetailMabim);
//        dpbtt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent detailIn = new Intent(MainMenu.this, DetailMahasiswa .class);
//                startActivity(detailIn);
//            }
//        });

    }

    public void openBimbinganta() {
        Intent intentbbmta = new Intent(this, SetujuBbmTA.class);
        startActivity(intentbbmta);
    }
    private void openSidang() {
        Intent intentsidang = new Intent(this, SidangjActivity.class);
        startActivity(intentsidang);
    }

    private void openSeminar() {
        Intent intentseminar = new Intent(this, JseminarActivity.class);
        startActivity(intentseminar);
    }

//    public ArrayList<ListNamaMahasiswa> getListNamaMahasiswa() {
//        ArrayList<ListNamaMahasiswa> listnamamhs = new ArrayList<>();
//        listnamamhs.add(new ListNamaMahasiswa(
//                null,
//                "Budy Bahahahaha",
//                2011623912
//        ));
//        listnamamhs.add(new ListNamaMahasiswa(
//                null,
//                "Alfred Alfonso",
//                98303928
//        ));
//        listnamamhs.add(new ListNamaMahasiswa(
//                null,
//                "Xavier the Third",
//                33333333
//        ));
//        listnamamhs.add(new ListNamaMahasiswa(
//                null,
//                "Nadila Saraswati",
//                2011521004
//        ));
//        return listnamamhs;
//
//
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_profile) {
            Intent MProfileIntent = new Intent(this, UserProfile.class);
            startActivity(MProfileIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void ClickMhsBimbingan(ThesesItem mhsbb) {
        Intent intentdetailta = new Intent(this, DetailTAActivity.class);
//        intentdetailta.putExtra("NMHSBB", mhsbb.getNamamhs());
//        intentdetailta.putExtra("NIMMHSBB", Integer.toString(mhsbb.getNimmhs()));
//        intentdetailta.putExtra("FMHS", mhsbb.getFotomhs());
        startActivity(intentdetailta);
    }

}