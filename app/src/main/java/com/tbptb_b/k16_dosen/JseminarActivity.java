package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tbptb_b.k16_dosen.models.jadwal_seminar;

import java.util.ArrayList;

public class JseminarActivity extends AppCompatActivity {
    private RecyclerView rvjsem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jseminar);

        rvjsem = findViewById(R.id. rv_jseminar);

        AdapterJSem adapter = new AdapterJSem (getjadwal_seminar());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvjsem.setLayoutManager(layoutManager);
        rvjsem.setAdapter(adapter);
    }

    public ArrayList<jadwal_seminar> getjadwal_seminar(){
        ArrayList<jadwal_seminar> listjsem = new ArrayList<>();
        listjsem.add(new jadwal_seminar(
                null,
                "senin, 10 oktober 2022",
                "winanda afrilia harisya",
                "2011522016",
                "Perancangan sistem informasi Bank Soal FTI"

        ));

        listjsem.add(new jadwal_seminar(
                null,
                "senin, 17 oktober 2022",
                "nadilla saraswati",
                "2011523012",
                "Perancangan Sistem Pengambilan Keputusan"

        ));

        return listjsem;
    }
}