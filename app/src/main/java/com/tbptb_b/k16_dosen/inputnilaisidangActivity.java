package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inputnilaisidangActivity extends AppCompatActivity {
    TextView jadwalinNSid,namainNSid, niminNSid;
    String jadwalSid,namaMhs, nimMhs;
//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputnilaisidang);

        Intent intentinNSid = getIntent();
        if (intentinNSid != null) {
            jadwalSid = intentinNSid.getStringExtra("jadwalsid");
            namaMhs = intentinNSid.getStringExtra("NMHSJSID");
            nimMhs = intentinNSid.getStringExtra("NIMMHSJSID");

            jadwalinNSid = findViewById(R.id.isijadwalins);
            jadwalinNSid.setText (jadwalSid);

            namainNSid = findViewById(R.id.namains);
            namainNSid.setText(namaMhs);

            niminNSid = findViewById(R.id.nimins);
            niminNSid.setText(nimMhs);
        }
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

    public void buttonINS(View view){
        Intent buttonINS = new Intent(inputnilaisidangActivity.this, TambahnilaiSidangActivity.class);
        startActivity(buttonINS);
    }

}