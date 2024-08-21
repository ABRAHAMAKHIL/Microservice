package com.swipeup.hotel.services;

import java.util.List;

import com.swipeup.hotel.entity.Hotel;

public interface HotelServices {
	
	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getHotelById(String hotelId);
}
