package com.example.papelitosgamma.Auxiliar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class RankingManager {

    public static ArrayList<Integer> ISC = new ArrayList<>(Arrays.asList(0,1,2,3));
    public static ArrayList<Integer> SSC = new ArrayList<>(Arrays.asList(0,1,2,3));


    public static void updateRanking(ArrayList<Integer> SC, int ct){
        int rankActual = SSC.get(ct);
        boolean keep_going = true;

        while(rankActual > 0 && keep_going){
            --rankActual;
            int indexPrev = ISC.get(rankActual);

            if(SC.get(ct)>SC.get(indexPrev)){

                Collections.swap(SSC, SSC.get(ct),SSC.get(indexPrev));
                Collections.swap(ISC, ISC.get(rankActual),ISC.get(rankActual + 1));
            }
            else keep_going = false;
        }
    }

    public static void showRanking(){

        for(int i = 0; i < ISC.size(); ++i) {
            int nextTeam = ISC.get(i);
            System.out.println("Puesto  " + i);
            System.out.println("Equipo  " + nextTeam);
            System.out.println("Puntuacion  " + GameData.SCORES.get(nextTeam));
        }

        System.out.println("\n");
    }
}

}
