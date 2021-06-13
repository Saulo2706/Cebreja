package com.gs.cebreja.network.response;

public class Packing {

    private Long id;
    private String name;

    public Packing() {
    }

    public Packing(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Packing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
