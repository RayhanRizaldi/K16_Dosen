package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class PilihanActivity extends AppCompatActivity {
    Button buttonlogbook;
    Button buttondetailseminar;
    Button buttondetailsidang;
    Button buttonpembatalanta;
    Button buttoninputnilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan);

        buttonlogbook = findViewById(R.id.buttonPilihanLogbook);
        buttonlogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogbook();
            }
        });

        buttondetailseminar = findViewById(R.id.buttonPilihanDetailSeminar);
        buttondetailseminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailSeminar();
            }
        });

        buttondetailsidang = findViewById(R.id.buttonPilihanDetailSidang);
        buttondetailsidang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openDetailSidang();}
        });
    }

    public void openLogbook(){
        Intent intentlogbook = new Intent(this,LogbookActivity.class);
        startActivity(intentlogbook);
    }

    public void openDetailSeminar(){
        Intent intentdetailseminar = new Intent(this,DetailSeminarActivity.class);
        startActivity(intentdetailseminar);
    }

    public void openDetailSidang(){
        Intent intentdetailsidang = new Intent(this, DetailSidangActivity.class);
        startActivity(intentdetailsidang);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_profile, menu);
//        return true;
//    }
}