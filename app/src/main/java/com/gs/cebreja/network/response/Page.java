package com.gs.cebreja.network.response;

import java.io.Serializable;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Page implements Serializable
{

    @com.squareup.moshi.Json(name = "size")
    private Long size;
    @com.squareup.moshi.Json(name = "totalElements")
    private Long totalElements;
    @com.squareup.moshi.Json(name = "totalPages")
    private Long totalPages;
    @com.squareup.moshi.Json(name = "number")
    private Long number;
    private final static long serialVersionUID = -8761280047942376215L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Page() {
    }

    /**
     *
     * @param number
     * @param size
     * @param totalPages
     * @param totalElements
     */
    public Page(Long size, Long totalElements, Long totalPages, Long number) {
        super();
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Page withSize(Long size) {
        this.size = size;
        return this;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Page withTotalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Page withTotalPages(Long totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Page withNumber(Long number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {
        return "Page{" +
                "size=" + size +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", number=" + number +
                '}';
    }
}
