package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doAction(View view) {
        NotificationManagerCompat myManager=NotificationManagerCompat.from(this);
        NotificationCompat.Builder myNoti=new NotificationCompat.Builder(this);
        myNoti.setContentTitle("Hi");
        myNoti.setContentText("Hello");
        myNoti.setSmallIcon(android.R.drawable.ic_btn_speak_now);
        Intent intent=new Intent(this, MainActivity.class);
        PendingIntent pd= PendingIntent.getActivity(this,1,intent,0);
        myNoti.setContentIntent(pd);
        myNoti.setAutoCancel(true);//Notification should be read only once

        myManager.notify(1,myNoti.build());
        finish();

    }
}