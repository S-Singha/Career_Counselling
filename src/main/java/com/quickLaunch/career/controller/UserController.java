package com.quickLaunch.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickLaunch.career.model.NewUser;
import com.quickLaunch.career.repository.UserDAOImpl;

@RestController
@RequestMapping(value = "/user")

public class UserController {
	@Autowired
	UserDAOImpl userDAOImpl;

	@PutMapping
	public ResponseEntity<Void> updateUser(@RequestBody NewUser user) {
		try {
			System.out.println("Inside update user");
			userDAOImpl.updateUserDetails(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
