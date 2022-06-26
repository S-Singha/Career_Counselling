package com.quickLaunch.career.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickLaunch.career.model.QuizAns;
import com.quickLaunch.career.model.Result;
import com.quickLaunch.career.repository.ResultDAOImpl;

@RestController
public class ResultController 
{
	@Autowired
	ResultDAOImpl resultdaoImpl;
	Result result;
	
	@GetMapping(value = "/result/{contactNo}")
	
	public List<Result> getResult(@PathVariable String contactNo)
    {
		System.out.println("getting the result"+contactNo);
        QuizAns quizAns = resultdaoImpl.getCustomerQuizAnswer(contactNo);
        
        if(null != quizAns)
        {
        	return resultdaoImpl.getFinalCourseProfession(quizAns);
        }
        return null;
    }
}
