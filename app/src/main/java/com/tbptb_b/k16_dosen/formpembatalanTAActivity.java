package com.tbptb_b.k16_dosen;

import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.tbptb_b.k16_dosen.models.BatalTaResponse;
import com.tbptb_b.k16_dosen.retrofit.RetrofitClient;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

public class formpembatalanTAActivity extends AppCompatActivity {

    String token, getToken;
    Button buttonpembatalan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembatalan_ta);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");
        Log.d("PembatalanTA-Debug", token);
    }
    public void detailTA(View view) {
        buttonpembatalan = findViewById(R.id.buttonpembatalan);

        // Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient StoryClient = retrofit.create(StoryClient.class);
        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        getToken = sharedPref.getString("TOKEN", "");
        String token = "Bearer " + getToken;

        Call<BatalTaResponse> call = StoryClient.batalTA(token);
        call.enqueue(new Callback<BatalTaResponse>() {
            @Override
            public void onResponse(Call<BatalTaResponse> call, Response<BatalTaResponse> response) {
                BatalTaResponse pembatalanTugasAkhirResponse = response.body();
                Log.d("PembatalanTA-Debug", response.toString());
                if (pembatalanTugasAkhirResponse != null && pembatalanTugasAkhirResponse.getStatus().equals("success")) {
                    String message = pembatalanTugasAkhirResponse.getMessage();
                    Toast.makeText(formpembatalanTAActivity.this, message, Toast.LENGTH_SHORT).show();

                    SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("TOKEN", token);
                    editor.apply();

                    Intent mainIntent = new Intent(formpembatalanTAActivity.this, PembatalanTaActivity.class);
                    mainIntent.putExtra("IS_LOGGED_IN", true);
                    startActivity(mainIntent);
                }
            }

            @Override
            public void onFailure(Call<BatalTaResponse> call, Throwable t) {

            }
        });
    }
    public void buttonBackDetailTA(View view) {
        Intent DetailTugasAkhirIntent = new Intent(this, DetailTAActivity.class);
        DetailTugasAkhirIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(DetailTugasAkhirIntent);
        finish();
    }
}