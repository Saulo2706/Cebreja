package com.gs.cebreja.activity;

import com.gs.cebreja.R;
import com.gs.cebreja.model.User;
import com.gs.cebreja.util.SetupUI;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AddBeerActivity extends MainActivity implements View.OnClickListener {

    private AutoCompleteTextView paisBeerTextView,typeBeerTextView,brandTextView,packageTextView;
    private LinearLayout list_Ingredients;
    private Button buttonAdd, FinishButton;
    private TextView alcholicPercentage;
    private SeekBar barPercentageAlcholic;

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

        //seekbar percetage alcholic
        alcholicPercentage = findViewById(R.id.alcholicPercentage);
        barPercentageAlcholic = findViewById(R.id.barPercentageAlcholic);
        barPercentageAlcholic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int i =0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                i = progress;
                alcholicPercentage.setText(""+i+" %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //select world_beer
        paisBeerTextView = findViewById(R.id.paisBeerTextView);
        ArrayAdapter<String> adapter_world = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, worlds);
        paisBeerTextView.setAdapter(adapter_world);

        //select type_beer
        typeBeerTextView = findViewById(R.id.typeBeerTextView);
        ArrayAdapter<String> adapter_type = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, type_beer);
        typeBeerTextView.setAdapter(adapter_type);

        //select brand_beer
        brandTextView = findViewById(R.id.brandTextView);
        ArrayAdapter<String> adapter_brand = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, brand_beer);
        brandTextView.setAdapter(adapter_brand);

        //select package_beer
        packageTextView = findViewById(R.id.packageTextView);
        ArrayAdapter<String> adapter_package = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, package_beer);
        packageTextView.setAdapter(adapter_package);


        buttonAdd.setOnClickListener(this);
        FinishButton.setOnClickListener(this);


    }

    private static final String[] worlds = new String[]{"Brazil","Estados Unidos","Argentina"};
    private static final String[] type_beer = new String[]{"Pilsen","Lager","Bock"};
    private static final String[] brand_beer = new String[]{"Skol","Patagonia","Amstel"};
    private static final String[] package_beer = new String[]{"Engradado","Litro","Latinha"};

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