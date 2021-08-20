package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.papelitosgamma.Auxiliar.GameData;
import com.example.papelitosgamma.Auxiliar.GameManager;
import com.example.papelitosgamma.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Round extends AppCompatActivity {

    private String currentPlayer;
    private ArrayList<String> wordsLeft;
    private int index, timer = 30;
    private boolean first = true, round=true;
    private Random random;
    private TextView textCurrentPlayer, textCurrentWord, countDown;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        textCurrentPlayer = findViewById(R.id.currentPlayer);
        textCurrentWord = findViewById(R.id.currentWord);
        startButton = findViewById(R.id.nextWordButtom);
        countDown = findViewById(R.id.countDownRound);

        initialize();

        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(wordsLeft.size()==1){
                    if(round){
                        countDown.setText("");
                        int winner = getIndexOfLargest()+1;
                        StartRound.roundNumber++;
                        startButton.setText("Ronda "+ StartRound.roundNumber);
                        textCurrentWord.setText("Equipo " + winner);
                        round = false;
                    }else{
                        Intent intent = new Intent(v.getContext(),StartRound.class);
                        startActivity(intent);
                    }
                }else{
                    if(first){
                        first = false;
                        startButton.setText("SIGUIENTE");
                        textCurrentWord.setText(wordsLeft.get(index));
                        startTime();
                    }else{
                        wordsGuessed();
                        textCurrentWord.setText(wordsLeft.get(index));
                    }
                }
            }
        });
    }

    void initialize(){
        wordsLeft = (ArrayList<String>) GameData.WORDS.clone();
        random = new Random();
        update();
    }

    void update(){
        currentPlayer = GameData.GAME_MANAGER.currentPlayer();
        textCurrentPlayer.setText(currentPlayer);
        index = nextIndex();
    }

    int nextIndex(){
        return random.nextInt(wordsLeft.size());
    }

    void wordsGuessed(){
        wordsLeft.remove(index);
        GameData.GAME_MANAGER.increaseScore();
        index = nextIndex();

    }

    void startTime(){
        new CountDownTimer(31000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.setText(String.valueOf(timer));
                timer--;
            }
            @Override
            public void onFinish() {
                first = true;
                textCurrentWord.setText("SIGUIENTE JUGADOR");
                startButton.setText("COMENZAR");
                countDown.setText("30");
                timer=30;
                GameData.GAME_MANAGER.nextTurn();
                update();
            }

        }.start();
    }

}