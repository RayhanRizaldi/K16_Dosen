package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.tbptb_b.k16_dosen.R;

public class DSidang2Activity extends AppCompatActivity {

    TextView namains, nimins;
    String namaMhs, nimMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsidang2);

        Intent intentdetailta = getIntent();
        if (intentdetailta != null) {
            namaMhs = intentdetailta.getStringExtra("NMHSJSID");
            nimMhs = intentdetailta.getStringExtra("NIMMHSJSID");
            namains = findViewById(R.id.namains);
            namains.setText(namaMhs);
            nimins = findViewById(R.id.nimins);
            nimins.setText(nimMhs);
        }

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