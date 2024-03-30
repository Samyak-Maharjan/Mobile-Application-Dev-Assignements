package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void serviceaction(View view) {
        if(view.getId()==R.id.btnstart){
            Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MyService.class);
            startService(intent);
        }
        else if (view.getId()==R.id.btnstop) {
            Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
        }
        /*
        switch(view.getId())
        {
            case R.id.btnstart:
                Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,MyService.class);
                startService(intent);
                break;

            case R.id.btnstop:
                Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, MyService.class);
                stopService(intent);
        }
         */
    }
}