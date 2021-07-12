package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.papelitosgamma.Auxiliar.GameData;
import com.example.papelitosgamma.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Vector;

public class RegisterWords extends AppCompatActivity {


    private TextInputEditText wordCollector;
    private Button wordRegister;
    private Spinner playerSelector;
    private ArrayAdapter<String> playersAdapter;

    private Vector<Integer> chosenWords;

    private int index;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_words);

        chosenWords = new Vector<Integer>(GameData.PLAYER_AMOUNT);
        for(int i = 0; i < GameData.PLAYER_AMOUNT; ++i)chosenWords.add(0);
        index = 0;


        wordCollector = findViewById(R.id.wordInput);
        wordRegister = findViewById(R.id.register_btn);
        playerSelector = findViewById(R.id.players_spn);
       // fillPlayerTextViews(playersViews);

        playersAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, GameData.PLAYERS);
        playersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerSelector.setAdapter(playersAdapter);

        playerSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void registerWord(View view) {
        if (GameData.WORDS.size() < GameData.WORD_AMOUNT) {
            int chosenAmount = chosenWords.get(index);
            if (chosenAmount < GameData.WORDS_PER_PLAYER) {
                if (chosenAmount == GameData.WORDS_PER_PLAYER - 1) {
                    playerSelector.getChildAt(index);
                }
                GameData.WORDS.add(wordCollector.getText().toString());
                wordCollector.getText().clear();
                chosenWords.set(index, chosenAmount + 1);
               // Snackbar.make(this, playerSelector, GameData.WORDS.size() + "/" + GameData.WORD_AMOUNT, Snackbar.LENGTH_SHORT).show();
                if(GameData.WORDS.size() == GameData.WORD_AMOUNT){
                    wordRegister.setText("PLAY");
                    wordRegister.setBackgroundColor(Color.MAGENTA);
                }

            } else
                Snackbar.make(this, playerSelector, "Palabras agotadas", Snackbar.LENGTH_SHORT).show();

        }
        else {
            Intent intent = new Intent(view.getContext(), StartRound.class);
            startActivity(intent);
        }


    }
    }
