package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tbptb_b.k16_dosen.models.ListNamaMahasiswa;

import java.util.ArrayList;

public class SetujuBbmTA extends AppCompatActivity {

    private RecyclerView rvListmaba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setuju_bbm_ta);

        rvListmaba = findViewById(R.id.rv_listbbm);

        Adapter2 adapter = new Adapter2(getListNamaMahasiswa());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvListmaba.setLayoutManager(layoutManager);
        rvListmaba.setAdapter(adapter);
    }
    public ArrayList<ListNamaMahasiswa> getListNamaMahasiswa(){
        ArrayList<ListNamaMahasiswa> listnamamhs = new ArrayList<>();
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Budy Bahahahaha",
                2011623912
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Alfred Alfonso",
                98303928
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Xavier the Third",
                33333333
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Nadila Saraswati",
                2011521004
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Budy Bahahahaha",
                2011623912
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Alfred Alfonso",
                98303928
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Xavier the Third",
                33333333
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Nadila Saraswati",
                2011521004
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Budy Bahahahaha",
                2011623912
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Alfred Alfonso",
                98303928
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Xavier the Third",
                33333333
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Nadila Saraswati",
                2011521004
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Budy Bahahahaha",
                2011623912
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Alfred Alfonso",
                98303928
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Xavier the Third",
                33333333
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Nadila Saraswati",
                2011521004
        ));
        return listnamamhs;


    }

    public void openDetailta(){
        Intent intentdetailta = new Intent(this,SetujuBbmTA.class);
        startActivity(intentdetailta);
    }
    public void openBimbinganta(){
        Intent intentbbmta = new Intent(this,SetujuBbmTA.class);
        startActivity(intentbbmta);
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