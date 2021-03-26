package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class SignUpActivity_2 extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_2);
        SetupUI.set(findViewById(R.id.signUpPage2), SignUpActivity_2.this);

    }
}