package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.papelitosgamma.Auxiliar.*;
import com.example.papelitosgamma.R;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Button start_button; // boton para empezar a jugar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("HOLa");

        start_button = findViewById(R.id.start_btn);
    }


    public void Start(View view) { //Desordenar jugadores y pasar a la pantalla siguiente para mostrarlos
        Collections.shuffle(com.example.papelitosgamma.Auxiliar.GameData.PLAYERS);
        Intent intent = new Intent(view.getContext(), com.example.papelitosgamma.Activities.TeamsView.class);
        startActivity(intent);
    }
}