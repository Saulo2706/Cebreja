package com.gs.cebreja.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gs.cebreja.R;
import com.gs.cebreja.model.OrderSolicitations;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.ApproveOrderResponse;
import com.gs.cebreja.network.response.GetBeerOrderDetailedResponse;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailedOrderAdminActivity extends MainActivity {
    private OrderSolicitations order;
    private TextView titleBeer,brand_Beer,type_Beer,world_Beer,alcohlic_Beer,package_Beer,volume_Beer,description_Beer,ingredients_Beer;
    private ImageView imageBeer;
    private String ingredients = "";
    private Button yesApprove,noApprove;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_order_admin);
        order = (OrderSolicitations) getIntent().getSerializableExtra("order");
        user = getIntent().getParcelableExtra("user");
        user.setToken(User.token);

        System.out.println(user);

        titleBeer = findViewById(R.id.titleBeer);
        brand_Beer = findViewById(R.id.brand_Beer);
        type_Beer = findViewById(R.id.type_Beer);
        world_Beer = findViewById(R.id.world_Beer);
        alcohlic_Beer = findViewById(R.id.alcohlic_Beer);
        package_Beer = findViewById(R.id.package_Beer);
        volume_Beer = findViewById(R.id.volume_Beer);
        description_Beer = findViewById(R.id.description_Beer);
        ingredients_Beer = findViewById(R.id.ingredients_Beer);
        imageBeer = findViewById(R.id.imageBeer);
        noApprove = findViewById(R.id.noApprove);
        yesApprove = findViewById(R.id.yesApprove);

        ImageButton order_back_btn;
        //Botão voltar
        order_back_btn = findViewById(R.id.order_back_btn);
        order_back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );

        yesApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postApprove(order.getId());
                Intent intent = new Intent(DetailedOrderAdminActivity.this, ApproveOrderSuccessAdminActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);

            }
        });

        noApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postDisapprove(order.getId());
                Intent intent = new Intent(DetailedOrderAdminActivity.this, ApproveOrderSuccessAdminActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });


        obtemDetalhes(order.getId());

    }

    private void postApprove(Long id){
        ApiService.postApproveOrder()
                .postApproveOrder(id,"Bearer "+ User.token)
                .enqueue(new Callback<ApproveOrderResponse>() {
                    @Override
                    public void onResponse(Call<ApproveOrderResponse> call, Response<ApproveOrderResponse> response) {
                    }

                    @Override
                    public void onFailure(Call<ApproveOrderResponse> call, Throwable t) {
                    }
                });
    }

    private void postDisapprove(Long id){
        ApiService.postDisapproveOrder()
                .postDisapproveOrder(id,"Bearer "+ User.token)
                .enqueue(new Callback<ApproveOrderResponse>() {
                    @Override
                    public void onResponse(Call<ApproveOrderResponse> call, Response<ApproveOrderResponse> response) {
                    }

                    @Override
                    public void onFailure(Call<ApproveOrderResponse> call, Throwable t) {
                    }
                });
    }


    private void obtemDetalhes(Long id){
        ApiService.getInstanceBeerUpload()
                .getOrderDetailed(id,"Bearer "+ User.token)
                .enqueue(new Callback<GetBeerOrderDetailedResponse>() {
                    @Override
                    public void onResponse(Call<GetBeerOrderDetailedResponse> call, Response<GetBeerOrderDetailedResponse> response) {
                        if (response.isSuccessful()){
                            titleBeer.setText(response.body().getName());
                            brand_Beer.setText(response.body().getBrand().getName());
                            type_Beer.setText(response.body().getType().getName());
                            world_Beer.setText(response.body().getCountry().getName());
                            alcohlic_Beer.setText(response.body().getAlcholicPercentage());
                            package_Beer.setText(response.body().getPacking().getName());
                            volume_Beer.setText(response.body().getVolume());
                            description_Beer.setText(response.body().getDescription());


                            int size = response.body().getIngredientsList().size();
                            for (int i=0; i<size; i++){
                                if (i == size-1){
                                    ingredients += response.body().getIngredientsList().get(i).getName();
                                }else{
                                    ingredients += response.body().getIngredientsList().get(i).getName() +", ";
                                }

                            }
                            ingredients_Beer.setText(ingredients);

                            if (response.body().getPhotos().size() > 0){
                                Picasso.get().load(response.body().getPhotos().get(0)).into(imageBeer);
                            }else{
                                imageBeer.setImageResource(R.drawable.cebreja);
                            }
                        }else{


                        }
                    }

                    @Override
                    public void onFailure(Call<GetBeerOrderDetailedResponse> call, Throwable t) {

                    }
                });
    }
}