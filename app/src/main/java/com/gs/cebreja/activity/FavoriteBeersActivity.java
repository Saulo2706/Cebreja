package com.gs.cebreja.activity;

import com.google.android.material.navigation.NavigationView;
import com.gs.cebreja.R;
import com.gs.cebreja.adapters.MyAdapterFavoriteBeers;
import com.gs.cebreja.adapters.MyAdapterSolicitations;
import com.gs.cebreja.mapper.FavoriteMapper;
import com.gs.cebreja.mapper.OrdersMapper;
import com.gs.cebreja.model.Beer;
import com.gs.cebreja.model.Favorite;
import com.gs.cebreja.model.OrderSolicitations;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.GetBeerOrderResponse;
import com.gs.cebreja.network.response.GetListFavoriteResponse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteBeersActivity extends MainActivity implements MyAdapterFavoriteBeers.ItemFavoriteOrderClickListner {

    private List<Favorite> favorites;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MyAdapterFavoriteBeers solicitationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_beers);

        ImageButton manage_back_btn;



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

        obtemDetalhes();
        configuraAdapter();
    }

    private void configuraAdapter(){
        recyclerView = findViewById(R.id.recyclerview);
        solicitationsAdapter = new MyAdapterFavoriteBeers(this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(solicitationsAdapter);
    }

    private void obtemDetalhes(){
        ApiService.getInstanceListFavorite()
                .getOrders("Bearer "+ User.token)
                .enqueue(new Callback<List<GetListFavoriteResponse>>() {
                    @Override
                    public void onResponse(Call<List<GetListFavoriteResponse>> call, Response<List<GetListFavoriteResponse>> response) {
                        if (response.isSuccessful()){
                            favorites = FavoriteMapper.deFavoriteParaDominio(response.body());
                            solicitationsAdapter.setFavorites(favorites);
                        }else{
                            System.out.println("ERRO 1");
                        }
                    }
                    @Override
                    public void onFailure(Call<List<GetListFavoriteResponse>> call, Throwable t) {
                        System.out.println("ERRO 2");
                    }
                });
    }

    @Override
    public void itemFavoriteOrderClickListner(Favorite favorite) {
        Beer beer = new Beer();
        beer.setId(favorite.getId());
        Intent intent = new Intent(this, BeerActivity.class);
        intent.putExtra("beer",beer);
        //intent.putExtra("order", order);
        startActivity(intent);
        
    }
}