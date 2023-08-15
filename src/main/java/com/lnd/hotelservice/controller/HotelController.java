package com.lnd.hotelservice.controller;


import com.lnd.hotelservice.domain.Hotel;
import com.lnd.hotelservice.externalclient.RatingService;
import com.lnd.hotelservice.response.HotelResponse;
import com.lnd.hotelservice.response.Rating;
import com.lnd.hotelservice.response.RatingResponse;
import com.lnd.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelController {
    @Autowired
    HotelService service;

    @Autowired
    RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<Hotel>> listHotels() {
        return ResponseEntity.ok(service.listHotels());
    }

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(hotel));
    }

    @GetMapping("{hotelId}")
    public ResponseEntity<HotelResponse> getHotel(@PathVariable Integer hotelId) {
        Hotel hotel = service.getHotel(hotelId);
        RatingResponse ratingResponse = ratingService.getRatings(hotel.hotelId);
        HotelResponse response = new HotelResponse();
        response.setHotel(hotel);
        response.setRatings(Collections.unmodifiableList(ratingResponse.getRatingList()));
        response.setRatingServiceDetails(ratingResponse.getServerDetails());
        return ResponseEntity.ok(response);
    }
}
