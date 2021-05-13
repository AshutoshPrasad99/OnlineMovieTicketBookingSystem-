package service;

import model.User;

public interface UserService 
{
	int signup(User u1) throws Exception;
	int[] login(User u1) throws Exception;
}
