package com.gs.cebreja.controller;


import com.google.android.material.navigation.NavigationView;
import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;



public class RankingActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        SetupUI.set(findViewById(R.id.rankingPage), RankingActivity.this);

        drawerLayout = findViewById(R.id.rankingPage);
        navigationView = findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);




    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else  {
            super.onBackPressed();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.nav_ranking:
                intent = new Intent (RankingActivity.this,RankingActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_profile_settings:
                 intent = new Intent (RankingActivity.this,ManagementProfile.class);
                 startActivity(intent);
                break;
            case R.id.nav_favorite_beers:
                intent = new Intent (RankingActivity.this,FavoriteBeers.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                intent = new Intent (RankingActivity.this,IndexActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }
}