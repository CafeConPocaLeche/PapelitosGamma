package com.example.papelitosgamma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.papelitosgamma.Activities.RegisterWords;
import com.example.papelitosgamma.Activities.StartRound;
import com.example.papelitosgamma.Auxiliar.GameData;

public class  Scores extends AppCompatActivity {

    private ListView ranking_lv;
    private ArrayAdapter<String> ranking_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        ranking_lv = findViewById(R.id.rankingListView);


        ranking_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, GameData.GAME_MANAGER.buildRanking());
        ranking_lv.setAdapter(ranking_adapter);
        ranking_lv.setBackgroundColor(Color.DKGRAY);
    }


    public void MATAME(View view) {
       finish();
    }

    public void startNextRound(View view) {
        Intent intent = new Intent(view.getContext(), StartRound.class);
        startActivity(intent);
    }
}