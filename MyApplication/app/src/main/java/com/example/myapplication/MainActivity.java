package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    String[] countries;

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.list);
        countries = getResources().getStringArray(R.array.countries);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String country_name = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),"You Selected "+country_name , Toast.LENGTH_LONG).show();
            }
        });
    }
}