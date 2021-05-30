package com.gs.cebreja.activity;

import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AddBeerActivity extends MainActivity implements View.OnClickListener {

    LinearLayout list_Ingredients;
    Button buttonAdd, FinishButton;

    List<String> ingredientList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beer);
        SetupUI.set(findViewById(R.id.addBeer), AddBeerActivity.this);

        list_Ingredients = findViewById(R.id.list_Ingredients);
        buttonAdd = findViewById(R.id.add_Ingredients);
        FinishButton = findViewById(R.id.FinishButton);


        buttonAdd.setOnClickListener(this);
        FinishButton.setOnClickListener(this);


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