package com.lnd.hotelservice.service;

import com.lnd.hotelservice.domain.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel save(Hotel hotel);
    public List<Hotel> listHotels();
    public Hotel getHotel(Integer id);

}
