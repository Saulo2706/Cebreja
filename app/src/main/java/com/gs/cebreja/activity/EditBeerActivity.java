package com.gs.cebreja.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.gs.cebreja.R;
import com.gs.cebreja.mapper.ItemSelectMapper;
import com.gs.cebreja.model.Beer;
import com.gs.cebreja.model.StringWithId;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.BeerItemResponseGeneric;
import com.gs.cebreja.network.response.BeerResponse;
import com.gs.cebreja.util.SetupUI;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditBeerActivity extends MainActivity implements View.OnClickListener {
    Beer beer;
    private EditText editTextNameBeer,editTextVolumeBeer,editTextAlcholicBeer,editTextDescriptionBeer;
    private AutoCompleteTextView paisBeerTextView,typeBeerTextView,brandTextView,packageTextView;
    private Button buttonAdd,addImage, FinishButton;
    private LinearLayout list_Ingredients;
    private ImageView pickedImage;
    private ImageButton EditBeerBackBtn;

    private List<StringWithId> listType = new ArrayList<>();
    private List<StringWithId> listWold = new ArrayList<>();
    private List<StringWithId> listPackge = new ArrayList<>();
    private List<StringWithId> listBrand = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_beer);
        SetupUI.set(findViewById(R.id.editBeer), EditBeerActivity.this);
        beer = (Beer) getIntent().getSerializableExtra("beer");

        list_Ingredients = findViewById(R.id.list_Ingredients);
        editTextNameBeer = findViewById(R.id.editTextNameBeer);
        editTextVolumeBeer = findViewById(R.id.editTextVolumeBeer);
        editTextAlcholicBeer = findViewById(R.id.editTextAlcholicBeer);
        editTextDescriptionBeer = findViewById(R.id.editTextDescriptionBeer);
        paisBeerTextView = findViewById(R.id.paisBeerTextView);
        typeBeerTextView = findViewById(R.id.typeBeerTextView);
        brandTextView = findViewById(R.id.brandTextView);
        packageTextView = findViewById(R.id.packageTextView);
        buttonAdd = findViewById(R.id.add_Ingredients);
        addImage = findViewById(R.id.addImage);
        FinishButton = findViewById(R.id.FinishButton);
        pickedImage = findViewById(R.id.pickedImage);
        EditBeerBackBtn = findViewById(R.id.EditBeerBackBtn);


        obtemItens("type");
        obtemItens("packing");
        obtemItensMarca("brand");
        obtemItensPais("country");
        obterDadosBeer();

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(EditBeerActivity.this).crop().compress(1024).maxResultSize(1080,1080).start();

            }
        });

        EditBeerBackBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                }
        );

        buttonAdd.setOnClickListener(this);
        FinishButton.setOnClickListener(this);

    }

    private void obterDadosBeer(){
        ApiService.getInstanceBeer()
                .findCervejas(beer.getId(),"Bearer "+ User.token)
                .enqueue(new Callback<BeerResponse>() {
                    @Override
                    public void onResponse(Call<BeerResponse> call, Response<BeerResponse> response) {
                        if (response.isSuccessful()){
                            editTextNameBeer.setText(response.body().getName());
                            editTextVolumeBeer.setText(response.body().getVolume());
                            editTextAlcholicBeer.setText(response.body().getAlcholicPercentage());
                            editTextDescriptionBeer.setText(response.body().getDescription());
                            brandTextView.setText(response.body().getBrand().getName());
                            typeBeerTextView.setText(response.body().getType().getName());
                            paisBeerTextView.setText(response.body().getCountry().getName());
                            packageTextView.setText(response.body().getPacking().getName());

                            int size = response.body().getIngredientsList().size();
                            for (int i=0; i<size; i++){
                                String posi = String.valueOf(i + 1);
                                addViewParans(response.body().getIngredientsList().get(i).getName(),posi);
                            }

                            if (response.body().getPhotos().size() > 0){

                                Picasso.get().load(response.body().getPhotos().get(0)).resize(300,300).into(pickedImage);
                            }

                        }else{

                        }
                    }

                    @Override
                    public void onFailure(Call<BeerResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_Ingredients:
                addView();
                break;

            case R.id.FinishButton:
                //checkIfValidAndRead();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();
        pickedImage.setImageURI(uri);
    }

    private void addView() {

        final View ingredientsView = getLayoutInflater().inflate(R.layout.ingredient_list,null,false);

        EditText ingrediente =  ingredientsView.findViewById(R.id.editTextIngredientBeer);
        EditText qtd_ingrediente =  ingredientsView.findViewById(R.id.editTextqtdBeer);
        ImageView imgClose = ingredientsView.findViewById(R.id.imageRemove);

        imgClose.setOnClickListener(new View.OnClickListener(){;
            @Override
            public void onClick(View v){
                removeView(ingredientsView);
            }
        });
        list_Ingredients.addView(ingredientsView);

    }

    private void addViewParans(String ing, String qtdIngrediente) {

        final View ingredientsView = getLayoutInflater().inflate(R.layout.ingredient_list,null,false);

        EditText ingrediente =  ingredientsView.findViewById(R.id.editTextIngredientBeer);
        EditText qtd_ingrediente =  ingredientsView.findViewById(R.id.editTextqtdBeer);
        ImageView imgClose = ingredientsView.findViewById(R.id.imageRemove);

        ingrediente.setText(ing);
        qtd_ingrediente.setText(qtdIngrediente);

        imgClose.setOnClickListener(new View.OnClickListener(){;
            @Override
            public void onClick(View v){
                removeView(ingredientsView);
            }
        });
        list_Ingredients.addView(ingredientsView);

    }


    private void removeView(View view){

        list_Ingredients.removeView(view);
    }

    private void obtemItens(String item){
        ApiService.getInstanceItem()
                .findItem(item,"Bearer "+User.token)
                .enqueue(new Callback<List<BeerItemResponseGeneric>>() {
                    @Override
                    public void onResponse(Call<List<BeerItemResponseGeneric>> call, Response<List<BeerItemResponseGeneric>> response) {
                        if (item == "type"){
                            listType = ItemSelectMapper.deItemParaDominio(response.body());
                            //select type_beer
                            typeBeerTextView = findViewById(R.id.typeBeerTextView);
                            ArrayAdapter<StringWithId> adapter_type = new ArrayAdapter<StringWithId>(EditBeerActivity.this,android.R.layout.simple_dropdown_item_1line, listType);
                            typeBeerTextView.setAdapter(adapter_type);

                            typeBeerTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                                    String name= m.getString();
                                    Long idType =m.getId();

                                    System.out.println("id tipo: " + idType);
                                }

                            });
                        }else if(item == "packing"){
                            listPackge= ItemSelectMapper.deItemParaDominio(response.body());

                            packageTextView = findViewById(R.id.packageTextView);
                            ArrayAdapter<StringWithId> adapter_package = new ArrayAdapter<StringWithId>(EditBeerActivity.this,android.R.layout.simple_dropdown_item_1line, listPackge);
                            packageTextView.setAdapter(adapter_package);

                            packageTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                                    String name= m.getString();
                                    Long idPackage =m.getId();

                                    System.out.println("id embalagem: " + idPackage);
                                }
                            });

                        }
                    }
                    @Override
                    public void onFailure(Call<List<BeerItemResponseGeneric>> call, Throwable t) {
                        System.out.println("DEU RUIM");
                    }
                });
    }

    private void obtemItensPais(String item){
        ApiService.getInstanceItemGen()
                .findItem(item,"Bearer "+User.token)
                .enqueue(new Callback<List<BeerItemResponseGeneric>>() {
                    @Override
                    public void onResponse(Call<List<BeerItemResponseGeneric>> call, Response<List<BeerItemResponseGeneric>> response) {
                        listWold = ItemSelectMapper.deItemParaDominio(response.body());

                        paisBeerTextView = findViewById(R.id.paisBeerTextView);
                        ArrayAdapter<StringWithId> adapter_world = new ArrayAdapter<StringWithId>(EditBeerActivity.this,android.R.layout.simple_dropdown_item_1line, listWold);
                        paisBeerTextView.setAdapter(adapter_world);

                        paisBeerTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                                String name= m.getString();
                                Long idWorld =m.getId();

                                System.out.println("id pais: " + idWorld);
                            }
                        });
                    }
                    @Override
                    public void onFailure(Call<List<BeerItemResponseGeneric>> call, Throwable t) {
                        System.out.println("DEU RUIM");
                    }
                });
    }

    private void obtemItensMarca(String item){
        ApiService.getInstanceItemGen()
                .findItem(item,"Bearer "+User.token)
                .enqueue(new Callback<List<BeerItemResponseGeneric>>() {
                    @Override
                    public void onResponse(Call<List<BeerItemResponseGeneric>> call, Response<List<BeerItemResponseGeneric>> response) {
                        listBrand = ItemSelectMapper.deItemParaDominio(response.body());

                        brandTextView = findViewById(R.id.brandTextView);
                        ArrayAdapter<StringWithId> adapter_brand = new ArrayAdapter<StringWithId>(EditBeerActivity.this,android.R.layout.simple_list_item_1, listBrand);
                        brandTextView.setAdapter(adapter_brand);

                        brandTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                                String name= m.getString();
                                Long idBrand =m.getId();

                                System.out.println("id brand: " + idBrand);
                            }
                        });
                    }
                    @Override
                    public void onFailure(Call<List<BeerItemResponseGeneric>> call, Throwable t) {
                        System.out.println("DEU RUIM");
                    }
                });
    }
}