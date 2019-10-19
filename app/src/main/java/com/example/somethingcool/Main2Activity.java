package com.example.somethingcool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    ImageView bubbleClick;
    Integer count = 0;

//    float x, y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final MediaPlayer mp = MediaPlayer.create(this, R.raw.popsound);
        bubbleClick = (ImageView)findViewById(R.id.imageBubble);

        bubbleClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bubbleClick.setImageResource(R.drawable.popped);
                mp.start();
                count++;
                if (count >= 20){
                    startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        bubbleClick.setImageResource(R.drawable.bubble);
                        Random rn = new Random();
                        int x = rn.nextInt(700-20) + 20;
                        int y = rn.nextInt(1200-20) + 20;

                        bubbleClick.setY(y);
                        bubbleClick.setX(x);
                    }
                }, 80); // Millisecond 1000 = 1 sec

                //generate random values


            }
        });


    }
}