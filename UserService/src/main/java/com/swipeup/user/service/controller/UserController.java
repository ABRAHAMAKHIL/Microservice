package com.swipeup.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swipeup.user.service.payload.ApiResponse;
import com.swipeup.user.service.payload.UserDto;
import com.swipeup.user.service.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		UserDto savedUser = this.userService.saveUser(userDto);

		return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(@RequestParam(name="pageNumber",defaultValue = "1",required = false)Integer PageNumber,
			@RequestParam(name="pageSize",defaultValue = "1",required = false)Integer PageSize) {

		List<UserDto> savedUser = this.userService.getAlluser(PageNumber,PageSize);

		return new ResponseEntity<List<UserDto>>(savedUser, HttpStatus.FOUND);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getAllUserById(@PathVariable String userId) {

		UserDto savedUser = this.userService.getUserById(userId);

		return new ResponseEntity<UserDto>(savedUser, HttpStatus.FOUND);
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable String userId) {

		this.userService.deleteUserById(userId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.FOUND);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> UpdateUserById(@RequestBody UserDto  userDto, @PathVariable String userId) {

		UserDto usrDto =this.userService.updateUserById(userDto, userId);

		return new ResponseEntity<UserDto>(usrDto, HttpStatus.OK);
	}
	
	

}
