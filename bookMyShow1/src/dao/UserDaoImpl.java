package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import dbUtility.DbConnection;
import model.User;

public class UserDaoImpl implements UserDao 
{
	static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	public int signup(User u1) throws Exception
	{
		LOGGER.info("Inside the UserDaoImpl [DAO]");
		LOGGER.info("signup (DAO method) is called");
		
		int x = 0;
		try{
			Connection con = DbConnection.getCon();
			PreparedStatement ps = con.prepareStatement("INSERT INTO user(userName, contact, email, password) VALUES(?,?,?,?)");
			ps.setString(1, u1.getName());
			ps.setLong(2, u1.getContact());
			ps.setString(3, u1.getEmail());
			ps.setString(4, u1.getPassword());
			x = ps.executeUpdate();
			
			if(x != 0)
			{
				LOGGER.warn("New user data is inserted to database.");
			}
			else
			{
				LOGGER.warn("[FAILURE]New user data is not inserted to database.");
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		finally
		{
			DbConnection.conClose();
		}
		return x;
	}
	
	public int[] login(User u1) throws Exception
	{
		LOGGER.info("Inside the UserDaoImpl [DAO]");
		LOGGER.info("login (DAO method) is called");
		
		int[] flag = {0,0};
		String name = u1.getName();
		String password = u1.getPassword();
		try{
			Connection con = DbConnection.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT userID FROM user Where userName = '"+name+"' AND password = '"+password+"'");
			if(rs.next())
			{
				flag[0]= 1;
				flag[1]=rs.getInt(1);
			}
			
			if(flag[0] != 0)
			{
				LOGGER.info("Registered user.");
			}
			else
			{
				LOGGER.warn("Unregistered user.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.conClose();
		}
		return flag;
	}
}
