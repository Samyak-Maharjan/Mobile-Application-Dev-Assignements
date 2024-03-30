package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvresult;
    EditText val1,val2;
    ImageButton btnadd,btnsub,btnmul,btndiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1=findViewById(R.id.et1);
        val2=findViewById(R.id.et2);
        tvresult=findViewById(R.id.tvres);
        btnadd=findViewById(R.id.btnadd);
        btnsub=findViewById(R.id.btnsub);
        btnmul=findViewById(R.id.btnmul);
        btndiv=findViewById(R.id.btndiv);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(val1.getText().toString());
                double num2=Double.parseDouble(val2.getText().toString());
                double result=num1+num2;
                tvresult.setText("Answer is:\n"+result);
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(val1.getText().toString());
                double num2=Double.parseDouble(val2.getText().toString());
                double result=num1-num2;
                tvresult.setText("Answer is:\n"+result);
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(val1.getText().toString());
                double num2=Double.parseDouble(val2.getText().toString());
                double result=num1*num2;
                tvresult.setText("Answer is:\n"+result);
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1=Double.parseDouble(val1.getText().toString());
                double num2=Double.parseDouble(val2.getText().toString());
                double result=num1/num2;
                tvresult.setText("Answer is:\n"+result);
            }
        });
    }
}