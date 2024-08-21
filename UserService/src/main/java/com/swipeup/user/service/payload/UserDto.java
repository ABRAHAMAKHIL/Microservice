package com.swipeup.user.service.payload;

import java.util.ArrayList;
import java.util.List;

import com.swipeup.user.service.entities.Ratings;

import lombok.Data;

@Data
public class UserDto {

	private String userId;

	private String name;

	private String password;

	private String about;
	
	private List<Ratings> ratings = new ArrayList<>();

}
