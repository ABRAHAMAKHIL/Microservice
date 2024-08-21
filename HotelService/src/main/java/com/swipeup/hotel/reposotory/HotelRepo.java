package com.swipeup.hotel.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swipeup.hotel.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String> {

}
