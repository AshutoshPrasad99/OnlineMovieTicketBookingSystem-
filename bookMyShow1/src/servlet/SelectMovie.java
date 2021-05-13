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

@WebServlet("/selectMovie")
public class SelectMovie extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(SelectMovie.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the SelectMovie");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			int seat = Integer.parseInt(request.getParameter("seat"));
			int theaterID = Integer.parseInt(request.getParameter("theaterID"));
			AdminServiceImpl asi = new AdminServiceImpl();
			ArrayList<Movie> movie = null;
			try{
				movie = new ArrayList<Movie>(asi.getMovie());
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
			LOGGER.warn("Movies are retrieved successfully");
			LOGGER.info("Redirect to addShow page");
			request.setAttribute("theaterID", theaterID);
			request.setAttribute("selectMovie", movie);
			request.setAttribute("seat", seat);
			RequestDispatcher rd = request.getRequestDispatcher("addShow.jsp");
			rd.forward(request, response);
		}

	}
}
