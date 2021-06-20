package com.gs.cebreja.network.response;

public class UserRegisterResponse {
    private String birthday;
    private String firstName;
    private String lastName;
    private Boolean paidUser;
    private String gender;
    private String email;
    private String token;

    public UserRegisterResponse() {
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(Boolean paidUser) {
        this.paidUser = paidUser;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserRegisterResponse{" +
                "birthday='" + birthday + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", paidUser=" + paidUser +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
