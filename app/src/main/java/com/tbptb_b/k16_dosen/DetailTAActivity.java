package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DetailTAActivity extends AppCompatActivity {
    ImageButton buttonmenupilihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ta);

        buttonmenupilihan = findViewById(R.id.iconList);
        buttonmenupilihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPilihan();
            }
        });
    }

    public void openPilihan(){
        Intent intentpilihan = new Intent(this,PilihanActivity.class);
        startActivity(intentpilihan);
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