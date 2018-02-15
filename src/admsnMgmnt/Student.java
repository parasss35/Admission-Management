package admsnMgmnt;

import java.awt.Color;
import java.sql.*;
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

public class Student extends JFrame implements ActionListener{
	JPanel panel1;
	JLabel lTop,lTop1, back ,lPic, lFname,lLname;
	JButton blog,bFeeDetails;
	JLabel lblEnrolNo,lblDob,lblAddress,lblGender,lblContact,lblBranch;
    JTextField txtEnrolNo,txtContact, txtGender, txtDOB, txtBranch;
    JTextArea txtAddress;
    JLabel lblFathersName,lblMothersName,lblMothersOcc,lblFathersOcc,lblFathersContact,lblMothersContact,lblDateFormat;
    JTextField txtFathersName,txtMothersName,txtMothersOcc,txtFathersOcc,txtFathersContact,txtMothersContact;
    
	public Student(){}
	public Student(StudentBean st) {
		initComponents();
		txtEnrolNo.setText(Integer.toString(st.getEnrollNo()));
		lFname.setText(st.getfName()+" "+st.getlName());
		txtDOB.setText(String.valueOf(st.getDob()));
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

	void initComponents() {
		getContentPane();
		setBounds(10, 10, 1300, 700);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f = new Font("Times New Roman",Font.BOLD,28);
		Icon i = new ImageIcon("b2.jpg");
		back = new JLabel(i);
		setContentPane(back);                          	
		
	    Icon i1 = new ImageIcon("b1.jpg");
		lTop = new JLabel(i1);
		lTop.setBounds(0, 0, 1300, 150);
		
		Icon i2 = new ImageIcon("studen.jpg");
		lPic = new JLabel(i2);
		lPic.setBounds(70, 80, 180, 180);
		add(lPic);
		add(lTop);
	
		lFname= new JLabel("");
		lFname.setBounds(300, 170, 400, 30);
		lFname.setFont(f);
		lFname.setBackground(Color.red);
		lFname.setForeground(Color.BLUE);;
		add(lFname);
		
		blog = new JButton("LOG OUT");
		blog.setBounds(1150,170,90,30);
		add(blog);
		blog.addActionListener(this);
		
		bFeeDetails = new JButton("FEE DETAILS");
		bFeeDetails.setBounds(1150,230,90,30);
		add(bFeeDetails);
		bFeeDetails.addActionListener(this);
		
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
		lblDateFormat=new JLabel("* yyyy - MM - dd ");
		
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
        panel1.add(lblDateFormat);
        
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
        lblDateFormat.setBounds(390,50,150,20);
        
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
		txtFathersContact.setText("");
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
		if(a.getSource()==blog){			
			new Loginform().setVisible(true);
			setVisible(false);}
		if(a.getSource()==bFeeDetails)
		{
			StudentBean stb=new StudentBean();
			stb.setEnrollNo(Integer.parseInt(txtEnrolNo.getText()));
			try {
				new FeeDetails(stb.getEnrollNo());
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} 
		}
			
		}
	
