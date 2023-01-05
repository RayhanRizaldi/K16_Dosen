package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.tbptb_b.k16_dosen.datamodels.GetListSidangResponse;
import com.tbptb_b.k16_dosen.datamodels.SeminarsItem;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class inputnilaisidangActivity extends AppCompatActivity {
    TextView jadwalinNSid,namainNSid, niminNSid,JTAinNSid;
    String jadwalSid,namaMhs, nimMhs,JTASid;
//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputnilaisidang);

        Intent intentinNSid = getIntent();
        if (intentinNSid != null) {
            jadwalSid = intentinNSid.getStringExtra("jadwalsid");
            namaMhs = intentinNSid.getStringExtra("NMHSJSID");
            nimMhs = intentinNSid.getStringExtra("NIMMHSJSID");
            JTASid = intentinNSid.getStringExtra("judulTAsid");


            jadwalinNSid = findViewById(R.id.isijadwalins);
            jadwalinNSid.setText (jadwalSid);

            namainNSid = findViewById(R.id.namains);
            namainNSid.setText(namaMhs);

            niminNSid = findViewById(R.id.nimins);
            niminNSid.setText(nimMhs);

            JTAinNSid = findViewById(R.id.isiJTAins);
            JTAinNSid.setText(JTASid);
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
//
//    public void buttonINS(View view){
//        Intent buttonINS = new Intent(inputnilaisidangActivity.this, inputnilaisidangActivity.class);
//        startActivity(buttonINS);
//    }

}