package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailSeminarActivity extends AppCompatActivity {
    TextView textNim,textNama;
    ImageView imageAvatar;
    String namaMhs, nimMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);

        Intent intentdetailsmr = getIntent();
        if (intentdetailsmr != null) {
            namaMhs = intentdetailsmr.getStringExtra("NMHSBB");
            nimMhs = intentdetailsmr.getStringExtra("NIMMHSBB");
            textNama = findViewById(R.id.textNama2);
            textNama.setText(namaMhs);
            textNim = findViewById(R.id.textNim2);
            textNim.setText(nimMhs);
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