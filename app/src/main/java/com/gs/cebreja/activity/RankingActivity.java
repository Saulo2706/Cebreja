package com.gs.cebreja.activity;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.gs.cebreja.R;
import com.gs.cebreja.adapters.MyAdapter;
import com.gs.cebreja.model.Beer;
import com.gs.cebreja.util.SetupUI;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class RankingActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    ImageButton menuIcon;

    RecyclerView recyclerView;
    List<Beer> beerList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        SetupUI.set(findViewById(R.id.rankingPage), RankingActivity.this);

        drawerLayout = findViewById(R.id.rankingPage);
        navigationView = findViewById(R.id.nav_view);
        menuIcon = (ImageButton) findViewById(R.id.menu_icon);

        recyclerView = findViewById(R.id.recyclerview);
        beerList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //passando dados para a recycler
        for(int i = 0; i<=10; i++){
            Beer details = new Beer("Cerveja"+i, "descricao"+i);
            beerList.add(details);
        }
        myAdapter = new MyAdapter(beerList);
        recyclerView.setAdapter(myAdapter);

        navigationDrawer();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setSelectedItemId(R.id.ranking);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.solicitacoes:
                        startActivity(new Intent(getApplicationContext()
                        ,SolicitationActivity.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;
                    case R.id.ranking:
                        return true;
                }
                return false;
            }
        });

    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        menuIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
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
                 intent = new Intent (RankingActivity.this, ManagementProfileActivity.class);
                 startActivity(intent);
                break;
            case R.id.nav_favorite_beers:
                intent = new Intent (RankingActivity.this, FavoriteBeersActivity.class);
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