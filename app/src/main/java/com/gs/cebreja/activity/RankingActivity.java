package com.gs.cebreja.activity;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.gs.cebreja.R;
import com.gs.cebreja.adapters.MyAdapterRanking;
import com.gs.cebreja.model.Beer;
import com.gs.cebreja.model.User;
import com.gs.cebreja.util.SetupUI;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class RankingActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener{
    private TextView navUsername, navEmail;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menuIcon;
    private RecyclerView recyclerView;
    private MyAdapterRanking.RecyclerViewClickListner listner;
    private List<Beer> beerList;
    private MyAdapterRanking myAdapterRanking;
    private View headerView;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        SetupUI.set(findViewById(R.id.rankingPage), RankingActivity.this);
        User user = getIntent().getExtras().getParcelable("user");
        user.setToken(User.token);

        drawerLayout = findViewById(R.id.rankingPage);
        navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        navUsername = headerView.findViewById(R.id.UserName);
        navEmail = headerView.findViewById(R.id.Email);
        menuIcon = (ImageView) findViewById(R.id.menu_icon);

        navUsername.setText(user.getFirstName());
        navEmail.setText(user.getEmail());

        setOnClickListener();
        recyclerView = findViewById(R.id.recyclerview);
        toolbar = findViewById(R.id.toolbar);
        beerList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //passando dados para a recycler
        for(int i = 0; i<=10; i++){
            Beer details = new Beer(i,"Cerveja"+i, "descricao"+i);
            beerList.add(details);
        }

        myAdapterRanking = new MyAdapterRanking(beerList, listner);
        recyclerView.setAdapter(myAdapterRanking);

        navigationDrawer();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setSelectedItemId(R.id.ranking);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.solicitacoes:
                        Intent intent = new Intent(RankingActivity.this, SolicitationActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;
                    case R.id.ranking:
                        return true;
                }
                return false;
            }
        });

    }

    private void setOnClickListener() {
        listner = new MyAdapterRanking.RecyclerViewClickListner() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), BeerActivity.class);
                intent.putExtra("titleBeer",beerList.get(position).getTitle());
                startActivity(intent);
            }
        };
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


    public void onCustomToggleClick(View view) {
        //Toast.makeText(this, "CustomToggle", Toast.LENGTH_SHORT).show();
    }


}