package admsnMgmnt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.*;

import beans.StudentBean;
import beans.TeacherBean;
import dao.StudentDaoImpl;
import dao.TeacherDaoImpl;

public class AdminTD extends JFrame implements ActionListener{

	JPanel panel1;
	JLabel lTop, back ,lPic, lName;
	JButton bUpdate,bSave,bBack;
	JLabel lblID,lblDob,lblAddress,lblGender,lblContact,lblDept,lblQualif,lblDesign,lblDateFormatUpdate;
    JTextField txtID,txtContact, txtGender, txtDOB, txtDept,txtQualif,txtDesign;
    JTextArea  txtAddress;

    public AdminTD(){}
    
    public AdminTD(TeacherBean tb) {
    	initComponents();
    	txtID.setText(Integer.toString(tb.getTid()));
    	lName.setText(tb.getfName()+" "+tb.getlName());
    	Date date=tb.getDob();
    	DateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
    	txtDOB.setText(fr.format(date));
    	txtAddress.setText(tb.getAddr());
    	txtDept.setText(tb.getDept());
    	txtGender.setText(tb.getGender());
    	txtContact.setText(tb.getContact());
    	txtQualif.setText(tb.getQual());
    	txtDesign.setText(tb.getDesig());
    	File f = tb.getImg();
    	BufferedImage image;
    	try {
    		image = ImageIO.read(f);
    		ImageIcon img = new ImageIcon(image);
    		lPic.setIcon(img);
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    	}
    	add(panel1);
    	setVisible(true);
    	
    	}
	public void initComponents(){
		getContentPane();
		setBounds(10, 10, 1300, 700);
		setResizable(false);
		setLayout(null);
		setTitle("Welcome TO BPIT");
		
		Font f = new Font("Times New Roman",Font.BOLD,28);
		Font labelFont = new Font("Courier New",Font.BOLD,16);
		Icon i = new ImageIcon("b2.jpg");
		back = new JLabel(i);
		setContentPane(back);                          //background image
		
	    Icon i1 = new ImageIcon("b1.jpg");
		lTop = new JLabel(i1);
		lTop.setBounds(0, 0, 1300, 150);
		
		Icon i2 = new ImageIcon("teacher.jpg");
		lPic = new JLabel(i2);
		lPic.setBounds(70, 80, 180, 180);
		add(lPic);
		add(lTop);
		
		lName = new JLabel("");
		lName.setBounds(300, 170, 600, 30);
		lName.setFont(f);
		lName.setForeground(Color.BLUE);
		add(lName);
		
		bUpdate = new JButton("UPDATE");
		bUpdate.setBounds(1150,170,90,30);
		add(bUpdate);
		bUpdate.addActionListener(this);
		
		bSave = new JButton("SAVE");
		bSave.setBounds(1150,220,90,30);
		add(bSave);
		bSave.addActionListener(this);
		
		bBack = new JButton("BACK");
		bBack.setBounds(1150,270,90,30);
		add(bBack);
		bBack.addActionListener(this);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(300, 210, 700, 440);
		panel1.setBackground(Color.white);
		
		lblID = new JLabel("ID");
		lblDob=new JLabel("DATE OF BIRTH");
		lblAddress=new JLabel("ADDRESS");
		lblGender=new JLabel("GENDER");
		lblContact=new JLabel("PHONE NUMBER");
        lblDept=new JLabel("DEPARTMENT");
        lblQualif=new JLabel("QUALIFICATION");
        lblDesign=new JLabel("DESIGNATION");
		lblDateFormatUpdate=new JLabel("* MM/dd/yyyy ");
        
        txtID = new JTextField();
        txtDept = new JTextField();
        txtDOB= new JTextField();
        txtGender = new JTextField();
        txtAddress=new JTextArea(200,10);
		txtContact=new JTextField();
		txtQualif=new JTextField();
		txtDesign=new JTextField();
	   		
        panel1.add(lblID);panel1.add(txtID);
		panel1.add(lblDob);panel1.add(txtDOB);
		panel1.add(lblContact);panel1.add(txtContact);
		panel1.add(lblGender);panel1.add(txtGender);
		panel1.add(lblAddress);panel1.add(txtAddress);
		panel1.add(lblDept);panel1.add(txtDept);
		panel1.add(lblDateFormatUpdate); 
		panel1.add(lblDesign);panel1.add(txtDesign);
		panel1.add(lblQualif);panel1.add(txtQualif);
		
		lblID.setBounds(30,10,150,20);
	    lblID.setFont(labelFont);
	    txtID.setBounds(230,10,150,20);
	    txtID.setEditable(false);
	    txtID.setFont(labelFont);

		lblDob.setBounds(30,50,150,20);
	    lblDob.setFont(labelFont);
	    txtDOB.setBounds(230,50,150,20);
	    txtDOB.setEditable(false);
	    txtDOB.setFont(labelFont);
	    
	    lblDateFormatUpdate.setBounds(390,50,100,20);
        
	    	lblGender.setBounds(30,90,150,20);
			lblGender.setFont(labelFont);
	        txtGender.setBounds(230,90,150,20);
	        txtGender.setEditable(false);
	        txtGender.setFont(labelFont);

			lblAddress.setBounds(30,130,100,20);
	        lblAddress.setFont(labelFont);
			txtAddress.setBounds(230,130,200,50);
			txtAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        txtAddress.setEditable(false);
	        txtAddress.setFont(labelFont);
	                
			lblContact.setBounds(30,200,150,20);
	        lblContact.setFont(labelFont);
			txtContact.setBounds(230,200,150,20);
	        txtContact.setEditable(false);
	        txtContact.setFont(labelFont);
	                
			lblDept.setBounds(30,240,150,20);
	        lblDept.setFont(labelFont);
			txtDept.setBounds(230,240,150,20);
	        txtDept.setEditable(false);
	        txtDept.setFont(labelFont);
	                
	        lblQualif.setBounds(30,280,170,20);
	        lblQualif.setFont(labelFont);
	        txtQualif.setBounds(230,280,150,20);
	        txtQualif.setEditable(false);
	        txtQualif.setFont(labelFont);
	                
			lblDesign.setBounds(30,320,210,20);
	        lblDesign.setFont(labelFont);
	        txtDesign.setBounds(230,320,150,20);
	        txtDesign.setEditable(false);
	        txtDesign.setFont(labelFont);
		
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==bUpdate){			
			 txtID.setEditable(false);
			 txtDOB.setEditable(true);
			 txtGender.setEditable(true);
			 txtAddress.setEditable(true);
			 txtContact.setEditable(true);
			 txtDept.setEditable(true);
			 txtQualif.setEditable(true);
			 txtDesign.setEditable(true);
			}		
		if(a.getSource()==bSave)
		{

			TeacherDaoImpl tdi=new TeacherDaoImpl();
			TeacherBean tb = new TeacherBean();
			try
			{
			String date1=txtDOB.getText();
			SimpleDateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date myDate=fr.parse(date1);
			java.sql.Date sqlDate=new java.sql.Date(myDate.getTime());
			tb.setDob(sqlDate);	
			tb.setAddr(txtAddress.getText());
			tb.setDept(txtDept.getText());
			tb.setGender(txtGender.getText());
			tb.setContact(txtContact.getText());
			tb.setQual(txtQualif.getText());
			tb.setDesig(txtDesign.getText());
			}
			catch(Exception e)
			{
				
			}
			try {
				int t= tdi.updateTeacher(Integer.parseInt(txtID.getText()),tb);
				if(t>0){
					JOptionPane.showMessageDialog(null, "Updated Successfully");
					//new Admin().setVisible(true);
					setVisible(false);
				}
			}
			catch (SQLException | IOException e1) {
				e1.printStackTrace();
			}
		}
		if(a.getSource()==bBack)
		{
			this.setVisible(false);
		}
	}
}



