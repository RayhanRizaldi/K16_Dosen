package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.tbptb_b.k16_dosen.adapter.jsid_adapter;
import com.tbptb_b.k16_dosen.models.jsem_model;
import com.tbptb_b.k16_dosen.models.jsid_model;

import java.util.ArrayList;

public class JsidangActivity extends AppCompatActivity implements jsid_adapter.ItemjsidClickListener{

    private RecyclerView rvjsid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsidang);

        rvjsid = findViewById(R.id.rv_jsid);

        jsid_adapter jsidadapter = new jsid_adapter(getjsid_model());
        jsidadapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvjsid.setLayoutManager(layoutManager);
        rvjsid.setAdapter(jsidadapter);

    }

    public ArrayList<jsid_model> getjsid_model(){
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
        Intent dsidIntent = new Intent(this, DSidang2Activity.class);

        startActivity(dsidIntent);

    }
}