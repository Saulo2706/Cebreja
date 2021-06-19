package com.gs.cebreja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gs.cebreja.R;
import com.gs.cebreja.model.User;

public class BeerRegistred extends MainActivity {

    private Button btn_goto_ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_registred);
        User user = getIntent().getParcelableExtra("user");
        user.setToken(User.token);


        //Botão voltar
        btn_goto_ranking = findViewById(R.id.btn_goto_ranking);
        btn_goto_ranking.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(BeerRegistred.this, RankingActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    }
                }
        );


    }
}