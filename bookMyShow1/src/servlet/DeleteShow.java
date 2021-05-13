package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import service.AdminServiceImpl;

@WebServlet("/deleteShow")
public class DeleteShow extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(DeleteShow.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LOGGER.info("Inside the DeleteShow Page");
		
		//retrieve show id that was coming from adminShow.jsp
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		AdminServiceImpl asi = new AdminServiceImpl();		//creating AdminServiceImpl object
		PrintWriter out = response.getWriter();
		
		boolean flag = false;
		try {
			
			// calling deleteShow method of AdminServiceImpl class (from service package) and passing show ID as an argument and storing boolean value that will returned by the deleteShow method.
			flag = asi.deleteShow(sid);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(!flag)
		{
			//printing success message
			LOGGER.warn("Show deleted successfully.");
			out.print("Show deleted successfully...");
		}
		else
		{
			//printing failure message
			LOGGER.warn("Show delete operation failed.");
			out.print("Something went wrong...");
		}
	}
}
