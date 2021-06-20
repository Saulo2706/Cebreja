package com.gs.cebreja.model;

public class UserApreciation {

    String date,user,score,comment;

    public UserApreciation() {
    }

    public UserApreciation(String date, String user, String score, String comment) {
        this.date = date;
        this.user = user;
        this.score = score;
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "GetAppreciationResponse{" +
                "date='" + date + '\'' +
                ", user='" + user + '\'' +
                ", score='" + score + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

}
