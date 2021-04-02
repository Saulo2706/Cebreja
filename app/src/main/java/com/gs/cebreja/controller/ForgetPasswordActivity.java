package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class ForgetPasswordActivity extends MainActivity {

    private ImageButton forget_password_back_btn;
    private Button forget_password_next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        SetupUI.set(findViewById(R.id.activity_forget_password), ForgetPasswordActivity.this);

        //Botão proximo
        forget_password_next_btn = (Button) findViewById(R.id.forget_password_next_btn);
        forget_password_next_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(ForgetPasswordActivity.this, ForgetPasswordCodeVerifyActivity.class);
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