package com.swipeup.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swipeup.hotel.entity.Hotel;
import com.swipeup.hotel.exception.ResourceNotFoundException;
import com.swipeup.hotel.reposotory.HotelRepo;

@Service
public class HotelServiceImp implements HotelServices {

	@Autowired
	private HotelRepo hoteRepo;

	@Override
	public Hotel create(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return this.hoteRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return this.hoteRepo.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		Hotel hotel = this.hoteRepo.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel","HotelId",hotelId));
		return hotel;
	}

}
