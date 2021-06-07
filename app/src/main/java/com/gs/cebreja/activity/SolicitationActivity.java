package com.gs.cebreja.activity;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.gs.cebreja.R;
import com.gs.cebreja.model.User;


public class SolicitationActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menuIcon;
    private View headerView;
    private TextView navUsername, navEmail;
    private FloatingActionButton fab;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitation);
        user = getIntent().getParcelableExtra("user");
        user.setToken(User.token);

        drawerLayout = findViewById(R.id.solicitationsPage);
        navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        navUsername = headerView.findViewById(R.id.UserName);
        navEmail = headerView.findViewById(R.id.Email);
        menuIcon = (ImageView) findViewById(R.id.menu_icon);
        fab = findViewById(R.id.add_btn);


        navUsername.setText(user.getFirstName());
        navEmail.setText(user.getEmail());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SolicitationActivity.this, AddBeerActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });


        navigationDrawer();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);

        bottomNavigationView.setSelectedItemId(R.id.solicitacoes);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.solicitacoes:
                        return true;
                    case R.id.ranking:
                        Intent intent = new Intent(SolicitationActivity.this, RankingActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
            case R.id.nav_profile_settings:
                intent = new Intent (SolicitationActivity.this, ManagementProfileActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                break;
            case R.id.nav_favorite_beers:
                intent = new Intent (SolicitationActivity.this, FavoriteBeersActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                intent = new Intent (SolicitationActivity.this,IndexActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                break;
        }
        return false;
    }
}