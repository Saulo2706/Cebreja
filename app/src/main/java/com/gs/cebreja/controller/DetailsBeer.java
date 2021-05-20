package com.gs.cebreja.controller;

public class DetailsBeer {

    private String title;
    private String description;

    public DetailsBeer(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
