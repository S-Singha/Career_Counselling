package com.quickLaunch.career.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

//import com.quickLaunch.career.model.Result;
import com.quickLaunch.career.model.QuizAns;
import com.quickLaunch.career.model.Result;

@Repository
public class ResultDAOImpl 
{
	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	 
	 public QuizAns getCustomerQuizAnswer(String contactNo)
	 {
		String query =  "Select * from tbl_save_ans where contact_no = :contactNo";
		
	    SqlParameterSource parameterSource = new MapSqlParameterSource("contactNo",contactNo);
	    
	    try 
	    {
	        return jdbcTemplate.queryForObject(query, parameterSource, new RowMapper<QuizAns>() 
	        {
	        	@Override
	            public QuizAns mapRow(ResultSet rs, int rowNum) throws SQLException 
	        	{
	        		QuizAns ans = new QuizAns();
	        		ans.setContactNo(rs.getString("contact_no"));
	            	ans.setSubOption(rs.getString("subject_option")); //Testing
	            	ans.setHobbyOption(rs.getString("hobby_option")); //Cartoon Drawing
	            	
	            	return ans;
	            }
	        });
	    } 
	    catch (EmptyResultDataAccessException e) 
	    {
	    	e.printStackTrace();
	        return null;
	    }
	 }

	public List<Result> getFinalCourseProfession(QuizAns quizAns) 
	{
		String query =  "Select * from tbl_course_profession where subject_option=:subject OR hobby_option=:hobby";
		
		SqlParameterSource parameterSource = new MapSqlParameterSource("subject",quizAns.getSubOption()).addValue("hobby", quizAns.getHobbyOption());
		
		 try 
		    {
		        return jdbcTemplate.query(query, parameterSource, new RowMapper<Result>() 
		        {
		        	@Override
		            public Result mapRow(ResultSet rs, int rowNum) throws SQLException 
		        	{
		        		Result result = new Result();
		            	result.setCourse(rs.getString("course"));
		            	result.setProfession(rs.getString("profession"));
		            	
		            	return result;
		            }
		        });
		    } 
		    catch (EmptyResultDataAccessException e) 
		    {
		    	e.printStackTrace();
		        return null;
		    }
	}
}












