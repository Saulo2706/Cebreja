package com.gs.cebreja.model;

public class Favorite {
    public String string;
    public Long id;

    public Favorite(String string, Long id) {
        this.string = string;
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "string='" + string + '\'' +
                ", id=" + id +
                '}';
    }
}
