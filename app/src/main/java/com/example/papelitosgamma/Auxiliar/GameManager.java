package com.example.papelitosgamma.Auxiliar;

import java.util.ArrayList;

public class GameManager {

    private ArrayList<Team> teams = GameData.TEAMS;

    private static int team_turn = 0;
    private int round = 1;
    private static RankingManager rk_manager = new RankingManager();

   public String currentPlayer(){
        return teams.get(team_turn).getCurrentPlayer();
    }

    public void nextTurn(){
       //teams.get(team_turn).nextTurn();
        updateRanking();
       team_turn = (team_turn + 1) % GameData.TEAM_AMOUNT;
    }

    public void increaseScore(){
       int currentScore = GameData.SCORES.get(team_turn);
       GameData.SCORES.set(team_turn, currentScore + 1);
    }

    public void nextRound(){
       showRanking();
       round = (round + 1) % GameData.ROUND_AMOUNT+1;
    }
    
    public static void updateRanking(){
       rk_manager.updateRanking(GameData.SCORES, team_turn);
    }
    
    public static void showRanking(){
       rk_manager.showRanking();
    }
}
