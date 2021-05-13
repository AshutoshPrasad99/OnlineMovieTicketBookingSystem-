package jUnitTestCase;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.UserDaoImpl;
import exception.InvalidMobileNumberException;
import exception.InvalidPasswordSizeException;
import model.User;

public class UserDaoTest {

UserDaoImpl udi = null;
	
	@Before
	public void init()
	{
		udi = new UserDaoImpl();
	}
	
	@After
	public void deInit()
	{
		udi = null;
	}
	
	@Test
	public void signupTest() throws Exception
	{
		User u1 = new User();
		u1.setName("User1");
		try {
			u1.setContact(9999999999l);
		} catch (InvalidMobileNumberException e1) {
			e1.printStackTrace();
		}
		u1.setEmail("user1@abc.com");
		try {
			u1.setPassword("user11111");
		} catch (InvalidPasswordSizeException e1) {
			e1.printStackTrace();
		}
		
		assertEquals("signUp failed...",1,udi.signup(u1));
	}
	
	@Test
	public void loginTest() throws Exception
	{
		User u1 = new User();
		u1.setName("rohan");
		try {
			u1.setPassword("rohan111");
		} catch (InvalidPasswordSizeException e1) {
			e1.printStackTrace();
		}
		
		int[] flag = udi.login(u1);
		
		assertEquals("Login failed...",1,flag[0]);
	}
}
