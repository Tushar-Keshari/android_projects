package com.example.sharedprefference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,usermessage;
    Button ok;
    CheckBox check;
    int count =0;
    String user;
    String Message;
    boolean isChecked;

    SharedPreferences sharedperference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edittext);
        usermessage = findViewById(R.id.multiline);
        ok = findViewById(R.id.button);
        check = findViewById(R.id.checkBox);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count + 1;
                ok.setText("" + count);
            }
        });
        retriveData();
    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }

    public void saveData(){
        sharedperference = getSharedPreferences("DataSaved", Context.MODE_PRIVATE);
        user = username.getText().toString();
        Message = usermessage.getText().toString();

        if(check.isChecked()){
            isChecked = true;
        }
        else{
            isChecked = false;
        }
        SharedPreferences.Editor editor = sharedperference.edit();
        editor.putString("Key Name",user);
        editor.putString("Key Message" , Message);
        editor.putInt("counter" , count);
        editor.putBoolean("Key remember" , isChecked);
        editor.commit();
        Toast.makeText(getApplicationContext(),"Your Data is Saved ",Toast.LENGTH_LONG).show();
    }

    public void retriveData(){
        sharedperference = getSharedPreferences("DataSaved", Context.MODE_PRIVATE);
        user = sharedperference.getString("Key Name",null);
        Message = sharedperference.getString("Key Message",null);
        count = sharedperference.getInt("counter",0);
        isChecked = sharedperference.getBoolean("Key remember", false);

        username.setText(user);
        usermessage.setText(Message);
        ok.setText(""+count);
        if(isChecked){
            check.setChecked(true);
        }
        else{
            check.setChecked(false);
        }
    }
}