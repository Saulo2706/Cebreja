package com.gs.cebreja.network.response;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;


@Generated("jsonschema2pojo")
public class BeerRankingVoes implements Serializable{


    @com.squareup.moshi.Json(name = "id")
    private Long id;
    @com.squareup.moshi.Json(name = "name")
    private String name;
    @com.squareup.moshi.Json(name = "description")
    private String description;
    @com.squareup.moshi.Json(name = "liked")
    private Boolean liked;
    @com.squareup.moshi.Json(name = "photos")
    private List<String> photos = null;
    @com.squareup.moshi.Json(name = "_links")
    private Links links;
    private final static long serialVersionUID = 1949536171366996059L;

    /**
     * No args constructor for use in serialization
     *
     */
    public BeerRankingVoes() {
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
    public BeerRankingVoes(Long id, String name, String description, Boolean liked, List<String> photos, Links links) {
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

    public BeerRankingVoes withId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BeerRankingVoes withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BeerRankingVoes withDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public BeerRankingVoes withLiked(Boolean liked) {
        this.liked = liked;
        return this;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public BeerRankingVoes withPhotos(List<String> photos) {
        this.photos = photos;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public BeerRankingVoes withLinks(Links links) {
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
