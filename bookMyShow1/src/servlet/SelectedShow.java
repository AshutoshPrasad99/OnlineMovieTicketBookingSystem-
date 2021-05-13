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

//import org.json.simple.*;

import service.CustomerServiceImpl;

@WebServlet("/selectedShow")
public class SelectedShow extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(SelectedShow.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the SelectedShow");
		
		int mid = Integer.parseInt(request.getParameter("mid"));
		int tid = Integer.parseInt(request.getParameter("tid"));
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			int sid = 0;
			ArrayList<String> seats = null;
			CustomerServiceImpl csi = new CustomerServiceImpl();
			
			try{
				sid = csi.getShow(mid, tid);
				seats = csi.getSeats(sid);
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
			LOGGER.warn("Seats are retrieved successfully");
			LOGGER.info("Redirect to userSeat page");
			request.setAttribute("sid", sid);
			request.setAttribute("seats", seats);
			RequestDispatcher rd = request.getRequestDispatcher("userSeat.jsp");
			rd.forward(request, response);
		}
	}
}
