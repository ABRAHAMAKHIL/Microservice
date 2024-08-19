package com.swipeup.user.service.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public UserDto saveUser(UserDto userDto) {
		
		String userId = UUID.randomUUID().toString();
		
		User userVal = this.DtoToUser(userDto);
		userVal.setUserId(userId);
		User savedUser = userRepo.save(userVal);
		return this.userToDto(savedUser);
	}

	@Override
	public List<UserDto> getAlluser() {
		
		

		List<User> userVal = this.userRepo.findAll();
		List<UserDto> ListOfUserdtls = userVal.stream().map((usr) -> this.userToDto(usr)).collect(Collectors.toList());
		return ListOfUserdtls;
	}

	@Override
	public UserDto getUserById(String userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

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
