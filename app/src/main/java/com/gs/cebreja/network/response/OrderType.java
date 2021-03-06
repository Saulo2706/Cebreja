package com.gs.cebreja.network.response;

import java.io.Serializable;

public class OrderType implements Serializable {
    private Long id;
    private String name;

    public OrderType() {
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

    @Override
    public String toString() {
        return "OrderType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
