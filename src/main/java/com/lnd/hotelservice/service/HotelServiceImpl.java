package com.lnd.hotelservice.service;

import com.lnd.hotelservice.domain.Hotel;
import com.lnd.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> listHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(Integer hotelId) {
        return hotelRepository.findById(hotelId).orElse(new Hotel());
    }
}
