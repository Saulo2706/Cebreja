package com.gs.cebreja.network.response;

import com.squareup.moshi.Json;

public class BeersResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "original_title")
    private final String tituloOriginal;

    @Json(name = "overview")
    private final String description;

    public BeersResponse(String caminhoPoster, String tituloOriginal, String description) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
        this.description = description;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getDescription() {
        return description;
    }
}
