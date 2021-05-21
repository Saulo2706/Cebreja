package com.gs.cebreja.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class ForgetPasswordActivity extends MainActivity {

    private ImageButton forget_password_back_btn;
    private Button forget_password_next_btn;
    private TextView editTextEmailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        SetupUI.set(findViewById(R.id.activity_forget_password), ForgetPasswordActivity.this);

        editTextEmailAddress = (EditText)findViewById(R.id.editTextEmailAddress);
        //Botão proximo
        forget_password_next_btn = (Button) findViewById(R.id.forget_password_next_btn);
        forget_password_next_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editTextEmailAddress.length() == 0){
                            editTextEmailAddress.setError("Email não pode ser vazio!");
                        }else if(!editTextEmailAddress.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                            editTextEmailAddress.setError("Email invalido!");
                        }else{
                            changeActivity(ForgetPasswordActivity.this, ForgetPasswordCodeVerifyActivity.class);
                        }
                    }
                }
        );

        //Botão voltar
        forget_password_back_btn = (ImageButton) findViewById(R.id.forget_password_back_btn);
        forget_password_back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );

    }
}