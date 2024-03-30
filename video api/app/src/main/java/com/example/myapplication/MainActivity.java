
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv = findViewById(R.id.videoView);
        String videoPath="android.resource://"+getPackageName()+"/"
                +R.raw.video;
        Uri uri = Uri.parse(videoPath);
        vv.setVideoURI(uri);

        MediaController mc = new MediaController(this);
        vv.setMediaController(mc);
        mc.setAnchorView(vv);
    }
}
