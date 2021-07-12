package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.papelitosgamma.Auxiliar.GameData;
import com.example.papelitosgamma.R;

import java.util.ArrayList;
import java.util.Random;

public class Round extends AppCompatActivity {

    private ArrayList<String> wordsLeft;
    private int index;
    private Random random;
    private String currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        initialize();
    }

    int nextIndex(){
        return random.nextInt(wordsLeft.size());
    }

    void update(){
        currentPlayer = GameData.GAME_MANAGER.currentPlayer();
        index = nextIndex();
        //mostrar a quien le toca ahora por pantalla
    }

    void initialize(){
        wordsLeft = (ArrayList<String>) GameData.WORDS.clone();
        random = new Random();
        //inicializar el tiempo
        for(int i = 0; i < GameData.TEAM_AMOUNT; ++i)GameData.SCORES.add(0);
        update();
    }

    void wordGuessed(){
        wordsLeft.remove(index);
        GameData.GAME_MANAGER.increaseScore();
        if(wordsLeft.size() == 0){
            GameData.GAME_MANAGER.nextRound();
            // parar tiempo
            // mostrar puntuaciones
            // pasar a la pantalla de la siguiente ronda o terminar la partida
            //sacar boton de siguiente ronda
        }
       else  index = nextIndex();
    }

   void timeOver(){
        //resetear reloj
        GameData.GAME_MANAGER.nextTurn();
        update();
        //cambiar el boton
   }

   void startTime(){
        //cambiar el boton
        //ocultar las puntuaciones
        //enseñar la palabra
       //poner en marcha el crono
   }


}