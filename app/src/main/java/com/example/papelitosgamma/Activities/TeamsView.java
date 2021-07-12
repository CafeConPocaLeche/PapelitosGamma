package com.example.papelazos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.papelazos.Auxiliar.GameData;
import com.example.papelazos.R;

public class TeamsView extends AppCompatActivity {

    private ListView teamsListview;
    private ArrayAdapter<String> teamsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_view);

        teamsListview = findViewById(R.id.teamsview_lv);
        fillTeamNames();
        teamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, GameData.TEAMS);
        teamsListview.setAdapter(teamsAdapter);

    }

    public void fillTeamNames(){ //genera los nombres de cada equipo. Lo hace poniendo los integrantes separados por guiones
        String teamName = "";
        for(int i = 0; i < GameData.TEAM_AMOUNT; ++i){
            teamName = GameData.PLAYERS.get(2*i);
            teamName += " - ";
            teamName += GameData.PLAYERS.get(2*i + 1);
            GameData.TEAMS.add(teamName);
        }
        if(GameData.PLAYER_AMOUNT % 2 == 1){
            teamName += " - ";
            teamName += GameData.PLAYERS.get(GameData.PLAYER_AMOUNT - 1);
            GameData.TEAMS.set(GameData.TEAM_AMOUNT - 1, teamName);
        }
    }

    public void next(View view) {
        Intent intent = new Intent(view.getContext(), RegisterWords.class);
        startActivity(intent);
    }
}