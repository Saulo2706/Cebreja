package com.gs.cebreja.controller;

import androidx.appcompat.widget.Toolbar;

import androidx.drawerlayout.widget.DrawerLayout;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.google.android.material.navigation.NavigationView;
import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;


public class ManagementProfile extends MainActivity {

    private ImageButton manage_back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_profile);
        SetupUI.set(findViewById(R.id.manageProfile), ManagementProfile.this);

        //Botão voltar
        manage_back_btn = (ImageButton) findViewById(R.id.manage_back_btn);
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