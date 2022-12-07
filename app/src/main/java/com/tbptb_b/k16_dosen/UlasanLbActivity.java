package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.tbptb_b.k16_dosen.adapter.listulasan_adapter;
import com.tbptb_b.k16_dosen.models.ListUlasan;

import java.util.ArrayList;

public class UlasanLbActivity extends AppCompatActivity{

    private RecyclerView rv_ulasanlb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasan_lb);

        rv_ulasanlb = findViewById(R.id.rv_ulasanmhs);

        listulasan_adapter adapter4 = new listulasan_adapter(getListUlasan());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rv_ulasanlb.setLayoutManager(layoutManager);
        rv_ulasanlb.setAdapter(adapter4);
    }

    public ArrayList<ListUlasan> getListUlasan() {
        ArrayList<ListUlasan> Listulasan = new ArrayList<>();
        Listulasan.add(new ListUlasan(
                "Senin, 1 Oktober 2022",
                "Coba lagi!"
        ));
        Listulasan.add(new ListUlasan(
                "Selasa, 2 Oktober 2022",
                "Lanjutkan!"
        ));
        return Listulasan;
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