package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DSidang2Activity extends AppCompatActivity {

    String Mnama_psid,nim_psid,jadwal_psid;
    TextView namads2,nimds2, isijadwalds2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsidang2);

        Intent detailIntentpsidang = getIntent();
        if(detailIntentpsidang != null){
            Mnama_psid = detailIntentpsidang.getStringExtra("Mnama_psid");
            namads2 = findViewById(R.id.namads2);
            namads2.setText(Mnama_psid);

            nim_psid = detailIntentpsidang.getStringExtra("nim_psid");
            nimds2 = findViewById(R.id.nimds2);
            nimds2.setText(nim_psid);

            jadwal_psid = detailIntentpsidang.getStringExtra("jadwal_psid");
            isijadwalds2 = findViewById(R.id.isijadwalds2);
            isijadwalds2.setText(jadwal_psid);
        }

    }
}