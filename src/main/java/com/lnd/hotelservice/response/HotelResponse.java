package com.lnd.hotelservice.response;

import com.lnd.hotelservice.domain.Hotel;

import java.util.List;

public class HotelResponse {
    Hotel hotel;
    List<Rating> ratings;

    String ratingServiceDetails;

    public HotelResponse() {
    }

    public HotelResponse(Hotel hotel, List<Rating> ratings, String ratingServiceDetails) {
        this.hotel = hotel;
        this.ratings = ratings;
        this.ratingServiceDetails = ratingServiceDetails;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getRatingServiceDetails() {
        return ratingServiceDetails;
    }

    public void setRatingServiceDetails(String ratingServiceDetails) {
        this.ratingServiceDetails = ratingServiceDetails;
    }
}
