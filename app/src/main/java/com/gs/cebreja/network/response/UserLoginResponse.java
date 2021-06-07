package com.gs.cebreja.network.response;

import java.util.List;

public class UserLoginResponse {

    private List<UserLoginRoles> roles;
    private String email, firstName, lastName,gender,birthday,token;

    public UserLoginResponse() {
    }

    public List<UserLoginRoles> getRoles() {
        return roles;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "UserLoginResponse{" +
                "roles=" + roles +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
