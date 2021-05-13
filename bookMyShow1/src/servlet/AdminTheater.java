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

import model.Theater;
import service.AdminServiceImpl;

@WebServlet("/adminTheater")
public class AdminTheater extends HttpServlet
{
	static final Logger LOGGER = Logger.getLogger(AdminTheater.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the AdminTheater");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			AdminServiceImpl asi = new AdminServiceImpl();
			ArrayList<Theater> theater = null;
			try{
				theater = new ArrayList<Theater>(asi.getTheater());
			}
			catch(Exception e)
			{
				e.getMessage();
			}

			LOGGER.warn("Theaters are retrieved successfully");
			LOGGER.info("Redirect to adminTheater page");
			request.setAttribute("theater", theater);
			RequestDispatcher rd = request.getRequestDispatcher("adminTheater.jsp");
			rd.forward(request, response);
		}
	}
}
