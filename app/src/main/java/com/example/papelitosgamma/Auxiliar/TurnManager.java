package com.example.papelitosgamma.Auxiliar;

import java.util.ArrayList;

public class TurnManager {

    private ArrayList<Team> teams = GameData.TEAMS;

    private int team_turn = 0;

   public String currentPlayer(){
        return teams.get(team_turn).getCurrentPlayer();
    }

    public void nextTurn(){
       teams.get(team_turn).nextTurn();
       team_turn = (team_turn + 1) % GameData.TEAM_AMOUNT;
    }

}
