package com.gs.cebreja.network.response;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")

public class Embedded implements Serializable{

    @com.squareup.moshi.Json(name = "beerVoes")
    private List<BeerVoes> voes;
    private final static long serialVersionUID = 2894582487142234724L;


    /**
     * No args constructor for use in serialization
     *
     */
    public Embedded() {
    }

    /**
     *
     * @param voes
     */
    public Embedded(List<BeerVoes> voes) {
        super();
        this.voes = voes;
    }

    public List<BeerVoes> getVoes() {
        return voes;
    }

    public void setVoes(List<BeerVoes> voes) {
        this.voes = voes;
    }

    public Embedded withVoes(List<BeerVoes> voes) {
        this.voes = voes;
        return this;
    }


   @Override
    public String toString() {

        return "Embedded{" +
                "voes=" + voes +
                '}';
    }
}
