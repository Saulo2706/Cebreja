package com.gs.cebreja.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.gs.cebreja.controller.LoginController;
import com.gs.cebreja.mapper.UserLoginMapper;
import com.gs.cebreja.model.User;


import com.gs.cebreja.model.UserRole;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.UserLoginResponse;
import com.gs.cebreja.util.SetupUI;
import com.gs.cebreja.R;
import com.gs.cebreja.view.ILoginView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends MainActivity implements ILoginView {

    private EditText email, password;
    private ImageButton login_back_button;
    private Button btn_forget_password, btnSignUp, btnLogin;
    private LoginController loginPresenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetupUI.set(findViewById(R.id.loginPage), LoginActivity.this);

        dialog = new ProgressDialog(LoginActivity.this);
        dialog.setTitle("Realizando Login");
        dialog.setMessage("Carregando Solicitação");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        email = (EditText)findViewById(R.id.editTextEmailAddress);
        password = (EditText)findViewById(R.id.editTextPassword);
        loginPresenter = new LoginController(this);

        email.setText("saulojr02@outlook.com");
        password.setText("123456789");

        //Botão Login
        btnLogin =(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.show();
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

    public void post_request(String email, String password) {
        User user = new User(email,password);
        ApiService.getInstaceLogin()
                .obterDadosUser(user)
                .enqueue(new Callback<UserLoginResponse>() {
                    @Override
                    public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                        if (response.isSuccessful()){
                            List<UserRole> userRoles = UserLoginMapper.deRolesParaDominio(response.body().getRoles());
                            User user = new User(response.body().getEmail(),response.body().getFirstName(),response.body().getLastName(),response.body().getGender(),response.body().getBirthday(),response.body().getToken(),userRoles);
                            Toast.makeText(LoginActivity.this,"Login efetuado com sucesso",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, RankingActivity.class);
                            intent.putExtra("user", user);
                            dialog.dismiss();
                            startActivity(intent);
                        }else {
                            dialog.dismiss();
                            showError();
                            System.out.println(response.code());
                        }

                    }

                    @Override
                    public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                        dialog.dismiss();
                        showError();
                    }
                });

    }



    private void showError(){
        Toast.makeText(this,"Email ou Senha invalidos!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnLoginSuccess(String message) {
        post_request(email.getText().toString().trim(),password.getText().toString().trim());
    }

    @Override
    public void OnLoginError(String message) {
        dialog.dismiss();
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}



