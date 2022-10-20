package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.tbptb_b.k16_dosen.adapter.psid_adapter;
import com.tbptb_b.k16_dosen.models.psid_model;

import java.util.ArrayList;

public class SidangPersetujuanActivity extends AppCompatActivity implements psid_adapter.ItempsidClickListener{

    private RecyclerView rvpsid;
    CardView CrdJsem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidang_persetujuan);

        rvpsid = findViewById(R.id.rv_psid);

        psid_adapter psidadapter = new psid_adapter(getpsid_model());
        psidadapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvpsid.setLayoutManager(layoutManager);
        rvpsid.setAdapter(psidadapter);

        CrdJsem = findViewById(R.id.card_jsid);
        CrdJsem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetujuSidang();
            }
        });
    }

    private void SetujuSidang() {
        Intent intentssem = new Intent(this, DSidang2Activity.class);
        startActivity(intentssem);
    }

    public ArrayList<psid_model> getpsid_model(){
        ArrayList<psid_model> listpsid_model = new ArrayList<>();

        listpsid_model.add(new psid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016"

        ));

        listpsid_model.add(new psid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla saraswati",
                "2011523012"

        ));

        listpsid_model.add(new psid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001"

        ));
        listpsid_model.add(new psid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016"

        ));

        listpsid_model.add(new psid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla saraswati",
                "2011523012"

        ));

        listpsid_model.add(new psid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001"

        ));
        listpsid_model.add(new psid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016"

        ));

        listpsid_model.add(new psid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla saraswati",
                "2011523012"

        ));

        listpsid_model.add(new psid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001"

        ));

        return listpsid_model;
    }


    @Override
    public void onitempsidClick(psid_model psidmodel) {
//        Intent dpsidIntent = new Intent(this, DSidang2Activity.class);
//
//        startActivity(dpsidIntent);
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