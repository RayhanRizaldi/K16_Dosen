package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailMahasiswa extends AppCompatActivity {
Button buttonDetailta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        buttonDetailta = findViewById(R.id.buttondetailta);
        buttonDetailta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailta = new Intent(DetailMahasiswa.this,DetailTAActivity.class);
                startActivity(detailta);
            }
        });
    }
}