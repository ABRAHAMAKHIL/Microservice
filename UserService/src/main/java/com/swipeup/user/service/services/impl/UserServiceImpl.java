package com.swipeup.user.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swipeup.user.service.entities.Ratings;
import com.swipeup.user.service.entities.User;
import com.swipeup.user.service.exceptions.ResourceNotFoundException;
import com.swipeup.user.service.payload.UserDto;
import com.swipeup.user.service.repository.UserRepository;
import com.swipeup.user.service.services.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	
	private RestTemplate restTemplate;
	
	
	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserDto saveUser(UserDto userDto) {
		
		String userId = UUID.randomUUID().toString();
		
		User userVal = this.DtoToUser(userDto);
		userVal.setUserId(userId);
		User savedUser = userRepo.save(userVal);
		return this.userToDto(savedUser);
	}

	@Override
	public List<UserDto> getAlluser(Integer PageNumber, Integer PageSize) {
		
		Pageable pg = PageRequest.of(PageNumber, PageSize);
		Page<User> userVal = this.userRepo.findAll(pg);
		
		List<User> user= userVal.getContent();
		@SuppressWarnings("unchecked")
		ArrayList<Ratings> ratings = restTemplate.getForObject("http://localhost:8083/api/ratings/user/"+user.get(1).getUserId(), ArrayList.class);
		user.get(1).setRatings(ratings);
		
		List<UserDto> ListOfUserdtls = user.stream().map((usr) -> this.userToDto(usr)).collect(Collectors.toList());
		return ListOfUserdtls;
	}

	@Override
	public UserDto getUserById(String userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
	@SuppressWarnings("unchecked")
	ArrayList<Ratings> ratings = restTemplate.getForObject("http://localhost:8083/api/ratings/user/"+user.getUserId(), ArrayList.class);
		user.setRatings(ratings);
		User userVal = this.userRepo.save(user);
		log.info("{}",userVal);
		return this.userToDto(user);
	}

	@Override
	public void deleteUserById(String userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		userRepo.delete(user);

	}

	@Override
	public UserDto updateUserById(UserDto userDto ,String userId) {
			User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
			user.setAbout(userDto.getAbout());
			user.setName(userDto.getName());
			user.setPassword(userDto.getPassword());
			
			User savedUser = userRepo.save(user);
			return this.userToDto(savedUser);
	}

	public User DtoToUser(UserDto userDto) {

		return modelMapper.map(userDto, User.class);

	}

	public UserDto userToDto(User user) {

		return modelMapper.map(user, UserDto.class);

	}

}
