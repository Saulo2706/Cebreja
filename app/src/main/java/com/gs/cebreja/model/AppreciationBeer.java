package com.gs.cebreja.model;

public class AppreciationBeer {
    String comment;
    Float score;

    public AppreciationBeer(String comment, Float score) {
        this.comment = comment;
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
