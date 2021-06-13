package com.gs.cebreja.model;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    private Long id;
    private String title,description,pais, typeBeer, brandBeer, packegeBeer,status;
    private Boolean isLiked;
    private Long qtdLikes;
    private List<String> ingredients,caminhoPoster = new ArrayList<>();

    public Beer(Long id,String title, String description, Boolean isLiked,Long qtdLikes,List caminhoPoster) {
        this.id = id;
        this.title = title;
        this.isLiked = isLiked;
        this.qtdLikes = qtdLikes;
        this.description = description;
        this.caminhoPoster = caminhoPoster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQtdLikes() {
        return qtdLikes;
    }

    public void setQtdLikes(Long qtdLikes) {
        this.qtdLikes = qtdLikes;
    }

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public List<String> getCaminhoPoster() {
        return caminhoPoster;
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
