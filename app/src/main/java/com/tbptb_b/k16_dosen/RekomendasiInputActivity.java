package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RekomendasiInputActivity extends AppCompatActivity {
    TextView namainNSid, niminNSid;
    String namaMhs, nimMhs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi_input);

        Button buttonrekom = findViewById(R.id.buttonrekom);

        buttonrekom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RekomendasiInputActivity.this, detail_ri.class));
            }
        });

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
            getMenuInflater().inflate(R.menu.menu_profile, menu);
            return true;
        }
}