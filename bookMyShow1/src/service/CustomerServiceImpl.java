package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import dao.CustomerDaoImpl;
import model.Booking;
import model.BookingDetail;
import model.TheaterList;
import model.User;

public class CustomerServiceImpl implements CustomerService
{
	static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);
	private CustomerDaoImpl cdi = new CustomerDaoImpl();
	
	public ArrayList<TheaterList> showMovieTheater(int movieID) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("showMovieTheater (Service method) is called");
		
		ArrayList<TheaterList> list = new ArrayList<>();
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			list = cdi.showMovieTheater(movieID);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public int getShow(int mid, int tid) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("getShow (Service method) is called");
		
		int sid = 0;
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			sid = cdi.getShow(mid, tid);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return sid;
	}
	
	public ArrayList<String> getSeats(int showID) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("getSeats (Service method) is called");
		
		ArrayList<String> list = new ArrayList<>();
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			list = cdi.getSeats(showID);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public int updateShow(int sid, int seat) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("updateShow (Service method) is called");
		
		int x = 0;
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			x = cdi.updateShow(sid, seat);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}
	
	public int bookingTicket(ArrayList<Booking> list) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("bookingTicket (Service method) is called");
		
		int temp = 0;
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			temp = cdi.bookingTicket(list);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return temp;
	}
	public ArrayList<BookingDetail> bookingStatus(int userID) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("bookingStatus (Service method) is called");
		
		ArrayList<BookingDetail> list = new ArrayList<>();
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			list = cdi.bookingStatus(userID);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public User getUserData(int id) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("getUserData (Service method) is called");
		
		User u1 = null;
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			u1 = cdi.getUserData(id);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return u1;
	}
	
	public int updateProfile(User u1) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("updateProfile (Service method) is called");
		
		int x = 0;
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			x = cdi.updateProfile(u1);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}
	
	public boolean verifyPassword(User u1) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("verifyPassword (Service method) is called");
		
		boolean flag = false;
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			flag = cdi.verifyPassword(u1);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
	public int changePassword(User u1) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("changePassword (Service method) is called");
		
		int x = 0;
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			x = cdi.changePassword(u1);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}
	public boolean cancelTicket(int id) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("cancelTicket (Service method) is called");
		
		boolean flag = false;
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			flag = cdi.cancelTicket(id);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
	public int IncrementSeatNumber(int bid) throws Exception
	{
		LOGGER.info("Inside the CustomerServiceImpl [Service]");
		LOGGER.info("IncrementSeatNumber (Service method) is called");
		
		int x = 0;
		try{
			LOGGER.info("Calling IncrementSeatNumber (DAO method)");
			x = cdi.IncrementSeatNumber(bid);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}
}
