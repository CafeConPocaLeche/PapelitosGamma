package com.example.papelitosgamma.Auxiliar;

import java.util.ArrayList;
import java.util.Arrays;

public class GameData { //Datos y estructuras estatic o constantes de la partida

    public static final int TIME = 30 ;

    public static final int WORDS_PER_PLAYER = 1;

    public static final int TEAM_AMOUNT = 4;

    public static final int PLAYER_AMOUNT = 9;

    public static final String TEAM_SEPARATOR = " - ";

    public static final int WORD_AMOUNT = PLAYER_AMOUNT*WORDS_PER_PLAYER;

    public static ArrayList<String> PLAYERS = new ArrayList<>(Arrays.asList("Alberto", "Carlos", "Dorado", "María", "Miguel", "Miriam", "Paty", "Sergio", "Victor"));

    public static ArrayList<Team> TEAMS = new ArrayList<Team>(TEAM_AMOUNT);

    public static ArrayList<String> TEAM_NAMES = new ArrayList<String>(TEAM_AMOUNT);

    public static ArrayList<String> WORDS = new ArrayList<>(PLAYER_AMOUNT * WORDS_PER_PLAYER);

    public static boolean ATAJO = true;

    public static ArrayList<String> WORDS_ATAJO = new ArrayList<>(Arrays.asList("pergamino", "botafumeiro","contraproducente", "basilisco", "cloaca", "tendinitis", "Hertfelder", "tenedor", "locutorio"));

    public static GameManager GAME_MANAGER = new GameManager();

    public static ArrayList<Integer> SCORES = new ArrayList<>(TEAM_AMOUNT);

    public static int ROUND_AMOUNT = 3;
}
