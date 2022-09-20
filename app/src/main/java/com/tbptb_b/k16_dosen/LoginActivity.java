package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button button;
    EditText editUsername,editPassword;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.button_login);
        button.setOnClickListener(view -> openMainMenu());

//        editUsername = (EditText) findViewById(R.id.editUsername);
//        username = editUsername.getEditableText().toString();
//
//        editPassword = (EditText) findViewById(R.id.editPassword);
//        username = editPassword.getEditableText().toString();
//
//        if(password.equals("yeyjadi")){
//            Intent LoginIntent = new Intent(this, MainMenu.class);
//            LoginIntent.putExtra("username",username);
//            LoginIntent.putExtra("cek_login",true);
//            startActivity(LoginIntent);
//        }else{
//            Toast.makeText(this,"Yah Gagal",Toast.LENGTH_SHORT).show();
//        }
    }

    public void openMainMenu(){
        Intent LoginIntent = new Intent(this, MainMenu.class);
        startActivity(LoginIntent);
        finish();
    }
}