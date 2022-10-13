package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailSidangActivity extends AppCompatActivity  {
    TextView textNim3,textNama3;
    ImageView imageAvatar;
    String namaMhs, nimMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);

        Intent intentdetailsdng = getIntent();
        if (intentdetailsdng != null) {
            namaMhs = intentdetailsdng.getStringExtra("NMHSBB");
            nimMhs = intentdetailsdng.getStringExtra("NIMMHSBB");
            textNama3 = findViewById(R.id.textNama3);
            textNama3.setText(namaMhs);
            textNim3 = findViewById(R.id.textNim3);
            textNim3.setText(nimMhs);
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