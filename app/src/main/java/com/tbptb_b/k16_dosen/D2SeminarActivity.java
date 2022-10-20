package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class D2SeminarActivity extends AppCompatActivity {

    TextView TextnamaDs2, textnimDs2;
    String namaMhs, nimMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d2_seminar);

        Intent intentdetailta = getIntent();
        if (intentdetailta != null) {
            namaMhs = intentdetailta.getStringExtra("NMHSJSEM");
            nimMhs = intentdetailta.getStringExtra("NIMMHSJSEM");
            TextnamaDs2 = findViewById(R.id.TextnamaDs2);
            TextnamaDs2.setText(namaMhs);
            textnimDs2 = findViewById(R.id.textnimDs2);
            textnimDs2.setText(nimMhs);
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