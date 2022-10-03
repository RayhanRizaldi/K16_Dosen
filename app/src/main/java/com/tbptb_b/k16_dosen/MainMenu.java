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
import android.widget.Toast;

import com.tbptb_b.k16_dosen.models.ListNamaMahasiswa;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity implements Adapter.MhsBimbinganClickListener {

    Button setujubbmTA;
    //    private Boolean isLoggedIn = false;
    private RecyclerView rvListmaba;
    ImageButton buttondetailta;
    Button buttonsesi;
//    private Boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        rvListmaba = findViewById(R.id.rv_listbbm);

        Adapter adapter = new Adapter(getListNamaMahasiswa());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvListmaba.setLayoutManager(layoutManager);
        rvListmaba.setAdapter(adapter);


        buttondetailta = findViewById(R.id.imageButtonListDetailMabim2);

        buttondetailta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailta();
            }
        });

        setujubbmTA = findViewById(R.id.more_bimbingan);
        setujubbmTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBimbinganta();
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

    public ArrayList<ListNamaMahasiswa> getListNamaMahasiswa() {
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

    public void openDetailta() {
        Intent intentdetailta = new Intent(this, DetailTAActivity.class);
        startActivity(intentdetailta);
    }

    public void openBimbinganta() {
        Intent intentbbmta = new Intent(this, SetujuBbmTA.class);
        startActivity(intentbbmta);
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
        if (id == R.id.menu_profile) {
            Intent MProfileIntent = new Intent(this, UserProfile.class);
            startActivity(MProfileIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void ClickMhsBimbingan(ListNamaMahasiswa mhsbb) {
        Intent intentdetailta = new Intent(this, DetailTAActivity.class);
        intentdetailta.putExtra("NMHSBB", mhsbb.getNamamhs());
        intentdetailta.putExtra("NIMMHSBB", Integer.toString(mhsbb.getNimmhs()));
        intentdetailta.putExtra("FMHS", mhsbb.getFotomhs());
        startActivity(intentdetailta);
    }

}