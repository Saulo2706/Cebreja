package com.gs.cebreja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gs.cebreja.R;
import com.gs.cebreja.model.User;

public class ApproveOrderSuccessAdminActivity extends AppCompatActivity {

    private Button btn_goto_orders;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_order_success_admin);
        user = (User) getIntent().getParcelableExtra("user");
        user.setToken(User.token);

        System.out.println(user);

        //Botão voltar
        btn_goto_orders = findViewById(R.id.btn_goto_orders);
        btn_goto_orders.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ApproveOrderSuccessAdminActivity.this, SolicitationActivity.class);
                        intent.putExtra("user",user);
                        startActivity(intent);
                    }
                }
        );

    }
}
