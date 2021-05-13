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

import model.ShowsData;
import service.AdminServiceImpl;

@WebServlet("/adminShow")
public class AdminShow extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(AdminShow.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the AdminShow");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			//retrieves data that was coming from the adminShow.jsp
			int seat = Integer.parseInt(request.getParameter("seat"));
			String theater = request.getParameter("theater");
			int id = Integer.parseInt(request.getParameter("id"));
			
			AdminServiceImpl asi = new AdminServiceImpl();		//creating AdminServiceImpl object
			ArrayList<ShowsData> showData = null;				//creating an empty arraylist of show type
			try{
				
				//storing all the show objects that comes after calling the getShow method of AdminServiceImpl.java
				showData = new ArrayList<ShowsData>(asi.getShowList(id));
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
			if(showData.size() == 0)
			{
				LOGGER.warn("No show is available");
				LOGGER.info("Redirect to selectMovie page");
				request.setAttribute("theaterID", id);
				request.setAttribute("seat", seat);
				RequestDispatcher rd = request.getRequestDispatcher("selectMovie.jsp");		//redirect to selectMovie.jsp with the theater and seat
				rd.forward(request, response);
			}
			
			LOGGER.warn("Shows are retrieved successfully");
			LOGGER.info("Redirect to adminShow page");
			request.setAttribute("showsData", showData);
			request.setAttribute("theater", theater);
			request.setAttribute("seat", seat);
			RequestDispatcher rd = request.getRequestDispatcher("adminShow.jsp");		//redirect to adminShow.jsp with the arraylist, theater and seat
			rd.forward(request, response);
		}
	}
}
