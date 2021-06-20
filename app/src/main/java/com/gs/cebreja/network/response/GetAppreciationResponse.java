package com.gs.cebreja.network.response;

public class GetAppreciationResponse {
    String date,user,score,comment;

    public GetAppreciationResponse() {
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
