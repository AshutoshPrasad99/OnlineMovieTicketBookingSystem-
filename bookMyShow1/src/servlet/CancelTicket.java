package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import service.CustomerServiceImpl;

@WebServlet("/cancelTicket")
public class CancelTicket extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(CancelTicket.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the CancelTicket");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		CustomerServiceImpl csi = new CustomerServiceImpl();
		boolean flag = false;
		try {
			csi.IncrementSeatNumber(bid);
			flag = csi.cancelTicket(bid);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		if(!flag)
		{
			LOGGER.info("Ticket Cancelled.");
			LOGGER.info("Redirecting to cancelTicket page.");
			request.setAttribute("flag", flag);
			RequestDispatcher rd = request.getRequestDispatcher("cancelTicket.jsp");
			rd.forward(request, response);
		}
		else
		{
			LOGGER.info("Ticket Cancelation operation failed.");
			out.print("Something went wrong!!!");
		}
	}
}
