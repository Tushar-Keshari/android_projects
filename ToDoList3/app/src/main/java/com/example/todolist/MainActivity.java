package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button button;
    ListView listView;

    ArrayList<String> itemlist = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.edittext);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.list);

        itemlist = fileHelper.readData(this);

        arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1
                ,android.R.id.text1, itemlist);

        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(view -> {
            String itemname = text.getText().toString();
            itemlist.add(itemname);
            text.setText("");
            fileHelper.writeData(itemlist, MainActivity.this.getApplicationContext());
            arrayAdapter.notifyDataSetChanged();
        });

    }
}