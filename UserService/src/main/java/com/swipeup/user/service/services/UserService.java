package com.swipeup.user.service.services;

import java.util.List;

import com.swipeup.user.service.payload.UserDto;

public interface UserService {

	UserDto saveUser(UserDto userDto);

	List<UserDto> getAlluser(Integer PageNumber,Integer PageSize);

	UserDto getUserById(String userId);

	void deleteUserById(String userId);

	UserDto updateUserById(UserDto userDto,String userId);
}
