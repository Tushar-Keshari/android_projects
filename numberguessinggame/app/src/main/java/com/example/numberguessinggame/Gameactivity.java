package com.example.numberguessinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Gameactivity extends AppCompatActivity {

    private TextView textViewlast , textViewcount , textViewhint;
    private Button confirm;
    private EditText editTextguess;

    boolean twoDigit , threeDigit , fourDigit;

    Random r = new Random();
    int random;
    int remaningRights = 10;

    ArrayList<Integer> guesslist = new ArrayList<>();
    int userattempt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameactivity);

        textViewlast = findViewById(R.id.textViewlast);
        textViewcount = findViewById(R.id.textviewcount);
        textViewhint = findViewById(R.id.texthint);

        confirm = findViewById(R.id.buttonconfirm);
        editTextguess = findViewById(R.id.enternumber);

        //by using this we will get the option chosen by the user ....
        twoDigit = getIntent().getBooleanExtra("two",false);
        threeDigit = getIntent().getBooleanExtra("three",false);
        fourDigit = getIntent().getBooleanExtra("four",false);

        //checking for the option chosen by the user and accordingly generating the random value
        if(twoDigit){
            random = r.nextInt(90) + 10;
        }
        if(threeDigit){
            random = r.nextInt(900) + 100;
        }
        if(fourDigit){
            random = r.nextInt(9000) + 1000;
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = editTextguess.getText().toString();
                if(guess.equals("")){
                    Toast.makeText(Gameactivity.this , "Please Enter the Guess" , Toast.LENGTH_LONG).show();
                }
                else{
                    textViewlast.setVisibility(View.VISIBLE);
                    textViewcount.setVisibility(View.VISIBLE);
                    textViewhint.setVisibility(View.VISIBLE);

                    remaningRights--;
                    userattempt++;

                    int userGuess = Integer.parseInt(guess);
                    guesslist.add(userGuess);

                    textViewlast.setText("Your last guess is :"+guess);
                    textViewcount.setText("Your remaining is :"+remaningRights);

                    if(userGuess == random){
                        AlertDialog.Builder builder = new AlertDialog.Builder(Gameactivity.this);
                        builder.setTitle("Number Guessing game");
                        builder.setCancelable(false);
                        builder.setMessage("Conguratulation . My guess was " +random+ "\n\n You Know my no. in "
                        + userattempt + "attempts. \n\n Your guesses" + guesslist
                        + " \n\n Would you like to play again ?");

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Gameactivity.this , MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });

                        builder.create().show();

                    }
                    if(userGuess > random){
                        textViewhint.setText("Please decrease the guess");
                    }
                    if(userGuess < random){
                        textViewhint.setText("Please increase the guess");
                    }
                    if(remaningRights == 0){

                        AlertDialog.Builder builder = new AlertDialog.Builder(Gameactivity.this);
                        builder.setTitle("Number Guessing game");
                        builder.setCancelable(false);
                        builder.setMessage("Sorry . Your right to guess is over ." + "\n\n You Know my no. in "
                                + userattempt + "attempts. \n\n Your guesses" + guesslist
                                + " \n\n Would you like to play again ?");

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Gameactivity.this , MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });

                        builder.create().show();
                    }
                    editTextguess.setText("");
                }
            }
        });
    }
}