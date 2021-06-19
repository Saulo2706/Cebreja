package com.gs.cebreja.activity;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.gs.cebreja.R;
import com.gs.cebreja.mapper.ItemSelectMapper;
import com.gs.cebreja.mapper.UserLoginMapper;
import com.gs.cebreja.model.StringWithId;
import com.gs.cebreja.model.User;
import com.gs.cebreja.model.UserRole;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.BeerItemResponseGeneric;
import com.gs.cebreja.network.response.BeerOrderResponse;
import com.gs.cebreja.network.response.UserLoginResponse;
import com.gs.cebreja.util.SetupUI;

import android.content.Context;
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
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddBeerActivity extends MainActivity implements View.OnClickListener {

    private AutoCompleteTextView paisBeerTextView,typeBeerTextView,packageTextView,brandTextView,editTextAlcholicBee,ingrediente;
    private EditText editTextNameBeer,editTextVolumeBeer,editTextAlcholicBeer,editTextDescriptionBeer;
    private LinearLayout list_Ingredients;
    private Button buttonAdd,addImage, FinishButton;
    private ImageView pickedImage;
    private ImageButton manage_back_btn;
    private Uri uri;

    private File file;
    private int idBrand, idType, idPacking, idCountry, contadorIng,contadorIngre;

    private List<StringWithId> ingredientList = new ArrayList<>();
    private List<StringWithId> listType = new ArrayList<>();
    private List<StringWithId> listWold = new ArrayList<>();
    private List<StringWithId> listPackge = new ArrayList<>();
    private List<StringWithId> listBrand = new ArrayList<>();
    private Intent intent = new Intent();
    private HashMap<String,RequestBody> ingredients = new HashMap<String, RequestBody>();
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beer);
        SetupUI.set(findViewById(R.id.addBeer), AddBeerActivity.this);

        user = getIntent().getParcelableExtra("user");
        user.setToken(User.token);
        contadorIng=0;
        contadorIngre=0;
        editTextNameBeer = findViewById(R.id.editTextNameBeer);
        editTextVolumeBeer = findViewById(R.id.editTextVolumeBeer);
        editTextAlcholicBeer = findViewById(R.id.editTextAlcholicBeer);
        editTextDescriptionBeer =findViewById(R.id.editTextDescriptionBeer);

        list_Ingredients = findViewById(R.id.list_Ingredients);
        buttonAdd = findViewById(R.id.add_Ingredients);
        FinishButton = findViewById(R.id.FinishButton);

        obtemItens("type");
        obtemItens("packing");
        obtemItensMarca("brand");
        obtemItensPais("country");

        addImage = findViewById(R.id.addImage);
        pickedImage = findViewById(R.id.pickedImage);

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(AddBeerActivity.this).crop().compress(1024).maxResultSize(1080,1080).start();

            }
        });

        //Botão voltar
        manage_back_btn = findViewById(R.id.addBeer_back_btn);
        manage_back_btn.setOnClickListener(
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uri = data.getData();
        file = new File(uri.getPath());
        pickedImage.setImageURI(uri);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_Ingredients:
                addView();
                break;

            case R.id.FinishButton:
                if (checkIfValidAndRead()){
                    postBeer();
                    intent = new Intent(AddBeerActivity.this, BeerRegistred.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }
                break;

        }

    }

    private void postBeer(){

        RequestBody requestNameBeer = RequestBody.create(MediaType.parse("text/plain"),editTextNameBeer.getText().toString());
        RequestBody requestDescriptionBeer = RequestBody.create(MediaType.parse("text/plain"),editTextDescriptionBeer.getText().toString());
        RequestBody requestVolumeBeer = RequestBody.create(MediaType.parse("text/plain"),editTextVolumeBeer.getText().toString());
        RequestBody requestAlcholicBeer = RequestBody.create(MediaType.parse("text/plain"),editTextAlcholicBeer.getText().toString());
        RequestBody requestIdBrandBeer = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(idBrand));
        RequestBody requestBrandBeer = RequestBody.create(MediaType.parse("text/plain"),brandTextView.getText().toString());
        RequestBody requestIdCountryBeer = RequestBody.create(MediaType.parse("text/plain"),String.valueOf(idCountry));
        RequestBody requestCountryBeer = RequestBody.create(MediaType.parse("text/plain"),paisBeerTextView.getText().toString());
        RequestBody requestIdPackingBeer = RequestBody.create(MediaType.parse("text/plain"),String.valueOf(idPacking));
        RequestBody requestPackingBeer = RequestBody.create(MediaType.parse("text/plain"),packageTextView.getText().toString());
        RequestBody requestIdTypeBeer = RequestBody.create(MediaType.parse("text/plain"),String.valueOf(idType));
        RequestBody requestTypeBeer = RequestBody.create(MediaType.parse("text/plain"),typeBeerTextView.getText().toString());
        MultipartBody.Part requestImage = null;

        if (file == null){
            file = new File(uri.getPath());
        }
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
        requestImage = MultipartBody.Part.createFormData("photo", file.getName(),requestFile);


        ApiService.getInstanceBeerUpload().saveBeer("Bearer "+User.token,
                requestNameBeer,
                requestDescriptionBeer,
                requestVolumeBeer,
                requestAlcholicBeer,
                requestIdBrandBeer,
                requestBrandBeer,
                requestIdCountryBeer,
                requestCountryBeer,
                requestIdPackingBeer,
                requestPackingBeer,
                requestIdTypeBeer,
                requestTypeBeer,
                ingredients,
                requestImage
                ).
                enqueue(new Callback<BeerOrderResponse>() {
                    @Override
                    public void onResponse(Call<BeerOrderResponse> call, Response<BeerOrderResponse> response) {
                    }
                    @Override
                    public void onFailure(Call<BeerOrderResponse> call, Throwable t) {
                    }
                });
    }

    private boolean checkIfValidAndRead() {
        boolean result = true;


        if (list_Ingredients.getChildCount() < 1){
            Context contexto = getApplicationContext();
            String texto = "Adicione ao menos um ingrediente";
            Toast toast = Toast.makeText(contexto,texto,Toast.LENGTH_SHORT);
            toast.show();
            result = false;
        }

        for (int i=0; i < list_Ingredients.getChildCount(); i++){

            View ingredientsView = list_Ingredients.getChildAt(i);

            EditText ingrediente =  ingredientsView.findViewById(R.id.editTextIngredientBeer);
            EditText qtd_ingrediente =  ingredientsView.findViewById(R.id.editTextqtdBeer);

            System.out.println(ingredientsView.getId());

            if (ingrediente.getText().toString().isEmpty()){
                Context contexto = getApplicationContext();
                String texto = "Ingrediente não Informado" + i;
                Toast toast = Toast.makeText(contexto,texto,Toast.LENGTH_SHORT);
                toast.show();
                result = false;
            }else if(qtd_ingrediente.getText().toString().isEmpty()){
                Context contexto = getApplicationContext();
                String texto = "Posição do ingrediente não Informado" + i;
                Toast toast = Toast.makeText(contexto,texto,Toast.LENGTH_SHORT);
                toast.show();
                result = false;
            }
        }

        return result;
    }

    private void addView() {
        if (contadorIngre != 0){
            contadorIng = contadorIng + 1;
        }
        contadorIngre = contadorIngre + 1;
        final View ingredientsView = getLayoutInflater().inflate(R.layout.ingredient_list,null,false);

        ingrediente =  ingredientsView.findViewById(R.id.editTextIngredientBeer);
        EditText qtd_ingrediente =  ingredientsView.findViewById(R.id.editTextqtdBeer);
        ImageView imgClose = ingredientsView.findViewById(R.id.imageRemove);
        obtemItensIngredients("ingredient");

        imgClose.setOnClickListener(new View.OnClickListener(){;
           @Override
           public void onClick(View v){

               //ingrediente.getText();
               ingredients.remove("ingredients["+contadorIng+"].id");
               ingredients.remove("ingredients["+contadorIng+"].name");
               contadorIng = contadorIng - 1;
               contadorIngre = contadorIngre - 1;
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
                            ArrayAdapter<StringWithId> adapter_type = new ArrayAdapter<StringWithId>(AddBeerActivity.this,android.R.layout.simple_dropdown_item_1line, listType);
                            typeBeerTextView.setAdapter(adapter_type);

                            typeBeerTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                                    String name= m.getString();
                                    Long idTypeF =m.getId();
                                    idType = idTypeF.intValue();
                                    System.out.println("id tipo: " + idType);
                                }

                            });
                        }else if(item == "packing"){
                            listPackge= ItemSelectMapper.deItemParaDominio(response.body());

                            packageTextView = findViewById(R.id.packageTextView);
                            ArrayAdapter<StringWithId> adapter_package = new ArrayAdapter<StringWithId>(AddBeerActivity.this,android.R.layout.simple_dropdown_item_1line, listPackge);
                            packageTextView.setAdapter(adapter_package);

                            packageTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                                    String name= m.getString();
                                    Long idPackage =m.getId();
                                    idPacking = idPackage.intValue();
                                    System.out.println("id embalagem: " + idPacking);
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
                        ArrayAdapter<StringWithId> adapter_world = new ArrayAdapter<StringWithId>(AddBeerActivity.this,android.R.layout.simple_dropdown_item_1line, listWold);
                        paisBeerTextView.setAdapter(adapter_world);

                        paisBeerTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                                String name= m.getString();
                                Long idWorld =m.getId();
                                idCountry = idWorld.intValue();
                                System.out.println("id pais: " + idCountry);
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
                        ArrayAdapter<StringWithId> adapter_brand = new ArrayAdapter<StringWithId>(AddBeerActivity.this,android.R.layout.simple_list_item_1, listBrand);
                        brandTextView.setAdapter(adapter_brand);

                        brandTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                                String name= m.getString();
                                Long idBrandF =m.getId();

                                idBrand = idBrandF.intValue();
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

    private void obtemItensIngredients(String item){
        ApiService.getInstanceItemGen()
                .findItem(item,"Bearer "+User.token)
                .enqueue(new Callback<List<BeerItemResponseGeneric>>() {
                    @Override
                    public void onResponse(Call<List<BeerItemResponseGeneric>> call, Response<List<BeerItemResponseGeneric>> response) {
                        ingredientList = ItemSelectMapper.deItemParaDominio(response.body());


                        ArrayAdapter<StringWithId> adapter_ingredients = new ArrayAdapter<StringWithId>(AddBeerActivity.this,android.R.layout.simple_list_item_1, ingredientList);
                        ingrediente.setAdapter(adapter_ingredients);

                        ingrediente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                                String name= m.getString();
                                Long idIng =m.getId();

                                RequestBody idIngr = RequestBody.create(MediaType.parse("text/plain"),String.valueOf(idIng));
                                RequestBody nameIng = RequestBody.create(MediaType.parse("text/plain"),name);

                                ingredients.put("ingredients["+contadorIng+"].id",idIngr);
                                ingredients.put("ingredients["+contadorIng+"].name",nameIng);

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