package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class RekomendasiInputActivity extends AppCompatActivity {
    TextView namainNSid, niminNSid;
    String namaMhs, nimMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi_input);

        Intent intentRekomSem = getIntent();
        if (intentRekomSem != null) {
            namaMhs = intentRekomSem.getStringExtra("NMHSJSEM");
            nimMhs = intentRekomSem.getStringExtra("NIMMHSJSEM");
            namainNSid = findViewById(R.id.namarekom);
            namainNSid.setText(namaMhs);
            niminNSid = findViewById(R.id.nimrekom);
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
}