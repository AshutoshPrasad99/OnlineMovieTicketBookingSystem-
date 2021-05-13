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
import model.User;
import service.AdminServiceImpl;

@WebServlet("/adminUser")
public class AdminUser extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(AdminUser.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the AdminUser");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			AdminServiceImpl asi = new AdminServiceImpl();
			ArrayList<User> user = null;
			try{
				user = new ArrayList<User>(asi.getUser());
			}
			catch(Exception e)
			{
				e.getMessage();
			}

			LOGGER.warn("Users are retrieved successfully");
			LOGGER.info("Redirect to adminUser page");
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("adminUser.jsp");
			rd.forward(request, response);
		}
	}

}
