package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;

public class MyService extends Service {
    @Nullable
    Random num=new Random();
    boolean flag;
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        flag= true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    randomNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("Service onStartCommand","Thread id"+Thread.currentThread().getId());
            }
        }).start();
        return START_STICKY;
    }

    private void randomNumber() throws InterruptedException {
        while(flag)
        {
            int random=num.nextInt(100);
            Log.i("Service onStartCommand", "Random Number:"+random);
            Thread.sleep(1000);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag=false;

    }
}