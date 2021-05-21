package com.gs.cebreja.model;

public class Beer {

    private String title;
    private String description;

    public Beer(String title, String description) {
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
