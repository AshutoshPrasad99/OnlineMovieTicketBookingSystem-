package model;

public class Movie
{
	private int movieID;
	private String movieName;
	
	public int getMovieID()
	{
		return movieID;
	}
	public void setMovieID(int movieID)
	{
		this.movieID = movieID;
	}
	public void setMovieName(String name)
	{
		movieName = name;
	}
	public String getMovieName()
	{
		return movieName;
	}
}
