package jUnitTestCase;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import exception.InvalidMobileNumberException;
import model.Movie;
import model.Shows;
import model.ShowsData;
import model.Theater;
import model.User;
import service.AdminServiceImpl;

public class AdminServiceTest {
	
	AdminServiceImpl asi = null;
	
	@Before
	public void init()
	{
		asi = new AdminServiceImpl();
	}
	
	@After
	public void deInit()
	{
		asi = null;
	}

	@Test
	public void addTheaterTest() throws Exception
	{
		Theater t1 = new Theater();
		t1.setTheaterName("theater A");
		try {
			t1.setTheaterContact(6589741230l);
		} catch (InvalidMobileNumberException e1) {
			e1.printStackTrace();
		}
		t1.setTheaterAddress("theater-A-address");
		t1.setTotalSeat(60);
		assertEquals("theater is not added",1,asi.addTheater(t1));
	}
	
	@Test
	public void updateTheaterTest() throws Exception
	{
		Theater t1 = new Theater();
		t1.setTheaterID(0);
		t1.setTheaterName("theater A");
		try {
			t1.setTheaterContact(7894561235l);;
		} catch (InvalidMobileNumberException e1) {
			e1.printStackTrace();
		}
		t1.setTheaterAddress("theater-A-address");
		t1.setTotalSeat(60);
		assertEquals("theater is not updated",0,asi.updateTheater(t1));
	}
	
	@Test
	public void deleteTheaterTest() throws Exception
	{
		assertEquals("theater is not deleted",false,asi.deleteTheater(0));
	}
	
	@Test
	public void getTheaterTest() throws Exception {
		
		ArrayList<Theater> list = new ArrayList<>(asi.getTheater());
		assertEquals("Theater List not found...","THEATER 2",list.get(0).getTheaterName());
	}
	
	@Test
	public void addMovieTest() throws Exception
	{
		Movie m1 = new Movie();
		m1.setMovieName("movieTest-1");
		
		assertEquals("movie is not added",1,asi.addMovie(m1));
	}
	
	@Test
	public void deleteMovieTest() throws Exception
	{
		assertEquals("movie is not deleted",false,asi.deleteMovie(0));
	}
	
	@Test
	public void getMovieTest() throws Exception
	{
		ArrayList<Movie> list = new ArrayList<>(asi.getMovie());
		assertEquals("Theater List not found...","The Croods",list.get(0).getMovieName());
	}
	
	@Test
	public void getUserTest() throws Exception {
		
		ArrayList<User> list = new ArrayList<>(asi.getUser());
		assertEquals(" User List not found...","rohan",list.get(0).getName());
	}
	
	@Test
	public void getShowTest() throws Exception {
		
		ArrayList<ShowsData> list = new ArrayList<>(asi.getShowList(4));
		assertEquals("Show List not found...",44,list.get(0).getShowID());
	}
	
	@Test
	public void addShowTest() throws Exception
	{
		Shows s1 = new Shows();
		
		s1.setMovieID(1);
		s1.setTheaterID(15);
		s1.setDate("1111-11-11T11:11");
		s1.setAvailableSeat(40);
		s1.setPrice(200f);
		
		assertEquals("show is not added",1,asi.addShow(s1));
	}
	
	@Test
	public void deleteShowTest() throws Exception
	{
		assertEquals("show is not deleted",false,asi.deleteShow(0));
	}
}
