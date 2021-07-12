package com.example.papelitosgamma.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.papelitosgamma.R;

public class StartRound extends AppCompatActivity {

    public static String roundName = "Ronda 1";
    private TextView mTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_round);

        mTV = findViewById(R.id.roundName);
        mTV.setText(roundName);

    }
}