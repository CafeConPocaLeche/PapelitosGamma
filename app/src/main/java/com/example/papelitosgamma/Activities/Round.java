package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.papelitosgamma.Auxiliar.GameData;
import com.example.papelitosgamma.Auxiliar.GameManager;
import com.example.papelitosgamma.R;
import com.example.papelitosgamma.Scores;

import java.util.ArrayList;
import java.util.Random;

public class Round extends AppCompatActivity {

    private ArrayList<String> wordsLeft;
    private int index;
    private Random random;
    private TextView textCurrentPlayer, textCurrentWord, countDown;
    private Button startButton;
    private CountDownTimer crono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        textCurrentPlayer = findViewById(R.id.currentPlayer);
        textCurrentWord = findViewById(R.id.currentWord);
        startButton = findViewById(R.id.nextWordButtom);
        countDown = findViewById(R.id.countDownRound);


        wordsLeft = (ArrayList<String>) GameData.WORDS.clone();
        random = new Random();
        textCurrentPlayer.setText(GameManager.currentPlayer());
        countDown.setText(String.valueOf(GameData.TIME_LEFT));
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setOnClickListener(null);
                playTurn();
            }
        });
        setCrono(GameData.TIME_LEFT);

    }


    void playTurn(){
        new CountDownTimer(4000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                textCurrentWord.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                index = nextIndex();
                textCurrentWord.setText(wordsLeft.get(index));
                startButton.setText("ADIVINADA");
                startButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        wordGuessed();
                    }
                });
                crono.start();
            }
        }.start();


    }

    void wordGuessed(){
        GameManager.increaseScore();
        if(wordsLeft.size() > 1) {
            wordsLeft.remove(index);
            index = nextIndex();
            textCurrentWord.setText(wordsLeft.get(index));
        }
        else{
            GameData.TIME_LEFT = Integer.valueOf(countDown.getText().toString());
            crono.cancel();
            textCurrentWord.setText("");
            GameData.GAME_MANAGER.updateRanking();
            showScores();
            GameManager.nextRound();
        }

    }


    void setCrono(int seconds){
        crono = new CountDownTimer((seconds+ 1)*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.setText(String.valueOf(millisUntilFinished/1000));
            }
            @Override
            public void onFinish() {

                textCurrentWord.setText("");
                GameData.TIME_LEFT = GameData.INITIAL_TIME;
                GameManager.nextTurn();
                startButton.setText("COMENZAR");
                textCurrentPlayer.setText(GameManager.currentPlayer());
                countDown.setText(String.valueOf(GameData.TIME_LEFT));
                setCrono(GameData.TIME_LEFT);
                startButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startButton.setOnClickListener(null);
                        playTurn();
                    }
                });
            }

        };


    }

    int nextIndex(){ return random.nextInt(wordsLeft.size()); }

    void showScores(){
        Intent intent = new Intent(this, Scores.class);
        startActivity(intent);
    }

}