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


        teamsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, GameData.TEAM_NAMES);
        teamsListview.setAdapter(teamsAdapter);

    }



   public void fillTeamNames(){ //genera los nombres de cada equipo. Lo hace poniendo los integrantes separados por guiones
        String teamName = ""; Team t = new Team("");
        for(int i = 0; i < GameData.TEAM_AMOUNT; ++i){
            String player1 = GameData.PLAYERS.get(2*i);
            String player2 = GameData.PLAYERS.get(2*i + 1);
            teamName = player1 + GameData.TEAM_SEPARATOR + player2;
            GameData.TEAM_NAMES.add(teamName);
            t = new Team(teamName);
            t.addPlayer(player1);
            t.addPlayer(player2);
            GameData.TEAMS.add(t);
        }
        if(GameData.PLAYER_AMOUNT % 2 == 1){ //Cambiar este sistema por completo si ponemos mas de un equipo de 3 y revisarlo en general, porque es feillo
            String player3 = GameData.PLAYERS.get(GameData.PLAYER_AMOUNT - 1);
            teamName += GameData.TEAM_SEPARATOR + player3;
            GameData.TEAM_NAMES.set(GameData.TEAM_AMOUNT - 1, teamName);
            t.addPlayer(player3);
            GameData.TEAMS.set(GameData.TEAM_AMOUNT - 1, t);
        }
    }

    public void next(View view) {
        Intent intent = new Intent(view.getContext(), RegisterWords.class);
        startActivity(intent);
    }
}