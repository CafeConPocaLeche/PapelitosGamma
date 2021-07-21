package com.example.papelitosgamma.Auxiliar;

import java.util.ArrayList;

public class Team {

    private String name = "";
    private ArrayList<String> players = new ArrayList<>();
    private int turn = 0;

    public Team(String teamname){
        name = teamname;
    }

    public int size(){
        return players.size();
    }

    public void addPlayer(String playername){
        players.add(playername);
    }

    public void nextTurn(){
        turn = (turn + 1) % size();
    }

    public ArrayList<String> getPlayers(){
        return players;
    }

    public String getCurrentPlayer(){
        String name = players.get(turn);
        nextTurn();
        return name;
    }
}
