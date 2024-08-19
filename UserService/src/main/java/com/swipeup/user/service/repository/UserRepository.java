package com.swipeup.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swipeup.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
