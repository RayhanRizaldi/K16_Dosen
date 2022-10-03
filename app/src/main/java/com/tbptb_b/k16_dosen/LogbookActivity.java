package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.tbptb_b.k16_dosen.models.Listlogbook;

import java.util.ArrayList;

public class LogbookActivity extends AppCompatActivity {
Button buttondetaillb;

private RecyclerView rvLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);

        rvLogbook = findViewById(R.id.rv_lb);

        Adapter3 adapter = new Adapter3(getLislogbook());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);

//        buttondetaillb = findViewById(R.id.buttondetaillogbook);
//        buttondetaillb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDetailLogbook();
//            }
//        });
    }
     public ArrayList<Listlogbook> getLislogbook(){
        ArrayList<Listlogbook> ListLogbook = new ArrayList<>();
        ListLogbook.add(new Listlogbook(
                "Jumat, 30/9/2022",
                "Melakukan riset",
                1
        ));
         ListLogbook.add(new Listlogbook(
                 "Sabtu, 1/10/2022",
                 "Melakukan riset",
                 1
         ));
         ListLogbook.add(new Listlogbook(
                 "Minggu, 2/10/2022",
                 "Melengkapi riset",
                 1
         ));
         ListLogbook.add(new Listlogbook(
                 "Senin, 3/10/2022",
                 "Membuat Pendahuluan",
                 1
         ));ListLogbook.add(new Listlogbook(
                 "Selasa, 4/10/2022",
                 "Membuat Pendahuluan",
                 0
         ));
         ListLogbook.add(new Listlogbook(
                 "Rabu, 5/10/2022",
                 "Melengkapi Pendahuluan",
                 0
         ));
         ListLogbook.add(new Listlogbook(
                 "Kamis, 6/10/2022",
                 "Melakukan Tinjauan Pustaka",
                 0
         ));
         ListLogbook.add(new Listlogbook(
                 "Jumat, 7/10/2022",
                 "Membuat Tinjauan Pustaka",
                 0
         ));
         ListLogbook.add(new Listlogbook(
                 "Sabtu, 8/10/2022",
                 "Membuat Tinjauan Pustaka",
                 0
         ));
         ListLogbook.add(new Listlogbook(
                 "Minggu, 9/10/2022",
                 "Membuat Tinjauan Pustaka",
                 0
         ));ListLogbook.add(new Listlogbook(
                 "Senin, 10/10/2022",
                 "Membuat Tinjauan Pustaka",
                 0
         ));
         ListLogbook.add(new Listlogbook(
                 "Selasa, 11/10/2022",
                 "Membuat Metodologi",
                 0
         ));
         ListLogbook.add(new Listlogbook(
                 "Rabu, 12/10/2022",
                 "Melengkapi data",
                 0
         ));
         ListLogbook.add(new Listlogbook(
                 "Kamis, 13/10/2022",
                 "Revisi Bab Pendahuluan",
                 0
         ));
        return ListLogbook;
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