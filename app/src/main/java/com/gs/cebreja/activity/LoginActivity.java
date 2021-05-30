package com.gs.cebreja.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.gs.cebreja.controller.LoginController;
import com.gs.cebreja.model.User;
import com.gs.cebreja.util.SetupUI;
import com.gs.cebreja.R;
import com.gs.cebreja.view.ILoginView;

public class LoginActivity extends MainActivity implements ILoginView {

    private EditText email, password;
    private ImageButton login_back_button;
    private Button btn_forget_password, btnSignUp, btnLogin;
    private LoginController loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetupUI.set(findViewById(R.id.loginPage), LoginActivity.this);

        email = (EditText)findViewById(R.id.editTextEmailAddress);
        password = (EditText)findViewById(R.id.editTextPassword);
        loginPresenter = new LoginController(this);

        //Botão Login
        btnLogin =(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginPresenter.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
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



    }

    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        User user = new User(email.getText().toString().trim(),password.getText().toString().trim());
        Intent intent = new Intent(LoginActivity.this, RankingActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}


