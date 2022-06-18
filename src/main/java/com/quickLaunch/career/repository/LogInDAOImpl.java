package com.quickLaunch.career.repository;

import java.sql.SQLException;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.quickLaunch.career.model.Login;
import com.quickLaunch.career.model.User;

@Repository
public class LogInDAOImpl 
{
	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	public User getUserLogin(Login login)
	{
		String query = "Select password from tbl_user where contact_no = :contactNo";
	    SqlParameterSource parameterSource = new MapSqlParameterSource("contactNo", login.getContactNo());
	    try 
	    {
	        return jdbcTemplate.queryForObject(query, parameterSource, new RowMapper<User>() {
	            @Override
	            public User mapRow(ResultSet rs, int rowNum) throws SQLException
	            {
	            	User user = new User();
	            	//user.setFullName(rs.getString("user_name"));
	            	//user.setDob(rs.getDate("dob"));
	            	//user.setEmail(rs.getString("email_id"));
	            	//user.setContactNo(rs.getInt("contactNo"));
	            	user.setPassword(rs.getString("password")); //here password is the "password" column in tbl_user
	            	
	            	return user;
	            }
	        });
	    } 
	    catch (EmptyResultDataAccessException e) 
	    {
	        return null;
	    }
		
	}
}
