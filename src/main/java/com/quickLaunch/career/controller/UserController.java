package com.quickLaunch.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickLaunch.career.model.NewUser;
import com.quickLaunch.career.repository.UserDAOImpl;

@RestController
@RequestMapping(value="/user")

public class UserController 
{
	@Autowired
	UserDAOImpl userDAOImpl;
	
	@PutMapping
	public void updateUser(@RequestBody NewUser user)
	{
		System.out.println("Inside update user");
		userDAOImpl.updateUserDetails(user);
		
	}
}
