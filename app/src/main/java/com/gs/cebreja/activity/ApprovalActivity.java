package com.gs.cebreja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.gs.cebreja.R;
import com.gs.cebreja.model.User;

public class ApprovalActivity extends MainActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval);
        user = getIntent().getExtras().getParcelable("user");
        user.setToken(User.token);
        user.setRoles(User.roles);
        ImageButton manage_back_btn;



        //Botão voltar
        manage_back_btn = findViewById(R.id.manage_back_btn);
        manage_back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );

    }
}