package dao;

import java.util.ArrayList;

import model.Booking;
import model.BookingDetail;
import model.TheaterList;
import model.User;

public interface CustomerDao
{
	ArrayList<TheaterList> showMovieTheater(int theaterID) throws Exception;
	int getShow(int mid, int tid) throws Exception;
	ArrayList<String> getSeats(int showID) throws Exception;
	int updateShow(int sid, int seat) throws Exception;
	int bookingTicket(ArrayList<Booking> list) throws Exception;
	ArrayList<BookingDetail> bookingStatus(int userID) throws Exception;
	User getUserData(int id) throws Exception;
	int updateProfile(User u1) throws Exception;
	boolean verifyPassword(User u1) throws Exception;
	int changePassword(User u1) throws Exception;
	boolean cancelTicket(int id) throws Exception;
	int IncrementSeatNumber(int bid) throws Exception;
}
