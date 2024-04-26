package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText un,pw;
    Boolean token=false;
    Button btn;
    //String uname,pword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        un=findViewById(R.id.username);
        pw=findViewById(R.id.password);
        btn=findViewById(R.id.submit);

        MyHelper helper=new MyHelper(getApplicationContext(),"userinfo.db",null,1);
        SQLiteDatabase db=helper.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("uname","abc"); //field,value
        values.put("pass","123");
        long row=db.insert("userinfo",null,values);
        Toast.makeText(MainActivity.this, "Row Inserted"+row, Toast.LENGTH_SHORT).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //uname=un.getText().toString();
                //pword=pw.getText().toString();
                token=false; //this resets the token so if submit is re-clicked with wrong credentials it denies
                String proj[]={"uname","pass"};
                Cursor c=db.query("userinfo",proj,null,null,null,null,null);
                c.moveToFirst();
                do{
                    if((un.getText().toString()).equals(c.getString(0))&&   ((pw.getText().toString()).equals(c.getString(1))) )
                    {
                        token=true;
                    }
                }while (c.moveToNext());
                c.close();
                if(token){
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Access Granted");
                    builder.setMessage("You have logged in successfully");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "You have logged in", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                else {
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Access Denied");
                    builder.setMessage("Login Failed: Incorrect Credentials");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
            }
        });
    }
    class MyHelper extends SQLiteOpenHelper{

        public MyHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table userinfo(uname text,pass text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}