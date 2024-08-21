package com.swipeup.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "micro_users")
@Data
public class User {

	@Id
	@Column(name = "usrID")
	private String userId;
	@Column(name = "usrNm")
	private String name;
	@Column(name = "usrPswrd")
	private String password;
	@Column(name = "usrAbt")
	private String about;
	
	@Transient
	private List<Ratings> ratings = new ArrayList<>();

}
