package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;


public class MainMenu extends AppCompatActivity {
ImageButton buttondetailta, dpbtt;
Button buttonsesi;
//    private Boolean isLoggedIn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

//        if(isLoggedIn == false){
//            Intent loginintent = new Intent(this, LoginActivity.class);
//            startActivity(loginintent);
//        }


        buttondetailta = findViewById(R.id.detailprofile);
        buttondetailta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailta();
            }
        });

        dpbtt = findViewById(R.id.detailprofile);
        dpbtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIn = new Intent(MainMenu.this, DetailMahasiswa .class);
                startActivity(detailIn);
            }
        });

        buttonsesi = findViewById(R.id.more_seminar);
        buttonsesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sesiIn = new Intent(MainMenu.this,JseminarActivity.class);
                startActivity(sesiIn);
            }
        });
    }

    public void openDetailta(){
        Intent intentdetailta = new Intent(this,DetailTAActivity.class);
        startActivity(intentdetailta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_profile){
            Intent MProfileIntent = new Intent(this, UserProfile.class);
            startActivity(MProfileIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}