package com.gs.cebreja.network.response;

import java.util.List;

public class UserUpdateResponse {
    private List<UserLoginRoles> roles;
    private String email, firstName, lastName,gender,birthday;
    private Boolean paidUser;

    public UserUpdateResponse() {
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

    public Boolean getPaidUser() {
        return paidUser;
    }

    @Override
    public String toString() {
        return "UserUpdateResponse{" +
                "roles=" + roles +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", paidUser=" + paidUser +
                '}';
    }
}
