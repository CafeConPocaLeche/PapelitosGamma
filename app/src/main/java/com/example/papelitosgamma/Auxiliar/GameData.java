package com.example.papelitosgamma.Auxiliar;

import java.util.ArrayList;
import java.util.Arrays;

public class GameData { //Datos y estructuras estatic o constantes de la partida

    public static final int TIME = 30 ;

    public static final int WORDS_PER_PLAYER = 3;

    public static final int TEAM_AMOUNT = 4;

    public static final int PLAYER_AMOUNT = 9;

    public static ArrayList<String> PLAYERS = new ArrayList<>(Arrays.asList("Alberto", "Carlos", "Dorado", "María", "Miguel", "Miriam", "Paty", "Sergio", "Victor"));

    public static ArrayList<String> TEAMS = new ArrayList<>(TEAM_AMOUNT);

    public static ArrayList<String> WORDS = new ArrayList<>(PLAYER_AMOUNT * WORDS_PER_PLAYER);

}
