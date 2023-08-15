package com.lnd.hotelservice.externalclient;

import com.lnd.hotelservice.response.Rating;
import com.lnd.hotelservice.response.RatingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class RatingService {
    @Autowired
    RestTemplate template;

    @Value("${RATING_SERVICE_NAME}")
    String ratingServiceName;

    public RatingResponse getRatings(Integer hotelId) {
        List<Rating> ratings = new ArrayList<>();
        ResponseEntity<List> listEntiry = template.getForEntity("http://"+ratingServiceName+"/ratings/hotel/" + hotelId, List.class);
        HttpHeaders headers = listEntiry.getHeaders();
        String serverInfo = headers.getFirst("Server");
        RatingResponse ratingResponse = new RatingResponse(serverInfo, listEntiry.getBody());
        return ratingResponse;
    }



}
