package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.tbptb_b.k16_dosen.adapter.jsid_adapter;
import com.tbptb_b.k16_dosen.models.jsid_model;

import java.util.ArrayList;

public class SeminarPersetujuanActivity extends AppCompatActivity  implements jsid_adapter.ItemjsidClickListener {
    private RecyclerView rvssem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar_persetujuan);
        rvssem = findViewById(R.id.rv_persetujuansem);

        jsid_adapter jsidadapter = new jsid_adapter(getpersetujuanseminar_model());
        jsidadapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvssem.setLayoutManager(layoutManager);
        rvssem.setAdapter(jsidadapter);


    }

    public ArrayList<jsid_model> getpersetujuanseminar_model() {
        ArrayList<jsid_model> listjsid_model = new ArrayList<>();

        listjsid_model.add(new jsid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla saraswati",
                "2011523012"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001"

        ));

        return listjsid_model;
    }

    @Override
    public void onitemjsidClick(jsid_model jsidmodel) {
        Intent dsemIntent = new Intent(this, DSeminar2Activity.class);

        startActivity(dsemIntent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}