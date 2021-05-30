package com.gs.cebreja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.gs.cebreja.R;

public class BeerActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);

        TextView textView = findViewById(R.id.titleBeer);

        String titleBeer = "Titulo não inputado";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            titleBeer = extras.getString("titleBeer");
        }

        textView.setText(titleBeer);
    }
}