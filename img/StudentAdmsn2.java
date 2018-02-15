package cms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class StudentAdmsn2 implements ActionListener {
	
	JFrame frame;
	JPanel panel,panel1,panel2;
	JLabel lblTitle;
	JLabel lblFirstName,lblLastName,lblDob,lblAddress,lblGender,lblContact,lblRadMale,lblRadFemale,lblBranch;
	JTextField txtFirstName,txtLastName,txtContact;
	JTextArea txtAddress;
	JButton btnSubmit,btnReset,btnNew;
	JComboBox<String> comboDays,comboMonths,comboYears,comboBranch;
	JRadioButton radMale,radFemale;
	JLabel lblFathersName,lblMothersName,lblMothersOcc,lblFathersOcc,lblFathersContact,lblMothersContact;
	JTextField txtFathersName,txtMothersName,txtMothersOcc,txtFathersOcc,txtFathersContact,txtMothersContact;
	Connection conn=null;
	PreparedStatement ps=null;
	
	public StudentAdmsn2()
	{
		frame=new JFrame("Student Registration");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10,10,700,700);
		frame.setLayout(null);
		frame.setResizable(true);
		
		lblTitle=new JLabel("STUDENT REGISTRATION FORM");
		lblFirstName=new JLabel("FIRST NAME");
		lblLastName=new JLabel("LAST NAME");
		lblDob=new JLabel("DATE OF BIRTH");
		lblAddress=new JLabel("ADDRESS");
		lblGender=new JLabel("GENDER");
		lblContact=new JLabel("PHONE NUMBER");
		txtFirstName=new JTextField();
		txtLastName=new JTextField();
		txtAddress=new JTextArea(200,10);
		txtContact=new JTextField();
		comboDays=new JComboBox<>();
		comboMonths=new JComboBox<>();
		comboYears=new JComboBox<>();
		comboBranch=new JComboBox<>();
		comboDays.setModel(new DefaultComboBoxModel<>(new String[] { "--DD--","1", "2", "3", "4","5", "6", "7", "8","9", "10", "11", "12","13", "14", "15", "16","17", "18", "19", "20","21", "22", "23", "24","25", "26", "27", "28","29","30","31" }));
		comboMonths.setModel(new DefaultComboBoxModel<>(new String[] { "--MM--","January", "February", "March", "April","May", "June", "July", "August","September", "October", "November", "December"}));
		comboYears.setModel(new DefaultComboBoxModel<>(new String[] { "--YYYY--","1980","1981", "1982", "1983", "1984","1985", "1986", "1987", "1988","1989", "1990", "1991", "1992","1993", "1994", "1995", "1996","1997", "1998", "1999", "2000"}));
		comboBranch.setModel(new DefaultComboBoxModel<>(new String[] { "--BRANCH--","CSE", "ECE", "EEE", "IT","MBA", "BBA"}));
		radMale=new JRadioButton();
		radFemale=new JRadioButton();
		lblRadMale=new JLabel("MALE");
		lblRadFemale=new JLabel("FEMALE");
		lblBranch=new JLabel("BRANCH");
		lblFathersName=new JLabel("FATHER'S NAME");
		lblMothersName=new JLabel("MOTHER'S NAME");
		lblFathersOcc=new JLabel("FATHER'S OCCUPATION");
		lblMothersOcc=new JLabel("MOTHER'S OCCUPATION");
		lblFathersContact=new JLabel("FATHER'S CONTACT");
		lblMothersContact=new JLabel("MOTHER'S CONTACT");
		txtFathersName=new JTextField();
		txtFathersContact=new JTextField();
		txtFathersOcc=new JTextField();
		txtMothersName=new JTextField();
		txtMothersContact=new JTextField();
		txtMothersOcc=new JTextField();
		btnSubmit=new JButton("SAVE");
		btnReset=new JButton("RESET");
		btnNew=new JButton("NEW"); 
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 650, 100);
		panel.setBackground(Color.white);
		Font font=new Font("Courier New",Font.BOLD,28);
		
		panel.add(lblTitle);
		lblTitle.setBounds(110,10,500,70);
		lblTitle.setFont(font);
		
		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(10, 130, 650, 270);
		panel1.setBackground(Color.white);
		
		panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(10, 410, 650, 180);
		panel2.setBackground(Color.white);
		
		panel1.add(lblFirstName);panel1.add(lblLastName);
		panel1.add(lblDob);panel1.add(lblAddress);
		panel1.add(lblContact);panel1.add(txtContact);
		panel1.add(lblGender);panel1.add(txtFirstName);panel1.add(txtLastName);
		panel1.add(comboDays);panel1.add(comboMonths);panel1.add(comboYears);
		panel1.add(radMale);panel1.add(radFemale);panel1.add(lblRadMale);panel1.add(lblRadFemale);
		panel1.add(txtAddress);panel1.add(comboBranch);panel1.add(lblBranch);
		
		panel2.add(lblFathersName);panel2.add(lblMothersName);panel2.add(lblFathersOcc);
		panel2.add(lblMothersOcc);panel2.add(lblFathersContact);panel2.add(lblMothersContact);
		panel2.add(txtFathersName);panel2.add(txtMothersName);panel2.add(txtFathersOcc);
		panel2.add(txtMothersOcc);panel2.add(txtFathersContact);panel2.add(txtMothersContact);
	
		lblFirstName.setBounds(30,10,100,20);
		txtFirstName.setBounds(130,10,100,20);
		lblLastName.setBounds(380,10,100,20);
		txtLastName.setBounds(480,10,100,20);
		lblDob.setBounds(30,70,100,20);
		lblGender.setBounds(30,130,100,20);
		comboDays.setBounds(130,70,70,20);
		comboMonths.setBounds(210,70,70,20);
		comboYears.setBounds(290,70,70,20);
		radMale.setBounds(130,130,20,20);
		lblRadMale.setBounds(160,130,40,20);
		radFemale.setBounds(210,130,20,20);
		lblRadFemale.setBounds(240,130,60,20);
		lblAddress.setBounds(30,190,100,20);
		txtAddress.setBounds(140,190,200,50);
		txtAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblContact.setBounds(380,190,100,20);
		txtContact.setBounds(480,190,100,20);
		lblBranch.setBounds(380,130,100,20);
		comboBranch.setBounds(480,130,100,20);
		
		lblFathersName.setBounds(30,10,170,20);
		lblFathersOcc.setBounds(30,70,170,20);
		lblFathersContact.setBounds(30,130,170,20);
		txtFathersName.setBounds(170,10,100,20);
		txtFathersOcc.setBounds(170,70,100,20);
		txtFathersContact.setBounds(170,130,100,20);
		lblMothersName.setBounds(340,10,170,20);
		lblMothersOcc.setBounds(340,70,170,20);
		lblMothersContact.setBounds(340,130,170,20);
		txtMothersName.setBounds(490,10,150,20);
		txtMothersOcc.setBounds(490,70,150,20);
		txtMothersContact.setBounds(490,130,150,20);
		
		btnSubmit.setBounds(100,600,100,30);
		btnReset.setBounds(250,600,100,30);
		btnNew.setBounds(400,600,100,30);
		
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		btnSubmit.addActionListener(this);
		btnNew.addActionListener(this);
		btnReset.addActionListener(this);
		

		frame.add(panel);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(btnSubmit);
		frame.add(btnReset);
		frame.add(btnNew);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new StudentAdmsn2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSubmit)
		{
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","imaengineer35");
				
			}
			catch(ClassNotFoundException a){}
			catch(SQLException a){}
		}
		if(e.getSource()==btnNew)
		{
			JOptionPane.showMessageDialog(frame, "new");
		}
		if(e.getSource()==btnReset)
		{
			JOptionPane.showMessageDialog(null, "reset");
		}
		
	}

}
