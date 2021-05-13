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
import model.TheaterList;
import model.User;

public class CustomerDaoImpl implements CustomerDao
{
	static final Logger LOGGER = Logger.getLogger(CustomerDaoImpl.class);
	
	public ArrayList<TheaterList> showMovieTheater(int movieID) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("showMovieTheater (DAO method) is called");
		
		ArrayList<TheaterList> list = new ArrayList<>();
		String sql = "SELECT theater.theaterID, theater.theaterName, theater.thContact, theater.thAddress, shows.date, shows.availableSeat, shows.price FROM theater, shows WHERE theater.theaterID = shows.theaterID AND shows.movieID = '"+movieID+"'";
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				TheaterList tl1 = new TheaterList();
				tl1.setTheaterID(rs.getInt(1));
				tl1.setTheaterName(rs.getString(2));
				tl1.setContact(rs.getLong(3));
				tl1.setAddress(rs.getString(4));
				tl1.setDate(rs.getString(5));
				tl1.setSeats(rs.getInt(6));
				tl1.setPrice(rs.getInt(7));
				
				list.add(tl1);
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

	public int getShow(int mid, int tid) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("getShow (DAO method) is called");
		
		int sid = 0;
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT showID FROM shows WHERE theaterID = '"+tid+"' AND movieID = '"+mid+"'");
			while(rs.next())
			{
				sid = rs.getInt(1);
			}
			
			if(sid != 0)
			{
				LOGGER.warn("Show ID fetched form database.");
			}
			else
			{
				LOGGER.warn("Show ID is not available in database.");
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
		return sid;
	}
	
	public ArrayList<String> getSeats(int showID) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("getSeats (DAO method) is called");
		
		ArrayList<String> seatList = new ArrayList<>();
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT seat FROM booking WHERE showID = '"+showID+"'");
			while(rs.next())
			{
				seatList.add(rs.getString(1));
			}
			
			if(seatList == null)
			{
				LOGGER.warn("Seat data is not available in database.");
			}
			else
			{
				LOGGER.warn("Seat list fetched from database.");
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
		return seatList;
	}
	
	public int updateShow(int sid, int seat) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("updateShow (DAO method) is called");
		
