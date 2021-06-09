package com.gs.cebreja.network.response;

import java.io.Serializable;
import javax.annotation.Generated;
import com.squareup.moshi.Json;

@Generated("jsonschema2pojo")

public class First {


    @Json(name = "href")
    private String href;

    public First() {
    }

    public First(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "First{" +
                "href='" + href + '\'' +
                '}';
    }
}
