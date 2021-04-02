package com.gs.cebreja.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.gs.cebreja.util.SetupUI;
import com.gs.cebreja.R;

public class LoginActivity extends MainActivity {

    private EditText editTextEmailAddress, editTextPassword;
    private ImageButton login_back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetupUI.set(findViewById(R.id.loginPage), LoginActivity.this);

        login_back_button = (ImageButton) findViewById(R.id.login_back_button);
        login_back_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(LoginActivity.this, IndexActivity.class);
                    }
                }
        );


        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextEmailAddress = (EditText)findViewById(R.id.editTextEmailAddress);

    }

}



