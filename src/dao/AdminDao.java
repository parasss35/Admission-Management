package dao;

import java.io.IOException;
import java.sql.SQLException;

import beans.AdminBean;

public interface AdminDao {
	public AdminBean displayAdmin(String username,String password) throws SQLException,IOException; 

}
