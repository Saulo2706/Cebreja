package com.gs.cebreja.network.response;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;


@Generated("jsonschema2pojo")
public class BeerVoes implements Serializable{


    @com.squareup.moshi.Json(name = "id")
    private Long id;
    @com.squareup.moshi.Json(name = "name")
    private String name;
    @com.squareup.moshi.Json(name = "description")
    private String description;
    @com.squareup.moshi.Json(name = "liked")
    private Boolean liked;
    @com.squareup.moshi.Json(name = "photos")
    private List<Object> photos = null;
    @com.squareup.moshi.Json(name = "_links")
    private Links links;
    private final static long serialVersionUID = 1949536171366996059L;

    /**
     * No args constructor for use in serialization
     *
     */
    public BeerVoes() {
    }

    /**
     *
     * @param name
     * @param description
     * @param links
     * @param id
     * @param photos
     * @param liked
     */
    public BeerVoes(Long id, String name, String description, Boolean liked, List<Object> photos, Links links) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.liked = liked;
        this.photos = photos;
        this.links = links;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BeerVoes withId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BeerVoes withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BeerVoes withDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public BeerVoes withLiked(Boolean liked) {
        this.liked = liked;
        return this;
    }

    public List<Object> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Object> photos) {
        this.photos = photos;
    }

    public BeerVoes withPhotos(List<Object> photos) {
        this.photos = photos;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public BeerVoes withLinks(Links links) {
        this.links = links;
        return this;
    }

    @Override
    public String toString() {
        return "BeerVoes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", liked=" + liked +
                ", photos=" + photos +
                ", links=" + links +
                '}';
    }
}
