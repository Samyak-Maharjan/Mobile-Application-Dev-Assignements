package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHelper myHelper=new MyHelper(this,"StudentInfo.db",null,1);
        SQLiteDatabase db=myHelper.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("id",5);
        values.put("name","jain");
        values.put("marks",100);

        long row=db.insert("Info",null,values);
        System.out.println("Row Number is :" +row);
        String projections[]={"id","name","marks"};
        Cursor c=db.query("Info",projections,null,null,null,null,null);

        c.moveToLast();
        System.out.println("Name is "+c.getString(1));

    }
    class MyHelper extends SQLiteOpenHelper{

        public MyHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table Info(id integer,name text,marks integer)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

}