package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(Logout.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the Logout");
		
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");	//http 1.1
		response.setHeader("pragma","no-cache");	//http 1.0
		response.setHeader("Expires","0");		//proxies
		LOGGER.info("Cache data released.");

		HttpSession session = request.getSession();
		session.setAttribute("uID", null);
		LOGGER.info("Session data released.");
		response.sendRedirect("login.jsp");
	}
}
