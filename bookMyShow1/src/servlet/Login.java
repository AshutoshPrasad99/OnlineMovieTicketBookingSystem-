package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import exception.InvalidPasswordSizeException;
import model.User;
import service.UserServiceImpl;

@WebServlet("/login")
public class Login extends HttpServlet
{
	static final Logger LOGGER = Logger.getLogger(Login.class);	//logger object
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the Login Page");
		
		UserServiceImpl usi1 = new UserServiceImpl();
		User u1 = new User();
		PrintWriter out = response.getWriter();
		
		//retrieving username and password that was sent by the login.jsp
		String name = request.getParameter("username");
		String password = request.getParameter("pass");
		
		//storing user data into the u1 object of type User
		u1.setName(name);
		try {
			u1.setPassword(password);
		} catch (InvalidPasswordSizeException e1) {
			LOGGER.warn("Password length is less than 8 characters.");
			out.print(e1.getMessage());
		}
		
		/*creating an array named as flag with default value 0
		flag[0] = 0 means user data is not present in the database & flag[0] = 1 means user data is present in the database
		flag[1][x] where x represents user ID */
		int[] flag = {0,0};
		try {
			flag = usi1.login(u1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(flag[0]==1)		//represents 
		{
			//storing user ID and user name in the HttpSession object named as session
			HttpSession session = request.getSession();
			session.setAttribute("uID", flag[1]);
			session.setAttribute("uname", name);
			if(flag[1] == 29)
			{
				LOGGER.warn("Admin Login Successfully");
				response.sendRedirect("adminHome.jsp");
			}
			else
			{
				LOGGER.warn("User Login Successfully");
				response.sendRedirect("home.jsp");
			}
		}
		else
		{
			LOGGER.error("Login Failed");
			response.sendRedirect("login.jsp");
		}
	}

}
