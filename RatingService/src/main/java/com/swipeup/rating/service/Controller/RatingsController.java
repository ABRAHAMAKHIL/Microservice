package com.swipeup.rating.service.Controller;

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

import com.swipeup.rating.service.entity.Ratings;
import com.swipeup.rating.service.services.RatingService;

@RestController
@RequestMapping("/api/ratings")
public class RatingsController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/create")
	public ResponseEntity<Ratings> createRating(@RequestBody Ratings rating){
		
		Ratings savedRating = ratingService.create(rating);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
		
		
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Ratings>> listOfRating(){
		
		List<Ratings>	ratings  = ratingService.getRatings();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
		
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Ratings>> listOfRatingByuserId(@PathVariable String userId){
		
		List<Ratings>	ratings  = ratingService.getRatingsByUserId(userId);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
		
		
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<List<Ratings>> listOfRatingByHotelId(@PathVariable String hotelId){
		
		List<Ratings>	ratings  = ratingService.getRatingsByUserId(hotelId);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(ratings);
		
		
	}

}
