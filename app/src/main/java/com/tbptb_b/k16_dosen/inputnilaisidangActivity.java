package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tbptb_b.k16_dosen.datamodels.GetInputNSResponse;
import com.tbptb_b.k16_dosen.datamodels.GetListSidangResponse;
import com.tbptb_b.k16_dosen.datamodels.SeminarsItem;
import com.tbptb_b.k16_dosen.retrofit.RetrofitClient;
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
    int idThesis;
//    SharedPreferences sharedPreferences;
//    String getToken, token, grade;
//    EditText isigradeins;
//    Button buttonINS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputnilaisidang);

        Intent intentinNSid = getIntent();
        if (intentinNSid != null) {
            jadwalSid = intentinNSid.getStringExtra("Jadwalsid");
            namaMhs = intentinNSid.getStringExtra("Namasid");
            nimMhs = intentinNSid.getStringExtra("Nimsid");
            JTASid = intentinNSid.getStringExtra("JTAsid");


            jadwalinNSid = findViewById(R.id.isijadwalins);
            jadwalinNSid.setText (jadwalSid);

            namainNSid = findViewById(R.id.namains);
            namainNSid.setText(namaMhs);

            niminNSid = findViewById(R.id.nimins);
            niminNSid.setText(nimMhs);

            JTAinNSid = findViewById(R.id.isiJTAins);
            JTAinNSid.setText(JTASid);

            idThesis = intentinNSid.getIntExtra("ïdThesis", 0);
        }

//        //INPUT NILAI
//        buttonINS = findViewById(R.id.buttonINS);
//        cekInput();
//        isigradeins = findViewById(R.id.isigradeins);
    }
//
//    private void cekInput() {
//        grade = isigradeins.getText().toString();
//        sharedPreferences = getSharedPreferences("com.example.dosenklp1.SHARED_KEY", Context.MODE_PRIVATE);
//        getToken = sharedPreferences.getString("token", "");
//        token = "Bearer " + getToken;
//
//        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
//        String token = sharedPref.getString("TOKEN", "");
//
//        StoryClient storyClient = RetrofitClient.getService();
//        Call<GetInputNSResponse> call = storyClient.grade(277, grade , "Bearer " + token);
//        Log.d("idthes", idThesis + token );
//        call.enqueue(new Callback<GetInputNSResponse>() {
//            @Override
//            public void onResponse(Call<GetInputNSResponse> call, Response<GetInputNSResponse> response) {
//                GetInputNSResponse getInputNSResponse = response.body();
//                if(getInputNSResponse.getStatus().equals("success")) {
//                    Intent intent = new Intent(getApplication(), SidangjActivity.class);
//                    intent.putExtra("id", idThesis);
//                    startActivity(intent);
//                }
//            }
//            @Override
//            public void onFailure(Call<GetInputNSResponse> call, Throwable t) {
//
//            }
//        });
//    }

//    public void batal(View view) {
//        Intent batal = new Intent(this, SidangjActivity.class);
//        batal.putExtra("id", idThesis);
//        startActivity(batal);
//    }

//    public void InputNilai(View view) {
//        grade = isigradeins.getText().toString();
//        sharedPreferences = getSharedPreferences("com.example.dosenklp1.SHARED_KEY", Context.MODE_PRIVATE);
//        getToken = sharedPreferences.getString("token", "");
//        token = "Bearer " + getToken;
//
//        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
//        String token = sharedPref.getString("TOKEN", "");
//
//        StoryClient storyClient = RetrofitClient.getService();
//        Call<GetInputNSResponse> call = storyClient.grade(277, grade , "Bearer " + token);
//        Log.d("idthes", idThesis + token );
//        call.enqueue(new Callback<GetInputNSResponse>() {
//            @Override
//            public void onResponse(Call<GetInputNSResponse> call, Response<GetInputNSResponse> response) {
//                GetInputNSResponse getInputNSResponse = response.body();
//                if(getInputNSResponse.getStatus().equals("success")) {
//                    Intent intent = new Intent(getApplication(), SidangjActivity.class);
//                    intent.putExtra("id", idThesis);
//                    startActivity(intent);
//                }
//            }
//            @Override
//            public void onFailure(Call<GetInputNSResponse> call, Throwable t) {
//
//            }
//        });
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void buttonINS(View view){
        Intent buttonINS = new Intent(inputnilaisidangActivity.this, TambahnilaiSidangActivity.class);
        startActivity(buttonINS);
    }

}