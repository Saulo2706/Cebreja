package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class ForgetPasswordResetActivity extends MainActivity {

    private ImageButton forget_password_back_btn;
    private Button set_new_password_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_reset);
        SetupUI.set(findViewById(R.id.activity_forget_password_reset), ForgetPasswordResetActivity.this);

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