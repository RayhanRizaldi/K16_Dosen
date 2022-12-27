package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TambahnilaiSidangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahnilai_sidang);

    }
    public void buttonTNS(View view){
        Intent buttonTNS = new Intent(TambahnilaiSidangActivity.this, inputnilaisidangActivity.class);
        startActivity(buttonTNS);
    }
}