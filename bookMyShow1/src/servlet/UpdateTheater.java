package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import exception.InvalidMobileNumberException;
import model.Theater;
import service.AdminServiceImpl;

@WebServlet("/updateTheater")
public class UpdateTheater extends HttpServlet
{
	static final Logger LOGGER = Logger.getLogger(UpdateTheater.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the UpdateProfile");
		
		AdminServiceImpl asi = new AdminServiceImpl();
		Theater t1 = new Theater();
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("theaterID"));
		String theaterName = request.getParameter("theaterName");
		long contact = Long.parseLong(request.getParameter("theaterContact"));
		String address = request.getParameter("address");
		
		t1.setTheaterID(id);
		t1.setTheaterName(theaterName);
		try {
			t1.setTheaterContact(contact);
		} catch (InvalidMobileNumberException e1) {
			LOGGER.warn("Invalid contact number.");
			out.print(e1.getMessage());
		}
		t1.setTheaterAddress(address);
		
		int x = 0;
		try {
			x = asi.updateTheater(t1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(x != 0)
		{
			LOGGER.info("Theater updated successfully.");
			out.print("Theater updated successfully.");
		}
		else
		{
			LOGGER.info("Theater update operation failed.");
			out.print("Something went wrong.");
		}
	}
}
