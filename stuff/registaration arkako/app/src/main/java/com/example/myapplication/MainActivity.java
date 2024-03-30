package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    EditText usn, name;
    RadioGroup gender, choice;
    CheckBox c, java, python;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usn = findViewById(R.id.USN);
        name = findViewById(R.id.Name);
        gender = findViewById(R.id.gender);
        choice = findViewById(R.id.choice);
        c = findViewById(R.id.C);
        java = findViewById(R.id.Java);
        python = findViewById(R.id.Python);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String USN = usn.getText().toString();

                String Name = name.getText().toString();

                String Gender = ((RadioButton) findViewById(gender.getCheckedRadioButtonId())).getText().toString();

                StringBuilder skills = new StringBuilder();
                if(c.isChecked()){
                    skills.append("C, ");
                }
                if(java.isChecked()){
                    skills.append("Java, ");
                }
                if(python.isChecked()){
                    skills.append("Python, ");
                }
                String Skill = skills.toString();
                if (Skill.endsWith(", ")) {
                    Skill = Skill.substring(0, Skill.length() - 2);
                }

                String Choice = ((RadioButton) findViewById(choice.getCheckedRadioButtonId())).getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Student Selection");
                builder.setMessage("Name: "+Name+"\nUSN: "+USN+"\nGender: "+Gender+"\nSkills: "+Skill+"\nFuture Plan: "+Choice);
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
    }
}