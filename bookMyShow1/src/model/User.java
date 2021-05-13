package model;

import exception.InvalidMobileNumberException;
import exception.InvalidPasswordSizeException;
import validation.Validate;

public class User
{
	private int userID;
	private String name;
	private long contact;
	private String email;
	private String password;
	
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setContact(long contact) throws InvalidMobileNumberException
	{
		if(!Validate.isValidContact(contact))
		{
			throw new InvalidMobileNumberException();
		}
		else
		{
			this.contact = contact;
		}
	}
	public long getContact()
	{
		return contact;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return email;
	}
	
	public void setPassword(String password) throws InvalidPasswordSizeException
	{
		if(!Validate.isValidPassword(password))
		{
			throw new InvalidPasswordSizeException();
		}
		else
		{
			this.password = password;
		}
	}
	public String getPassword()
	{
		return password;
	}
}
