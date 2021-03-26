package com.gs.cebreja.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class SignUpActivity extends MainActivity {

    private Button btnNextSignUp, btnLoginSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SetupUI.set(findViewById(R.id.signUpPage), SignUpActivity.this);

        btnNextSignUp = (Button) findViewById(R.id.btnNextSignUp);
        btnNextSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(SignUpActivity.this, SignUpActivity_2.class);
                    }
                }
        );

        btnLoginSignUp = (Button) findViewById(R.id.btnLoginSignUp);
        btnLoginSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(SignUpActivity.this, LoginActivity.class);
                    }
                }
        );
    }
}