		int x = 0;
		try{
			int availableSeat = 0;
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT availableSeat FROM shows WHERE showID = '"+sid+"'");
			while(rs.next())
			{
				availableSeat = rs.getInt(1);
			}
			availableSeat -= seat;
			PreparedStatement ps = con.prepareStatement("UPDATE shows SET availableSeat=? WHERE showID=?");
			ps.setInt(1, availableSeat);
			ps.setInt(2, sid);
			x = ps.executeUpdate();
			
			if(x != 0)
			{
				LOGGER.warn("Available seat number is decremented to "+seat+" in the database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Decrementing avaliable seat to "+seat+" in the database is failed.");
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
	
	public int bookingTicket(ArrayList<Booking> list) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("bookingTicket (DAO method) is called");
		
		int temp = 0;
		try{
			Connection con = DbConnection.getCon();
			for(int i = 0; i < list.size(); i++)
			{
				Booking b1 = list.get(i);
				PreparedStatement ps = con.prepareStatement("INSERT INTO booking(userID, custName, custAge, showID, seat) VALUES(?,?,?,?,?)");
				ps.setInt(1, b1.getUserId());
				ps.setString(2, b1.getCustName());
				ps.setInt(3, b1.getCustAge());
				ps.setInt(4, b1.getShowID());
				ps.setString(5, b1.getSeat());
				
				temp += ps.executeUpdate();
			}
			
			if(temp != 0)
			{
				LOGGER.warn("Booking data is fetched from database.");
			}
			else
			{
				LOGGER.warn("Booking data is not available in database.");
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
		return temp;
	}
	
	public ArrayList<BookingDetail> bookingStatus(int userID) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("bookingStatus (DAO method) is called");
		
		ArrayList<BookingDetail> list = new ArrayList<>();
		String sql = "SELECT booking.bookingID, booking.custName, booking.custAge, movie.movieName, theater.theaterName, thAddress, shows.date, booking.seat, shows.price FROM booking, theater, movie, shows WHERE shows.showID = booking.showID AND movie.movieID = shows.movieID AND theater.theaterID = shows.theaterID AND booking.userID = '"+userID+"'";
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				BookingDetail bd = new BookingDetail();
				bd.setBookingID(rs.getInt(1));
				bd.setCustomerName(rs.getString(2));
				bd.setCustomerAge(rs.getInt(3));
				bd.setMovieName(rs.getString(4));
				bd.setTheaterName(rs.getString(5));
				bd.setTheaterAddress(rs.getString(6));
				bd.setDate(rs.getString(7));
				bd.setSeat(rs.getString(8));
				bd.setPrice(rs.getFloat(9));
				
				list.add(bd);
			}
			
			if(list == null)
			{
				LOGGER.warn("Booking data is not available in database.");
			}
			else
			{
				LOGGER.warn("Booking list fetched from database.");
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

	public User getUserData(int id) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("getUserData (DAO method) is called");
		
		User u1 = new User();
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT userName, contact, email FROM user WHERE userID = '"+id+"'");
			while(rs.next())
			{
				u1.setName(rs.getString(1));
				u1.setContact(rs.getLong(2));
				u1.setEmail(rs.getString(3));
			}
			LOGGER.warn("User data fetched from database.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		return u1;
	}
	
	public int updateProfile(User u1) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("updateProfile (DAO method) is called");
		
		int x = 0;
		try{
			Connection con = DbConnection.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE user SET userName = ?, contact = ?, email = ? WHERE userID = ?");
			ps.setString(1, u1.getName());
			ps.setLong(2, u1.getContact());
			ps.setString(3, u1.getEmail());
			ps.setInt(4, u1.getUserID());
			x = ps.executeUpdate();
			
			if(x != 0)
			{
				LOGGER.warn("User data is updated in the database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]User data is not updated in the database.");
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
	
	public boolean verifyPassword(User u1) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("verifyPassword (DAO method) is called");
		
		boolean passwordFlag = false;
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT password FROM user WHERE userID = '"+u1.getUserID()+"'");
			while(rs.next())
			{
				if(u1.getPassword().equals(rs.getString(1)))
				{
					passwordFlag = true;
				}
			}
			
			if(passwordFlag)
			{
				LOGGER.warn("Password is available in the database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Password is not available in the database.");
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
		return passwordFlag;
	}
	
	public int changePassword(User u1) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("changePassword (DAO method) is called");
		
		int x = 0;
		try{
			Connection con = DbConnection.getCon();
			PreparedStatement ps = con.prepareStatement("UPDATE user SET password = ? WHERE userID = ?");
			ps.setString(1, u1.getPassword());
			ps.setInt(2, u1.getUserID());
			x = ps.executeUpdate();
			
			if(x != 0)
			{
				LOGGER.warn("Password is changed from database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Password is not changed from database.");
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

	public boolean cancelTicket(int id) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("cancelTicket (DAO method) is called");
		
		boolean flag = false;
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			flag = st.execute("DELETE FROM booking WHERE bookingID = '"+id+"'");
			
			if(flag)
			{
				LOGGER.warn("Booking data deleted from database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Booking data is not deleted from database.");
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
		return flag;
	}
	
	public int IncrementSeatNumber(int bid) throws Exception
	{
		LOGGER.info("Inside the CustomerDaoImpl [DAO]");
		LOGGER.info("IncrementSeatNumber (DAO method) is called");
		
		int x = 0;
		try{
			int availableSeat = 0;
			int sid = 0;
			
			Connection con = DbConnection.getCon();
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT showID FROM booking WHERE bookingID = '"+bid+"'");
			while(rs.next())
			{
				sid = rs.getInt(1);
			}
			
			System.out.println("bid = "+bid);
			System.out.println("sid = "+sid);
			
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery("SELECT availableSeat FROM shows WHERE showID = '"+sid+"'");
			while(rs1.next())
			{
				availableSeat = rs1.getInt(1);
			}
			
			availableSeat += 1;
			
			PreparedStatement ps = con.prepareStatement("UPDATE shows SET availableSeat=? WHERE showID=?");
			ps.setInt(1, availableSeat);
			ps.setInt(2, sid);
			x = ps.executeUpdate();
			
			if(x != 0)
			{
				LOGGER.warn("Available seat number is incremented by 1 in the database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]Incrementing avaliable seat by 1 in the database is failed.");
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
}
