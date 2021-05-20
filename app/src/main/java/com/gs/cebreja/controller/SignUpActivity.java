package com.gs.cebreja.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class SignUpActivity extends MainActivity {

    private Button btnNextSignUp, btnLoginSignUp;
    private ImageButton signup_back_button;
    private EditText editTextEmailAddress,editTextPassword,editTextLastName,editTextFirstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SetupUI.set(findViewById(R.id.signUpPage), SignUpActivity.this);
        editTextFirstName = (EditText)findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText)findViewById(R.id.editTextLastName);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextEmailAddress = (EditText)findViewById(R.id.editTextEmailAddress);

        //BOTÃO DE VOLTAR
        signup_back_button = (ImageButton) findViewById(R.id.signup_back_button);
        signup_back_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );

        //BOTÃO PROXIMA PAGINA DE REGISTRO
        btnNextSignUp = (Button) findViewById(R.id.btnNextSignUp);
        btnNextSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editTextFirstName.length() == 0){
                            editTextFirstName.setError("Nome não pode ser vazio!");
                        }else if(editTextLastName.length() == 0){
                            editTextLastName.setError("Sobrenome não pode ser vazio!");
                        }else if(editTextEmailAddress.length() == 0){
                            editTextEmailAddress.setError("Email não pode ser vazio!");
                        }else if(!editTextEmailAddress.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                            editTextEmailAddress.setError("Email invalido!");
                        }else if(editTextPassword.length() == 0){
                            editTextPassword.setError("Senha não pode ser vazia!");
                        }else {
                            changeActivity(SignUpActivity.this, SignUpActivity_2.class);
                        }
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