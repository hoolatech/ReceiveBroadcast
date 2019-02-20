package com.als.receivebroadcast.service.intentService;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;

import com.als.receivebroadcast.R;

public class ToastIntentService extends IntentService {
    private static final String TAG = ToastIntentService.class.getSimpleName();
    private static final int JOB_ID = 53720236;
    private static final String CHANNEL_ID = "GeofenceTriggerChannelId";
    private static int NOTIFY_ID=1337;
    private static final String CHANNEL_NAME = "GeofenceTriggerChannel";

    public ToastIntentService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "on create");
    }

    @Override
    protected void onHandleIntent(@NonNull Intent downloadIntent) {
        Log.d(TAG, "GeofenceTriggerIntentService started.");
        //Toast.makeText(this.getApplicationContext(), "broadcast received", Toast.LENGTH_LONG).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME, NotificationManager.IMPORTANCE_NONE);
            ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(channel);

            startForeground(JOB_ID, new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("Test Content Title")
                    .setContentText("Test Content Text")
                    .setSmallIcon(R.drawable.geo_fence_img)
                    .build());
        }
        Log.d(TAG, "GeofenceTriggerIntentService created.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on destroy");
    }
}
