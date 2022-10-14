package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class DetailTAActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageButton buttonmenupilihan;
    TextView textNamaMhs, textNimMhs;
    ImageView imageAvatar;
    String namaMhs, nimMhs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ta);

//        buttonmenupilihan = findViewById(R.id.iconList);
//        buttonmenupilihan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPilihan();
//            }
//        });
        Intent intentdetailta = getIntent();
        if (intentdetailta != null) {
            namaMhs = intentdetailta.getStringExtra("NMHSBB");
            nimMhs = intentdetailta.getStringExtra("NIMMHSBB");
            textNamaMhs = findViewById(R.id.textNamaMhs);
            textNamaMhs.setText(namaMhs);
            textNimMhs = findViewById(R.id.textNimMhs);
            textNimMhs.setText(nimMhs);
        }
    }

    public void popUpDetailTA(View vp) {
        PopupMenu popTa = new PopupMenu(this, vp);
        popTa.setOnMenuItemClickListener(this);
        popTa.inflate(R.menu.menu_popup);
        popTa.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.buttonPilihanLogbook:
                Intent intentlogbook = new Intent(this, LogbookActivity.class);
                startActivity(intentlogbook);
                return true;
            case R.id.buttonPilihanDetailSeminar:
                Intent intentdetailseminar = new Intent(this, DetailSeminarActivity.class);
                intentdetailseminar.putExtra("NMHSBB", namaMhs);
                intentdetailseminar.putExtra("NIMMHSBB", nimMhs);
                startActivity(intentdetailseminar);
                return true;
            case R.id.buttonPilihanDetailSidang:
                Intent intentdetailsidang = new Intent(this, DetailSidangActivity.class);
                intentdetailsidang.putExtra("NMHSBB", namaMhs);
                intentdetailsidang.putExtra("NIMMHSBB", nimMhs);
                startActivity(intentdetailsidang);
                return true;
            case R.id.buttonPilihanPembatalan:
                Intent intentpembatalanTa = new Intent(this, PembatalanTaActivity.class);
                intentpembatalanTa.putExtra("NMHSBB", namaMhs);
                intentpembatalanTa.putExtra("NIMMHSBB", nimMhs);
                startActivity(intentpembatalanTa);
                return true;
            default:
                return false;
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