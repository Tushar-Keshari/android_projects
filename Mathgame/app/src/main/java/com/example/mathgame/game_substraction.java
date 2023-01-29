package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class game_substraction extends AppCompatActivity {
    Button ok,next;
    TextView viewscore ,viewlife , viewtime , viewques;
    EditText answer;
    Random random = new Random();
    int number1 , number2;
    int useranswer ;
    int realAnswer ,userScore = 0 , userLife = 3;
    CountDownTimer time;
    private static final long START_TIMER_IN_MILIS = 60000;  //final value should be writen with capital letter
    Boolean time_running;
    long timer_left_in_milis = START_TIMER_IN_MILIS;
    IntentFilter filter = new IntentFilter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_substraction);

        ok = findViewById(R.id.buttonOk);
        next = findViewById(R.id.buttonNext);
        answer = findViewById(R.id.editTextAnswer);
        viewscore = findViewById(R.id.score);
        viewlife = findViewById(R.id.life);
        viewtime = findViewById(R.id.timer);
        viewques = findViewById(R.id.textViewquestion);

        gameContinue();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useranswer = Integer.parseInt(answer.getText().toString());

                pauseTimer(); //CALLING PAUSE TIMER METHOD BEFOR CHECKING IRRECPECTIVE OF THE VALUE IF THE BUTTON I SCLICKED
                //THE TIMER WILL BE PAUSED ....
                if(useranswer == realAnswer){
                    userScore = userScore + 10;
                    viewscore.setText(""+userScore);
                    viewques.setText("Congurational , Your answer is correct.");
                }
                else{
                    userLife = userLife - 1;
                    viewlife.setText("" + userLife);
                    viewques.setText("Your Answer is Wrong.");
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
                answer.setText("");

                if(userLife == 0){
                    Toast.makeText(getApplicationContext(),"GAME OVER" , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(game_substraction.this , result.class);
//                    intent.putExtra("score" , userScore);
                    startActivity(intent);
//                    finish();
                }
                else{
                    gameContinue();
                }
            }
        });

    }
    public void gameContinue(){
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);

        realAnswer = number1 - number2;
        viewques.setText(""+number1 + "-" + ""+number2);

        startTimer();
    }
    public void startTimer(){
        time = new CountDownTimer(timer_left_in_milis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer_left_in_milis = millisUntilFinished;
                updateText();
            }
            @Override
            public void onFinish() {
                pauseTimer();
                resetTimer();
                updateText();
                userLife = userLife - 1 ;
                viewlife.setText(""+userLife);
                viewques.setText("Sorry! Time is up .");
            }
        }.start();
        time_running = true;
    }
    public void updateText(){     // IMPORTANT CODE FOR FORMING A TIMER
        int second = (int)(timer_left_in_milis / 1000) % 60 ;
        String time_left = String.format(Locale.getDefault() , "%02d" , second);
        viewtime.setText(time_left);
    }
    public void resetTimer(){
        timer_left_in_milis = START_TIMER_IN_MILIS;
        updateText();
    }
    public void pauseTimer(){
        time.cancel();
        time_running = false;
    }
}