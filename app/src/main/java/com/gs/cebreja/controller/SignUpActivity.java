package com.gs.cebreja.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class SignUpActivity extends MainActivity {

    private Button btnNextSignUp, btnLoginSignUp;
    private ImageButton signup_back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SetupUI.set(findViewById(R.id.signUpPage), SignUpActivity.this);


        //BOTÃO DE VOLTAR
        signup_back_button = (ImageButton) findViewById(R.id.signup_back_button);
        signup_back_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(SignUpActivity.this, IndexActivity.class);
                    }
                }
        );

        //BOTÃO PROXIMA PAGINA DE REGISTRO
        btnNextSignUp = (Button) findViewById(R.id.btnNextSignUp);
        btnNextSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(SignUpActivity.this, SignUpActivity_2.class);
                    }
                }
        );

        //BOTÃO PARA IR PARA TELA DE LOGIN
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