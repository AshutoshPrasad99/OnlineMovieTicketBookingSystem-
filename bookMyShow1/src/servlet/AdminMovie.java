package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.Movie;
import service.AdminServiceImpl;

@WebServlet("/adminMovie")
public class AdminMovie extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(AdminMovie.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the AdminMovie Page");
		
		//retrieve person and uID data from the session
		HttpSession session1 = request.getSession();
		String person = (String) session1.getAttribute("person");
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			
			AdminServiceImpl asi = new AdminServiceImpl();		//creating AdminServiceImpl object
			ArrayList<Movie> movie = null;						//creating an empty arraylist of movie type
			try{
				
				//storing all the movie objects that comes after calling the getMovie method of AdminServiceImpl.java
				movie = new ArrayList<Movie>(asi.getMovie());
			}
			catch(Exception e)
			{
				e.getMessage();
			}

			
			
			switch(person)
			{
			case "admin":
				if(movie != null )
				{
					LOGGER.info("Movie List retrieved and sent to Admin page.");
					request.setAttribute("movie", movie);
					RequestDispatcher rd = request.getRequestDispatcher("adminMovie.jsp");		//redirect to adminMovie.jsp with the arraylist
					rd.forward(request, response);
				}
				else
				{
					LOGGER.warn("Movie list is null.");
				}
				break;
			case "user":
				if(movie != null )
				{
					LOGGER.info("Movie List retrieved and sent to User page.");
					request.setAttribute("movie", movie);
					RequestDispatcher rd1 = request.getRequestDispatcher("userMovie.jsp");		//redirect to userMovie.jsp with the arraylist
					rd1.forward(request, response);
				}
				else
				{
					LOGGER.warn("Movie list is null.");
				}
			}
		}
	}	
}
