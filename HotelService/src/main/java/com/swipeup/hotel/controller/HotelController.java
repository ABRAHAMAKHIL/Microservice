package com.swipeup.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swipeup.hotel.entity.Hotel;
import com.swipeup.hotel.services.HotelServices;

@RestController
@RequestMapping("api/hotels")
public class HotelController {

	@Autowired
	private HotelServices hotelServices;

	@PostMapping("/")
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {

		Hotel savedHotel = this.hotelServices.create(hotel);
		return new ResponseEntity<Hotel>(savedHotel, HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAll() {
		List<Hotel> listHotels = this.hotelServices.getAll();
		return new ResponseEntity<List<Hotel>>(listHotels, HttpStatus.CREATED);

	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {

		Hotel hotel = this.hotelServices.getHotelById(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);

	}

}
