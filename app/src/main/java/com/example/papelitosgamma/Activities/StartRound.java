package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import java.lang.Thread;

import com.example.papelitosgamma.R;

public class StartRound extends AppCompatActivity {

    public static String roundName = "Ronda 1";
    private TextView mTV, mTVC;
    public int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_round);

        mTV = findViewById(R.id.roundName);
        mTV.setText(roundName);

        mTVC = findViewById(R.id.countDown);
        new CountDownTimer(4000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                mTVC.setText(String.valueOf(counter));
                counter--;
            }

            @Override
            public void onFinish() {
           gameStart();
            }
        }.start();

    }

   void gameStart(){
        Intent intent = new Intent(this, Round.class);
        startActivity(intent);
    }
}