package com.gs.cebreja.network.response;

public class GetListFavoriteResponse {
    private Long id;
    private String name;

    public GetListFavoriteResponse() {
    }

    public GetListFavoriteResponse(Long id, String name) {
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
        return "GetListFavoriteResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
