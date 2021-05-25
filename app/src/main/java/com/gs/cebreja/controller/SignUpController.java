package com.gs.cebreja.controller;


import android.content.Intent;

import com.gs.cebreja.activity.SignUpActivity_2;
import com.gs.cebreja.model.User;
import com.gs.cebreja.view.IRegisterView;

public class SignUpController {

    IRegisterView registerView;
    public SignUpController(IRegisterView registerView) {
        this.registerView = registerView;
    }

    public void OnRegister(String firstname, String lastname,String email, String password) {

        User user = new User(firstname,lastname,email,password);
        int registerCode = user.isValidRegister();

        if(registerCode == 0)
        {
            registerView.OnRegisterError("Nome não pode ficar em branco!");
        }else  if (registerCode == 1){
            registerView.OnRegisterError("Sobrenome não pode ficar em branco!");
        } else  if (registerCode == 2)
        {
            registerView.OnRegisterError("Email Invalido!");
        }else  if(registerCode == 3){
            registerView.OnRegisterError("Senha não pode ficar em branco!");
        }else  if(registerCode == 4){
            registerView.OnRegisterError("Senha menor que 9 digitos!");
        }else {
            registerView.OnRegisterSuccess("Login efetuado com sucesso");
        }

    }

    public void OnRegister_2(){
        registerView.OnRegisterSuccess("Login efetuado com sucesso");
    }


}
