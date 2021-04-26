package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.gs.cebreja.util.SetupUI;
import com.gs.cebreja.R;

public class LoginActivity extends MainActivity {

    private EditText editTextEmailAddress, editTextPassword;
    private ImageButton login_back_button;
    private Button btn_forget_password, btnSignUp, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetupUI.set(findViewById(R.id.loginPage), LoginActivity.this);

        //Botão Login
        btnLogin =(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(LoginActivity.this, RankingActivity.class);
                    }
                }
        );

        //Botão Registrar
        btnSignUp =(Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        changeActivity(LoginActivity.this, SignUpActivity.class);
                    }
                }
        );

        //Botão esqueci senha
        btn_forget_password =(Button) findViewById(R.id.btn_forget_password);
        btn_forget_password.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(LoginActivity.this, ForgetPasswordActivity.class);
                    }
                }
        );

        //Botão voltar
        login_back_button = (ImageButton) findViewById(R.id.login_back_button);
        login_back_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );


        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextEmailAddress = (EditText)findViewById(R.id.editTextEmailAddress);

    }

}



