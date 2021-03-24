package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gs.cebreja.R;

public class IndexActivity extends MainActivity {

    private Button btnSignUp, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);


        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(IndexActivity.this, LoginActivity.class);
                }
            }
        );

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(IndexActivity.this, SignInActivity.class);
                }
            }
        );
    }


}