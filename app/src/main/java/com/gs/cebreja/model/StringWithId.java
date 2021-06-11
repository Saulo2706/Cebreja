package com.gs.cebreja.model;

public class StringWithId {
    public String string;
    public Long id;

    public StringWithId(String stringPart, Long idPart) {
        string = stringPart;
        id = idPart;
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
        return string;
    }
}
