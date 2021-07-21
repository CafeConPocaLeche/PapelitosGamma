package com.example.papelitosgamma.Auxiliar;

import java.util.ArrayList;

public class GameManager {

    private ArrayList<Team> teams = GameData.TEAMS;

    private int team_turn = 0;
    private int team_counter = 0;
    private int round = 1;

   public String currentPlayer(){
        return teams.get(team_turn).getCurrentPlayer();
    }

    public void nextTurn(){
       //teams.get(team_turn).nextTurn();
       team_turn = (team_turn + 1) % GameData.TEAM_AMOUNT;
    }

    public void increaseScore(){
       team_counter=team_counter%4;
       int currentScore = GameData.SCORES.get(team_counter);
       GameData.SCORES.set(team_counter, currentScore + 1);
       team_counter++;
    }

    public void nextRound(){
       round = (round + 1) % GameData.ROUND_AMOUNT+1;
    }
}
