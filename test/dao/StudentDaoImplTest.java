package dao;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import beans.AdminBean;
import beans.StudentBean;
import main.Main;

public class StudentDaoImplTest {
	Connection conn;
	/*@Test
	  public void testAddStudent() throws ClassNotFoundException, SQLException, IOException, ParseException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		StudentDaoImpl sdi = new StudentDaoImpl();
		StudentBean stb=new StudentBean();
		
		String date1= "01/23/1997";
		SimpleDateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date myDate=fr.parse(date1);
		java.sql.Date sqlDate=new java.sql.Date(myDate.getTime());
    
		stb.setEnrollNo(110);
		stb.setfName("Himanshu");
		stb.setlName("bAnsAl");
		stb.setDob(sqlDate);	
		stb.setAddr("Rohini");
		stb.setBranch("CSE");
		stb.setGender("M");
		stb.setContact("8114484072");
		stb.setFaName("Pawan Bansal");
		stb.setFaOcc("Buisnessman");
		stb.setFaContact("9829932316");
		stb.setMoName("Pooja Bansal");
		stb.setMoOcc("Housewife");
		stb.setMoContact("8021438888");
		stb.setFee1("YES");
		stb.setFee2("NO");
		stb.setFee3("NO");
		stb.setFee4("NO");
		stb.setYear(1);
		File f=new File("paras.jpg");
		stb.setImg(f);
		
		int result = sdi.addStudent(stb);
		int expResult = 1;
		assertEquals(expResult,result);
	}*/
	@Test
	public void testUpdateStudent() throws ClassNotFoundException, SQLException, IOException, ParseException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		StudentDaoImpl sdi = new StudentDaoImpl();
		StudentBean stb=new StudentBean();
		
		String date1= "01/23/1997";
		SimpleDateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date myDate=fr.parse(date1);
		java.sql.Date sqlDate=new java.sql.Date(myDate.getTime());
		
		stb.setEnrollNo(110);
		stb.setfName("Himanshu");
		stb.setlName("bAnsAl");
		stb.setDob(sqlDate);	
		stb.setAddr("Rajasthan");
		stb.setBranch("CSE");
		stb.setGender("M");
		stb.setContact("8114484072");
		stb.setFaName("Pawan Bansal");
		stb.setFaOcc("Buisnessman");
		stb.setFaContact("9829932316");
		stb.setMoName("Pooja Bansal");
		stb.setMoOcc("Housewife");
		stb.setMoContact("8021438888");
		stb.setYear(1);
		File f=new File("paras.jpg");
		stb.setImg(f);	
		int result=sdi.updateStudent(110, stb);
		int expResult=1;
		assertEquals(expResult,result);
	}
	/*@Test
	    public void testDeleteStudent() throws ClassNotFoundException, SQLException, IOException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		StudentDaoImpl sdi = new StudentDaoImpl();
		int result = sdi.deleteStudent(109);
		int expResult=1;
		assertEquals(expResult,result);
		
	}
	@Test
	public void testDisplayStudent() throws ClassNotFoundException, SQLException, IOException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		StudentDaoImpl sdi = new StudentDaoImpl();	
		StudentBean st=sdi.displayStudent(110);
		assertEquals("Himanshu", st.getfName());
		assertEquals("bAnsAl", st.getlName());
		assertEquals(110, st.getEnrollNo());
		assertEquals("CSE", st.getBranch());
		assertEquals("M", st.getGender());
	}
	@Test
	public void testFeeUpdateStudent() throws SQLException, IOException, ClassNotFoundException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		StudentDaoImpl sdi = new StudentDaoImpl();	
		StudentBean stb = new StudentBean();
		stb.setFee2("YES");
		stb.setFee1("YES");
		stb.setFee3("NO");
		stb.setFee4("NO");
		int result = sdi.feeUpdateStudent(110,stb);
		int expResult = 1;
		assertEquals(expResult,result);
	}
	@Test
	public void testValidateStudent() throws SQLException, IOException, ClassNotFoundException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		StudentDaoImpl sdi = new StudentDaoImpl();	
		StudentBean sd=sdi.validateStudent(109, "paras");
		assertEquals("paras", sd.getfName());
		assertEquals(109, sd.getEnrollNo());	}*/
}
