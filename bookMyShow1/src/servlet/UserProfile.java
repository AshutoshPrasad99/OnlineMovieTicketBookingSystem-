package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.User;
import service.CustomerServiceImpl;

@WebServlet("/userProfile")
public class UserProfile extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(UserProfile.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the UserProfile");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("uID")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			int id = (int)session.getAttribute("uID");
			CustomerServiceImpl csi = new CustomerServiceImpl();
			User userData = null;
			try{
				userData = csi.getUserData(id);
			}
			catch(Exception e)
			{
				e.getMessage();
			}

			LOGGER.warn("User data are retrieved successfully");
			LOGGER.info("Redirect to userProfile page");
			request.setAttribute("userData", userData);
			RequestDispatcher rd = request.getRequestDispatcher("userProfile.jsp");
			rd.forward(request, response);
		}
	}
}
