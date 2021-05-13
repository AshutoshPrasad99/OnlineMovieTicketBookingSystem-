package model;

import java.sql.Timestamp;

public class BookingDetail
{
	private int bookingID;
	private String customerName;
	private int customerAge;
	private String MovieName;
	private String TheaterName;
	private String theaterAddress;
	private String date;
	private String seat;
	private float price;
	
	public int getBookingID()
	{
		return bookingID;
	}
	public void setBookingID(int bookingID)
	{
		this.bookingID = bookingID;
	}
	public String getCustomerName() 
	{
		return customerName;
	}
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}
	public int getCustomerAge() 
	{
		return customerAge;
	}
	public void setCustomerAge(int customerAge) 
	{
		this.customerAge = customerAge;
	}
	public String getMovieName() 
	{
		return MovieName;
	}
	public void setMovieName(String movieName) 
	{
		MovieName = movieName;
	}
	public String getTheaterName() 
	{
		return TheaterName;
	}
	public void setTheaterName(String theaterName) 
	{
		TheaterName = theaterName;
	}
	public String getTheaterAddress() 
	{
		return theaterAddress;
	}
	public void setTheaterAddress(String theaterAddress) 
	{
		this.theaterAddress = theaterAddress;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public String getSeat()
	{
		return seat;
	}
	public void setSeat(String seat)
	{
		this.seat = seat;
	}
	public float getPrice() 
	{
		return price;
	}
	public void setPrice(float price) 
	{
		this.price = price;
	}
}
