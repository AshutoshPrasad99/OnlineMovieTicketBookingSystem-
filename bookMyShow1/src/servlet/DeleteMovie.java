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

@WebServlet("/deleteMovie")
public class DeleteMovie extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(DeleteMovie.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the DeleteMovie Page");
		
		//retrieve movie id that was coming from adminMovie.jsp
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		AdminServiceImpl asi = new AdminServiceImpl();		//creating AdminServiceImpl object
		PrintWriter out = response.getWriter();
		
		boolean flag = false;
		try {
			
			// calling deleteMovie method of AdminServiceImpl class (from service package) and passing Movie ID as an argument and storing boolean value that will returned by the deleteMovie method.
			flag = asi.deleteMovie(mid);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(!flag)
		{
			//printing success message
			LOGGER.warn("Movie deleted successfully.");
			response.sendRedirect("adminMovie");
		}
		else
		{
			//printing failure message
			LOGGER.warn("Movie delete operation failed.");
			out.print("Something went wrong...");
		}
	}
}
