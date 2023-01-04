package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tbptb_b.k16_dosen.JseminarActivity;
import com.tbptb_b.k16_dosen.R;

public class menusemsidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menusemsid);
    }

    public void blistsem(View view){
        Intent blistsem = new Intent(menusemsidActivity.this, JseminarActivity.class);
        startActivity(blistsem);
    }

    public void blistsid(View view){
        Intent blistsid = new Intent(menusemsidActivity.this, SidangjActivity.class);
        startActivity(blistsid);
    }
}