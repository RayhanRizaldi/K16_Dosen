package com.tbptb_b.k16_dosen;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UserProfile extends AppCompatActivity {

    private ImageView pict_dosen;
    private static final int PICK_IMAGE=1;
    private static final String CHANNEL_ID = "test_kanal";
    private Button buttonnotif;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

//        pict_dosen = (ImageView) findViewById(R.id.pict_dosen);
//        pict_dosen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent gallery = new Intent();
//                gallery.setType("image/*");
//                gallery.setAction(Intent.ACTION_GET_CONTENT);
//
//                startActivityForResult(Intent.createChooser(gallery, "Pilih Gambar"), PICK_IMAGE);
//            }
//        });

        notificationManager = NotificationManagerCompat.from(this);

        createNotificationChannel();
        buttonnotif = findViewById(R.id.update_profile_button);
        buttonnotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(UserProfile.this, UserProfile.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(UserProfile.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(UserProfile.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.app_logo)
                        .setContentTitle("Profile Update")
                        .setContentText("Profile anda telah berhasil diperbarui")
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.app_logo, "CEK", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                Notification notification = builder.build();
                notificationManager.notify(101,notification);
            }
        });



//        Button button = findViewById(R.id.update_profile_button);
////        pict_dosen = findViewById(R.id.pict_dosen);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mGetContent.launch("image/*");
//
//            }
//        });

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notifikasi profile";
            String description = "Update profile";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "profile", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("notifikasi profile");
            notificationManager.createNotificationChannel(channel);
        }
    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    if (result != null){
                        pict_dosen.setImageURI(result);
                    }
                }
            }
    );

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}