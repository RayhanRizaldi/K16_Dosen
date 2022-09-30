package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText editUsername,editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();
        setupListeners();


    }

    private void setupUI() {
        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.button_login);
    }

    private void setupListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUsername();
            }
        });

    }

    void checkUsername(){
        boolean valid=true;
        if(valid){
            String username = editUsername.getEditableText().toString();
            String password = editPassword.getEditableText().toString();
            if(password.equals("yeyjadi") && username.equals("dengankekuatanbulan")){
                Intent LoginIntent = new Intent(this, MainMenu.class);
                LoginIntent.putExtra("username",username);
                LoginIntent.putExtra("cek_login",true);
                startActivity(LoginIntent);
            }else if(password.isEmpty() || username.isEmpty()){
                Toast.makeText(this,"Ada yang Kosong, Mending cek lagi",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Wah, ada yang salah nih",Toast.LENGTH_SHORT).show();
            }
        }
    };

}