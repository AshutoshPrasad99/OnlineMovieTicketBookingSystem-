package service;

import org.apache.log4j.Logger;

import dao.UserDaoImpl;
import model.User;

public class UserServiceImpl implements UserService
{
	static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	private UserDaoImpl udi = new UserDaoImpl();
	
	public int signup(User u1) throws Exception
	{
		LOGGER.info("Inside the UserServiceImpl [Service]");
		LOGGER.info("signup (Service method) is called");
		
		LOGGER.info("Calling signup (DAO method)");
		int x = udi.signup(u1);
		return x;
	}

	public int[] login(User u1) throws Exception
	{
		LOGGER.info("Inside the UserServiceImpl [Service]");
		LOGGER.info("login (Service method) is called");
		
		LOGGER.info("Calling login (DAO method)");
		int[] flag = udi.login(u1);
		return flag;
	}
}
