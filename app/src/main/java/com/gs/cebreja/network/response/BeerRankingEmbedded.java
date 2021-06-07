package com.gs.cebreja.network.response;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")

public class BeerRankingEmbedded implements Serializable{

    @com.squareup.moshi.Json(name = "beerVoes")
    private List<BeerRankingVoes> voes;
    private final static long serialVersionUID = 2894582487142234724L;


    /**
     * No args constructor for use in serialization
     *
     */
    public BeerRankingEmbedded() {
    }

    /**
     *
     * @param voes
     */
    public BeerRankingEmbedded(List<BeerRankingVoes> voes) {
        super();
        this.voes = voes;
    }

    public List<BeerRankingVoes> getVoes() {
        return voes;
    }

    public void setVoes(List<BeerRankingVoes> voes) {
        this.voes = voes;
    }

    public BeerRankingEmbedded withVoes(List<BeerRankingVoes> voes) {
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
