package com.als.receivebroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.als.receivebroadcast.service.intentService.MyIntentServiceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoService(View view) {
        Intent i = new Intent(getApplicationContext(), MyIntentServiceActivity.class);
        startActivity(i);
        setContentView(R.layout.activity_my_intent_service);
    }
}
