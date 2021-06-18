package com.gs.cebreja.network.response;

public class Appreciation {
    String comment;
    Float score;

    public Appreciation() {
    }

    public Appreciation(String comment, Float score) {
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

    @Override
    public String toString() {
        return "Appreciation{" +
                "comment='" + comment + '\'' +
                ", score=" + score +
                '}';
    }
}
