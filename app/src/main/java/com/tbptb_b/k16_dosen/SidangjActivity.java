package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.tbptb_b.k16_dosen.adapter.jsid_adapter;
import com.tbptb_b.k16_dosen.models.jsid_model;

import java.util.ArrayList;

public class SidangjActivity extends AppCompatActivity implements jsid_adapter.ItemjsidClickListener{

    //1.
    private static final String CHANNEL_ID = "notif_jsid";
    private Button buttonjsid;
    private NotificationManagerCompat notificationManagerJsid;

    private RecyclerView rvjsid;
//    Button SetujuSid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidangj);

        //recycle view
        rvjsid = findViewById(R.id.rv_jsid);
        jsid_adapter jsidadapter = new jsid_adapter(getjsid_model());
        jsidadapter.setListner(this);

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
                Intent resultIntent = new Intent(SidangjActivity.this,SidangPersetujuanActivity.class);
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
//                        .setStyle(new NotificationCompat.BigTextStyle()
//                                .bigText("Winanda Afrilia Harisya 2011522016, Mengirim Permintaan Sidang"))
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_baseline_arrow_back_24, "Lihat", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManagerJsid.notify(111, builder.build());
                SidangApprove();
            }
        });
        notificationManagerJsid = NotificationManagerCompat.from(this);
        createNotificationChannel();
    }

    private void SidangApprove() {
        Intent intentssid = new Intent(SidangjActivity.this, SidangPersetujuanActivity.class);
        startActivity(intentssid);
    }

    //3. tambahkan method untuk membuat arraylist-> ganti ner arraylist... pada oncreat dengan getjsem_model()
    public ArrayList<jsid_model> getjsid_model(){
        ArrayList<jsid_model> listjsid_model = new ArrayList<>();

        //3.1 tambahkan data yang akan dimasukkan pada list ->lanjut ke adapter
        listjsid_model.add(new jsid_model(
                null,
                "Rabu, 21 Desember 2022",
                "Winanda afrilia harisya",
                "2011522016",
                "Perancangan SPK pemilihan cafe terbaik disekitar unand"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla sarawati",
                "2011523012",
                "Perancangan Sistem informasi TA"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001",
                "Perancangan SPK pemilihan makanan kucing terbaik"

        ));
        listjsid_model.add(new jsid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016",
                "Perancangan SPK pemilihan cafe terbaik disekitar unand"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla sarawati",
                "2011523012",
                "Perancangan Sistem informasi TA"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001",
                "Perancangan SPK pemilihan makanan kucing terbaik"

        ));
        listjsid_model.add(new jsid_model(
                null,
                "selasa, 11 oktober 2022",
                "Winanda afrilia harisya",
                "2011522016",
                "Perancangan SPK pemilihan cafe terbaik disekitar unand"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "rabu, 12 oktober 2022",
                "Nadilla sarawati",
                "2011523012",
                "Perancangan Sistem informasi TA"

        ));

        listjsid_model.add(new jsid_model(
                null,
                "kamis, 13 oktober 2022",
                "Yupiko",
                "2011521001",
                "Perancangan SPK pemilihan makanan kucing terbaik"

        ));

        return listjsid_model;
    }

    @Override
    public void onItemjsidClick(jsid_model jsidmodel) {
        Intent intentins = new Intent(this, inputnilaisidangActivity.class);
        intentins.putExtra("jadwalsid",jsidmodel.getJadwal_jsid());
        intentins.putExtra("NMHSJSID", jsidmodel.getMnama_jsid());
        intentins.putExtra("NIMMHSJSID", jsidmodel.getNim_jsid());

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

//    public void profil_jsid(View view){
//        Intent profil_jsid = new Intent(SidangjActivity.this, TambahnilaiSidangActivity.class);
//        startActivity(profil_jsid);
//    }
}