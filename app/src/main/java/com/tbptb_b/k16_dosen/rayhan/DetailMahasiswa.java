package com.tbptb_b.k16_dosen.rayhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.retrofit.RetrofitClient;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;
import com.tbptb_b.k16_dosen.retrofit.detailmahasiswa.DetailMahasiswaResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMahasiswa extends AppCompatActivity {
    Button buttonDetailta;
    String tokenboi, token, gendernya;
    int tahunAwal, gender;
    String namaMhs, nimMhs, tanggallahir, tempatlahir, nomorTelp;
    TextView textNamaMhs,texttahunAwal;
    EditText textNimMhs, textTtl, TextTmpt, TextTelp, TextGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        Intent intentdetailMahasiswa = getIntent();
        if (intentdetailMahasiswa != null) {
            StoryClient mainInterface = RetrofitClient.getService();
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("prefs",MODE_PRIVATE);
            tokenboi = sharedPreferences.getString("TOKEN","");
            token = "Bearer" + tokenboi;

            int iD1 = intentdetailMahasiswa.getIntExtra("IDToast", 0);

            Call<DetailMahasiswaResponse> call = mainInterface.detailMahasiswa(token,iD1);
            call.enqueue(new Callback<DetailMahasiswaResponse>() {
                @Override
                public void onResponse(Call<DetailMahasiswaResponse> call, Response<DetailMahasiswaResponse> response) {
                    Log.d("detailmahasiswa-Debug",response.toString());
                    DetailMahasiswaResponse detailMhs = response.body();

                if (detailMhs != null) {
//                    Toast.makeText(DetailMahasiswa.this, "halo"+iD1, Toast.LENGTH_SHORT).show();
                    namaMhs = detailMhs.getStudent().getName();
                    nimMhs = detailMhs.getStudent().getNim();
                    tahunAwal = detailMhs.getStudent().getYear();
                    tanggallahir = detailMhs.getStudent().getBirthday();
                    tempatlahir = detailMhs.getStudent().getBirthplace();
                    nomorTelp = detailMhs.getStudent().getPhone();
                    gender = detailMhs.getStudent().getGender();
                    if(gender ==1){
                        gendernya = "Laki-Laki";
                    }if(gender == 2){
                        gendernya = "Perempuan";
                    }


                    textNamaMhs = findViewById(R.id.nama_mahasiswa);
                    textNimMhs = findViewById(R.id.nim_mahasiswa);
                    texttahunAwal = findViewById(R.id.smtawal_mahasiswa);
                    textTtl = findViewById(R.id.tgllahir_mahasiswa);
                    TextTmpt = findViewById(R.id.tempatlahir_mahasiswa);
                    TextTelp = findViewById(R.id.telp_mahasiswa);
                    TextGender = findViewById(R.id.gender_mahasiswa);

                    textNamaMhs.setText(namaMhs);
                    textNimMhs.setText(nimMhs);
                    texttahunAwal.setText(String.valueOf(tahunAwal));
                    textTtl.setText(tanggallahir);
                    TextTmpt.setText(tempatlahir);
                    TextTelp.setText("0"+nomorTelp);
                    TextGender.setText(gendernya);
                }

                }

                @Override
                public void onFailure(Call<DetailMahasiswaResponse> call, Throwable t) {

                }
            });


//            buttonDetailta = findViewById(R.id.buttondetailta);
//            buttonDetailta.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent detailta = new Intent(DetailMahasiswa.this,DetailTAActivity.class);
//                    startActivity(detailta);
//                }
//            });

        }
//        Toast.makeText(DetailMahasiswa.this, iD, Toast.LENGTH_SHORT).show();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }
}