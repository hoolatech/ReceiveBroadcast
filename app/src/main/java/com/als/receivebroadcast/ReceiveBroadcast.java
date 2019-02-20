package com.als.receivebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import com.als.receivebroadcast.service.intentService.ToastIntentService;

public class ReceiveBroadcast extends BroadcastReceiver {
    public ReceiveBroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        sendNotification(context, intent);
    }

    private void sendNotification(Context context, Intent intent) {
        Intent notificationIntent = new Intent(intent);
        notificationIntent.setClass(context, ToastIntentService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(notificationIntent);
            Toast.makeText(context, "start Foreground Service", Toast.LENGTH_LONG).show();
        } else {
            context.startService(notificationIntent);
            Toast.makeText(context, "start regular Service", Toast.LENGTH_LONG).show();
        }
    }
}