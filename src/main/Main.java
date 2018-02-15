package main;

import java.sql.Connection;
import java.sql.SQLException;

import admsnMgmnt.Admin;
import admsnMgmnt.Loginform;
import admsnMgmnt.StudentAdmission;
import dao.DataSource;

public class Main {
	private static Connection con;
	public static void main(String []args) throws SQLException,ClassNotFoundException
	{
		DataSource ds=new DataSource();
		con= ds.getDBConnection();
		new Loginform();
		
	}
	public static void setCon(Connection con) {
		Main.con = con;
	}
	public static Connection getCon() {
		return con;
	}
}
