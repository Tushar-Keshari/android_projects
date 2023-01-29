package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private RecyclerAdapter adapter;

    private ArrayList<String> countryNamelist = new ArrayList<>();
    private ArrayList<String> detailList = new ArrayList<>();
    private ArrayList<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycleview);

        countryNamelist.add("UNITED KINGDOM");
        countryNamelist.add("GERMANY");
        countryNamelist.add("USA");

        detailList.add("This is the United Kingdom flag");
        detailList.add("This is the Germany flag");
        detailList.add("This is the USA flag");

        imageList.add(R.drawable.uk);
        imageList.add(R.drawable.germany);
        imageList.add(R.drawable.usa);

        adapter = new RecyclerAdapter(countryNamelist,detailList,imageList,MainActivity.this);
        recycler.setAdapter(adapter);
    }
}