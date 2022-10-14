package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.tbptb_b.k16_dosen.adapter.jsem_adapter;
import com.tbptb_b.k16_dosen.models.jsem_model;

import java.util.ArrayList;
import java.util.Set;

//4.tambahkan implementasi
public class JseminarActivity extends AppCompatActivity implements jsem_adapter.ItemjsemClickListener{

    //1.
    private RecyclerView rvjsem;
    Button SetujuSem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jseminar);

        //2.
        rvjsem = findViewById(R.id.rv_jsem);

        //2.1
        jsem_adapter jsemadapter = new jsem_adapter(getjsem_model());
        //5.
        jsemadapter.setListner(this);
        //2.2
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //2.3
        rvjsem.setLayoutManager(layoutManager);
        rvjsem.setAdapter(jsemadapter);

        SetujuSem = findViewById(R.id.button_jsem);
        SetujuSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeminarApprove();
            }
        });

    }

    private void SeminarApprove() {
        Intent intentssem = new Intent(this, SeminarPersetujuanActivity.class);
        startActivity(intentssem);
    }

    //3. tambahkan method untuk membuat arraylist-> ganti ner arraylist... pada oncreat dengan getjsem_model()
    public ArrayList<jsem_model> getjsem_model(){
        ArrayList<jsem_model> listjsem_model = new ArrayList<>();

        //3.1 tambahkan data yang akan dimasukkan pada list ->lanjut ke adapter
        listjsem_model.add(new jsem_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016",
                "Perancangan SPK pemilihan cafe terbaik disekitar unand"

        ));

        listjsem_model.add(new jsem_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla sarawati",
                "2011523012",
                "Perancangan Sistem informasi TA"

        ));

        listjsem_model.add(new jsem_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001",
                "Perancangan SPK pemilihan makanan kucing terbaik"

        ));
        listjsem_model.add(new jsem_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016",
                "Perancangan SPK pemilihan cafe terbaik disekitar unand"

        ));

        listjsem_model.add(new jsem_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla sarawati",
                "2011523012",
                "Perancangan Sistem informasi TA"

        ));

        listjsem_model.add(new jsem_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001",
                "Perancangan SPK pemilihan makanan kucing terbaik"

        ));
        listjsem_model.add(new jsem_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016",
                "Perancangan SPK pemilihan cafe terbaik disekitar unand"

        ));

        listjsem_model.add(new jsem_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla sarawati",
                "2011523012",
                "Perancangan Sistem informasi TA"

        ));

        listjsem_model.add(new jsem_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001",
                "Perancangan SPK pemilihan makanan kucing terbaik"

        ));

        return listjsem_model;
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

    @Override
    public void onItemjsemClick(jsem_model jsemmodel) {
        //6.membuat Intent
        Intent intentdesem2 = new Intent(this, D2SeminarActivity.class);
        startActivity(intentdesem2);

    }
}