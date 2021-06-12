package com.gs.cebreja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gs.cebreja.R;

public class BeerActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);

        //Botão voltar
        ImageButton back_btn,beer_remove_btn;
        back_btn = findViewById(R.id.beer_back_btn);
        beer_remove_btn = findViewById(R.id.beer_remove_btn);

        beer_remove_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(BeerActivity.this, DeleteBeer.class);
                        //intent.putExtra("user", user);
                        startActivity(intent);
                    }
                }
        );

        back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );

    }

    public void onCustomLikeToggleClick(View view) {
        //Toast.makeText(this, "CustomToggle", Toast.LENGTH_SHORT).show();
    }

    public void onCustomFavToggleClick(View view) {
        //Toast.makeText(this, "CustomToggle", Toast.LENGTH_SHORT).show();
    }
}