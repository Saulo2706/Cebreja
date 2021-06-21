package com.gs.cebreja.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

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
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval);
        user = getIntent().getExtras().getParcelable("user");
        user.setToken(User.token);
        user.setRoles(User.roles);
        ImageButton manage_back_btn;

        dialog = new ProgressDialog(ApprovalActivity.this);
        dialog.setTitle("Carregando");
        dialog.setMessage("Carregando Solicitação");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

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
                            dialog.dismiss();
                            //System.out.println("DEU BOA "+ solicitations.get(0));
                        }else{
                            dialog.dismiss();
                            Toast.makeText(ApprovalActivity.this,"Erro ao obter lista!! - Codigo: "+response.code(),Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<List<GetBeerOrderResponse>> call, Throwable t) {
                        dialog.dismiss();
                        Toast.makeText(ApprovalActivity.this,"Erro ao obter lista!!",Toast.LENGTH_LONG).show();
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