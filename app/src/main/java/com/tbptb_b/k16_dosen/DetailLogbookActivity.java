package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailLogbookActivity extends AppCompatActivity {

    Button buttonUlasanLogbook;

    TextView textViewTanggalLogbook;
    EditText editTextKegiatanLogbook;
    String tanggallb, deskripsilb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);

        Intent intentdetaillb = getIntent();
        if(intentdetaillb != null){
            tanggallb = intentdetaillb.getStringExtra("TGLLB");
            deskripsilb = intentdetaillb.getStringExtra("DSKRLB");
            textViewTanggalLogbook = findViewById(R.id.textViewTanggalLogbook);
            textViewTanggalLogbook.setText(tanggallb);
            editTextKegiatanLogbook = findViewById(R.id.editTextKegiatanLogbook);
            editTextKegiatanLogbook.setText(deskripsilb);
        }

        buttonUlasanLogbook = findViewById(R.id.buttonUlasanLogbook);
        buttonUlasanLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUlasan();
            }
        });
    }

    public void openUlasan(){
        Intent intentulasan = new Intent(this,UlasanLbActivity.class);
        startActivity(intentulasan);
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