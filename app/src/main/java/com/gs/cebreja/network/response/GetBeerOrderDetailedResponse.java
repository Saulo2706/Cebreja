package com.gs.cebreja.network.response;

import java.util.List;

public class GetBeerOrderDetailedResponse {

    @com.squareup.moshi.Json(name = "id")
    private Long id;
    @com.squareup.moshi.Json(name = "orderType")
    private OrderType orderType;
    @com.squareup.moshi.Json(name = "orderStatus")
    private OrderStatus orderStatus;
    @com.squareup.moshi.Json(name = "whenChanged")
    private String whenChanged;
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
    @com.squareup.moshi.Json(name = "country")
    private Country country;
    @com.squareup.moshi.Json(name = "ingredients")
    private List<Ingredients> ingredientsList;
    @com.squareup.moshi.Json(name = "photos")
    private List<String> photos;

    public GetBeerOrderDetailedResponse() {
    }

    public GetBeerOrderDetailedResponse(Long id, OrderType orderType, OrderStatus orderStatus, String whenChanged, String name, String description, String volume, String alcholicPercentage, Packing packing, Type type, Brand brand, Country country, List<Ingredients> ingredientsList, List<String> photos) {
        this.id = id;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.whenChanged = whenChanged;
        this.name = name;
        this.description = description;
        this.volume = volume;
        this.alcholicPercentage = alcholicPercentage;
        this.packing = packing;
        this.type = type;
        this.brand = brand;
        this.country = country;
        this.ingredientsList = ingredientsList;
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getWhenChanged() {
        return whenChanged;
    }

    public void setWhenChanged(String whenChanged) {
        this.whenChanged = whenChanged;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "GetBeerOrderDetailedResponse{" +
                "id=" + id +
                ", orderType=" + orderType +
                ", orderStatus=" + orderStatus +
                ", whenChanged='" + whenChanged + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", volume='" + volume + '\'' +
                ", alcholicPercentage='" + alcholicPercentage + '\'' +
                ", packing=" + packing +
                ", type=" + type +
                ", brand=" + brand +
                ", country=" + country +
                ", ingredientsList=" + ingredientsList +
                ", photos=" + photos +
                '}';
    }
}
