package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JseminarActivity extends AppCompatActivity {
Button buttonjesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jseminar);

        buttonjesi = findViewById(R.id.buttonjusi);
        buttonjesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIn = new Intent(JseminarActivity.this, DSidang2Activity .class);
                startActivity(detailIn);
            }
        });
    }
}