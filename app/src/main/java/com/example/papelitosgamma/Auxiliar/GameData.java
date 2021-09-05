package com.example.papelitosgamma.Auxiliar;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class GameData { //Datos y estructuras estatic o constantes de la partida

    public static final int INITIAL_TIME = 10;

    public static int TIME_LEFT = INITIAL_TIME;

    public static final int WORDS_PER_PLAYER = 1;

    public static int TEAM_AMOUNT;

    public static int PLAYER_AMOUNT;

    public static final String TEAM_SEPARATOR = " - ";

    public static int WORD_AMOUNT;

    //public static ArrayList<Pair<String,Integer>> PLAYERSPOINTS = new ArrayList<>(Arrays.asList(Pair.create("Alberto",0), Pair.create("Carlos",0), Pair.create("Dorado",0), Pair.create("Maria",0), Pair.create("Miguel",0), Pair.create("Miri",0), Pair.create("Paty",0), Pair.create("Sergio",0), Pair.create("Victor",0)));

    //public static ArrayList<String> PLAYERS = new ArrayList<>(Arrays.asList("Alberto","Carlos","Dorado","Maria","Miguel","Miri","Paty","Sergio","Victor"));

    public static ArrayList<String> PLAYERS = new ArrayList<>();

    public static ArrayList<Team> TEAMS = new ArrayList<Team>(TEAM_AMOUNT);

    public static ArrayList<String> TEAM_NAMES = new ArrayList<String>(TEAM_AMOUNT);

    public static ArrayList<String> WORDS = new ArrayList<>(PLAYER_AMOUNT * WORDS_PER_PLAYER);

    public static GameManager GAME_MANAGER;

    public static ArrayList<Integer> SCORES = new ArrayList<>();

    public static int CURRENT_ROUND = 1;

    public static int ROUND_AMOUNT = 3;

    public static ArrayList<String> ROUND_TITLES = new ArrayList<>(Arrays.asList("DEFINE","UNA PALABRA","MIMICA"));

}
