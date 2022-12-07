package com.tbptb_b.k16_dosen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
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
import android.widget.Toast;

import com.tbptb_b.k16_dosen.adapter.listlogbook_adapter;
import com.tbptb_b.k16_dosen.models.Listlogbook;

import java.util.ArrayList;

public class LogbookActivity extends AppCompatActivity implements listlogbook_adapter.ListLogbookClickListener{
Button buttondetaillb;

private static final String CHANNEL_ID = "test_kanal";
private Button buttonnotif;
private RecyclerView rvLogbook;
private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);

        rvLogbook = findViewById(R.id.rv_lb);

        listlogbook_adapter adapter = new listlogbook_adapter(getLislogbook());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);

        notificationManager = NotificationManagerCompat.from(this);

        createNotificationChannel();

        buttonnotif = findViewById(R.id.notiflb);
        buttonnotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(LogbookActivity.this, LogbookActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(LogbookActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(LogbookActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.app_logo)
                        .setContentTitle("Ada Logbook")
                        .setContentText("Ada Logbook terbaru, ayo lihat!!")
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.app_logo, "CEK", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                Notification notification = builder.build();
                notificationManager.notify(101,notification);
            }
        });

//        buttondetaillb = findViewById(R.id.buttondetaillogbook);
//        buttondetaillb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDetailLogbook();
//            }
//        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notifikasi logbook";
            String description = "Ada Logbook masuk";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "jadwal Sidang", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("notifikasi jadwal sidang");
            notificationManager.createNotificationChannel(channel);
        }
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

    @Override
    public void onListLogbookClick(Listlogbook listlogbook) {
        Intent intentdetaillb = new Intent(this,DetailLogbookActivity.class);
        intentdetaillb.putExtra("TGLLB",listlogbook.getTanggallb());
        intentdetaillb.putExtra("DSKRLB",listlogbook.getDeskripsilb());
        startActivity(intentdetaillb);
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