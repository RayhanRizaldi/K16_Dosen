package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class LogbookActivity extends AppCompatActivity {
Button buttondetaillb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);

//        buttondetaillb = findViewById(R.id.buttondetaillogbook);
//        buttondetaillb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDetailLogbook();
//            }
//        });
    }

//    public void openDetailLogbook(){
//        Intent intentdetaillogbook = new Intent(this,DetailLogbookActivity.class);
//        startActivity(intentdetaillogbook);
//    }
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