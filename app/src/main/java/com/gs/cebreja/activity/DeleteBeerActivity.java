package com.gs.cebreja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class DeleteBeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_beer);
        SetupUI.set(findViewById(R.id.deleteBeer), DeleteBeerActivity.this);

        ImageButton back_btn;
        back_btn = findViewById(R.id.manage_back_btn);


        back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );

    }
}