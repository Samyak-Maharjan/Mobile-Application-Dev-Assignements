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

    public void doAction(View view) {  //registering your own action
        Intent intent=new Intent();
        intent.setAction("com.se.simha");//Any package name can be used, and same to be handled in intent-filter.
        intent.addCategory("android.intent.category.DEFAULT");
        sendBroadcast(intent);
    }
}