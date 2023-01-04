package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashScreen extends AppCompatActivity {

    private ImageView image;
    private TextView text ;

    Animation animationimage , animationtext ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        image = findViewById(R.id.gameimage);
        text = findViewById(R.id.gametext);

        animationimage = AnimationUtils.loadAnimation(this,R.anim.imageanimation);
        animationtext = AnimationUtils.loadAnimation(this,R.anim.textanimation);

        image.setAnimation(animationimage);
        text.setAnimation(animationtext);

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(splashScreen.this,MainActivity.class));
                finish();
            }
        }.start();



    }
}