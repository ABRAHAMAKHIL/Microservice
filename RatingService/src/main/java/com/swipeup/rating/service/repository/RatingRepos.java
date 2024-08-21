package com.swipeup.rating.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.swipeup.rating.service.entity.Ratings;

public interface RatingRepos extends MongoRepository<Ratings, String>{
	
	List<Ratings> findByUserId(String userId);
	List<Ratings> findByHotelId(String hotelId);

}
