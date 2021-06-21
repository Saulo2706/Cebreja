package com.gs.cebreja.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.gs.cebreja.R;
import com.gs.cebreja.model.AppreciationBeer;
import com.gs.cebreja.model.Beer;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.AppreciationResponseGeneric;
import com.gs.cebreja.network.response.BeerResponse;
import com.gs.cebreja.network.response.FavoriteUnfavoriteResponseGeneric;
import com.gs.cebreja.util.SetupUI;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerActivity extends MainActivity {
    TextView titleBeer,brand_Beer,score_Beer,type_Beer,world_Beer,alcohlic_Beer,package_Beer,volume_Beer,description_Beer,ingredients_Beer;
    ToggleButton favoriteButtonDetails;
    ImageView imageBeer;
    ImageButton back_btn,beer_remove_btn,beer_edit_btn;
    String ingredients = "";
    RatingBar ratingBar;
    EditText editTextAvaliationBeer;
    Button finishButton,descriptionUsers;
    Beer beer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        SetupUI.set(findViewById(R.id.activityBeer), BeerActivity.this);
        beer = (Beer) getIntent().getSerializableExtra("beer");

        titleBeer = findViewById(R.id.titleBeer);
        favoriteButtonDetails = findViewById(R.id.favoriteButtonDetails);
        brand_Beer = findViewById(R.id.brand_Beer);
        score_Beer = findViewById(R.id.score_Beer);
        type_Beer = findViewById(R.id.type_Beer);
        world_Beer = findViewById(R.id.world_Beer);
        alcohlic_Beer = findViewById(R.id.alcohlic_Beer);
        package_Beer = findViewById(R.id.package_Beer);
        volume_Beer = findViewById(R.id.volume_Beer);
        description_Beer = findViewById(R.id.description_Beer);
        ingredients_Beer = findViewById(R.id.ingredients_Beer);
        imageBeer = findViewById(R.id.imageBeer);
        finishButton = findViewById(R.id.finishButton);
        descriptionUsers = findViewById(R.id.descriptionUsers);
        ratingBar = findViewById(R.id.ratingBar);
        editTextAvaliationBeer = findViewById(R.id.editTextAvaliationBeer);

        obtemDetalhes(beer.getId());

        //Botão voltar
        back_btn = findViewById(R.id.beer_back_btn);
        beer_remove_btn = findViewById(R.id.beer_remove_btn);
        beer_edit_btn = findViewById(R.id.beer_edit_btn);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post_request(editTextAvaliationBeer.getText().toString(),ratingBar.getRating());
            }
        });

        beer_remove_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(BeerActivity.this, DeleteBeerActivity.class);
                        //intent.putExtra("user", user);
                        startActivity(intent);
                    }
                }
        );

        beer_edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeerActivity.this, EditBeerActivity.class);
                intent.putExtra("beer", beer);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );


        favoriteButtonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favoriteButtonDetails.isChecked()){
                    ApiService.getInstanceFavorite().favoriteCerveja(beer.getId(),"Bearer "+ User.token).enqueue(new Callback<FavoriteUnfavoriteResponseGeneric>() {
                        @Override
                        public void onResponse(Call<FavoriteUnfavoriteResponseGeneric> call, Response<FavoriteUnfavoriteResponseGeneric> response) {
                        }
                        @Override
                        public void onFailure(Call<FavoriteUnfavoriteResponseGeneric> call, Throwable t) {
                        }
                    });
                }else {
                    ApiService.getInstanceFavorite().unfavoriteCerveja(beer.getId(), "Bearer " + User.token).enqueue(new Callback<FavoriteUnfavoriteResponseGeneric>() {
                        @Override
                        public void onResponse(Call<FavoriteUnfavoriteResponseGeneric> call, Response<FavoriteUnfavoriteResponseGeneric> response) {
                        }

                        @Override
                        public void onFailure(Call<FavoriteUnfavoriteResponseGeneric> call, Throwable t) {
                        }

                    });
                }
            }
        });

        descriptionUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (BeerActivity.this, AvaliationsBeerActivity.class);
                intent.putExtra("beer", beer);
                startActivity(intent);
            }
        });

    }

    private void post_request(String comment, Float score) {
        AppreciationBeer appreciationBeer = new AppreciationBeer(comment,score);
        ApiService.getInstanceAppreciation()
                .saveAppreciation(beer.getId(),"Bearer "+ User.token,appreciationBeer)
                .enqueue(new Callback<AppreciationResponseGeneric>() {
                    @Override
                    public void onResponse(Call<AppreciationResponseGeneric> call, Response<AppreciationResponseGeneric> response) {
                    }

                    @Override
                    public void onFailure(Call<AppreciationResponseGeneric> call, Throwable t) {
                    }
                });
    }

    private void obtemDetalhes(Long id){
        ApiService.getInstanceBeer()
                .findCervejas(id,"Bearer "+ User.token)
                .enqueue(new Callback<BeerResponse>() {
                    @Override
                    public void onResponse(Call<BeerResponse> call, Response<BeerResponse> response) {
                        if (response.isSuccessful()){
                            titleBeer.setText(response.body().getName());
                            brand_Beer.setText(response.body().getBrand().getName());
                            type_Beer.setText(response.body().getType().getName());
                            world_Beer.setText(response.body().getCountry().getName());
                            alcohlic_Beer.setText(response.body().getAlcholicPercentage());
                            package_Beer.setText(response.body().getPacking().getName());
                            volume_Beer.setText(response.body().getVolume());
                            description_Beer.setText(response.body().getDescription());



                            try{
                                editTextAvaliationBeer.setText(response.body().getAppreciation().getComment());
                                ratingBar.setRating(response.body().getAppreciation().getScore());
                            } catch (NullPointerException npe) {

                            }

                            int size = response.body().getIngredientsList().size();
                            for (int i=0; i<size; i++){
                                if (i == size-1){
                                    ingredients += response.body().getIngredientsList().get(i).getName();
                                }else{
                                    ingredients += response.body().getIngredientsList().get(i).getName() +", ";
                                }

                            }
                            ingredients_Beer.setText(ingredients);

                            //score_Beer.setText(response.body());
                            if (response.body().getPhotos().size() > 0){
                                Picasso.get().load(response.body().getPhotos().get(0)).into(imageBeer);
                            }else{
                                imageBeer.setImageResource(R.drawable.cebreja);
                            }
                        }else{


                        }
                    }

                    @Override
                    public void onFailure(Call<BeerResponse> call, Throwable t) {

                    }
                });
    }

}