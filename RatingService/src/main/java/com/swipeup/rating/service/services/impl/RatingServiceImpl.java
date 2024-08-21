package com.swipeup.rating.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swipeup.rating.service.entity.Ratings;
import com.swipeup.rating.service.repository.RatingRepos;
import com.swipeup.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepos ratingRepo;

	@Override
	public Ratings create(Ratings ratings) {

		return ratingRepo.save(ratings);
	}

	@Override
	public List<Ratings> getRatings() {

		return ratingRepo.findAll();
	}

	@Override
	public List<Ratings> getRatingsByUserId(String userId) {

		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Ratings> getRatingsByHotelId(String hotelId) {

		return ratingRepo.findByHotelId(hotelId);
	}

}
