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

import model.BookingDetail;
import service.CustomerServiceImpl;

@WebServlet("/userBookingStatus")
public class UserBookingStatus extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(UserBookingStatus.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the UserBookingStatus");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			int id = (int)session.getAttribute("uID");
			CustomerServiceImpl csi = new CustomerServiceImpl();
			ArrayList<BookingDetail> bookingStatusData = null;
			try{
				bookingStatusData = new ArrayList<BookingDetail>(csi.bookingStatus(id));
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
			LOGGER.warn("Booking details are retrieved successfully");
			LOGGER.info("Redirect to userBookingStatus page");
			request.setAttribute("bookingStatusData", bookingStatusData);
			RequestDispatcher rd = request.getRequestDispatcher("userBookingStatus.jsp");
			rd.forward(request, response);
		}
	}
}
