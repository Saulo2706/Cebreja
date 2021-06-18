package com.gs.cebreja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
    }
}