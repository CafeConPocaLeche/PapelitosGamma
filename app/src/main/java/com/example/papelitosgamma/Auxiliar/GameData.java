package com.example.papelitosgamma.Auxiliar;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class GameData { //Datos y estructuras estatic o constantes de la partida

    public static final int TIME = 30 ;

    public static final int WORDS_PER_PLAYER = 1;

    public static final int TEAM_AMOUNT = 4;

    public static final int PLAYER_AMOUNT = 9;

    public static final String TEAM_SEPARATOR = " - ";

    public static final int WORD_AMOUNT = PLAYER_AMOUNT*WORDS_PER_PLAYER;

    //public static ArrayList<Pair<String,Integer>> PLAYERSPOINTS = new ArrayList<>(Arrays.asList(Pair.create("Alberto",0), Pair.create("Carlos",0), Pair.create("Dorado",0), Pair.create("Maria",0), Pair.create("Miguel",0), Pair.create("Miri",0), Pair.create("Paty",0), Pair.create("Sergio",0), Pair.create("Victor",0)));

    public static ArrayList<String> PLAYERS = new ArrayList<>(Arrays.asList("Alberto","Carlos","Dorado","Maria","Miguel","Miri","Paty","Sergio","Victor"));

    public static ArrayList<Team> TEAMS = new ArrayList<Team>(TEAM_AMOUNT);

    public static ArrayList<String> TEAM_NAMES = new ArrayList<String>(TEAM_AMOUNT);

    public static ArrayList<String> WORDS = new ArrayList<>(PLAYER_AMOUNT * WORDS_PER_PLAYER);

    public static boolean ATAJO = true;

    public static ArrayList<String> WORDS_ATAJO = new ArrayList<>(Arrays.asList("uno","dos","tres","cuatro","cinco"));

    public static GameManager GAME_MANAGER = new GameManager();

    public static ArrayList<Integer> SCORES = new ArrayList<>(Arrays.asList(0,0,0,0));

    public static int ROUND_AMOUNT = 3;
}
