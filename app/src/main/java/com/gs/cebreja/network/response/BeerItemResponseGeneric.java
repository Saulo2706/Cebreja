package com.gs.cebreja.network.response;


public class BeerItemResponseGeneric {

    @com.squareup.moshi.Json(name = "id")
    private Long id;
    @com.squareup.moshi.Json(name = "name")
    private String name;

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


}
