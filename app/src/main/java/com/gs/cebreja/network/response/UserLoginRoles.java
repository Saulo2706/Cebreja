package com.gs.cebreja.network.response;

public class UserLoginRoles {

    private int id;
    private String name,authority;

    public UserLoginRoles() {
    }

    public UserLoginRoles(int id, String name, String authority) {
        this.id = id;
        this.name = name;
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String authority() {
        return authority;
    }

    @Override
    public String toString() {
        return "UserLoginRoles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
