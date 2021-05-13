package dbUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import servlet.AdminUser;

public class DbConnection
{
	static final Logger LOGGER = Logger.getLogger(DbConnection.class);
	private static Connection con = null;
	
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		
		LOGGER.info("Inside the DbConnection");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshow", "root", "root");

		LOGGER.warn("Connection established successfully.");
		
		return con;
	}

	public static void  conClose() throws SQLException
	{
		LOGGER.info("Inside the DbConnection");
		
		if(con!=null)
		{
			con.close();
			LOGGER.warn("Connection closed successfully.");
		}
	}
}
