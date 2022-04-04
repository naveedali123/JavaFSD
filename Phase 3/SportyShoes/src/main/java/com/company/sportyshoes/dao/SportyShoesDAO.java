package com.company.sportyshoes.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.company.sportyshoes.entity.*;

@Repository
public class SportyShoesDAO {
	
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		public List<User> getUserDetails(int id) {
			
	
			List<User> userDetails = jdbcTemplate.query("select * from users", new RowMapper<User> () {
			
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setUsername(rs.getString(1));
					user.setUseremail(rs.getString(2));
					
					return user;
				}
				
			});
			
			return userDetails;
		}
		
		
		public boolean getAdmin(String adminemail, String  adminpassword) {
			
			boolean isSuccess;
	
			@SuppressWarnings("deprecation")
			Admin adminCredential = jdbcTemplate.queryForObject("select * from admin where adminemail=? AND adminpassword=?", new Object[] { adminemail,  adminpassword} , new RowMapper<Admin> () {
				
				
				public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
					Admin admin = new Admin();
					admin.setAdminemail(rs.getString(1));
	       			admin.setAdminpassword(rs.getString(2));
					
					return admin;
				}	
			});
			
			if(adminCredential != null) {
				
				isSuccess = true;
				
			}else {
				
				isSuccess = false;
				
			}
			
			return isSuccess;
		}
		
		
		public void changeAdminPassword(String adminpassword) {
			
			jdbcTemplate.update("update admin set adminpassword=? where adminid=1", new Object[] { adminpassword });
			
		}
		
		
		public List<User> getUsers() {
			
			List<User> users = jdbcTemplate.query("select * from users", new RowMapper<User> () {
				
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					
					user.setUsername(rs.getString(1));
					user.setUseremail(rs.getString(2));
					
					return user;
				}
				
			});
			
			return users;
		}
		
		
		public User getUserByName(String username) {
			
			@SuppressWarnings("deprecation")
			User userDetails = jdbcTemplate.queryForObject("select * from users where username=?", new Object[] {username} , new RowMapper<User> () {
				
				
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					
					user.setUsername(rs.getString(2));
					user.setUseremail(rs.getString(3));
					
					return user;
				}
				
			});
			
			return userDetails;
		}
		
		
		public List<Product> getProducts() {
			
			List<Product> products = jdbcTemplate.query("select * from products", new RowMapper<Product> () {
				
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product product = new Product();
					
					product.setProductid(rs.getInt(1));
					product.setProductname(rs.getString(2));
					product.setProductprice(rs.getInt(3));
					product.setCategoryname(rs.getString(4));
					
					return product;
				}
				
			});
			
			return products;
		}
		
		
		public void addProductDetail(Product product) {
			
			jdbcTemplate.update("insert into products (productname, productprice, categoryname ) values (?, ?, ?)", new Object[] {
					product.getProductname(), product.getProductprice(), product.getCategoryname()
			});					
		}
		
		
		public void modifyProductDetail(Product product) {
			
			jdbcTemplate.update("update products set productprice=?, categoryname=? where productid=?", new Object[] {
					product.getProductprice(), product.getCategoryname(), product.getProductid()
			});	
		}
		
		
		public int deletProductById(int id) {
			
			int val = jdbcTemplate.update("delete from products where productid=?", new Object[] {id});
			
			return val;
		}
		
		public List<PurchaseReport> getPurchaseReport(int categoryId, String purchaseDate) {
			
			//String sql = "select * from purchasereport where categoryid="+categoryId+" AND purchasedate="+purchaseDate;
			
			@SuppressWarnings("deprecation")
			List<PurchaseReport> report = jdbcTemplate.query("select * from purchasereport where categoryid=? AND purchasedate=?", new Object[] {categoryId, purchaseDate } ,new RowMapper<PurchaseReport> () {
				
				public PurchaseReport mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					PurchaseReport purchaseReport = new PurchaseReport();
					
					purchaseReport.setUsername(rs.getString(2));
					purchaseReport.setProductname(rs.getString(3));
					
					return purchaseReport;
				}
				
			});
			
			return report;
		}
		
		
}
