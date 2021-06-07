package com.gs.cebreja.network.response;
import java.io.Serializable;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class BeerRankingResponse implements Serializable {

    @com.squareup.moshi.Json(name = "_embedded")
    private BeerRankingEmbedded beerRankingEmbedded;
    @com.squareup.moshi.Json(name = "_links")
    private Links links;
    @com.squareup.moshi.Json(name = "page")
    private Page page;
    private final static long serialVersionUID = -1222331466734938698L;

    /**
     * No args constructor for use in serialization
     *
     */
    public BeerRankingResponse() {
    }

    /**
     *
     * @param links
     * @param page
     * @param beerRankingEmbedded
     */
    public BeerRankingResponse(BeerRankingEmbedded beerRankingEmbedded, Links links, Page page) {
        super();
        this.beerRankingEmbedded = beerRankingEmbedded;
        this.links = links;
        this.page = page;
    }

    public BeerRankingEmbedded getEmbedded() {
        return beerRankingEmbedded;
    }

    public void setEmbedded(BeerRankingEmbedded beerRankingEmbedded) {
        this.beerRankingEmbedded = beerRankingEmbedded;
    }

    public BeerRankingResponse withEmbedded(BeerRankingEmbedded beerRankingEmbedded) {
        this.beerRankingEmbedded = beerRankingEmbedded;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public BeerRankingResponse withLinks(Links links) {
        this.links = links;
        return this;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public BeerRankingResponse withPage(Page page) {
        this.page = page;
        return this;
    }

    @Override
    public String toString() {
        return "BeerResponse{" +
                "embedded=" + beerRankingEmbedded +
                ", links=" + links +
                ", page=" + page +
                '}';
    }
}
