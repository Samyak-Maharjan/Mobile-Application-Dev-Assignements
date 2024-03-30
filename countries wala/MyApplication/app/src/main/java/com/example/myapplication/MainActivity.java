package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin=findViewById(R.id.spin);
        String items[]={"india","pak","bangla"};
        ArrayAdapter ad=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spin.setAdapter(ad);
    }
}