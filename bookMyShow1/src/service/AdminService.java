package service;

import java.util.ArrayList;

import model.BookingDetail;
import model.Movie;
import model.Shows;
import model.ShowsData;
import model.Theater;
import model.User;

public interface AdminService 
{
	int addTheater(Theater theater) throws Exception;
	int updateTheater(Theater theater) throws Exception;
	boolean deleteTheater(int id) throws Exception;
	ArrayList<Theater> getTheater() throws Exception;
	int addMovie(Movie movie) throws Exception;
	boolean deleteMovie(int id) throws Exception;
	ArrayList<Movie> getMovie() throws Exception;
	ArrayList<User> getUser() throws Exception;
	ArrayList<ShowsData> getShowList(int id) throws Exception;
	int addShow(Shows show) throws Exception;
	boolean deleteShow(int id) throws Exception;
}
