package admsnMgmnt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class StudentTable implements ActionListener{
	JFrame fr;
	JButton btnStudentTable,btnAdminLogin,btnTeacherTable;
	
	public StudentTable()
	{
		fr=new JFrame();
		
		fr=new JFrame("Student Registration");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setBounds(10,10,700,700);
		fr.setLayout(null);
		fr.setResizable(true);
		
		btnStudentTable=new JButton("StudentTable");
		btnStudentTable.setBounds(200,100,70,40);
		btnStudentTable.addActionListener(this);
		
		btnAdminLogin=new JButton("AdminLogin");
		btnAdminLogin.setBounds(300,100,70,40);
		btnAdminLogin.addActionListener(this);
		
		btnTeacherTable=new JButton("Teacher");
		btnTeacherTable.setBounds(400,100,70,40);
		btnTeacherTable.addActionListener(this);

		
		fr.add(btnAdminLogin);
		fr.add(btnStudentTable);
		fr.add(btnTeacherTable);
		fr.setVisible(true);
	}

	public static void main(String[] args) {
		new StudentTable();
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Connection conn=null;
		PreparedStatement pst=null;
		if(arg0.getSource()==btnStudentTable)
		{
		try
		{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 JOptionPane.showMessageDialog(null,"Connection 1");
		     conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","imaengineer35");
		     JOptionPane.showMessageDialog(null,"Connection 2");
		     String SQL="create table Student(enrollno number(3) primary key,fname varchar2(20),lname varchar2(20),dob date,addr varchar2(40),branch varchar2(4),gender varchar2(2),contact number(10),faname varchar2(20),faocc varchar2(15),facontact number(10),moname varchar2(20),moocc varchar2(15),mocontact number(10),fee1 varchar2(5),fee2 varchar2(5),fee3 varchar2(5),fee4 varchar2(5),img blob)";
		     pst=conn.prepareStatement(SQL);
		     JOptionPane.showMessageDialog(null,"Prepared");
		     pst.executeUpdate();
		     System.out.print("dd");
		     conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"SQL");}
		catch(ClassNotFoundException e)
		{JOptionPane.showMessageDialog(null,"Class");}
		}
		if(arg0.getSource()==btnAdminLogin)
		{
			try
			{
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 JOptionPane.showMessageDialog(null,"Connection 1");
			     conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","imaengineer35");
			     JOptionPane.showMessageDialog(null,"Connection 2");
			     String SQL1="create table admin(username varchar2(20),password varchar2(20))";
			     pst=conn.prepareStatement(SQL1);
			     JOptionPane.showMessageDialog(null,"Prepared");
			     pst.executeUpdate();
			     System.out.print("dd");
			     conn.close();
			}
			catch(SQLException e)
			{
				System.out.println(e);
				JOptionPane.showMessageDialog(null,"SQL");}
			catch(ClassNotFoundException e)
			{JOptionPane.showMessageDialog(null,"Class");}
		}
		if(arg0.getSource()==btnTeacherTable)
		{
		try
		{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 JOptionPane.showMessageDialog(null,"Connection 1");
		     conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","imaengineer35");
		     JOptionPane.showMessageDialog(null,"Connection 2");
		     String SQL="create table Teacher(tid number(3) primary key,fname varchar2(20),lname varchar2(20),dob date,addr varchar2(40),dept varchar2(4),gender varchar2(2),contact number(10),qual varchar2(20),desig varchar2(15),img blob)";
		     pst=conn.prepareStatement(SQL);
		     JOptionPane.showMessageDialog(null,"Prepared");
		     pst.executeUpdate();
		     System.out.print("dd");
		     conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"SQL");}
		catch(ClassNotFoundException e)
		{JOptionPane.showMessageDialog(null,"Class");}
		}

	}

}
