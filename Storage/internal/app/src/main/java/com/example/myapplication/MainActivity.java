package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
                String msg=etmsg.getText().toString();
                try{
                    FileOutputStream fileOutputStream=openFileOutput("myfile",MODE_PRIVATE);
                    fileOutputStream.write(msg.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(),"Message Wrote",Toast.LENGTH_SHORT).show();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }

            }
        });
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg;
                StringBuffer stringBuffer=new StringBuffer();
                try{
                    FileInputStream fileInputStream=openFileInput("myfile");
                    InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    while((msg=bufferedReader.readLine())!=null)
                    {
                        stringBuffer.append(msg+"\n");
                    }
                    tvmsg.setText(stringBuffer.toString());
                    tvmsg.setVisibility(View.VISIBLE);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }




            }
        });
    }

}