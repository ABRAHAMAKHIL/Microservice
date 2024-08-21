package com.swipeup.rating.service.services;

import java.util.List;

import com.swipeup.rating.service.entity.Ratings;

public interface RatingService {

	Ratings create(Ratings ratings);

	List<Ratings> getRatings();

	List<Ratings> getRatingsByUserId(String userId);

	List<Ratings> getRatingsByHotelId(String hotelId);
}
