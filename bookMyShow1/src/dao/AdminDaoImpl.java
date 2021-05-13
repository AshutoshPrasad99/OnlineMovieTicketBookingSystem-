package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import dbUtility.DbConnection;
import model.Booking;
import model.BookingDetail;
import model.Movie;
import model.Shows;
import model.ShowsData;
import model.Theater;
import model.User;
import servlet.AdminUser;

public class AdminDaoImpl implements AdminDao
{
	static final Logger LOGGER = Logger.getLogger(AdminDaoImpl.class);
	
	public int addTheater(Theater t1) throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("addTheater (DAO method) is called");
		
		int x = 0;
		try{
			Connection con = DbConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO theater(theaterName, thContact, thAddress) VALUES(?,?,?)");
			ps.setString(1, t1.getTheaterName());
			ps.setLong(2, t1.getTheaterContact());
			ps.setString(3, t1.getTheaterAddress());
			x = ps.executeUpdate();

			if(x != 0)
			{
				LOGGER.warn("Theater data is inserted to database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Theater data is not inserted to database.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		
		return x;
	}
	public int updateTheater(Theater t1) throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("updateTheater (DAO method) is called");
		
		int x = 0;
		try{
			Connection con = DbConnection.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE theater SET theaterName = ?, thContact = ?, thAddress = ? WHERE theaterID = ?");
			ps.setString(1, t1.getTheaterName());
			ps.setLong(2, t1.getTheaterContact());
			ps.setString(3, t1.getTheaterAddress());
			ps.setInt(4, t1.getTheaterID());
			x = ps.executeUpdate();

			if(x != 0)
			{
				LOGGER.warn("Theater data is updated in the database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Theater data is not updated in the database.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		
		return x;
	}
	public boolean deleteTheater(int id) throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("deleteTheater (DAO method) is called");
		boolean x = false;
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			x = st.execute("DELETE FROM theater WHERE theaterID = '"+id+"'");

			if(x)
			{
				LOGGER.warn("Theater data deleted from database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Theater data is not deleted from database.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		
		return x;
	}
	
	public ArrayList<Theater> getTheaterList() throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("getTheaterList (DAO method) is called");
		
		ArrayList<Theater> list = new ArrayList<>();
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM theater");
			while(rs.next())
			{
				Theater th1 = new Theater();
				th1.setTheaterID(rs.getInt(1));
				th1.setTheaterName(rs.getString(2));
				th1.setTheaterContact(rs.getLong(3));
				th1.setTheaterAddress(rs.getString(4));
				
				list.add(th1);
			}

			if(list == null)
			{
				LOGGER.warn("Theater data is not available in database.");
			}
			else
			{
				LOGGER.warn("Theater list fetched from database.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		
		return list;
	}
	
	public int addMovie(Movie m1) throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("addMovie (DAO method) is called");
		
		int x = 0;
		try{
			Connection con = DbConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO movie(movieName) VALUES(?)");
			ps.setString(1, m1.getMovieName());
			x = ps.executeUpdate();

			if(x != 0)
			{
				LOGGER.warn("Movie data inserted to database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Movie data is not inserted to database.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		
		return x;
	}
	
	public boolean deleteMovie(int id) throws Exception
	{
		
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("deleteMoviea (DAO method) is called");
		
		boolean x = false;
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			x = st.execute("DELETE FROM movie WHERE movieID = '"+id+"'");
			
			if(x)
			{
				LOGGER.warn("Movie data deleted from database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Movie data is not deleted from database.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		
		return x;
	}
	
	public ArrayList<Movie> getMovieList() throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("getMovieList (DAO method) is called");
		
		ArrayList<Movie> list = new ArrayList<>();
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM movie");
			while(rs.next())
			{
				Movie m1 = new Movie();
				m1.setMovieID(rs.getInt(1));
				m1.setMovieName(rs.getString(2));
				list.add(m1);
			}

			if(list == null)
			{
				LOGGER.warn("Movie data is not available in database.");
			}
			else
			{
				LOGGER.warn("Movie list fetched from database.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		
		return list;
	}
	
	public ArrayList<User> getUserList() throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("getUserList (DAO method) is called");
		
		boolean n = false;
		ArrayList<User> list = new ArrayList<>();
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT userID, UserName, contact, email FROM user");
			while(rs.next())
			{
				if(n)
				{
					User u1 = new User();
					u1.setUserID(rs.getInt(1));
					u1.setName(rs.getString(2));
					u1.setContact(rs.getLong(3));
					u1.setEmail(rs.getString(4));
					
					list.add(u1);
				}
				n = true;
			}

			if(list == null)
			{
				LOGGER.warn("User data is not available in database.");
			}
			else
			{
				LOGGER.warn("User list fetched from database.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		
		return list;
	}
	
	public int addShow(Shows s1) throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("addShow (DAO method) is called");
		
		int x = 0;
		try{
			Connection con = DbConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO shows(MovieID, theaterID, date, availableSeat, price) VALUES(?,?,?,?,?)");
			ps.setInt(1, s1.getMovieID());
			ps.setInt(2, s1.getTheaterID());
			ps.setString(3, s1.getDate());
			ps.setInt(4, s1.getAvailableSeat());
			ps.setFloat(5, s1.getPrice());
			x = ps.executeUpdate();
			
			if(x != 0)
			{
				LOGGER.warn("Show data inserted to database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Show data is not inserted to database.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		return x;
	}
	
	public boolean deleteShow(int id) throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("deleteShow (DAO method) is called");
		
		boolean x = false;
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			x = st.execute("DELETE FROM Shows WHERE showID = '"+id+"'");

			if(x)
			{
				LOGGER.warn("Show data deleted from database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Show data is not deleted from database.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		return x;
	}
	
	public ArrayList<ShowsData> getShowList(int id) throws Exception
	{
		LOGGER.info("Inside the AdminDaoImpl [DAO]");
		LOGGER.info("getShowList (DAO method) is called");
		
		ArrayList<ShowsData> list = new ArrayList<>();
		String sql = "SELECT shows.showID, shows.theaterID, movie.movieName, shows.date, shows.availableSeat, shows.price FROM shows, movie WHERE movie.movieID = shows.movieID AND shows.theaterID = '"+id+"'";
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				ShowsData s1 = new ShowsData();
				s1.setShowID(rs.getInt(1));
				s1.setTheaterID(rs.getInt(2));
				s1.setMovieName(rs.getString(3));
				s1.setDate(rs.getString(4));
				s1.setAvailableSeat(rs.getInt(5));
				s1.setPrice(rs.getInt(6));
				
				list.add(s1);
			}

			if(list == null)
			{
				LOGGER.warn("Show data is not available in database.");
			}
			else
			{
				LOGGER.warn("Show list fetched from database.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		return list;
	}
}
