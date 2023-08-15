package com.lnd.hotelservice.response;

import java.util.List;

public class RatingResponse {
    String serverDetails;
    List<Rating> ratingList;

    public RatingResponse() {
    }

    public RatingResponse(String serverDetails, List<Rating> ratingList) {
        this.serverDetails = serverDetails;
        this.ratingList = ratingList;
    }

    public String getServerDetails() {
        return serverDetails;
    }

    public void setServerDetails(String serverDetails) {
        this.serverDetails = serverDetails;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
