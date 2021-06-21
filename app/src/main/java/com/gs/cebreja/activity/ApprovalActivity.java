package com.gs.cebreja.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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

public class ApprovalActivity extends MainActivity implements MyAdapterSolicitations.ItemBeerOrderClickListner{

    private User user;
    private List<OrderSolicitations> solicitations;

    private LinearLayoutManager layoutManager;
    private MyAdapterSolicitations solicitationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval);
        user = getIntent().getExtras().getParcelable("user");
        user.setToken(User.token);
        user.setRoles(User.roles);
        ImageButton manage_back_btn;

        configuraAdapter();
        obtemDetalhes();

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
        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
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
                            //System.out.println("DEU BOA "+ solicitations.get(0));
                        }else{
                            System.out.println("ERRO 1");
                        }
                    }
                    @Override
                    public void onFailure(Call<List<GetBeerOrderResponse>> call, Throwable t) {
                        System.out.println("ERRO 2");
                    }
                });
    }

    @Override
    public void onItemBeerOrderClicado(OrderSolicitations order) {
        Intent intent = new Intent(this, DetailedOrderActivity.class);
        intent.putExtra("order",order);
        //intent.putExtra("order", order);
        startActivity(intent);
    }
}