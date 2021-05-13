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

@WebServlet("/deleteTheater")
public class DeleteTheater extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(DeleteTheater.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the DeleteTheater Page");
		
		//retrieve theater id that was coming from adminTheater.jsp
		int tid = Integer.parseInt(request.getParameter("tid"));
		
		AdminServiceImpl asi = new AdminServiceImpl();		//creating AdminServiceImpl object
		PrintWriter out = response.getWriter();
		
		boolean flag = false;
		try {
			
			// calling deleteTheater method of AdminServiceImpl class (from service package) and passing theater ID as an argument and storing boolean value that will returned by the deleteTheater method.
			flag = asi.deleteTheater(tid);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(!flag)
		{
			//printing success message
			LOGGER.warn("Theater deleted successfully.");
			response.sendRedirect("adminTheater");
		}
		else
		{
			//printing failure message
			LOGGER.warn("Theater delete operation failed.");
			out.print("Something went wrong...");
		}
	}
}
