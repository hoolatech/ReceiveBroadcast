package com.als.receivebroadcast.service.intentService;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.als.receivebroadcast.R;
import com.als.receivebroadcast.util.ThreadUtil;

public class MyIntentServiceActivity extends AppCompatActivity {

    public static final String TAG_INTENT_SERVICE = "TAG_INTENT_SERVICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent_service);

        setTitle("Android IntentService Example.");

        // Get activity main thread.
        Thread currThread = Thread.currentThread();

        // Get main thread info.
        String threadInfo = ThreadUtil.getThreadInfo(currThread);

        // Log main thread info.
        Log.d(TAG_INTENT_SERVICE, "Activity main thread info. " + threadInfo);

        // Click this button to start background service which start a child thread manually.
        Button startServiceWithChildThread = (Button)findViewById(R.id.intent_service_start_child_thread);
        startServiceWithChildThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyIntentServiceActivity.this, MyCommonService.class);
                startService(intent);
            }
        });

        // Click this button to start a intent service.
        Button startIntentService = (Button)findViewById(R.id.intent_service_start_intent_service);
        startIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyIntentServiceActivity.this, MyIntentService.class);
                startService(intent);
            }
        });

    }
}
