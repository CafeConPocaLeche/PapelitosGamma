package com.example.papelazos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.papelazos.Auxiliar.GameData;
import com.example.papelazos.R;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Button start_button; // boton para empezar a jugar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button = findViewById(R.id.start_btn);
    }


    public void Start(View view) { //Desordenar jugadores y pasar a la pantalla siguiente para mostrarlos
        Collections.shuffle(GameData.PLAYERS);
        Intent intent = new Intent(view.getContext(), TeamsView.class);
        startActivity(intent);
    }
}