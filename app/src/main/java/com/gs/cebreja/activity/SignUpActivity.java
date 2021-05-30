package com.gs.cebreja.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.gs.cebreja.R;
import com.gs.cebreja.controller.LoginController;
import com.gs.cebreja.controller.SignUpController;
import com.gs.cebreja.model.User;
import com.gs.cebreja.util.SetupUI;
import com.gs.cebreja.view.ILoginView;
import com.gs.cebreja.view.IRegisterView;

public class SignUpActivity extends MainActivity implements IRegisterView {

    private Button btnNextSignUp, btnLoginSignUp;
    private ImageButton signup_back_button;
    private EditText email,password,LastName,FirstName, passwordConfirm;
    private SignUpController signUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SetupUI.set(findViewById(R.id.signUpPage), SignUpActivity.this);

        FirstName = (EditText)findViewById(R.id.editTextFirstName);
        LastName = (EditText)findViewById(R.id.editTextLastName);
        password = (EditText)findViewById(R.id.editTextPassword);
        email = (EditText)findViewById(R.id.editTextEmailAddress);
        passwordConfirm = (EditText)findViewById(R.id.editTextConfirmPassword);

        signUpPresenter = new SignUpController(this);

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
                        if (password.getText().toString().trim().equals(passwordConfirm.getText().toString().trim())){
                            signUpPresenter.OnRegister(FirstName.getText().toString().trim(),LastName.getText().toString().trim(),email.getText().toString().trim(),password.getText().toString().trim());
                        }else {
                            Context contexto = getApplicationContext();
                            String texto = "Senhas não conferem!";
                            Toast toast = Toast.makeText(contexto,texto,Toast.LENGTH_SHORT);
                            toast.show();
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

    @Override
    public void OnRegisterSuccess(String message) {
        //Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        User user = new User(FirstName.getText().toString().trim(),LastName.getText().toString().trim(),email.getText().toString().trim(),password.getText().toString().trim());
        Intent intent = new Intent(SignUpActivity.this, SignUpActivity_2.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    @Override
    public void OnRegisterError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}