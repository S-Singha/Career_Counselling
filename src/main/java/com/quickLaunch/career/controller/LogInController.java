package com.quickLaunch.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickLaunch.career.model.Login;
import com.quickLaunch.career.model.User;
import com.quickLaunch.career.repository.LogInDAOImpl;

@RestController
public class LogInController 
{
	@Autowired
	LogInDAOImpl daoImpl;
	
	@PostMapping(value = "/user")
	public ResponseEntity<Void>  user(@RequestBody Login login) {
		System.out.println("getting the login"+login);
		
//		Random randomGenerator = new Random();
//		int randomInt = randomGenerator.nextInt(8);
//		login.setId(randomInt);
	    
		if(0 ==login.getContactNo() || null == login.getPassword()) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
	    User savedUser = daoImpl.getUserLogin(login);
	    
	    if(null != savedUser && savedUser.getPassword().equals(login.getPassword())) {
	    	return new ResponseEntity<>(HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}
