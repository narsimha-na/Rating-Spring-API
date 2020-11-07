package com.na.Rating.entity;

public class AverageRatingResponse {

    private String user_id;
    private String rating;

    public AverageRatingResponse(String user_id, String rating) {
        this.user_id = user_id;
        this.rating = rating;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
