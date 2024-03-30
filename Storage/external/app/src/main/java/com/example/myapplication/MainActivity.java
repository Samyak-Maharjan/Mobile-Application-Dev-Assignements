package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText etmsg;
    TextView tvmsg;
    Button btnwrite,btnread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etmsg=(EditText)findViewById(R.id.etmsg);
        tvmsg=(TextView)findViewById(R.id.tvmsg);
        btnwrite=(Button)findViewById(R.id.btnwrite);
        btnread=(Button)findViewById(R.id.btnread);


        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                name=Environment.getExternalStorageState();//name of external storage
                if(Environment.MEDIA_MOUNTED.equals(name))
                {
                    File Dir=new File(String.valueOf(getExternalFilesDir("/MyAppDir")));//refer to directory
                    if(!Dir.exists())
                    {
                        Dir.mkdir();
                    }
                    File file=new File(Dir,"MyMessage.txt");
                    String msg=etmsg.getText().toString();
                    try {
                        FileOutputStream fileOutputStream=new FileOutputStream(file);
                        fileOutputStream.write(msg.getBytes());
                        fileOutputStream.close();
                        Toast.makeText(getApplicationContext(),"Written Sucessful",Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Storage Not Mounted", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//This Section is for work

            }
        });

    }
}
