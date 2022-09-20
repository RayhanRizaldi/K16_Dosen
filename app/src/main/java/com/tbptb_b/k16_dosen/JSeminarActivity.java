package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class JSeminarActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdaptorDataRV adapterDataRV;
    List<String> listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jseminar);

        recyclerView = findViewById(R.id.rvData);
        listData = new ArrayList<>();

        for (int i=0; i<10; i++){
            listData.add("data Ke "+i);

        }
        linearLayoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterDataRV = new AdaptorDataRV(this, listData);
        recyclerView.setAdapter(adapterDataRV);
        adapterDataRV.notifyDataSetChanged();
    }
}