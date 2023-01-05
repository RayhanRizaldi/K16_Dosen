package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tbptb_b.k16_dosen.datamodels.GetInputNSResponse;
import com.tbptb_b.k16_dosen.retrofit.RetrofitClient;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahnilaiSidangActivity extends AppCompatActivity {
    TextView jadwalTNS,namaTNS, nimTNS,JTATNS;
    String jadwaltns,namatns, nimtns,JTAtns;
    Button buttonTNS;
    int idThesis;
    SharedPreferences sharedPreferences;
    String getToken, token, grade;
    EditText isigradeTNS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahnilai_sidang);

        //INPUT NILAI
        buttonTNS = findViewById(R.id.buttonTNS);
        isigradeTNS = (EditText) findViewById(R.id.isigradeTNS);

        cekInput();
    }

    private void cekInput() {
        grade = isigradeTNS.getText().toString();
        sharedPreferences = getSharedPreferences("com.example.dosenklp1.SHARED_KEY", Context.MODE_PRIVATE);
        getToken = sharedPreferences.getString("token", "");
        token = "Bearer " + getToken;

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        StoryClient storyClient = RetrofitClient.getService();
        Call<GetInputNSResponse> call = storyClient.grade(277, grade , "Bearer " + token);
        Log.d("idthes", idThesis + token );
        call.enqueue(new Callback<GetInputNSResponse>() {
            @Override
            public void onResponse(Call<GetInputNSResponse> call, Response<GetInputNSResponse> response) {
                GetInputNSResponse getInputNSResponse = response.body();
                if(getInputNSResponse.getStatus().equals("success")) {
                    Intent intent = new Intent(getApplication(), inputnilaisidangActivity.class);
                    intent.putExtra("id", idThesis);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<GetInputNSResponse> call, Throwable t) {

            }
        });
    }

    public void InputNilai(View view) {
        grade = isigradeTNS.getText().toString();
        sharedPreferences = getSharedPreferences("com.example.dosenklp1.SHARED_KEY", Context.MODE_PRIVATE);
        getToken = sharedPreferences.getString("token", "");
        token = "Bearer " + getToken;

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        StoryClient storyClient = RetrofitClient.getService();
        Call<GetInputNSResponse> call = storyClient.grade(277, grade , "Bearer " + token);
        Log.d("idthes", idThesis + token );
        call.enqueue(new Callback<GetInputNSResponse>() {
            @Override
            public void onResponse(Call<GetInputNSResponse> call, Response<GetInputNSResponse> response) {
                GetInputNSResponse getInputNSResponse = response.body();
                if(getInputNSResponse.getStatus().equals("success")) {
                    Intent intent = new Intent(getApplication(),inputnilaisidangActivity.class);
                    intent.putExtra("id", idThesis);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<GetInputNSResponse> call, Throwable t) {

            }
        });
    }
//    private void back() {
//        Intent intent = new Intent(TambahnilaiSidangActivity.this, inputnilaisidangActivity.class);
//        startActivity(intent);
//    }

//    public void buttonTNS(View view){
//        Intent buttonTNS = new Intent(TambahnilaiSidangActivity.this, inputnilaisidangActivity.class);
//        startActivity(buttonTNS);
//    }
}