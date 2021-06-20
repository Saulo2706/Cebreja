package com.gs.cebreja.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.gs.cebreja.R;
import com.gs.cebreja.adapters.MyAdapterAvaliationsBeer;
import com.gs.cebreja.adapters.MyAdapterRanking;
import com.gs.cebreja.mapper.AppreciationsMapper;
import com.gs.cebreja.mapper.BeerRankingMapper;
import com.gs.cebreja.model.Beer;
import com.gs.cebreja.model.User;
import com.gs.cebreja.model.UserApreciation;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.BeerResponse;
import com.gs.cebreja.network.response.GetAppreciationResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvaliationsBeerActivity extends MainActivity {

    private Beer beer;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private List<UserApreciation> appreciations;
    private MyAdapterAvaliationsBeer appreciationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliations_beer);
        beer = (Beer) getIntent().getSerializableExtra("beer");
        ImageButton manage_back_btn;

        configuraAdapter();
        obtemDetalhes(beer.getId());


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

    private void configuraAdapter(){
        recyclerView = findViewById(R.id.recyclerview);
        appreciationAdapter = new MyAdapterAvaliationsBeer();
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(appreciationAdapter);
    }

    private void obtemDetalhes(Long id){
        ApiService.getInstanceAppreciation()
                .getAppreciation(id,"Bearer "+ User.token)
                .enqueue(new Callback <List<GetAppreciationResponse>>() {
                    @Override
                    public void onResponse(Call<List<GetAppreciationResponse>> call, Response<List<GetAppreciationResponse>> response) {
                        if (response.isSuccessful()){
                            appreciations = AppreciationsMapper.deApreciationParaDominio(response.body());
                            appreciationAdapter.setAppreciations(appreciations);
                        }else{
                            System.out.println("ERRO 1");
                        }
                    }
                    @Override
                    public void onFailure(Call<List<GetAppreciationResponse>> call, Throwable t) {
                        System.out.println("ERRO 2");
                    }
                });
    }
}