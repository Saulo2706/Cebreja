package com.gs.cebreja.network.response;
import java.io.Serializable;
import javax.annotation.Generated;
import com.squareup.moshi.Json;

public class Links implements Serializable{


    @Generated("jsonschema2pojo")

    @Json(name = "first")
    private First first;

    @Json(name = "next")
    private Next next;

    @Json(name = "prev")
    private Prev prev;

    @Json(name = "self")
    private Self self;

    @Json(name = "last")
    private Last last;
    private final static long serialVersionUID = 1581231359299364535L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Links() {
    }


    /**
     *
     * @param first
     * @param next
     * @param prev
     * @param self
     * @param last
     */

    public Links(First first, Next next, Prev prev, Self self, Last last) {
        this.first = first;
        this.next = next;
        this.prev = prev;
        this.self = self;
        this.last = last;
    }


    public Next getNext() {
        return next;
    }

    public Last getLast() {
        return last;
    }

    public First getFirst() {
        return first;
    }

    public Prev getPrev() {
        return prev;
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

