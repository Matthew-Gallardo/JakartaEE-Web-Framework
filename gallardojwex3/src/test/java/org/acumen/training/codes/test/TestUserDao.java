package org.acumen.training.codes.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.acumen.training.codes.dao.UserDao;
import org.acumen.training.codes.model.User;
import org.junit.jupiter.api.Test;

public class TestUserDao {
	
	@Test
	public void testInsert() {
		UserDao dao = new UserDao("bookstore_pu");
		User user= new User();
	
		user.setEmail("kaisotto8@gmail.com");
		user.setFirstName("Kai");
		user.setLastName("Sotto");
		user.setPassword("iloveph");
		dao.insert(user);
		System.out.println("Inserted 1 record");
	}
	
	@Test
	public void testValidate() {
		UserDao dao = new UserDao("bookstore_pu");
		  User foundUser = dao.findUserByCredentials("kaisotto8@gmail.com", "iloveph");
	    
	        assertNotNull(foundUser, "User should be found");
	        assertEquals("kaisotto8@gmail.com", foundUser.getEmail(), "Emails should match");
	        assertEquals("Kai", foundUser.getFirstName(), "First names should match");
	        assertEquals("Sotto", foundUser.getLastName(), "Last names should match");
	}


}
