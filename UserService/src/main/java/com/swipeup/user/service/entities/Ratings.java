package com.swipeup.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {
	
	private String RatingId;
	private  String userId;
	private String hotelId;
	private int rating;
	private String remark;

}
