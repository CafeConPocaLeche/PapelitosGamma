package com.example.papelitosgamma.Auxiliar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class RankingManager {

    public static ArrayList<Integer> ANT = new ArrayList<>();
    public static ArrayList<Integer> POST = new ArrayList<>();
    public static int FIRST = 0;

    public RankingManager(int teamount){
        ANT.add(teamount - 1);
        for(int i = 0; i < teamount - 1; ++i){
            ANT.add(i);
            POST.add(i + 1);
        }
        POST.add(0);
    }

    public static void updateRanking(ArrayList<Integer> SC, int act){
        boolean keep_going = true;

        while(keep_going){
          if(SC.get(act) > SC.get(ANT.get(act))){
              int prev = ANT.get(act);
              if(prev == FIRST){
                  FIRST = act;
                  keep_going = false;
              }
              //Festival de intercambio de los seis punteros afectados
              int next = POST.get(act);
              int prevprev = ANT.get(prev);

              POST.set(act, prev);
              ANT.set(act, prevprev);
              POST.set(prev, next);
              ANT.set(prev, act);
              POST.set(prevprev, act);
              ANT.set(next, prev);
          }
          else keep_going = false;
        }
    }

    public static ArrayList<String> buildRanking(){  //cambiar por fillRanking
        ArrayList<String> ranking = new ArrayList<String>();
        int i = FIRST;

      do{ ranking.add("Equipo " + (i + 1) + " --- " + GameData.SCORES.get(i) + " puntos");
          i = POST.get(i);
      }while(i != FIRST);

        return ranking;
    }

}

