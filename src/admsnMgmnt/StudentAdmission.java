package admsnMgmnt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

import beans.StudentBean;
import dao.StudentDaoImpl;

import java.util.Date;
import oracle.sql.DATE;

public class StudentAdmission extends JFrame implements ActionListener {
	
	JPanel panel,panel1,panel2;
	JLabel lblTitle;
	JLabel lblFirstName,lblLastName,lblDob,lblAddress,lblGender,lblContact,lblRadMale,lblRadFemale,lblBranch;
	JTextField txtFirstName,txtLastName,txtContact;
	JTextArea txtAddress;
	JButton btnNext,btnBack,btnNew,btnBrowse;
	JComboBox<String> comboDays,comboMonths,comboYears,comboBranch;
	JRadioButton radMale,radFemale;
	JLabel lblFathersName,lblMothersName,lblMothersOcc,lblFathersOcc,lblFathersContact,lblMothersContact,lblDateFormat;
	JTextField txtFathersName,txtMothersName,txtMothersOcc,txtFathersOcc,txtFathersContact,txtMothersContact;
	JLabel lblPhoto1;
	JFormattedTextField txtDate;
	ButtonGroup btnGroup;
	JTextField txtDate1, txtBrowse;
	JFileChooser img;
	java.io.File file;
	
	public StudentAdmission()
	{
		new JFrame("Student Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10,10,700,700);
		setLayout(null);
		setResizable(false);
		
		lblTitle=new JLabel("STUDENT REGISTRATION FORM");
		lblFirstName=new JLabel("FIRST NAME");
		lblLastName=new JLabel("LAST NAME");
		lblDob=new JLabel("DATE OF BIRTH");
		lblAddress=new JLabel("ADDRESS");
		lblGender=new JLabel("GENDER");
		lblContact=new JLabel("PHONE NUMBER");
		lblDateFormat=new JLabel("* MM / dd / yyyy ");
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
		btnGroup=new ButtonGroup();
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
		
		btnNext=new JButton("NEXT");
		btnBack=new JButton("BACK");
		
		img = new JFileChooser();
		btnBrowse=new JButton("BROWSE");
		txtBrowse = new JTextField();
		
		SimpleDateFormat fr=new SimpleDateFormat("DD-MM-YYYY");
		
	    txtDate1=new JTextField();
		
		btnGroup.add(radFemale);
		btnGroup.add(radMale);		
		lblPhoto1=new JLabel("   YOUR PHOTO HERE  ");
		
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
		panel1.add(lblPhoto1);panel1.add(txtDate1);panel1.add(lblDateFormat);
		
		panel2.add(lblFathersName);panel2.add(lblMothersName);panel2.add(lblFathersOcc);
		panel2.add(lblMothersOcc);panel2.add(lblFathersContact);panel2.add(lblMothersContact);
		panel2.add(txtFathersName);panel2.add(txtMothersName);panel2.add(txtFathersOcc);
		panel2.add(txtMothersOcc);panel2.add(txtFathersContact);panel2.add(txtMothersContact);
	
		lblFirstName.setBounds(30,10,100,20);
		txtFirstName.setBounds(110,10,100,20);
		lblLastName.setBounds(220,10,100,20);
		txtLastName.setBounds(310,10,100,20);
		lblPhoto1.setBounds(460,10,140,140);
		lblPhoto1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblDob.setBounds(30,70,100,20);
		txtDate1.setBounds(130,70,150,26);
		lblDateFormat.setBounds(130,100,150,20);
		comboBranch.setBounds(300,70,100,26);
		lblGender.setBounds(30,130,100,20);
		radMale.setBounds(130,130,20,20);
		lblRadMale.setBounds(160,130,40,20);
		radFemale.setBounds(210,130,20,20);
		lblRadFemale.setBounds(240,130,60,20);
		lblAddress.setBounds(30,190,100,20);
		txtAddress.setBounds(140,190,200,50);
		txtAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblContact.setBounds(380,220,100,20);
		txtContact.setBounds(480,220,100,20);
		btnBrowse.setBounds(480,160,100,30);
		
		lblFathersName.setBounds(30,10,170,20);
		lblFathersOcc.setBounds(30,70,170,20);
		lblFathersContact.setBounds(30,130,170,20);
		txtFathersName.setBounds(170,10,150,20);
		txtFathersOcc.setBounds(170,70,150,20);
		txtFathersContact.setBounds(170,130,150,20);
		lblMothersName.setBounds(340,10,170,20);
		lblMothersOcc.setBounds(340,70,170,20);
		lblMothersContact.setBounds(340,130,170,20);
		txtMothersName.setBounds(490,10,150,20);
		txtMothersOcc.setBounds(490,70,150,20);
		txtMothersContact.setBounds(490,130,150,20);
		
		btnNext.setBounds(400,600,100,30);
		btnBack.setBounds(100,600,100,30);
		
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel1.add(btnBrowse);
		
		btnNext.addActionListener(this);
		btnBack.addActionListener(this);
		btnBrowse.addActionListener(this);
		
		add(panel);
		add(panel1);
		add(panel2);
		add(btnNext);
		add(btnBack);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNext)
		{
			String ch=null;
			if(radMale.isSelected())
			{
			    ch="M";
			}
			else if(radFemale.isSelected())
			{
				ch="F";
			}
			int flag=0;
				try
				{
					String f="No";
					String date1=txtDate1.getText();
					SimpleDateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
					java.util.Date myDate=fr.parse(date1);
					java.sql.Date sqlDate=new java.sql.Date(myDate.getTime());
		        
				
		        StudentBean stb=new StudentBean();
		        stb.setfName(txtFirstName.getText());
				stb.setlName(txtLastName.getText());
				stb.setDob(sqlDate);	
				stb.setAddr(txtAddress.getText());
				stb.setBranch((String) comboBranch.getSelectedItem());
				stb.setGender(ch);
				stb.setContact(txtContact.getText());
				stb.setFaName(txtFathersName.getText());
				stb.setFaOcc(txtFathersOcc.getText());
				stb.setFaContact(txtFathersContact.getText());
				stb.setMoName(txtMothersName.getText());
				stb.setMoOcc(txtMothersOcc.getText());
				stb.setMoContact(txtMothersContact.getText());
				stb.setFee1(f);
				stb.setFee2(f);
				stb.setFee3(f);
				stb.setFee4(f);
				stb.setYear(1);
				stb.setImg(file);
				
				Validate validate = new Validate();
				if(validate.studentValidation(stb) && flag==0){
				
				StudentDaoImpl stimpl=new StudentDaoImpl();
				int rowAffected =stimpl.addStudent(stb);
				if(rowAffected==1)
				{
					JOptionPane.showMessageDialog(null, "Student details successfully Saved");
					new AdminFeeClass(stb).setVisible(true);
					this.setVisible(false);
				}
				}
				}
				catch(ParseException e1)
				{
					JOptionPane.showMessageDialog(null, "Incorrect date format");
					flag=1;
				}
				catch(NullPointerException e1){
					JOptionPane.showMessageDialog(null, "Upload the image");
					flag=1;
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					flag=1;
				}
		}
		if(e.getSource()==btnBack)
		{
			new Admin().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==btnBrowse){
			int retval = img.showOpenDialog(null);
			if(retval== JFileChooser.APPROVE_OPTION){
				file= img.getSelectedFile();
				lblPhoto1.setIcon(new ImageIcon(file.getAbsolutePath()));
			}
		}
	}
}
