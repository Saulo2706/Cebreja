package com.gs.cebreja.network.response;
import java.io.Serializable;
import javax.annotation.Generated;
import com.squareup.moshi.Json;

public class Links implements Serializable{


    @Generated("jsonschema2pojo")


    @Json(name = "self")
    private Self self;
    private final static long serialVersionUID = 1581231359299364535L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Links() {
    }

    /**
     *
     * @param self
     */
    public Links(Self self) {
        super();
        this.self = self;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Links withSelf(Self self) {
        this.self = self;
        return this;
    }

    @Override
    public String toString() {
        return "Links{" +
                "self=" + self +
                '}';
    }
}

