package com.quickLaunch.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickLaunch.career.model.QuizSubAns;
import com.quickLaunch.career.repository.QuizSubAnsDAOImpl;

@RestController
public class QuizSubAnsController 
{
	@Autowired
	QuizSubAnsDAOImpl quizsubansdaoImpl;
	
	@PostMapping(value = "/save/quizans")
    public ResponseEntity<Void> saveQuizAns(@RequestBody QuizSubAns quizans) 
	{
		System.out.println("Save user ans:"+quizans);
		try 
		{
			quizsubansdaoImpl.getSubjectAns(quizans);
			//quizsubansdaoImpl.getHobbyAns(quizans);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
