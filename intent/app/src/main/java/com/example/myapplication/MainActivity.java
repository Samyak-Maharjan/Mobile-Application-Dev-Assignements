package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clickme(View view) {
        TextView tv=findViewById(R.id.tvinfo);
        tv.setText("Software Engineering");
    }

    public void ExpIntent(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void ImpIntent(View view) {
        Uri uri=Uri.parse("tel:8005551234");
        Intent intent=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
        Toast.makeText(this, "This is from ImpIntent method", Toast.LENGTH_LONG).show();
        Log.d("App", "ImpIntent: For Check... ");
    }
}