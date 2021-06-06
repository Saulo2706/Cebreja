package com.gs.cebreja.network.response;
import java.io.Serializable;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class BeerResponse implements Serializable {

    @com.squareup.moshi.Json(name = "_embedded")
    private Embedded embedded;
    @com.squareup.moshi.Json(name = "_links")
    private Links links;
    @com.squareup.moshi.Json(name = "page")
    private Page page;
    private final static long serialVersionUID = -1222331466734938698L;

    /**
     * No args constructor for use in serialization
     *
     */
    public BeerResponse() {
    }

    /**
     *
     * @param links
     * @param page
     * @param embedded
     */
    public BeerResponse(Embedded embedded, Links links, Page page) {
        super();
        this.embedded = embedded;
        this.links = links;
        this.page = page;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public BeerResponse withEmbedded(Embedded embedded) {
        this.embedded = embedded;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public BeerResponse withLinks(Links links) {
        this.links = links;
        return this;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public BeerResponse withPage(Page page) {
        this.page = page;
        return this;
    }

    @Override
    public String toString() {
        return "BeerResponse{" +
                "embedded=" + embedded +
                ", links=" + links +
                ", page=" + page +
                '}';
    }
}
