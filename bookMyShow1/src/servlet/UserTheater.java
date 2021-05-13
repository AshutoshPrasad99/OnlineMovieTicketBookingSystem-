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

import model.TheaterList;
import service.CustomerServiceImpl;

@WebServlet("/userTheater")
public class UserTheater extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(UserTheater.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the UserTheater");
		
		int mid = Integer.parseInt(request.getParameter("mid"));
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			CustomerServiceImpl csi = new CustomerServiceImpl();
			ArrayList<TheaterList> theater = null;
			try{
				theater = new ArrayList<TheaterList>(csi.showMovieTheater(mid));
			}
			catch(Exception e)
			{
				e.getMessage();
			}

			LOGGER.warn("Theater data are retrieved successfully");
			LOGGER.info("Redirect to userTheater page");
			request.setAttribute("theater", theater);
			request.setAttribute("mid", mid);
			RequestDispatcher rd = request.getRequestDispatcher("userTheater.jsp");
			rd.forward(request, response);
		}
	}
}
