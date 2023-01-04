package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.tbptb_b.k16_dosen.retrofit.RetrofitClient;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;
import com.tbptb_b.k16_dosen.retrofit.detailta.DetailTAResponse;
import com.tbptb_b.k16_dosen.retrofit.detailta.SupervisorsItem;
import com.tbptb_b.k16_dosen.retrofit.listmahasiswa.ListMhsMenuResponse;
import com.tbptb_b.k16_dosen.retrofit.listmahasiswa.ThesesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTAActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageButton buttonmenupilihan;
    TextView textNamaMhs, textNimMhs;
    EditText textTitle, textDospem;
    ImageView imageAvatar;
    String namaMhs, nimMhs, TitleTa;
    String tokenboi, token;
    int iD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ta);

//        buttonmenupilihan = findViewById(R.id.iconList);
//        buttonmenupilihan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPilihan();
//            }
//        });

        Intent intentdetailta = getIntent();
        if (intentdetailta != null) {
            iD = intentdetailta.getIntExtra("ID",0);
//            nimMhs = intentdetailta.getStringExtra("NIMMHSBB");
//            textNamaMhs = findViewById(R.id.textNamaMhs);
//            textNamaMhs.setText(namaMhs);
//            textNimMhs = findViewById(R.id.textNimMhs);
//            textNimMhs.setText(nimMhs);
        }



        StoryClient mainInterface = RetrofitClient.getService();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("prefs",MODE_PRIVATE);
        tokenboi = sharedPreferences.getString("TOKEN","");
        token = "Bearer" + tokenboi;
//        Toast.makeText(DetailTAActivity.this, token, Toast.LENGTH_SHORT).show();


        Call<DetailTAResponse> call = mainInterface.detailTAmahasiswa(token,iD);
//        Call<SupervisorsItem> callSv = mainInterface.detailSv(token);
        call.enqueue(new Callback<DetailTAResponse>() {
            @Override
            public void onResponse(Call<DetailTAResponse> call, Response<DetailTAResponse> response) {
                Log.d("menuListmahasiswa-Debug",response.toString());
                DetailTAResponse detailTA = response.body();

                if (detailTA != null /*|| detailTA.getId() == iD*/) {
                    namaMhs = detailTA.getStudent().getName();
                    nimMhs = detailTA.getStudent().getNim();
                    TitleTa = detailTA.getTitle();

                    textNamaMhs = findViewById(R.id.textNamaMhs);
                    textNimMhs = findViewById(R.id.textNimMhs);
                    textTitle = findViewById(R.id.editTextJudul);
                    textDospem = findViewById(R.id.editTextDospem);

                    textNamaMhs.setText(namaMhs);
                    textNimMhs.setText(nimMhs);
                    textTitle.setText(TitleTa);


//                    for (DetailTAResponse.Super datum : datumList) {
//                        displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
//                    }

//                                        callSv.enqueue(new Callback<SupervisorsItem>() {
//                                            @Override
//                                            public void onResponse(Call<SupervisorsItem> callSv, Response<SupervisorsItem> responseSv) {
//                                                Log.d("menuListmahasiswa-Debug",responseSv.toString());
//                                                SupervisorsItem detailSv = responseSv.body();
//
//                                                if (detailSv != null) {
//                                                    textDospem.setText("detailSv.getName()");
//                                                    Toast.makeText(DetailTAActivity.this, "token", Toast.LENGTH_SHORT).show();
//
//                                                }
//
//                                            }
//
//                                            @Override
//                                            public void onFailure(Call<SupervisorsItem> callSv, Throwable t) {
//
//                                            }
//                                        });
                }

            }

            @Override
            public void onFailure(Call<DetailTAResponse> call, Throwable t) {

            }
        });
    }

    public void popUpDetailTA(View vp) {
        PopupMenu popTa = new PopupMenu(this, vp);
        popTa.setOnMenuItemClickListener(this);
        popTa.inflate(R.menu.menu_popup);
        popTa.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.buttonDetailMahasiswa:
                Intent intentdetailMahasiswa = new Intent(this, DetailMahasiswa.class);
                startActivity(intentdetailMahasiswa);
                return true;
            case R.id.buttonPilihanLogbook:
                Intent intentlogbook = new Intent(this, LogbookActivity.class);
                startActivity(intentlogbook);
                return true;
            case R.id.buttonPilihanDetailSeminar:
                Intent intentdetailseminar = new Intent(this, DetailSeminarActivity.class);
                intentdetailseminar.putExtra("NMHSBB", namaMhs);
                intentdetailseminar.putExtra("NIMMHSBB", nimMhs);
                startActivity(intentdetailseminar);
                return true;
            case R.id.buttonPilihanDetailSidang:
                Intent intentdetailsidang = new Intent(this, DetailSidangActivity.class);
                intentdetailsidang.putExtra("NMHSBB", namaMhs);
                intentdetailsidang.putExtra("NIMMHSBB", nimMhs);
                startActivity(intentdetailsidang);
                return true;
            case R.id.buttonPilihanPembatalan:
                Intent intentpembatalanTa = new Intent(this, PembatalanTaActivity.class);
                intentpembatalanTa.putExtra("NMHSBB", namaMhs);
                intentpembatalanTa.putExtra("NIMMHSBB", nimMhs);
                startActivity(intentpembatalanTa);
                return true;
            default:
                return false;
        }
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