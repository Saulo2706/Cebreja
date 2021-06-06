package com.gs.cebreja.network.response;
import java.io.Serializable;
import javax.annotation.Generated;
import com.squareup.moshi.Json;

@Generated("jsonschema2pojo")
public class Self implements Serializable{

    @Json(name = "href")
    private String href;
    private final static long serialVersionUID = 1587088906392211496L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Self() {
    }

    /**
     *
     * @param href
     */
    public Self(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Self withHref(String href) {
        this.href = href;
        return this;
    }

    @Override
    public String toString() {
        return "Self{" +
                "href='" + href + '\'' +
                '}';
    }
}
