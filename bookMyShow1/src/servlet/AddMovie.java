package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.Movie;
import service.AdminServiceImpl;

@WebServlet("/addMovie")
public class AddMovie extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(AddMovie.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the AddMovie Page");
		
		AdminServiceImpl asi = new AdminServiceImpl();		//creating AdminServiceImpl object
		Movie m1 = new Movie();								//creating Movie object (POJO)
		
		//retrieve entered movie name that was coming from addMovie.jsp
		String movieName = request.getParameter("movieName");
		
		//storing movie name in the Movie object
		m1.setMovieName(movieName);
		
		int x = 0;
		try {
			
			// calling addMovie method of AdminServiceImpl class (from service package) and passing Movie object as an argument and storing value that will returned by the addMovie method.
			x = asi.addMovie(m1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		if(x != 0)
		{
			//printing success message
			LOGGER.warn("Movie added successfully.");
			out.print("Movie added successfully.");
		}
		else
		{
			//printing failure message
			LOGGER.warn("Adding movie operation failed.");
			out.print("Something went worng.");
		}
	}

}
