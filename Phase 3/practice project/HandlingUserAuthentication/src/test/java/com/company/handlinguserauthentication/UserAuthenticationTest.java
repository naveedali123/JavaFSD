package com.company.handlinguserauthentication;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

@SuppressWarnings("deprecation")
@RunWith(JUnitPlatform.class)
@DisplayName("UserAuthenticationTest")
public class UserAuthenticationTest {

	@BeforeAll
	static void initAll() {
		System.out.println("User Authentication method is going to be executed..");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("All User Authentication method were executed..");
	}

	@BeforeEach
	void beforeEachMEthod() {
		System.out.println("Given Test method is now executing..");
	}
	
	@AfterEach
	void afterEachMEthod() {
		System.out.println("Given Test method was executed..");
	}
	
	@Test
	@DisplayName("verify email Test")
	void emailAuth() {
		String userEmail = "varshit@gmail.com";
		String email = "varshit@gmail.com";
		
	    assertEquals(userEmail, email);
		
		assertSame(userEmail, email);
		
		System.out.println("User Email is verified.");
		
	}
	
	@Test
	@DisplayName("verify password Test")
	void passAuth() {
		String userPassword = "var@123";
		String password = "var@123";
		
	    assertEquals(userPassword, password);
		
		assertSame(userPassword, password);
		
		System.out.println("User Password is verified.");
		
	}
	
	@Test
	@DisplayName("verify user Test")
	void userAuth() {
		String userEmail = "varshit@gmail.com";
		String email = "varshit@gmail.com";
		
		String userPassword = "var@123";
		String password = "var@123";
		
		assertEquals(userEmail, email);
		
		assertSame(userEmail, email);
		
		
	    assertEquals(userPassword, password);
		
		assertSame(userPassword, password);
		
		System.out.println("User is verified.");
		
	}
}
