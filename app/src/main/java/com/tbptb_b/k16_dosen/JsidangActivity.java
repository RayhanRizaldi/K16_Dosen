package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tbptb_b.k16_dosen.adapter.jsem_adapter;
import com.tbptb_b.k16_dosen.adapter.jsid_adapter;
import com.tbptb_b.k16_dosen.models.jsem_model;
import com.tbptb_b.k16_dosen.models.jsid_model;

import java.util.ArrayList;
//4.tambahkan implementasi
public class JsidangActivity extends AppCompatActivity implements jsid_adapter.ItemjsidClickListener{

    //1.
    private RecyclerView rvjsid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsidang);

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

        return listjsid_model;
    }

    @Override
    public void onItemjsidClick(jsid_model jsidmodel) {
        Intent detailIntentJsidang = new  Intent (this, inputnilaisidangActivity.class);
        detailIntentJsidang.putExtra("Mnama_jsid",jsidmodel.getMnama_jsid());
        detailIntentJsidang.putExtra("nim_jsid", jsidmodel.getNim_jsid());
        detailIntentJsidang.putExtra("jadwal_jsid", jsidmodel.getJadwal_jsid());
        detailIntentJsidang.putExtra("JTA_jsid", jsidmodel.getJTA_jsid());
        startActivity(detailIntentJsidang);

    }
}