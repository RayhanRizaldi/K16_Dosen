package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tbptb_b.k16_dosen.models.Response;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "notif_login";
    Button btnLogin;
    EditText editUsername,editPassword;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        notificationManager = NotificationManagerCompat.from(this);

        createNotificationChannel();

        setupUI();
        setupListeners();
        cekLogin();


    }

    private void cekLogin() {
        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.button_login);

        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();

                StoryClient client = retrofit.create(StoryClient.class);
                Call<Response> call =client.login(username,password);

                call.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        Response loginResponse = response.body();
                        Log.d("LoginAct-Debug", response.toString());
                        if (loginResponse != null){
                            Toast.makeText(LoginActivity.this,"Sukses Login",Toast.LENGTH_SHORT).show();

                            String token = loginResponse.getAuthorisation().getToken();

                            SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("TOKEN",token);
                            editor.apply();

                            Intent LoginIntent = new Intent(LoginActivity.this, MainMenu.class);
                            startActivity(LoginIntent);

                        }else{
                            Toast.makeText(LoginActivity.this,"Ada yang salah ni, yok cek lagi!",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                        Toast.makeText(LoginActivity.this,"Server Gagal",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Login Berhasil";
            String description = "Aplikasi TA.pps";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);


            notificationManager.createNotificationChannel(channel);
        }
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
                NotificationCompat.Builder builder = new NotificationCompat.Builder(LoginActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable._200px_logo_unand_svg)
                        .setContentTitle("Selamat Datang")
                        .setContentText("Deskripsi Tambahan")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManager.notify(001,builder.build());
            }
        });

    }

    void checkUsername(){
        boolean valid=true;
        if(valid){
            String username = editUsername.getEditableText().toString();
            String password = editPassword.getEditableText().toString();
            if(password.equals("a") && username.equals("a")){
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