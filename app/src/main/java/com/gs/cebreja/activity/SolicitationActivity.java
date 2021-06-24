package com.gs.cebreja.activity;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.gs.cebreja.R;
import com.gs.cebreja.adapters.MyAdapterSolicitations;
import com.gs.cebreja.mapper.OrdersMapper;
import com.gs.cebreja.model.OrderSolicitations;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.GetBeerOrderResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SolicitationActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener, MyAdapterSolicitations.ItemBeerOrderClickListner{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menuIcon;
    private View headerView;
    private TextView navUsername, navEmail;
    private FloatingActionButton fab;
    private List<OrderSolicitations> solicitations;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MyAdapterSolicitations solicitationsAdapter;
    private ProgressDialog dialog;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitation);
        user = getIntent().getParcelableExtra("user");
        user.setToken(User.token);


        dialog = new ProgressDialog(SolicitationActivity.this);
        dialog.setTitle("Carregando");
        dialog.setMessage("Carregando Solicitação");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

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

        configuraAdapter();
        obtemDetalhes();

    }

    private void configuraAdapter(){
        recyclerView = findViewById(R.id.recyclerview);
        solicitationsAdapter = new MyAdapterSolicitations(this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(solicitationsAdapter);
    }

    private void obtemDetalhes(){
        ApiService.getInstanceBeerUpload()
                .getOrders("Bearer "+ User.token)
                .enqueue(new Callback<List<GetBeerOrderResponse>>() {
                    @Override
                    public void onResponse(Call<List<GetBeerOrderResponse>> call, Response<List<GetBeerOrderResponse>> response) {
                        if (response.isSuccessful()){

                            solicitations = OrdersMapper.deOrderParaDominio(response.body());
                            solicitationsAdapter.setSolicitations(solicitations);
                            dialog.dismiss();
                            //System.out.println("DEU BOA "+ solicitations.get(0));
                        }else{
                            Toast.makeText(SolicitationActivity.this,"Erro ao obter lista!! - Codigo: "+response.code(),Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }
                    }
                    @Override
                    public void onFailure(Call<List<GetBeerOrderResponse>> call, Throwable t) {
                        Toast.makeText(SolicitationActivity.this,"Erro ao obter lista!!",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
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
            case R.id.nav_about:
                intent = new Intent (SolicitationActivity.this,AboutActivity.class);
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

    @Override
    public void onItemBeerOrderClicado(OrderSolicitations order) {

    }
}