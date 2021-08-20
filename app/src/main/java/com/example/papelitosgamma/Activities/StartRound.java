package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.service.notification.NotificationListenerService;
import android.view.View;
import android.widget.TextView;
import java.lang.Thread;

import com.example.papelitosgamma.Auxiliar.GameData;
import com.example.papelitosgamma.Auxiliar.GameManager;
import com.example.papelitosgamma.Auxiliar.RankingManager;
import com.example.papelitosgamma.R;
import com.example.papelitosgamma.Scores;

public class StartRound extends AppCompatActivity {

    public static int roundNumber = 1;
    private String roundName;
    private TextView mTV, mTVC;
    public int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_round);

        if(roundNumber==4){
            Intent intent = new Intent(this, Scores.class);
            startActivity(intent);
        }

        mTV = findViewById(R.id.roundName);
        roundName = "Ronda " + roundNumber;
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
        counter = 3;
        Intent intent = new Intent(this, Round.class);
        startActivity(intent);
    }
}