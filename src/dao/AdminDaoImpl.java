package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AdminBean;
import beans.TeacherBean;
import main.Main;

public class AdminDaoImpl implements AdminDao {

	@Override
	public AdminBean displayAdmin(String username,String password) throws SQLException, IOException {
		String SQL="select * from admin where username=? and password=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setString(1,username);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		AdminBean adb=new AdminBean();
		if(rs.next())
		{
			adb.setUsername(rs.getString(1));
			adb.setPassword(rs.getString(2));
		}
		return adb;
	}
}
