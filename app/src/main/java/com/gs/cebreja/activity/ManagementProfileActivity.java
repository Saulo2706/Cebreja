package com.gs.cebreja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.gs.cebreja.R;
import com.gs.cebreja.model.User;
import com.gs.cebreja.util.SetupUI;

public class ManagementProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_profile);
        SetupUI.set(findViewById(R.id.manageProfile), ManagementProfileActivity.this);
        User user = getIntent().getParcelableExtra("user");
        user.setToken(User.token);

        ImageButton manage_back_btn;
        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName = findViewById(R.id.etlastName);
        EditText etEmail = findViewById(R.id.etEmail);

        etFirstName.setText(user.getFirstName());
        etLastName.setText(user.getLastName());
        etEmail.setText(user.getEmail());

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