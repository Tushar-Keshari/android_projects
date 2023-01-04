package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    RadioButton button1 , button2 ,button3;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Gameactivity.class);

                if(!button1.isChecked() && !button2.isChecked() && !button3.isChecked()){
                    Snackbar.make(v, "Please select a number of digits",Snackbar.LENGTH_LONG).show();
                }
                else{
                    if(button1.isChecked()){
                        intent.putExtra("two",true);
                    }
                    if(button2.isChecked()){
                        intent.putExtra("three",true);
                    }
                    if(button3.isChecked()){
                        intent.putExtra("four",true);
                    }
                    startActivity(intent);
                }
            }
        });
    }
}