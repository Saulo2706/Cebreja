package com.gs.cebreja.network.response;

import java.util.List;

public class GetBeerOrderResponse {

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
    @com.squareup.moshi.Json(name = "photos")
    private List<String> photos;

    public GetBeerOrderResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getWhenChanged() {
        return whenChanged;
    }

    public void setWhenChanged(String whenChanged) {
        this.whenChanged = whenChanged;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "GetBeerOrderResponse{" +
                "id=" + id +
                ", orderType=" + orderType +
                ", orderStatus=" + orderStatus +
                ", name='" + name + '\'' +
                ", photos=" + photos +
                '}';
    }
}
