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
import admsnMgmnt.Student;
import beans.AdminBean;
import beans.StudentBean;
import main.Main;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int addStudent(StudentBean student) throws SQLException,IOException{
		

		String SQL="insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String SQL1="select enno from num";
		String SQL2="update num set enno=enno+1";
		PreparedStatement ps1=Main.getCon().prepareStatement(SQL1);
		PreparedStatement ps2=Main.getCon().prepareStatement(SQL2);
		ResultSet rs=ps1.executeQuery();
		int eno=0;
		if(rs.next())
		{
			eno=rs.getInt(1)+1;
		}
		ps2.executeUpdate();
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		student.setEnrollNo(eno);
		ps.setInt(1, student.getEnrollNo());
		ps.setString(2,student.getfName());
		ps.setString(3,student.getlName());
		ps.setDate(4, student.getDob());	
		ps.setString(5,student.getAddr());
		ps.setString(6, student.getBranch());
		ps.setString(7, student.getGender());
		ps.setString(8, student.getContact());
		ps.setString(9,student.getFaName());
		ps.setString(10,student.getFaOcc());
		ps.setString(11,student.getFaContact());
		ps.setString(12,student.getMoName());
		ps.setString(13, student.getMoOcc());
		ps.setString(14, student.getMoContact());
		ps.setString(15,student.getFee1());
		ps.setString(16,student.getFee2());
		ps.setString(17,student.getFee3());
		ps.setString(18,student.getFee4());
		File f=student.getImg();
		FileInputStream fis=new FileInputStream(f);
		ps.setBinaryStream(19,fis,(int)f.length());
		
		ps.setInt(20, student.getYear());
		
		return ps.executeUpdate();
	}

	@Override
	public int updateStudent(int enrollno, StudentBean stu) throws SQLException, IOException {
		String SQL="update student set dob=? , addr=?, branch=?, gender=?,contact=?,faname=?,faocc=?,facontact=?,moname=?,moocc=?,mocontact=?,year=?where enrollno=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setDate(1, stu.getDob());
		ps.setString(2, stu.getAddr());
		ps.setString(3, stu.getBranch());
		ps.setString(4, stu.getGender());
		ps.setString(5, stu.getContact());
		ps.setString(6, stu.getFaName());
		ps.setString(7, stu.getFaOcc());
		ps.setString(8, stu.getFaContact());
		ps.setString(9, stu.getMoName());
        ps.setString(10, stu.getMoOcc());
		ps.setString(11, stu.getMoContact());
		stu.setEnrollNo(enrollno);
		ps.setInt(12,stu.getYear());
		ps.setInt(13, stu.getEnrollNo());
		int st =  ps.executeUpdate();
		return st;
	}

	@Override
	public int deleteStudent(int enrollno) throws SQLException, IOException {
		String SQL="delete from student where enrollno=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setInt(1,enrollno);
		return ps.executeUpdate();
	}

	@Override
	public StudentBean displayStudent(int enrollno) throws SQLException, IOException {
		String SQL="select * from student where enrollno=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setInt(1,enrollno);
		ResultSet rs=ps.executeQuery();
		StudentBean st=new StudentBean();
		if(rs.next())
		{
			st.setEnrollNo(rs.getInt(1));
			st.setfName(rs.getString(2));
			st.setlName(rs.getString(3));
			st.setDob(rs.getDate(4));
			st.setAddr(rs.getString(5));
			st.setBranch(rs.getString(6));
			st.setGender(rs.getString(7));
			st.setContact((String)rs.getString(8));
			st.setFaName(rs.getString(9));
			st.setFaOcc(rs.getString(10));
			st.setFaContact(rs.getString(11));
			st.setMoName(rs.getString(12));
			st.setMoOcc(rs.getString(13));
			st.setMoContact(rs.getString(14));
			st.setFee1(rs.getString(15));
			st.setFee2(rs.getString(16));
			st.setFee3(rs.getString(17));
			st.setFee4(rs.getString(18));
			
			Blob blob=rs.getBlob("img");
			InputStream is=blob.getBinaryStream();
			BufferedImage image = ImageIO.read(is);
			File file= new File("abc");
	        ImageIO.write(image,"jpg",file);
	        st.setImg(file);
	        
	        st.setYear(rs.getInt(20));
		}
		return st;
	
	}

	@Override
	public int feeUpdateStudent(int enrollno, StudentBean stb) throws SQLException, IOException {
		String SQL="update student set fee1=?,fee2=?,fee3=?,fee4=? where enrollno=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setString(1, stb.getFee1());
		ps.setString(2, stb.getFee2());
		ps.setString(3, stb.getFee3());
		ps.setString(4, stb.getFee4());
		ps.setInt(5, enrollno);
		return ps.executeUpdate();
	}

	@Override
	public StudentBean validateStudent(int enrollno, String name) throws SQLException, IOException {
		String SQL="select * from student where enrollno=? and fname=?";
		PreparedStatement ps=Main.getCon().prepareStatement(SQL);
		ps.setInt(1,enrollno);
		ps.setString(2,name);
		ResultSet rs=ps.executeQuery();
		StudentBean stb=new StudentBean();
		if(rs.next())
		{
			stb.setEnrollNo((rs.getInt(1)));
			stb.setfName((rs.getString(2)));
		}
		return stb;
	}
}
