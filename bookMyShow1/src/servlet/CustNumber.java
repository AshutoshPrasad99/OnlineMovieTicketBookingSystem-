package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import exception.InvalidSeatNumberException;

@WebServlet("/custNumber")
public class CustNumber extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(CustNumber.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the CustNumber");
		
		PrintWriter out = response.getWriter();
		String[] seats = request.getParameterValues("seatArr[]");
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		if(seats.length == 0)
		{
			try {
				throw new InvalidSeatNumberException();
			} catch (InvalidSeatNumberException e) {
				LOGGER.warn("Number of seats is zero.");
				out.print(e.getMessage());
			}
		}
		else
		{
			HttpSession seatData = request.getSession();
			seatData.setAttribute("seat", seats);
			seatData.setAttribute("sid", sid);
			
			JSONObject jobj = new JSONObject();
			String urlToRedirect = "bookingTicket.jsp";
			jobj.put("url",urlToRedirect);
			response.getWriter().write(jobj.toString());
		}
	}
}