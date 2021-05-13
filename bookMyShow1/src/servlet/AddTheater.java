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

@WebServlet("/addTheater")
public class AddTheater extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(AddTheater.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the AddTheater Page");
		
		AdminServiceImpl asi = new AdminServiceImpl();		//creating AdminServiceImpl object
		Theater t1 = new Theater();							//creating Theater object (POJO)
		PrintWriter out = response.getWriter();
		
		//retrieve data that was coming from addTheater.jsp
		String theaterName = request.getParameter("theaterName");
		long contact = Long.parseLong(request.getParameter("theaterContact"));
		String address = request.getParameter("address");
		
		//setting all the retrieved values into the Theater object
		t1.setTheaterName(theaterName);
		try {
			t1.setTheaterContact(contact);
		} catch (InvalidMobileNumberException e1) {
			out.print(e1.getMessage());
		}
		t1.setTheaterAddress(address);
		
		int x = 0;
		try {
			// calling addTheater method of AdminServiceImpl class (from service package) and passing Theater object as an argument and storing value that will returned by the addTheater method.
			x = asi.addTheater(t1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(x != 0)
		{
			//printing success message
			LOGGER.warn("Theater added successfully.");
			out.print("Theater added successfully.");
		}
		else
		{
			//printing failure message
			LOGGER.warn("Adding theater operation failed.");
			out.print("Something went worng.");
		}
	}
}
