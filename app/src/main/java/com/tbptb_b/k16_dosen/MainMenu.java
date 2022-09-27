package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;
import com.tbptb_b.k16_dosen.models.ListNamaMahasiswa;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {
Button buttondetailta;
//    private Boolean isLoggedIn = false;
    private RecyclerView rvListmaba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        rvListmaba = findViewById(R.id.rv_listmhs);

        Adapter adapter = new Adapter(getListNamaMahasiswa());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvListmaba.setLayoutManager(layoutManager);
        rvListmaba.setAdapter(adapter);

        buttondetailta = findViewById(R.id.more_bimbingan);
        buttondetailta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailta();
            }
        });
//        if(isLoggedIn == false){
//            Intent loginintent = new Intent(this, LoginActivity.class);
//            startActivity(loginintent);
//        }

//        dpbtt = findViewById(R.id.imageButtonListDetailMabim);
//        dpbtt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent detailIn = new Intent(MainMenu.this, DetailMahasiswa .class);
//                startActivity(detailIn);
//            }
//        });

    }

    public ArrayList<ListNamaMahasiswa> getListNamaMahasiswa(){
        ArrayList<ListNamaMahasiswa> listnamamhs = new ArrayList<>();
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Budy Bahahahaha",
                2011623912
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Alfred Alfonso",
                98303928
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Xavier the Third",
                33333333
        ));
        listnamamhs.add(new ListNamaMahasiswa(
                null,
                "Nadila Saraswati",
                2011521004
        ));
        return listnamamhs;


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