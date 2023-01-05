package com.tbptb_b.k16_dosen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.tbptb_b.k16_dosen.adapter.jsid_adapter;
import com.tbptb_b.k16_dosen.datamodels.GetDetailTAResponse;
import com.tbptb_b.k16_dosen.datamodels.GetListSidangResponse;
import com.tbptb_b.k16_dosen.datamodels.SeminarsItem;
import com.tbptb_b.k16_dosen.models.jsid_model;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SidangjActivity extends AppCompatActivity implements jsid_adapter.ItemjsidClickListener{

    //1.
    private static final String CHANNEL_ID = "notif_jsid";
    private Button buttonjsid;
    private NotificationManagerCompat notificationManagerJsid;

    private RecyclerView rvjsid;
    private static final String TAG = "SidangjActivity-Debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidangj);

        //recycle view
        rvjsid = findViewById(R.id.rv_jsid);
        jsid_adapter jsidadapter = new jsid_adapter();
        jsidadapter.setListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvjsid.setLayoutManager(layoutManager);
        rvjsid.setAdapter(jsidadapter);
//
        notificationManagerJsid = NotificationManagerCompat.from(this);
        createNotificationChannel();

        buttonjsid = findViewById(R.id.button_jsid);
        buttonjsid.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(SidangjActivity.this, SidangPersetujuanActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(SidangjActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                //intentnya
                NotificationCompat.Builder builder = new NotificationCompat.Builder(SidangjActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable._200px_logo_unand_svg)
                        .setContentTitle("PERMINTAAN SIDANG")
                        .setContentText("Winanda Afrilia Harisya 2011522016, Mengirim Permintaan Sidang")
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_baseline_arrow_back_24, "Lihat", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManagerJsid.notify(111, builder.build());
                SidangApprove();


                //firebase
                FirebaseMessaging.getInstance().getToken()
                        .addOnCompleteListener(new OnCompleteListener<String>() {
                            @Override
                            public void onComplete(@NonNull Task<String> task) {
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                                    return;
                                }

                                // Get new FCM registration token
                                String token = task.getResult();

                                // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
                                Log.d(TAG, token);
                                Toast.makeText(SidangjActivity.this, token, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        notificationManagerJsid = NotificationManagerCompat.from(this);
        createNotificationChannel();

        //API
        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN","");

        //minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryClient client = retrofit.create(StoryClient.class);

        Call<GetListSidangResponse> call = client.getThesis("Bearer" + token);
        call.enqueue(new Callback<GetListSidangResponse>() {
            @Override
            public void onResponse(Call<GetListSidangResponse> call, Response<GetListSidangResponse> response) {
                Log.d("SidangjActivity-Debug", response.toString());

                GetListSidangResponse getListSidangResponse = response.body();
                if(getListSidangResponse != null){
                    List<SeminarsItem> listThesis = getListSidangResponse.getSeminars();
                    Log.d("SidangjActivity-Debug", String.valueOf(listThesis.size()));
                    jsidadapter.setItemThesis(listThesis);
                }
            }

            @Override
            public void onFailure(Call<GetListSidangResponse> call, Throwable t) {
//                Toast.makeText(.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void SidangApprove() {
        Intent intentssid = new Intent(SidangjActivity.this, SidangPersetujuanActivity.class);
        startActivity(intentssid);
    }

    @Override
    public void onItemjsidClick(SeminarsItem jsidmodel) {
        Intent intentins = new Intent(this, inputnilaisidangActivity.class);
        intentins.putExtra("Namasid", jsidmodel.getThesis().getStudent().getName());
        intentins.putExtra("Nimsid", jsidmodel.getThesis().getStudent().getNim());
        intentins.putExtra("Jadwalsid", jsidmodel.getThesis().getStartAt());
        intentins.putExtra("JTAsid", jsidmodel.getThesis().getTitle());
        intentins.putExtra("Id Thesis", jsidmodel.getThesisId());
        startActivity(intentins);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifikasi";
            String description = "Notifikasi Seminar TA Bertambah";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManagerJsid.createNotificationChannel(channel);
        }
    }

}