package dao;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import beans.TeacherBean;
import main.Main;

public class TeacherDaoImplTest {
	Connection conn;
	/*@Test
	public void testAddTeacher() throws ClassNotFoundException, SQLException, ParseException, IOException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		TeacherDaoImpl tdi = new TeacherDaoImpl();
		TeacherBean tb=new TeacherBean();
		
		String date1= "01/23/1997";
		SimpleDateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date myDate=fr.parse(date1);
		java.sql.Date sqlDate=new java.sql.Date(myDate.getTime());
    
		tb.setTid(802);
		tb.setfName("Payal");
		tb.setlName("Pahwa");
		tb.setDob(sqlDate);	
		tb.setAddr("Rohini");
		tb.setDept("CSE");
		tb.setGender("F");
		tb.setContact("8114484072");
		tb.setQual("B.tech,M.tech");
		tb.setDesig("Principal");
		File f=new File("payal.png");
		tb.setImg(f);
		
		int result = tdi.addTeacher(tb);
		int expResult = 1;
		assertEquals(expResult,result);
	}*/

	 @Test
	   public void testUpdateTeacher() throws ClassNotFoundException, SQLException, IOException, ParseException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		TeacherDaoImpl tdi = new TeacherDaoImpl();
		TeacherBean tb=new TeacherBean();
		String date1= "01/23/1997";
		SimpleDateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date myDate=fr.parse(date1);
		java.sql.Date sqlDate=new java.sql.Date(myDate.getTime());
		tb.setTid(802);
		tb.setfName("Payal");
		tb.setlName("Pahwa");
		tb.setDob(sqlDate);	
		tb.setAddr("Rajasthan");
		tb.setDept("CSE");
		tb.setGender("F");
		tb.setContact("8114484072");
		tb.setQual("B.tech,M.tech");
		tb.setDesig("Principal");
		File f=new File("payal.png");
		tb.setImg(f);
	
		int result=tdi.updateTeacher(802, tb);
		int expResult=1;
		assertEquals(expResult,result);

			}

	 /*@Test
	  public void testDeleteTeacher() throws ClassNotFoundException, SQLException, IOException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		TeacherDaoImpl tdi = new TeacherDaoImpl();
		int result = tdi.deleteTeacher(803);
		int expResult=1;
		assertEquals(expResult,result);

	}*/
	/* @Test
	   public void testDisplayTeacher() throws ClassNotFoundException, SQLException, IOException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		TeacherDaoImpl tdi = new TeacherDaoImpl();	
		TeacherBean tb=tdi.displayTeacher(802);
		assertEquals("Himanshu", tb.getfName());
		assertEquals("bAnsAl", tb.getlName());
		assertEquals(802, tb.getTid());
		assertEquals("CSE", tb.getDept());
		assertEquals("F", tb.getGender());
	}
*/
	/*@Test
	public void testValidateTeacher() throws SQLException, IOException, ClassNotFoundException {
		DataSource ds=new DataSource();
	 	conn = ds.getDBConnection();
		Main.setCon(conn);
		TeacherDaoImpl tdi = new TeacherDaoImpl();	
		TeacherBean tb=tdi.validateTeacher(802, "Payal");
		assertEquals("Payal", tb.getfName());
		assertEquals(802, tb.getTid());
	}*/

}
