package com.tbptb_b.k16_dosen.firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.SetujuBbmTA;

public class FirebaseMessagingTappsService extends FirebaseMessagingService {
    private static final String CHANNEL_ID = "notif_setujubbmta";
//    private NotificationManagerCompat notificationManager;
    private static final String TAG = "Service-debug";

    public FirebaseMessagingTappsService() {
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        displayNotification(remoteMessage.getNotification());

    }

    private void displayNotification(RemoteMessage.Notification notification) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Persetujuan";
            String description = "Bimbingan diperlukan";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);


            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = null;

        Intent resultIntent = new Intent(this, SetujuBbmTA.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable._200px_logo_unand_svg)
                .setContentTitle("Perlu Persetujuan")
                .setContentText("Ada Mahasiswa perlu Bimbingan")
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat.from(this).notify(001,builder.build());
    }
}