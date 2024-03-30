package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb1,pb2;
    Button btn;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar pb1=findViewById(R.id.PBHori);
        ProgressBar pb2=findViewById(R.id.PBCircle);

        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb1.setVisibility(View.VISIBLE);
                pb2.setVisibility(View.VISIBLE);

                Timer timer=new Timer();
                TimerTask timerTask=new TimerTask() {
                    @Override
                    public void run() {
                        counter++;
                        pb1.setProgress(counter);
                        pb2.setProgress(counter);

                        if (counter==100){
                            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                            startActivity(intent);
                        }
                    }
                };
                timer.schedule(timerTask,100,100);
            }
        });
    }
}