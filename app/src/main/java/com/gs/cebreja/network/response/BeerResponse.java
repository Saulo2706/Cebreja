package com.gs.cebreja.network.response;

import java.util.List;

public class BeerResponse {

    @com.squareup.moshi.Json(name = "id")
    private Long id;
    @com.squareup.moshi.Json(name = "name")
    private String name;
    @com.squareup.moshi.Json(name = "description")
    private String description;
    @com.squareup.moshi.Json(name = "volume")
    private String volume;
    @com.squareup.moshi.Json(name = "alcholicPercentage")
    private String alcholicPercentage;
    @com.squareup.moshi.Json(name = "packing")
    private Packing packing;
    @com.squareup.moshi.Json(name = "type")
    private Type type;
    @com.squareup.moshi.Json(name = "brand")
    private Brand brand;
    @com.squareup.moshi.Json(name = "status")
    private Status status;
    @com.squareup.moshi.Json(name = "country")
    private Country country;
    @com.squareup.moshi.Json(name = "ingredients")
    private List<Ingredients> ingredientsList;
    @com.squareup.moshi.Json(name = "photos")
    private List<String> photos = null;
    @com.squareup.moshi.Json(name = "liked")
    private Boolean liked;
    @com.squareup.moshi.Json(name = "likes")
    private Long likes;


    public BeerResponse() {
    }

    public BeerResponse(Long id, String name, String description, String volume, String alcholicPercentage, Packing packing, Type type, Brand brand, Status status, Country country, List<Ingredients> ingredientsList, List<String> photos, Boolean liked, Long likes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.volume = volume;
        this.alcholicPercentage = alcholicPercentage;
        this.packing = packing;
        this.type = type;
        this.brand = brand;
        this.status = status;
        this.country = country;
        this.ingredientsList = ingredientsList;
        this.photos = photos;
        this.liked = liked;
        this.likes = likes;
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAlcholicPercentage() {
        return alcholicPercentage;
    }

    public void setAlcholicPercentage(String alcholicPercentage) {
        this.alcholicPercentage = alcholicPercentage;
    }

    public Packing getPacking() {
        return packing;
    }

    public void setPacking(Packing packing) {
        this.packing = packing;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "BeerResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", volume='" + volume + '\'' +
                ", alcholicPercentage='" + alcholicPercentage + '\'' +
                ", packing=" + packing +
                ", type=" + type +
                ", brand=" + brand +
                ", status=" + status +
                ", country=" + country +
                ", ingredientsList=" + ingredientsList +
                ", photos=" + photos +
                ", liked=" + liked +
                ", likes=" + likes +
                '}';
    }
}
