package com.gs.cebreja.model;

import com.gs.cebreja.network.response.OrderStatus;
import com.gs.cebreja.network.response.OrderType;

import java.util.List;

public class OrderSolicitations {
    private Long id;
    private String name;
    private String whenChanged;
    private List<String> photos;
    private OrderType orderType;
    private OrderStatus orderStatus;

    public OrderSolicitations() {
    }

    public OrderSolicitations(Long id, String name, String whenChanged, List<String> photos, OrderType orderType, OrderStatus orderStatus) {
        this.id = id;
        this.name = name;
        this.whenChanged = whenChanged;
        this.photos = photos;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
    }

    public String getWhenChanged() {
        return whenChanged;
    }

    public void setWhenChanged(String whenChanged) {
        this.whenChanged = whenChanged;
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

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
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

    @Override
    public String toString() {
        return "OrderSolicitations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photos=" + photos +
                ", orderType=" + orderType +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
