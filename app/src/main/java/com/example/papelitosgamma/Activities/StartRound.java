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

    private String roundName;
    private TextView mTV, mTVC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_round);

        mTV = findViewById(R.id.roundName);
        roundName = "Ronda " + GameData.CURRENT_ROUND;
        mTV.setText(roundName);

        mTVC = findViewById(R.id.countDown);

        mTVC.setText(GameData.ROUND_TITLES.get(GameData.CURRENT_ROUND - 1));
        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
               // mTVC.setText(String.valueOf(counter));
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