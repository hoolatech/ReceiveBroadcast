package com.als.receivebroadcast.service.intentService;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.als.receivebroadcast.util.ThreadUtil;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    // Invoked when this intent service is started.
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            // Get current child thread.
            Thread currThread = Thread.currentThread();
            // Get current thread info.
            String threadInfo = ThreadUtil.getThreadInfo(currThread);
            // Log current thread info.
            Log.d(MyIntentServiceActivity.TAG_INTENT_SERVICE, "MyIntentService child thread info." + threadInfo);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(MyIntentServiceActivity.TAG_INTENT_SERVICE, "MyIntentService onCreate() method is invoked.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MyIntentServiceActivity.TAG_INTENT_SERVICE, "MyIntentService onDestroy() method is invoked.");
    }
}