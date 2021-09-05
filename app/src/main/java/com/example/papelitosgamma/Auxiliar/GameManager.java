package com.example.papelitosgamma.Auxiliar;

import java.util.ArrayList;

public class GameManager {


    private static int team_turn = 0;
    private static RankingManager rk_manager = new RankingManager(GameData.TEAM_AMOUNT);

   public static String currentPlayer(){
        return GameData.TEAMS.get(team_turn).getCurrentPlayer();
    }

    public static void nextTurn(){
       GameData.GAME_MANAGER.updateRanking();
       GameData.TEAMS.get(team_turn).nextTurn();
       team_turn = (team_turn + 1) % GameData.TEAM_AMOUNT;
    }

    public static void increaseScore(){
       int currentScore = GameData.SCORES.get(team_turn);
       GameData.SCORES.set(team_turn, currentScore + 1);
    }

    public static void nextRound(){ GameData.CURRENT_ROUND = (GameData.CURRENT_ROUND) % GameData.ROUND_AMOUNT + 1; }
    
    public static void updateRanking(){
       rk_manager.updateRanking(GameData.SCORES, team_turn);
    }


    public static ArrayList<String> buildRanking(){return rk_manager.buildRanking();}

}
