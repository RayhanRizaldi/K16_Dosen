package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.tbptb_b.k16_dosen.adapter.jsid_adapter;
import com.tbptb_b.k16_dosen.models.jsid_model;

import java.util.ArrayList;

public class JadwalSidangActivity extends AppCompatActivity implements jsid_adapter.ItemjsidClickListener{

    //1.
    private RecyclerView rvjsid;
    Button SetujuSid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_sidang);

        //2.
        rvjsid = findViewById(R.id.rv_jsid);

        //2.1
        jsid_adapter jsidadapter = new jsid_adapter(getjsid_model());
        //5.
        jsidadapter.setListner(this);
        //2.2
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //2.3
        rvjsid.setLayoutManager(layoutManager);
        rvjsid.setAdapter(jsidadapter);

        SetujuSid = findViewById(R.id.button_jsid);
        SetujuSid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SidangApprove();
            }
        });

    }

    private void SidangApprove() {
        Intent intentssid = new Intent(this, DetailListSidangActivity.class);
        startActivity(intentssid);
    }

    //3. tambahkan method untuk membuat arraylist-> ganti ner arraylist... pada oncreat dengan getjsem_model()
    public ArrayList<jsid_model> getjsid_model(){
        ArrayList<jsid_model> listjsid_model = new ArrayList<>();

        //3.1 tambahkan data yang akan dimasukkan pada list ->lanjut ke adapter
        listjsid_model.add(new jsid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016",
                "Perancangan SPK pemilihan cafe terbaik disekitar unand"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla sarawati",
                "2011523012",
                "Perancangan Sistem informasi TA"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001",
                "Perancangan SPK pemilihan makanan kucing terbaik"

        ));
        listjsid_model.add(new jsid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016",
                "Perancangan SPK pemilihan cafe terbaik disekitar unand"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla sarawati",
                "2011523012",
                "Perancangan Sistem informasi TA"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001",
                "Perancangan SPK pemilihan makanan kucing terbaik"

        ));
        listjsid_model.add(new jsid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016",
                "Perancangan SPK pemilihan cafe terbaik disekitar unand"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla sarawati",
                "2011523012",
                "Perancangan Sistem informasi TA"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001",
                "Perancangan SPK pemilihan makanan kucing terbaik"

        ));

        return listjsid_model;
    }

    @Override
    public void onItemjsidClick(jsid_model jsidmodel) {
        Intent intentdesid2 = new Intent(this, inputnilaisidangActivity.class);
        intentdesid2.putExtra("NMHSJSID", jsidmodel.getMnama_jsid());
        intentdesid2.putExtra("NIMMHSJSID", jsidmodel.getNim_jsid());
        startActivity(intentdesid2);
    }
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