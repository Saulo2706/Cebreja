package com.gs.cebreja.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class ForgetPasswordMessageActivity extends MainActivity {
    private Button btn_goto_loginpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_message);
        SetupUI.set(findViewById(R.id.activity_forget_password_message), ForgetPasswordMessageActivity.this);

        //Botão voltar
        btn_goto_loginpage = (Button) findViewById(R.id.btn_goto_loginpage);
        btn_goto_loginpage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(ForgetPasswordMessageActivity.this, LoginActivity.class);
                    }
                }
        );

    }
}