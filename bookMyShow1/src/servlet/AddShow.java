package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.Shows;
import service.AdminServiceImpl;

@WebServlet("/addShow")
public class AddShow extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(AddShow.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the AddShow Page");
		
		//retrieve data that was coming from addShow.jsp
		int movieID = Integer.parseInt(request.getParameter("movieID"));
		int theaterID = Integer.parseInt(request.getParameter("theaterID"));
		String date = request.getParameter("date");
		int seats = Integer.parseInt(request.getParameter("seat"));
		float price = Float.parseFloat(request.getParameter("price"));
		
		AdminServiceImpl asi = new AdminServiceImpl();		//creating AdminServiceImpl object
		Shows s1 = new Shows();								//creating Shows object (POJO)
		
		//setting all the retrieved values into the Shows object
		s1.setMovieID(movieID);
		s1.setTheaterID(theaterID);
		s1.setDate(date);
		s1.setAvailableSeat(seats);
		s1.setPrice(price);
		
		int x = 0;
		try {
			
			// calling addShow method of AdminServiceImpl class (from service package) and passing Shows object as an argument and storing value that will returned by the addShow method.
			x = asi.addShow(s1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		if(x != 0)
		{	
			//printing success message
			LOGGER.warn("Show added successfully.");
			out.print("Show added successfully.");
		}
		else
		{
			//printing failure message
			LOGGER.warn("Adding show operation failed.");
			out.print("Something went worng.");
		}
	}
}
