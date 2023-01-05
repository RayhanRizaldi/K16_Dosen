package com.tbptb_b.k16_dosen.rayhan;

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

import com.tbptb_b.k16_dosen.DetailSeminarActivity;
import com.tbptb_b.k16_dosen.DetailSidangActivity;
import com.tbptb_b.k16_dosen.LogbookActivity;
import com.tbptb_b.k16_dosen.PembatalanTaActivity;
import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.adapter.AdapterSupervisors;
import com.tbptb_b.k16_dosen.retrofit.RetrofitClient;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;
import com.tbptb_b.k16_dosen.retrofit.detailta.DetailTAResponse;
import com.tbptb_b.k16_dosen.retrofit.detailta.SupervisorsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTAActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageButton buttonmenupilihan;
    Button buttonDetailmahasiswa;
    TextView textNamaMhs, textNimMhs, textAbstrak;
    EditText textTitle, textDospem, textMulaiBimb;
    ImageView imageAvatar;
    String namaMhs;
    String nimMhs;
    String TitleTa, MulaiBbing, abstrak;
    SupervisorsItem namaDosen;
    String tokenboi, token;
    int iD;

    private AdapterSupervisors adapterDosen;



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


            StoryClient mainInterface = RetrofitClient.getService();
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("prefs",MODE_PRIVATE);
            tokenboi = sharedPreferences.getString("TOKEN","");
            token = "Bearer" + tokenboi;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("ID2",iD);
            editor.apply();

//        Toast.makeText(DetailTAActivity.this, token, Toast.LENGTH_SHORT).show();

            int [] listdosen= {R.id.editTextDospem, R.id.editTextDospem2};
            List<String> list = new ArrayList<>();

//        String dos = new String();
//        adapterDosen = new AdapterSupervisors();

            Call<DetailTAResponse> call = mainInterface.detailTAmahasiswa(token,iD);
//        Call<SupervisorsItem> callSv = mainInterface.detailSv(token);
            call.enqueue(new Callback<DetailTAResponse>() {
                @Override
                public void onResponse(Call<DetailTAResponse> call, Response<DetailTAResponse> response) {
                    Log.d("detailTAmahasiswa-Debug",response.toString());
                    DetailTAResponse detailTA = response.body();
//                    Toast.makeText(DetailTAActivity.this, "halo"+iD, Toast.LENGTH_SHORT).show();

                    if (detailTA != null /*|| detailTA.getId() == iD*/) {

//                    adapterDosen.getDataDosen().get(5);
//                    adapterDosen.getDataDosen();

                        namaMhs = detailTA.getStudent().getName();
                        nimMhs = detailTA.getStudent().getNim();
                        TitleTa = detailTA.getTitle();
                        MulaiBbing = detailTA.getStartAt();
                        abstrak = detailTA.getJsonMemberAbstract();
//                    namaDosen = detailTA.getSupervisors().get(3);

                        textNamaMhs = findViewById(R.id.textNamaMhs);
                        textNimMhs = findViewById(R.id.textNimMhs);
                        textTitle = findViewById(R.id.editTextJudul);
//                    textDospem = findViewById(R.id.editTextDospem);
                        textMulaiBimb = findViewById(R.id.editTextMulaiBimb);
                        textAbstrak = findViewById(R.id.textAbstrak);

                        textNamaMhs.setText(namaMhs);
                        textNimMhs.setText(nimMhs);
                        textTitle.setText(TitleTa);
//                    textDospem.setText((CharSequence) namaDosen);
                        textMulaiBimb.setText(MulaiBbing);
                        textAbstrak.setText(abstrak);

                        try {
                            for (int a = 0 ; a<detailTA.getSupervisors().size() ; a++){
                                String dospem = detailTA.getSupervisors().get(a).getName();
                                list.add(dospem);
                            }
                            for (int b = 0; b < listdosen.length; b++){
                                ((TextView)findViewById(listdosen[b])).setText(list.get(b));
                            }

                        }catch (IndexOutOfBoundsException e){
//                        Toast.makeText(DetailTAActivity.this, "", Toast.LENGTH_SHORT).show();
                        }



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

//            buttonDetailmahasiswa = findViewById(R.id.buttondMahasiswa);
//            buttonDetailmahasiswa.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intentdetailMahasiswa = new Intent(DetailTAActivity.this,DetailMahasiswa.class);
//                    int bungtolonglah = iD;
//                    intentdetailMahasiswa.putExtra("IDToast", bungtolonglah);
//                    startActivity(intentdetailMahasiswa);
//
//                }
//            });
        }



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
                Intent intentdetailMahasiswa = new Intent(DetailTAActivity.this,DetailMahasiswa.class);
                int bungtolonglah = iD;
                intentdetailMahasiswa.putExtra("IDToast", bungtolonglah);
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