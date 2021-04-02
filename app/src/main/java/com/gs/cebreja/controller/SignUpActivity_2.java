package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class SignUpActivity_2 extends MainActivity {

    private ImageButton signup_back_button;
    private Button btnLoginSignUp, btnFinishRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_2);
        SetupUI.set(findViewById(R.id.signUpPage2), SignUpActivity_2.this);

        //BOTÃO DE VOLTAR
        signup_back_button = (ImageButton) findViewById(R.id.signup_back_button);
        signup_back_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(SignUpActivity_2.this, SignUpActivity.class);
                    }
                }
        );

        //BOTÃO FINALIZAR CADASTRO
        btnFinishRegister = (Button) findViewById(R.id.signup_finish_button);
        btnFinishRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //changeActivity(SignUpActivity_2.this, LoginActivity.class);
                    }
                }
        );

        //BOTÃO PARA IR PARA TELA DE LOGIN
        btnLoginSignUp = (Button) findViewById(R.id.signup_login_button_2);
        btnLoginSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(SignUpActivity_2.this, LoginActivity.class);
                    }
                }
        );

    }
}