package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cardnumber , name , address ,apartmentno , zip , city , state;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.demo_image);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        cardnumber = findViewById(R.id.cardno);
        name = findViewById(R.id.cardname);
        address = findViewById(R.id.billadd);
        apartmentno = findViewById(R.id.apartno);
        zip = findViewById(R.id.zipno);
        city = findViewById(R.id.citytext);
        state = findViewById(R.id.textstate);
        ok = findViewById(R.id.buttonok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "The data is saved ",Toast.LENGTH_LONG).show();
            }
        });
    }
}