package com.na.Rating.entity;

public class AverageRatingResponse {

    private String user_id;
    private int rating;

    public AverageRatingResponse(String user_id, int rating) {
        this.user_id = user_id;
        this.rating = rating;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
