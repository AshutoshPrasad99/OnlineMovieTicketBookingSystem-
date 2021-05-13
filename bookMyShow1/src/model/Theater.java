package model;

import exception.InvalidMobileNumberException;
import validation.Validate;

public class Theater
{
	private int theaterID;
	private String theaterName;
	private long theaterContact;
	private String theaterAddress;
	private int totalSeat;

	public int getTheaterID()
	{
		return theaterID;
	}
	public void setTheaterID(int theaterID)
	{
		this.theaterID = theaterID;
	}
	public void setTheaterName(String name)
	{
		theaterName = name;
	}
	public String getTheaterName()
	{
		return theaterName;
	}

	public void setTheaterContact(long contact) throws InvalidMobileNumberException
	{
		if(!Validate.isValidContact(contact))
		{
			throw new InvalidMobileNumberException();
		}
		else
		{
			this.theaterContact = contact;
		}
	}
	public long getTheaterContact()
	{
		return theaterContact;
	}

	public void setTheaterAddress(String address)
	{
		theaterAddress = address;
	}
	public String getTheaterAddress()
	{
		return theaterAddress;
	}
	
	public int getTotalSeat()
	{
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat)
	{
		this.totalSeat = totalSeat;
	}
}
