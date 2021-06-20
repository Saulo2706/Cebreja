package com.gs.cebreja.activity;

import com.gs.cebreja.R;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FavoriteBeersActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_beers);

        ImageButton manage_back_btn;



        //Botão voltar
        manage_back_btn = findViewById(R.id.manage_back_btn);
        manage_back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );
    }
}