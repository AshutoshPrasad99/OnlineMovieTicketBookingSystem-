package service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import dao.AdminDaoImpl;
import model.Movie;
import model.Shows;
import model.ShowsData;
import model.Theater;
import model.User;

public class AdminServiceImpl implements AdminService
{
	static final Logger LOGGER = Logger.getLogger(AdminServiceImpl.class);
	private AdminDaoImpl adi = new AdminDaoImpl();

	public int addTheater(Theater theater) throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("addTheater (Service method) is called");
		
		int x = 0;
		try{
			LOGGER.info("Calling addTheater (DAO method)");
			x = adi.addTheater(theater);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}

	public int updateTheater(Theater theater) throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("updateTheater (Service method) is called");
		
		int x = 0;
		try{
			LOGGER.info("Calling updateTheater (DAO method)");
			x = adi.updateTheater(theater);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}
	public boolean deleteTheater(int id) throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("deleteTheater (Service method) is called");
		
		boolean x = false;
		try{
			LOGGER.info("Calling deleteTheater (DAO method)");
			x = adi.deleteTheater(id);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}

	public ArrayList<Theater> getTheater() throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("getTheater (Service method) is called");
		
		ArrayList<Theater> list = null;
		try{
			LOGGER.info("Calling getTheaterList (DAO method)");
			list = new ArrayList(adi.getTheaterList());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}

	public int addMovie(Movie movie) throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("addMovie (Service method) is called");
		
		int x = 0;
		try{
			LOGGER.info("Calling addMovie (DAO method)");
			x = adi.addMovie(movie);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}

	public boolean deleteMovie(int id) throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("deleteMovie (Service method) is called");
		
		boolean x = false;
		try{
			LOGGER.info("Calling deleteMovie (DAO method)");
			x = adi.deleteMovie(id);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}

	public ArrayList<Movie> getMovie() throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("getMovie (Service method) is called");
		
		ArrayList<Movie> list = null;
		try{
			LOGGER.info("Calling getMovieList (DAO method)");
			list = new ArrayList(adi.getMovieList());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}

	public ArrayList<User> getUser() throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("getUser (Service method) is called");
		
		ArrayList<User> list = null;
		try{
			LOGGER.info("Calling getUserList (DAO method)");
			list = new ArrayList(adi.getUserList());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public ArrayList<ShowsData> getShowList(int id) throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("getShowList (Service method) is called");
		
		ArrayList<ShowsData> list = null;
		try{
			LOGGER.info("Calling getShowList (DAO method)");
			list = new ArrayList(adi.getShowList(id));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}

	public int addShow(Shows show) throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("addShow (Service method) is called");
		
		int x = 0;
		try{
			LOGGER.info("Calling addShow (DAO method)");
			x = adi.addShow(show);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}

	public boolean deleteShow(int id) throws Exception
	{
		LOGGER.info("Inside the AdminServiceImpl [Service]");
		LOGGER.info("deleteShow (Service method) is called");
		
		boolean x = false;
		try{
			LOGGER.info("Calling deleteShow (DAO method)");
			x = adi.deleteShow(id);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return x;
	}
}
