package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView clv;
    String title[]={"Apple","Orange","Tomato"};
    String desc[]={"Fruit","Fruit","Vegetable"};
    int imgscr[]={R.drawable.apple,R.drawable.orange,R.drawable.tomato};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clv=findViewById(R.id.CListView1);
        customAdapter adapter=new customAdapter();
        clv.setAdapter(adapter);
    }
    class customAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imgscr.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.customlistview,null);
            ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
            TextView titletv=(TextView) view.findViewById(R.id.txttitle);
            TextView desctv=(TextView) view.findViewById(R.id.txtdes);

            imageView.setImageResource(imgscr[i]);
            titletv.setText(title[i]);
            desctv.setText(desc[i]);
            return view;
        }
    }
}