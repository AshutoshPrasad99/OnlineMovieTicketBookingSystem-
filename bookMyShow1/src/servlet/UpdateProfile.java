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

import exception.InvalidMobileNumberException;
import model.Theater;
import model.User;
import service.AdminServiceImpl;
import service.CustomerServiceImpl;

@WebServlet("/updateProfile")
public class UpdateProfile extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(UpdateProfile.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the UpdateProfile");
		
		CustomerServiceImpl csi = new CustomerServiceImpl();
		User u1 = new User();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		int id = (int)session.getAttribute("uID");
		String name1 = request.getParameter("name");
		long contact = Long.parseLong(request.getParameter("contact"));
		String email = request.getParameter("email");
		
		u1.setUserID(id);
		u1.setName(name1);
		try {
			u1.setContact(contact);
		} catch (InvalidMobileNumberException e1) {
			LOGGER.info("Invalid contact number.");
			out.print(e1.getMessage());
		}
		u1.setEmail(email);
		int x = 0;
		try {
			x = csi.updateProfile(u1);
			session.setAttribute("uname", name1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(x != 0)
		{
			LOGGER.info("Profile updated successfully.");
			out.print("Profile updated successfully.");
		}
		else
		{
			LOGGER.info("Profile update operation failed.");
			out.print("Something went wrong.");
		}
	}
}
