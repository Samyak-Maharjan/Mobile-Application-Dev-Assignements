package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity { Button b1,b2,b3,b4,b5;
    EditText t1,t2;


    TextView t3;
    double x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main); setUIview();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    x = Double.parseDouble(t1.getText().toString());
                    y = Double.parseDouble(t2.getText().toString());

                    x = x + y;
                    t3.setText(String.valueOf(x));

                } catch (Exception e) {
                }
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    x = Double.parseDouble(t1.getText().toString());
                    y = Double.parseDouble(t2.getText().toString());

                    x = x - y;
                    t3.setText(String.valueOf(x));
                } catch (Exception e) {
                }
            }

        } ); b4.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           try {
                                               x = Double.parseDouble(t1.getText().toString());
                                               y = Double.parseDouble(t2.getText().toString());

                                               x = x * y;
                                               t3.setText(String.valueOf(x));


                                           } catch (Exception e) {
                                           }

                                       }
                                   }
        ); b5.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         try {
                                             x = Double.parseDouble(t1.getText().toString());
                                             y = Double.parseDouble(t2.getText().toString());

                                             x = x / y;
                                             t3.setText(String.valueOf(x));
                                         } catch (Exception e) {
                                         }
                                     }
                                 }
        );
        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      t1.setText(""); t2.setText(""); t3.setText(""); x=0.0;
                                      y=0.0;
                                  }
                              }

        );
    }
    public void setUIview(){ b1=(Button)findViewById(R.id.b1); b2=(Button)findViewById(R.id.b2); b3=(Button)findViewById(R.id.b3); b4=(Button)findViewById(R.id.b4); b5=(Button)findViewById(R.id.b5); t1=(EditText)findViewById(R.id.t1); t2=(EditText)findViewById(R.id.t2); t3=(TextView)findViewById(R.id.t3);
    }
}