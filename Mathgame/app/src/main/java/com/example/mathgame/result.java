package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    Button playagain , exit ;
    TextView display , final_score ;
    int score = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        playagain = findViewById(R.id.buttonPlayagain);
        exit = findViewById(R.id.buttonexit);
//        display = findViewById(R.id.textViewdisplay);
//        final_score = findViewById(R.id.textviewScore);

//        Intent intent = getIntent();
//        score = intent.getIntExtra("score" , 1);
//        String userscore = String.valueOf(score);

//        display.setText("Congurationals! The game is over.");
//        final_score.setText("Your score is : "+ 10);

        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(result.this ,MainActivity.class);//when ever ypou use intent
                //you should always call the finish() function tp close the previous activitie ...for no overloading
                startActivity(intent);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}