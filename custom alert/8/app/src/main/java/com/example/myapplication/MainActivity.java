package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgp;
    RadioButton rb;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button alertbtn=findViewById(R.id.btnalert);
        alertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Title Info.");
                builder.setMessage("Description about Alert Dialog");
                builder.setIcon(R.drawable.ic_baseline_add_alert_24);
                builder.setCancelable(true);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Messgae from positive button",Toast.LENGTH_SHORT).show();
                    }
                }).setNeutralButton("HELP", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
            }
        });

        Button btncustom=findViewById(R.id.btncustom);
        btncustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);
                build.setIcon(R.drawable.ic_baseline_add_alert_24);
                build.setTitle("Custom Alert Dialog");
                build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Toast",Toast.LENGTH_LONG).show();
                    }
                });
                build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
                    }
                });
                View customeview=getLayoutInflater().inflate(R.layout.custom_alert,null);
                build.setView(customeview);
                build.show();
            }

        });

        Spinner spin=findViewById(R.id.spin);
        String items[]={"India","Pak","Bangla"};
        ArrayAdapter ad=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items);
        spin.setAdapter(ad);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Item Selected is"+items[i],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }



    public void radioaction(View v){
        rb=findViewById(v.getId());
        //rgp=findViewById(R.id.rgp1);
        //int radioId=rgp.getCheckedRadioButtonId();
        //rb=findViewById(radioId);
        Toast.makeText(this,"Id Selected is:"+rb.getText(),Toast.LENGTH_SHORT).show();
    }


}