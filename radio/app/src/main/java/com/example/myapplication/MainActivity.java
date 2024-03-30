package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgp;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void radioaction(View v){
        rb=findViewById(v.getId());
        //rgp=findViewById(R.id.rgp1);
        //int radioId=rgp.getCheckedRadioButtonId();
        //rb=findViewById(radioId);
        Toast.makeText(this,"Id Selected is:"+rb.getText(),Toast.LENGTH_SHORT).show();
    }
}

