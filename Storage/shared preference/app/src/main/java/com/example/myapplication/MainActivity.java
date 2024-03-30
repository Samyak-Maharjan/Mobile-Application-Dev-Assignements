package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etname,etage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname=(EditText)findViewById(R.id.etname);
        etage=(EditText)findViewById(R.id.etage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp=getSharedPreferences("MyOwnShared",MODE_PRIVATE);
        String s1=sp.getString("user","");
        int age=sp.getInt("age",0);
        etname.setText(s1);
        etage.setText(String.valueOf(age));


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp=getSharedPreferences("MyOwnShared",MODE_PRIVATE);
        SharedPreferences.Editor myedit=sp.edit();
        myedit.putString("user",etname.getText().toString());
        myedit.putInt("age",Integer.parseInt(etage.getText().toString()));
        myedit.commit();

    }
}