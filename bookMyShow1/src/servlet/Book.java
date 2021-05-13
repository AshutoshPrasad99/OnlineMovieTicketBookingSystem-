package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.Booking;
import service.CustomerServiceImpl;

@WebServlet("/book")
public class Book extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(Book.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the Book");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			ArrayList<Booking> list = new ArrayList<>();
			CustomerServiceImpl csi = new CustomerServiceImpl();
			HttpSession seatData = request.getSession();
			String[] seats = (String[])seatData.getAttribute("seat");
			int sid = (int)seatData.getAttribute("sid");
			int uid = (int)session.getAttribute("uID");
			
			for(int i = 1; i<=seats.length; i++)
			{
				Booking b1 = new Booking();
				b1.setUserId(uid);
				b1.setCustName(request.getParameter("name"+i));
				b1.setCustAge(Integer.parseInt(request.getParameter("age"+i)));
				b1.setShowID(sid);
				b1.setSeat(seats[i-1]);
				
				list.add(b1);
			}
			
			int temp = 0;
			int x = 0;
			try {
				temp = csi.bookingTicket(list);
				x = csi.updateShow(sid, seats.length);
				if(x != 0)
				{
					LOGGER.info("Available seat updated.");
				}
				else
				{
					LOGGER.info("Available seat update operation failed.");
				}
				
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			if(temp == seats.length)
			{
				LOGGER.info("Booking successful.");
				LOGGER.info("Redirecting to bookinkMsg page");
				response.sendRedirect("bookingMsg.jsp");
			}
			else
			{
				LOGGER.warn("Something went worng!!!");
				out.print("Something went worng!!!");
			}
		}
	}
}
