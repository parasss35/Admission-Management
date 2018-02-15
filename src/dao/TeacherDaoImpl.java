package dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import beans.StudentBean;
import beans.TeacherBean;
import main.Main;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public int addTeacher(TeacherBean teacher) throws SQLException, IOException {
		
		String SQL="insert into teacher values(?,?,?,?,?,?,?,?,?,?,?)";
		String SQL1="select tno from num";
		String SQL2="update num set tno=tno+1";
		PreparedStatement ps1=Main.getCon().prepareStatement(SQL1);
		PreparedStatement ps2=Main.getCon().prepareStatement(SQL2);
		ResultSet rs=ps1.executeQuery();
		int tid=0;
		if(rs.next())
		{
			tid=rs.getInt(1)+1;
		}
		ps2.executeUpdate();
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		teacher.setTid(tid);
		ps.setInt(1, teacher.getTid());
		ps.setString(2,teacher.getfName());
		ps.setString(3,teacher.getlName());
		ps.setDate(4, teacher.getDob());
		ps.setString(5,teacher.getAddr());
		ps.setString(6, teacher.getDept());
		ps.setString(7, teacher.getGender());
		ps.setString(8, teacher.getContact());
		ps.setString(9,teacher.getQual());
		ps.setString(10,teacher.getDesig());
		File f=teacher.getImg();
		FileInputStream fis=new FileInputStream(f);
		ps.setBinaryStream(11,fis,(int)f.length());
		return ps.executeUpdate();
	}

	@Override
	public int updateTeacher(int tid, TeacherBean tb) throws SQLException, IOException {
		String SQL="update teacher set dob=?,addr=?,dept=?,gender=?,contact=?,qual=?,desig=? where tid=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setDate(1, tb.getDob());
		ps.setString(2, tb.getAddr());
		ps.setString(3, tb.getDept());
		ps.setString(4, tb.getGender());
		ps.setString(5, tb.getContact());
		ps.setString(6, tb.getQual());
		ps.setString(7, tb.getDesig());
		ps.setInt(8, tid);
		return ps.executeUpdate();
	}

	@Override
	public int deleteTeacher(int tid) throws SQLException, IOException {
		String SQL="delete from teacher where tid=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setInt(1,tid);
		return ps.executeUpdate();
	}

	@Override
	public TeacherBean displayTeacher(int tid) throws SQLException, IOException {
		String SQL="select * from teacher where tid=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setInt(1,tid);
		ResultSet rs=ps.executeQuery();
		TeacherBean tb=new TeacherBean();
		if(rs.next())
		{
			tb.setTid(rs.getInt(1));
			tb.setfName(rs.getString(2));
			tb.setlName(rs.getString(3));
			tb.setDob(rs.getDate(4));
			tb.setAddr(rs.getString(5));
			tb.setDept(rs.getString(6));
			tb.setGender(rs.getString(7));
			tb.setContact((String)rs.getString(8));
			tb.setQual(rs.getString(9));
			tb.setDesig(rs.getString(10));
			Blob blob=rs.getBlob("img");
			InputStream is=blob.getBinaryStream();
			BufferedImage image = ImageIO.read(is);
			File file= new File("abc");
	           ImageIO.write(image,"jpg",file);
	        tb.setImg(file);
		}
		
		return tb;
		}

	@Override
	public TeacherBean validateTeacher(int tid, String name) throws SQLException, IOException {
		String SQL="select * from teacher where tid=? and fname=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setInt(1,tid);
		ps.setString(2,name);
		ResultSet rs=ps.executeQuery();
		TeacherBean tb=new TeacherBean();
		if(rs.next())
		{
			tb.setTid(((rs.getInt(1))));
			tb.setfName((rs.getString(2)));
		}
		return tb;
	}
	

}
