package com.gs.cebreja.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.JsonToken;
import android.util.Patterns;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class User implements Parcelable {

    public static String token;
    public static List<UserRole> roles;
    private String email, password, firstName, lastName,gender,birthDate;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String firstName, String lastName, String gender, String birthDate,String token, List<UserRole> roles) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.token = token;
        this.roles = roles;
    }

    public User(String email, String firstName, String lastName, String gender, String birthDate,String token) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.token = token;
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    protected User(Parcel in) {
        email = in.readString();
        password = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        gender = in.readString();
        birthDate = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        User.token = token;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) {
        birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public int isValidRegister() {
        if(TextUtils.isEmpty(getFirstName()))
            return  0;
        else if(TextUtils.isEmpty(getLastName()))
            return 1;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return  2;
        else if(TextUtils.isEmpty(getPassword()))
            return 3;
        else if(getPassword().length()<=8)
            return 4;
        else
            return -1;
    }

    public int isValid() {
        // 0. Check for Email Empty
        // 1. Check for Email Match pattern
        // 2. Check for Password > 8

        if(TextUtils.isEmpty(getEmail()))
            return  0;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return  1;
        else if(TextUtils.isEmpty(getPassword()))
            return 2;
        else if(getPassword().length()<=8)
            return 3;
        else
            return -1;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(gender);
        dest.writeString(birthDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "roles=" + roles +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
