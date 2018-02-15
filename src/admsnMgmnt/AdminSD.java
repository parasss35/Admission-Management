package admsnMgmnt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import beans.StudentBean;
import dao.StudentDaoImpl;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AdminSD extends JFrame implements ActionListener{
	JPanel panel1;
	JLabel lTop,lTop1, back ,lPic, lFname,lLname;
	JButton bUpdate,bSave,bBack;
	JLabel lblEnrolNo,lblDob,lblAddress,lblGender,lblContact,lblBranch,lblYear;
    JTextField txtEnrolNo,txtContact, txtGender, txtDOB, txtBranch;
    JTextArea txtAddress;
    JLabel lblFathersName,lblMothersName,lblMothersOcc,lblFathersOcc,lblFathersContact,lblMothersContact,lblDateFormatUpdate,lblDateFormat;
    JTextField txtFathersName,txtMothersName,txtMothersOcc,txtFathersOcc,txtFathersContact,txtMothersContact;
    JComboBox<Integer> comboYear;
    int year1;
    public AdminSD(){}
    
	public AdminSD(StudentBean st) {
	initComponents();
	txtEnrolNo.setText(Integer.toString(st.getEnrollNo()));
	lFname.setText(st.getfName()+" "+st.getlName());
	Date date=st.getDob();
	DateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
	txtDOB.setText(fr.format(date));
	txtAddress.setText(st.getAddr());
	txtBranch.setText(st.getBranch());
	txtGender.setText(st.getGender());
	txtContact.setText(st.getContact());
	txtFathersName.setText(st.getFaName());
	txtFathersContact.setText(st.getFaContact());
	txtFathersOcc.setText(st.getFaOcc());
	txtMothersName.setText(st.getMoName());
	txtMothersContact.setText(st.getMoContact());
	txtMothersOcc.setText(st.getMoOcc());
	comboYear.setSelectedItem(st.getYear());
	year1=st.getYear();
	File f = st.getImg();
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
		setLayout(null);
		setBounds(10, 10, 1300, 700);
		setResizable(false);
		
		setTitle("Welcome TO BPIT");
		
		Font f = new Font("Times New Roman",Font.BOLD,28);
		Icon i = new ImageIcon("b2.jpg");
		back = new JLabel(i);
		setContentPane(back);                          //                   background image
			
	    Icon i1 = new ImageIcon("b1.jpg");
		lTop = new JLabel(i1);
		lTop.setBounds(0, 0, 1300, 150);

		Icon i2 = new ImageIcon("studen.jpg");
		lPic = new JLabel(i2);
		lPic.setBounds(70, 80, 180, 180);
		lPic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(lPic);
		add(lTop);
	
		lFname= new JLabel("h");
		lFname.setBounds(300, 170, 300, 30);
		lFname.setFont(f);
		lFname.setBackground(Color.red);
		lFname.setForeground(Color.BLUE);;
		add(lFname);

		lblDateFormatUpdate=new JLabel("* MM/dd/yyyy ");

		bUpdate = new JButton("UPDATE");
		bUpdate.setBounds(1150,170,90,30);
		add(bUpdate);
		bUpdate.addActionListener(this);
		
		bSave = new JButton("SAVE");
		bSave.setBounds(1150,220,90,30);
		add(bSave);
		bSave.addActionListener(this);
		
		bBack=new JButton("BACK");
		bBack.setBounds(1150,270,90,30);
		add(bBack);
		bBack.addActionListener(this);
		
		comboYear=new JComboBox<>();
		comboYear.setModel(new DefaultComboBoxModel<>(new Integer[] {1,2,3,4}));
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(300, 210, 700, 440);
		panel1.setBackground(Color.white);
		
		lblEnrolNo = new JLabel("ENROLLMENT NO");
		lblDob=new JLabel("DATE OF BIRTH");
		lblAddress=new JLabel("ADDRESS");
		lblGender=new JLabel("GENDER");
		lblContact=new JLabel("PHONE NUMBER");
        lblBranch=new JLabel("BRANCH");
		lblFathersName=new JLabel("FATHER'S NAME");
		lblMothersName=new JLabel("MOTHER'S NAME");
		lblFathersOcc=new JLabel("FATHER'S OCCUPATION");
		lblMothersOcc=new JLabel("MOTHER'S OCCUPATION");
		lblFathersContact=new JLabel("FATHER'S CONTACT");
		lblMothersContact=new JLabel("MOTHER'S CONTACT");
		lblYear=new JLabel("YEAR");
                
                
        txtEnrolNo = new JTextField();
        txtBranch = new JTextField();
        txtDOB= new JTextField();
        txtGender = new JTextField();
        txtAddress=new JTextArea(200,10);
		txtContact=new JTextField();
        txtFathersName=new JTextField();
		txtFathersContact=new JTextField();
		txtFathersOcc=new JTextField();
		txtMothersName=new JTextField();
		txtMothersContact=new JTextField();
		txtMothersOcc=new JTextField();
                
        Font labelFont = new Font("Courier New",Font.BOLD,14);
        panel1.add(lblEnrolNo);panel1.add(txtEnrolNo);
		panel1.add(lblDob);panel1.add(lblAddress);
		panel1.add(lblContact);panel1.add(txtContact);
		panel1.add(lblGender);panel1.add(txtDOB);panel1.add(txtGender);
		panel1.add(txtAddress);panel1.add(txtBranch);panel1.add(lblBranch);
        panel1.add(lblFathersName);panel1.add(lblMothersName);panel1.add(lblFathersOcc);
		panel1.add(lblMothersOcc);panel1.add(lblFathersContact);panel1.add(lblMothersContact);
        panel1.add(txtFathersName);panel1.add(txtMothersName);panel1.add(txtFathersOcc);
		panel1.add(txtMothersOcc);panel1.add(txtFathersContact);panel1.add(txtMothersContact);
        panel1.add(lblDateFormatUpdate);panel1.add(comboYear);panel1.add(lblYear);        
                
                
        lblEnrolNo.setBounds(30,10,150,20);
        lblEnrolNo.setFont(labelFont);
		txtEnrolNo.setBounds(230,10,150,20);
        txtEnrolNo.setEditable(false);
        txtEnrolNo.setFont(labelFont);

		
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
        
        lblYear.setBounds(480,130,70,20);
        lblYear.setFont(labelFont);
        comboYear.setBounds(550,130,50,20);
        comboYear.setEnabled(false);
                
		lblContact.setBounds(30,200,150,20);
        lblContact.setFont(labelFont);
		txtContact.setBounds(230,200,100,20);
        txtContact.setEditable(false);
        txtContact.setFont(labelFont);
                
		lblBranch.setBounds(30,240,150,20);
        lblBranch.setFont(labelFont);
		txtBranch.setBounds(230,240,100,20);
        txtBranch.setEditable(false);
        txtBranch.setFont(labelFont);
                
        lblFathersName.setBounds(30,280,170,20);
        lblFathersName.setFont(labelFont);
        txtFathersName.setBounds(230,280,100,20);
        txtFathersName.setEditable(false);
        txtFathersName.setFont(labelFont);

                
		lblFathersOcc.setBounds(30,320,210,20);
        lblFathersOcc.setFont(labelFont);
        txtFathersOcc.setBounds(230,320,100,20);
        txtFathersOcc.setEditable(false);
        txtFathersOcc.setFont(labelFont);

		lblFathersContact.setBounds(30,360,210,20);
        lblFathersContact.setFont(labelFont);
		txtFathersContact.setBounds(230,360,100,20);
        txtFathersContact.setEditable(false);
        txtFathersContact.setFont(labelFont);
                
		lblMothersName.setBounds(360,280,170,20);
        lblMothersName.setFont(labelFont);
        txtMothersName.setBounds(570,280,100,20);
        txtMothersName.setEditable(false);
        txtMothersName.setFont(labelFont);

		lblMothersOcc.setBounds(360,320,210,20);
        txtMothersOcc.setBounds(570,320,100,20);
        lblMothersOcc.setFont(labelFont);
        txtMothersOcc.setEditable(false);
        txtMothersOcc.setFont(labelFont);

		lblMothersContact.setBounds(360,360,210,20);
		txtMothersContact.setBounds(570,360,100,20);
        lblMothersContact.setFont(labelFont);
        txtMothersContact.setEditable(false);
        txtMothersContact.setFont(labelFont);
 
	}
	
		@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==bUpdate){			
			 txtDOB.setEditable(true);
			 txtGender.setEditable(true);
			 txtAddress.setEditable(true);
			 txtContact.setEditable(true);
			 txtBranch.setEditable(true);
			 txtFathersName.setEditable(true);
			 txtFathersOcc.setEditable(true);
			 txtFathersContact.setEditable(true);
			 txtMothersName.setEditable(true);
			 txtMothersOcc.setEditable(true);
			 txtMothersContact.setEditable(true);
			 comboYear.setEnabled(true);
			}
		if(a.getSource()==bSave)
		{
			
				StudentDaoImpl stdi=new StudentDaoImpl();
				StudentBean stb = new StudentBean();
				try {
					String date1=txtDOB.getText();
				SimpleDateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
				java.util.Date myDate=fr.parse(date1);
				java.sql.Date sqlDate=new java.sql.Date(myDate.getTime());
				stb.setEnrollNo(Integer.parseInt(txtEnrolNo.getText()));
					 stb.setDob(sqlDate);
					 stb.setGender(txtGender.getText());
					 stb.setAddr(txtAddress.getText());
					 stb.setBranch(txtBranch.getText());
					 stb.setContact(txtContact.getText());
					 stb.setFaContact(txtFathersContact.getText());
					 stb.setFaName(txtFathersName.getText());
					 stb.setFaOcc(txtFathersOcc.getText());
					 stb.setMoContact(txtMothersContact.getText());
					 stb.setMoName(txtMothersName.getText());
					 stb.setMoOcc(txtMothersOcc.getText());
					 int year=Integer.parseInt((comboYear.getSelectedItem().toString()));
					 stb.setYear(year);
					int st= stdi.updateStudent(stb.getEnrollNo(),stb);
					//int year1=Integer.parseInt((comboYear.getSelectedItem().toString()));
					if(year<year1)
					{
						JOptionPane.showMessageDialog(null, "Enter valid year");
						comboYear.setSelectedItem(year1);
					}
					else if(st>0){
						JOptionPane.showMessageDialog(null, "Updated Successfully");
						this.setVisible(false);
					}
				}
				catch (SQLException | IOException e1) {
					e1.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
		}
		
		if(a.getSource()==bBack)
		{
			
			this.setVisible(false);
		}
	}
}
