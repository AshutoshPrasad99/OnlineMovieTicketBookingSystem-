package model;

import java.sql.Timestamp;

public class Shows
{
	private int movieID;
	private int theaterID;
	private String date;
	private int availableSeat;
	private float price;
	
	public int getMovieID() 
	{
		return movieID;
	}
	public void setMovieID(int movieID) 
	{
		this.movieID = movieID;
	}
	public int getTheaterID() {
		return theaterID;
	}
	public void setTheaterID(int theaterID) 
	{
		this.theaterID = theaterID;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public int getAvailableSeat() 
	{
		return availableSeat;
	}
	public void setAvailableSeat(int availableSeat) 
	{
		this.availableSeat = availableSeat;
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
