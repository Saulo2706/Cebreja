package com.gs.cebreja.activity;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.gs.cebreja.R;
import com.gs.cebreja.model.StringWithId;
import com.gs.cebreja.model.User;
import com.gs.cebreja.util.SetupUI;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AddBeerActivity extends MainActivity implements View.OnClickListener {

    private AutoCompleteTextView paisBeerTextView,typeBeerTextView,packageTextView,brandTextView,editTextAlcholicBeer;
    private LinearLayout list_Ingredients;
    private Button buttonAdd,addImage, FinishButton;
    private ImageView pickedImage;

    List<String> ingredientList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beer);
        SetupUI.set(findViewById(R.id.addBeer), AddBeerActivity.this);

        User user = getIntent().getParcelableExtra("user");
        user.setToken(User.token);

        ImageButton manage_back_btn;

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

        list_Ingredients = findViewById(R.id.list_Ingredients);
        buttonAdd = findViewById(R.id.add_Ingredients);
        FinishButton = findViewById(R.id.FinishButton);


        //LISTA PAISES - SELECT
        List<StringWithId> listWold = new ArrayList<StringWithId>();
        listWold.add(new StringWithId("Brazil", 0L));
        listWold.add(new StringWithId("Paraguay", 1L));
        listWold.add(new StringWithId("EUA", 2L));
        listWold.add(new StringWithId("Canada", 3L));
        listWold.add(new StringWithId("Argentina", 4L));

        //LISTA TIPO - SELECT
        List<StringWithId> listType = new ArrayList<StringWithId>();
        listType.add(new StringWithId("Pilsen",0L));
        listType.add(new StringWithId("Largen",1L));
        listType.add(new StringWithId("Alcool Puro",2L));

        //LISTA EMBALAGEM - SELECT
        List<StringWithId> listPackge = new ArrayList<StringWithId>();
        listPackge.add(new StringWithId("Engradado",0L));
        listPackge.add(new StringWithId("Garrafa",1L));
        listPackge.add(new StringWithId("Latinha",2L));

        //LISTA MARCAS - SELECT
        List<StringWithId> listBrand = new ArrayList<StringWithId>();
        listBrand.add(new StringWithId("Skol", 0L));
        listBrand.add(new StringWithId("Brahma", 1L));
        listBrand.add(new StringWithId("Patagonia", 2L));
        listBrand.add(new StringWithId("Amstel", 3L));
        listBrand.add(new StringWithId("Polar", 4L));

        //select world_beer
        paisBeerTextView = findViewById(R.id.paisBeerTextView);
        ArrayAdapter<StringWithId> adapter_world = new ArrayAdapter<StringWithId>(this,android.R.layout.simple_dropdown_item_1line, listWold);
        paisBeerTextView.setAdapter(adapter_world);

        //select type_beer
        typeBeerTextView = findViewById(R.id.typeBeerTextView);
        ArrayAdapter<StringWithId> adapter_type = new ArrayAdapter<StringWithId>(this,android.R.layout.simple_dropdown_item_1line, listType);
        typeBeerTextView.setAdapter(adapter_type);

        //select brand_beer
        brandTextView = findViewById(R.id.brandTextView);
        ArrayAdapter<StringWithId> adapter_brand = new ArrayAdapter<StringWithId>(this,android.R.layout.simple_list_item_1, listBrand);
        brandTextView.setAdapter(adapter_brand);

        //select package_beer
        packageTextView = findViewById(R.id.packageTextView);
        ArrayAdapter<StringWithId> adapter_package = new ArrayAdapter<StringWithId>(this,android.R.layout.simple_dropdown_item_1line, listPackge);
        packageTextView.setAdapter(adapter_package);

        addImage = findViewById(R.id.addImage);
        pickedImage = findViewById(R.id.pickedImage);


        paisBeerTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                String name= m.getString();
                Long idWorld =m.getId();

                System.out.println("id pais: " + idWorld);
            }
        });
        typeBeerTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                String name= m.getString();
                Long idType =m.getId();

                System.out.println("id tipo: " + idType);
            }
        });
        brandTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                String name= m.getString();
                Long idBrand =m.getId();

                System.out.println("id brand: " + idBrand);
            }
        });
        packageTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StringWithId m=(StringWithId) parent.getItemAtPosition(position);
                String name= m.getString();
                Long idPackage =m.getId();

                System.out.println("id embalagem: " + idPackage);
            }
        });


        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(AddBeerActivity.this).crop().compress(1024).maxResultSize(1080,1080).start();

            }
        });


        buttonAdd.setOnClickListener(this);
        FinishButton.setOnClickListener(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();
        pickedImage.setImageURI(uri);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_Ingredients:
                addView();
                break;

            case R.id.FinishButton:
                checkIfValidAndRead();
                break;
        }

    }

    private boolean checkIfValidAndRead() {
        ingredientList.clear();
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

    private void removeView(View view){

        list_Ingredients.removeView(view);
    }
}