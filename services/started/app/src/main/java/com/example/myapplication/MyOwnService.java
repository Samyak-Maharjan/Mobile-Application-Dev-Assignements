package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyOwnService extends Service {
    MediaPlayer player;
    public MyOwnService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Created..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started..", Toast.LENGTH_SHORT).show();
        if(player==null)
        {
            player= MediaPlayer.create(this,R.raw.audio);
        }
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                player.release();player=null;
            }
        });
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed...", Toast.LENGTH_SHORT).show();
        player.release();
        player=null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
