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
        buttonTNS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(isigradeTNS.getText().toString())){
                    Toast.makeText(TambahnilaiSidangActivity.this,"Inputkan Nilai",Toast.LENGTH_SHORT).show();
                }else{
                    save();
                }
            }
        });
    }

    private void save() {
        String grade = isigradeTNS.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        StoryClient storyClient = RetrofitClient.getService();
        Call<GetInputNSResponse> call = storyClient.patchnilai(277, grade , "Bearer " + token);
        call.enqueue(new Callback<GetInputNSResponse>() {
            @Override
            public void onResponse(Call<GetInputNSResponse> call, Response<GetInputNSResponse> response) {
                Log.d("TesPost", response.body().toString());
                Toast.makeText(TambahnilaiSidangActivity.this, "Input Nilai Berhasil, Grade : " +grade, Toast.LENGTH_SHORT).show();
                back();
            }

            @Override
            public void onFailure(Call<GetInputNSResponse> call, Throwable t) {
                Log.d("TestPost", t.getMessage().toString());
            }
        });
    }

    private void back() {
        Intent intent = new Intent(TambahnilaiSidangActivity.this, inputnilaisidangActivity.class);
        startActivity(intent);
    }

//    public void buttonTNS(View view){
//        Intent buttonTNS = new Intent(TambahnilaiSidangActivity.this, inputnilaisidangActivity.class);
//        startActivity(buttonTNS);
//    }
}