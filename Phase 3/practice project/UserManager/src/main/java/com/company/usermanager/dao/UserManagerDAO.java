package com.company.usermanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.company.usermanager.entity.User;

@Repository
public class UserManagerDAO {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User getUserDetails(int id) {
			
			@SuppressWarnings("deprecation")
			User userDetails = jdbcTemplate.queryForObject("select * from users where userid=?", new Object[] {id} , new RowMapper<User> () {
				
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setUserid(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setUseremail(rs.getString(3));
					user.setUserpassword(rs.getString(4));
					
					return user;
				}
				
			});
			
			return userDetails;
		}
	
	
	public void updateUserDetails(User user) {
		
		jdbcTemplate.update("update users set username=?, useremail=?, userpassword=? where userid=?", new Object[] {
												user.getUsername(), user.getUseremail(), user.getUserpassword(), user.getUserid()} );
					
		
	}
}
