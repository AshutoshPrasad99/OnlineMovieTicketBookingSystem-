package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import exception.InvalidPasswordSizeException;
import model.User;
import service.CustomerServiceImpl;

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
	
	static final Logger LOGGER = Logger.getLogger(ChangePassword.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LOGGER.info("Inside the ChangePassword");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("uID");
		String lastPass = request.getParameter("lastPassword");
		String newPass = request.getParameter("newPassword");
		
		CustomerServiceImpl csi = new CustomerServiceImpl();
		User u1 = new User();
		u1.setUserID(id);
		try {
			u1.setPassword(lastPass);
		} catch (InvalidPasswordSizeException e1) {
			LOGGER.warn("Password length is less than 8 characters.");
			out.print(e1.getMessage());
		}
		boolean flag = false;
		try {
			flag = csi.verifyPassword(u1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(flag)
		{
			LOGGER.info("Last password verified.");
			try {
				u1.setPassword(newPass);
			} catch (InvalidPasswordSizeException e1) {
				LOGGER.warn("Length of new password is less than 8 characters.");
				out.print(e1.getMessage());
			}
			
			try {
				csi.changePassword(u1);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			LOGGER.info("Password changed successfully.");
			request.setAttribute("flag", flag);
			RequestDispatcher rd = request.getRequestDispatcher("passUpdateMsg.jsp");
			rd.forward(request, response);
		}
		else
		{
			LOGGER.info("Last password is incorrect.");
			request.setAttribute("flag", flag);
			RequestDispatcher rd = request.getRequestDispatcher("passUpdateMsg.jsp");
			rd.forward(request, response);
		}
	}
}
