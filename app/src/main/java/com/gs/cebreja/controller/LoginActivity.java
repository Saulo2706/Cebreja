package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import com.gs.cebreja.util.SetupUI;
import com.gs.cebreja.R;

public class LoginActivity extends MainActivity {

    EditText editTextEmailAddress, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetupUI.set(findViewById(R.id.loginPage), LoginActivity.this);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextEmailAddress = (EditText)findViewById(R.id.editTextEmailAddress);

    }

}



