package com.gs.cebreja.model;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    private int id;
    private String title,description,pais, typeBeer, brandBeer, packegeBeer;
    private List<String> ingredients = new ArrayList<>();

    public Beer(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTypeBeer() {
        return typeBeer;
    }

    public void setTypeBeer(String typeBeer) {
        this.typeBeer = typeBeer;
    }

    public String getBrandBeer() {
        return brandBeer;
    }

    public void setBrandBeer(String brandBeer) {
        this.brandBeer = brandBeer;
    }

    public String getPackegeBeer() {
        return packegeBeer;
    }

    public void setPackegeBeer(String packegeBeer) {
        this.packegeBeer = packegeBeer;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
