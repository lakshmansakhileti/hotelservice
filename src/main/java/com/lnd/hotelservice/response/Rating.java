package com.lnd.hotelservice.response;

public class Rating {
    Integer rating;
    Integer userId;

    public Rating() {
    }

    public Rating(Integer rating, Integer userId) {
        this.rating = rating;
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
