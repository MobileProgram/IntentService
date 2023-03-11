package com.mblhcmute.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends IntentService {

    public MyService() {
        super("my_intent_thread");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        Toast.makeText(this, "MyService started", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "MyService stopped", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        synchronized (this) {
            try{
                wait(20000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
