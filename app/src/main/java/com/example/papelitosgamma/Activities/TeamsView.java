package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.papelitosgamma.Auxiliar.*;
import com.example.papelitosgamma.R;

public class TeamsView extends AppCompatActivity {

    private ListView teamsListview;
    private ArrayAdapter<String> teamsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_view);

        teamsListview = findViewById(R.id.teamsview_lv);
        fillTeamNames();
        teamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, com.example.papelitosgamma.Auxiliar.GameData.TEAMS);
        teamsListview.setAdapter(teamsAdapter);

    }

    public void fillTeamNames(){ //genera los nombres de cada equipo. Lo hace poniendo los integrantes separados por guiones
        String teamName = "";
        for(int i = 0; i < com.example.papelitosgamma.Auxiliar.GameData.TEAM_AMOUNT; ++i){
            teamName = com.example.papelitosgamma.Auxiliar.GameData.PLAYERS.get(2*i);
            teamName += " - ";
            teamName += com.example.papelitosgamma.Auxiliar.GameData.PLAYERS.get(2*i + 1);
            com.example.papelitosgamma.Auxiliar.GameData.TEAMS.add(teamName);
        }
        if(com.example.papelitosgamma.Auxiliar.GameData.PLAYER_AMOUNT % 2 == 1){
            teamName += " - ";
            teamName += com.example.papelitosgamma.Auxiliar.GameData.PLAYERS.get(com.example.papelitosgamma.Auxiliar.GameData.PLAYER_AMOUNT - 1);
            com.example.papelitosgamma.Auxiliar.GameData.TEAMS.set(com.example.papelitosgamma.Auxiliar.GameData.TEAM_AMOUNT - 1, teamName);
        }
    }

    public void next(View view) {
        Intent intent = new Intent(view.getContext(), RegisterWords.class);
        startActivity(intent);
    }
}