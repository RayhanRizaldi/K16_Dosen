package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tbptb_b.k16_dosen.models.Nilaitaresponse;
import com.tbptb_b.k16_dosen.retrofit.RetrofitClient;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NilTaActivity extends AppCompatActivity {

    Button savenilai;
    EditText nilaita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai_ta);


        savenilai = findViewById(R.id.buttonnilaita);
        nilaita = (EditText) findViewById(R.id.Editnilaita);

        cekInput();

    }

    private void cekInput() {
        savenilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(nilaita.getText().toString())){
                    Toast.makeText(NilTaActivity.this,"Inputkan Nilai",Toast.LENGTH_SHORT).show();
                }else{
                    save();
                }
            }
        });
    }

    private void save() {
        String grade = nilaita.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences("prefs",Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        StoryClient storyClient = RetrofitClient.getService();
        Call<Nilaitaresponse>call = storyClient.patchnilai(277, grade , "Bearer " + token);
        call.enqueue(new Callback<Nilaitaresponse>() {
            @Override
            public void onResponse(Call<Nilaitaresponse> call, Response<Nilaitaresponse> response) {
                Log.d("TesPost", response.body().toString());
                Toast.makeText(NilTaActivity.this, "Input Nilai Berhasil, Grade : " +grade, Toast.LENGTH_SHORT).show();
                back();
            }

            @Override
            public void onFailure(Call<Nilaitaresponse> call, Throwable t) {
                Log.d("TestPost", t.getMessage().toString());
            }
        });
    }

    private void back() {
        Intent intent = new Intent(NilTaActivity.this, DetailTAActivity.class);
        startActivity(intent);
    }

//











    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }
}