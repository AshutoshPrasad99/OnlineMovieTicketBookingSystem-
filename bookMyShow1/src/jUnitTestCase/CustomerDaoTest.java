package jUnitTestCase;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import dao.CustomerDaoImpl;
import model.Booking;
import model.BookingDetail;
import model.TheaterList;
import model.User;

public class CustomerDaoTest {

CustomerDaoImpl cdi = null;
	
	@Before
	public void init()
	{
		cdi = new CustomerDaoImpl();
	}
	
	@After
	public void deInit()
	{
		cdi = null;
	}

	@Test
	public void showMovieTheaterTest() throws Exception
	{
		ArrayList<TheaterList> list = new ArrayList<>(cdi.showMovieTheater(1));
		assertEquals("Theater List not found...",4,list.get(0).getTheaterID());
	}
	
	@Test
	public void getShowTest() throws Exception
	{
		assertEquals("Show ID List not found...",44,cdi.getShow(1,4));
	}
	
	@Test
	public void getSeatsTest() throws Exception
	{
		ArrayList<String> seat = new ArrayList<>(cdi.getSeats(52));
		assertEquals("Show List not found...","3D",seat.get(0));
	}
	
	@Test
	public void updateShowTest() throws Exception
	{
		assertEquals("Show ID not updated.",1,cdi.updateShow(68, 1));
	}
	
	@Test
	public void bookingTicketTest() throws Exception
	{
		Booking b1 = new Booking();
		b1.setUserId(29);
		b1.setCustName("testUser-1");
		b1.setCustAge(25);
		b1.setShowID(50);
		b1.setSeat("5D");
		
		ArrayList<Booking> list = new ArrayList<>();
		list.add(b1);
		
		assertEquals("Booking failed...",1,cdi.bookingTicket(list));
	}
	
	@Test
	public void bookingStatusTest() throws Exception
	{
		ArrayList<BookingDetail> list = new ArrayList<>(cdi.bookingStatus(31));
		assertEquals("Booking Data not found...",73,list.get(0).getBookingID());
	}
	
	@Test
	public void getUserDataTest() throws Exception
	{
		User u1 = cdi.getUserData(31);
		assertEquals("User Data not found...","rohan",u1.getName());
	}
	
	@Test
	public void updateProfileTest() throws Exception
	{
		User u1 = new User();
		u1.setUserID(0);
		u1.setName("Rohan");
		u1.setContact(5555555555l);
		u1.setEmail("rohan@abc.com");
		
		assertEquals("Update failed...",0,cdi.updateProfile(u1));
	}
	
	@Test
	public void verifyPasswordTest() throws Exception
	{
		User u1 = new User();
		u1.setUserID(31);
		u1.setPassword("rohan111");
		
		assertEquals("Incorrect password...",true,cdi.verifyPassword(u1));
	}
	
	@Test
	public void changePasswordTest() throws Exception
	{
		User u1 = new User();
		u1.setUserID(31);
		u1.setPassword("rohan111");
		
		assertEquals("Password update operation failed...",1,cdi.changePassword(u1));
	}
	
	@Test
	public void cancelTicketTest() throws Exception
	{
		assertEquals("Cancel ticket operation failed...",false,cdi.cancelTicket(0));
	}
}
