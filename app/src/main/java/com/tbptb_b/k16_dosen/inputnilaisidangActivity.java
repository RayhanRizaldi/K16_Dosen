package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class inputnilaisidangActivity extends AppCompatActivity {

    String Mnama_jsid,nim_jsid,jadwal_jsid,JTA_jsid;
    TextView namains,nimins, isijadwalins, isiJTAins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputnilaisidang);

        Intent detailIntentJsidang = getIntent();
        if(detailIntentJsidang != null){
            Mnama_jsid = detailIntentJsidang.getStringExtra("Mnama_jsid");
            namains = findViewById(R.id.namads2);
            namains.setText(Mnama_jsid);

            nim_jsid = detailIntentJsidang.getStringExtra("nim_jsid");
            nimins = findViewById(R.id.nimds2);
            nimins.setText(nim_jsid);

            jadwal_jsid = detailIntentJsidang.getStringExtra("jadwal_jsid");
            isijadwalins = findViewById(R.id.isijadwalds2);
            isijadwalins.setText(jadwal_jsid);

            JTA_jsid = detailIntentJsidang.getStringExtra("JTA_jsid");
            isiJTAins = findViewById(R.id.isiJTAds2);
            isiJTAins.setText(JTA_jsid);
        }

    }
}