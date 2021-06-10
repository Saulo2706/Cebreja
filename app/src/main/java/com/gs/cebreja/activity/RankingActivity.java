package com.gs.cebreja.activity;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.gs.cebreja.R;
import com.gs.cebreja.adapters.MyAdapterRanking;
import com.gs.cebreja.mapper.BeerRankingMapper;
import com.gs.cebreja.model.Beer;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.BeerRankingResponse;
import com.gs.cebreja.util.SetupUI;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingActivity extends MainActivity implements NavigationView.OnNavigationItemSelectedListener, MyAdapterRanking.OnBeerClickedListner{
    private TextView navUsername, navEmail;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menuIcon;
    private List<Beer> beerList;
    private MyAdapterRanking myAdapterRanking;
    private View headerView;
    private Toolbar toolbar;
    private SearchView searchView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private MyAdapterRanking beerAdapter;
    private ProgressBar progressBar;
    private GridLayoutManager layoutManager;
    private int j,size = 0;
    private long page_next, total_pages;
    User user;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        SetupUI.set(findViewById(R.id.rankingPage), RankingActivity.this);
        size = 10;
        user = getIntent().getExtras().getParcelable("user");
        user.setToken(User.token);
        user.setRoles(User.roles);

        for (int i = 0; i < user.roles.size(); i++){
            j = user.getRoles().get(i).getId();
            if (j == 1){
                System.out.println("Usuario Admin");
            }

            if(j == 2){
                System.out.println("Usuario Aprovador");
            }
        }

        if(j > 2 || j<1){
            System.out.println("Usuario Comum");
        }


        progressBar = findViewById(R.id.progressBar);
        drawerLayout = findViewById(R.id.rankingPage);
        navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        navUsername = headerView.findViewById(R.id.UserName);
        navEmail = headerView.findViewById(R.id.Email);
        menuIcon = (ImageView) findViewById(R.id.menu_icon);
        toolbar = findViewById(R.id.toolbar);
        searchView = findViewById(R.id.searchToolbar);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        navUsername.setText(user.getFirstName());
        navEmail.setText(user.getEmail());
        beerList = new ArrayList<>();
        progressBar.setVisibility(View.VISIBLE);

        configuraAdapter();
        refreshRecycler();
        searchRecycler();
        obtemCervejas();



        //menu inferior
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



    private void obtemCervejas(){
        ApiService.getInstace()
        .obterCervejas(0,size,"Bearer "+User.token)
        .enqueue(new Callback<BeerRankingResponse>() {
            @Override
            public void onResponse(Call<BeerRankingResponse> call, Response<BeerRankingResponse> response) {
                if (response.isSuccessful()){
                    page_next = response.body().getPage().getNumber() + 1;
                    total_pages = response.body().getPage().getTotalPages();
                    List<Beer> listBeer = BeerRankingMapper.deBeerVoesParaDominio(response.body().getEmbedded().getVoes());
                    beerAdapter.setBeerList(listBeer);
                    progressBar.setVisibility(View.GONE);
                }else{
                    System.out.println("Token: "+User.token + " Code response: "+response.code());
                    showError();
                }
            }

            @Override
            public void onFailure(Call<BeerRankingResponse> call, Throwable t) {
                showError();
            }
        });
    }

    private void showError(){
        Toast.makeText(this,"Erro ao obter lista de cervejas",Toast.LENGTH_LONG).show();
    }

    private void configuraAdapter(){
        recyclerView = findViewById(R.id.recyclerview);
        beerAdapter = new MyAdapterRanking(this);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(beerAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                    if (page_next < total_pages){
                        performPagination();
                    }
                }
        });
    }



    private void refreshRecycler(){
        //atualizando a pagina
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ApiService.getInstace()
                        .obterCervejas(0,size,"Bearer "+User.token)
                        .enqueue(new Callback<BeerRankingResponse>() {
                            @Override
                            public void onResponse(Call<BeerRankingResponse> call, Response<BeerRankingResponse> response) {
                                if (response.isSuccessful()){
                                    page_next = response.body().getPage().getNumber() + 1;
                                    total_pages = response.body().getPage().getTotalPages();
                                    BeerRankingMapper.listBeerAdd = new ArrayList<>();
                                    List<Beer> listBeer = BeerRankingMapper.deBeerVoesParaDominio(response.body().getEmbedded().getVoes());
                                    beerAdapter.setBeerList(listBeer);
                                    progressBar.setVisibility(View.GONE);
                                }else{
                                    System.out.println("Token: "+User.token + " Code response: "+response.code());
                                    showError();
                                }
                            }

                            @Override
                            public void onFailure(Call<BeerRankingResponse> call, Throwable t) {
                                showError();
                            }
                        });
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void searchRecycler(){
        //busca
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                System.out.println("cliquei no botão de pesquisa final");

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
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
                 intent = new Intent (RankingActivity.this, ManagementProfileActivity.class);
                 intent.putExtra("user", user);
                 startActivity(intent);
                break;
            case R.id.nav_favorite_beers:
                intent = new Intent (RankingActivity.this, FavoriteBeersActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                intent = new Intent (RankingActivity.this,IndexActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                break;
        }
        return false;
    }


    public void onCustomToggleClick(View view) {
        //Toast.makeText(this, "CustomToggle", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBeerClicked(Beer beer) {
        Intent intent = new Intent(this, BeerActivity.class);
        startActivity(intent);
    }

    private void performPagination(){
        progressBar.setVisibility(View.VISIBLE);
        ApiService.getInstace()
                .obterCervejas(page_next, size,"Bearer "+User.token)
                .enqueue(new Callback<BeerRankingResponse>() {
                    @Override
                    public void onResponse(Call<BeerRankingResponse> call, Response<BeerRankingResponse> response) {
                        if (response.isSuccessful()){
                            if (page_next < total_pages){
                                if(!response.body().getLinks().getPrev().equals(response.body().getLinks().getSelf())){
                                    page_next = response.body().getPage().getNumber() + 1;
                                    beerAdapter.setBeerList(BeerRankingMapper.deBeerVoesParaDominioAdd(response.body().getEmbedded().getVoes()));
                                    progressBar.setVisibility(View.GONE);
                                }else {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(RankingActivity.this,"Isto é tudo por hoje!!",Toast.LENGTH_LONG).show();
                                }
                            }
                        }else{
                            System.out.println("Token: "+User.token + " Code response: "+response.code());
                            showError();
                        }
                    }

                    @Override
                    public void onFailure(Call<BeerRankingResponse> call, Throwable t) {
                        showError();
                    }
                });
    }
}