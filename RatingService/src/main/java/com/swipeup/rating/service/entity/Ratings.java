package com.swipeup.rating.service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

	
import lombok.AllArgsConstructor;
import lombok.Data;


@Document("user_Ratings")
@Data
@AllArgsConstructor
public class Ratings {
	
	@Id
	private String RatingId;
	private  String userId;
	private String hotelId;
	private int rating;
	private String remark;

}
