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
import exception.InvalidPasswordSizeException;
import model.User;
import service.UserServiceImpl;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(Signup.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the Signup");
		
		UserServiceImpl usi1 = new UserServiceImpl();
		User u1 = new User();
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		long contact = Long.parseLong(request.getParameter("contact"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		u1.setName(name);
		try {
			u1.setContact(contact);
		} catch (InvalidMobileNumberException e1) {
			LOGGER.warn("Invalid contact number.");
			out.print(e1.getMessage());
		}
		u1.setEmail(email);
		try {
			u1.setPassword(password);
		} catch (InvalidPasswordSizeException e1) {
			LOGGER.warn("Password length is less than 8 characters.");
			out.print(e1.getMessage());
		}
		
		int x = 0;
		try {
			x = usi1.signup(u1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(x>0)
		{
			LOGGER.info("Sign Up successful.");
			LOGGER.info("Redirecting to login page.");
			response.sendRedirect( "login.jsp" );
		}
	}

}
