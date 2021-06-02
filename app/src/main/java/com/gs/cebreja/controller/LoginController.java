package com.gs.cebreja.controller;

import com.gs.cebreja.model.User;
import com.gs.cebreja.view.ILoginView;

public class LoginController{

    ILoginView loginView;
    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    public void OnLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValid();
        if(loginCode == 0)
        {
            loginView.OnLoginError("Por favor insira o email");
        }else  if (loginCode == 1){
            loginView.OnLoginError("Por favor insira um email valido");
        } else  if (loginCode == 2)
        {
            loginView.OnLoginError("Por favor insira uma senha");
        }else  if(loginCode == 3){
            loginView.OnLoginError("Por favor insira uma senha maior de 8 caracteres!");
        }
        else {
            loginView.OnLoginSuccess("Login efetuado com sucesso");
        }
    }




}


