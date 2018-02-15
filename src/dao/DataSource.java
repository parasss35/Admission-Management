package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	public Connection getDBConnection() throws SQLException,ClassNotFoundException
	{
		String user="system";
		String pass="imaengineer35";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
		
	}

}
