package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.papelitosgamma.Auxiliar.GameData;
import com.example.papelitosgamma.R;

import java.util.ArrayList;

public class Round extends AppCompatActivity {

    private ArrayList<String> wordsLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        initialize();
    }


    void initialize(){
        wordsLeft = (ArrayList<String>) GameData.WORDS.clone();
        //inicializar el tiempo
        String currentPlayer = GameData.TURN_MANAGER.currentPlayer();
    }
}