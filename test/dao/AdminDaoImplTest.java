package dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import beans.AdminBean;
import main.Main;

public class AdminDaoImplTest {
	private static Connection conn;
	
	@Test
	public void testDisplayAdmin() throws SQLException, IOException, ClassNotFoundException {
		DataSource ds=new DataSource();
		conn=ds.getDBConnection();
		Main.setCon(conn);
		AdminDaoImpl adi = new AdminDaoImpl();	
		AdminBean ad=adi.displayAdmin("admin","123456");
		assertEquals("admin", ad.getUsername());
		assertEquals("123456", ad.getPassword());
	}
}
