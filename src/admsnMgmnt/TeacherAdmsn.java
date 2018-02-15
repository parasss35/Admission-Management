package admsnMgmnt;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;

import beans.StudentBean;
import beans.TeacherBean;
import dao.StudentDaoImpl;
import dao.TeacherDaoImpl;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class TeacherAdmsn extends JFrame implements ActionListener {
	
	JPanel panelMiddle,panelBottom,panelTop;
	JLabel lblFirstName1,lblLastName1,lblDob1,lblAddress1,lblGender1,lblContact1,lblRadMale1,lblRadFemale1,lblDepartment1,lblFacDesg1,lblQualification1,lblTitle1,lblPhoto,lblDateFormat;
	JTextField txtFirstName1,txtLastName1,txtContact1,txtQualification1,txtDate,txtDoc,txtBrowse;
	JTextArea txtAddress1;
	JButton btnSubmit1,btnBack1,btnNew1,btnBrowse,btnDoc;
	JComboBox<String> comboDept1,comboFacDesg1;
	JRadioButton radMale1,radFemale1;
	ButtonGroup btnRadio;
	JFileChooser fd,fb;
	Connection conn=null;
	PreparedStatement ps=null;
	java.io.File file;
	
	public TeacherAdmsn()
	{
		//FRAME
		new JFrame("Faculty Registration");
		setBounds(10,10,700,700);
		setLayout(null);
		
		
		//FONT
		Font font=new Font("Courier New",Font.BOLD,28);
		
		
		//LABELS
		lblTitle1=new JLabel("FACULTY REGISTRATION FORM");
		lblTitle1.setBounds(110,10,500,70);
		lblTitle1.setFont(font);
		
		lblFirstName1=new JLabel("FIRST NAME");
		lblFirstName1.setBounds(30,10,100,20);
		
		lblLastName1=new JLabel("LAST NAME");
		lblLastName1.setBounds(260,10,100,20);
		
		lblDob1=new JLabel("DATE OF BIRTH");
		lblDob1.setBounds(30,70,100,20);
		
		lblDateFormat=new JLabel("* MM / dd / yyyy ");
		lblDateFormat.setBounds(250,70,150,20);
		
		lblAddress1=new JLabel("ADDRESS");
		lblAddress1.setBounds(30,190,100,20);
		
		lblGender1=new JLabel("GENDER");
		lblGender1.setBounds(30,130,100,20);
		
		lblContact1=new JLabel("PHONE NUMBER");
		lblContact1.setBounds(380,190,100,20);
		
		lblRadMale1=new JLabel("MALE");
		lblRadMale1.setBounds(160,130,40,20);
		
		lblRadFemale1=new JLabel("FEMALE");
		lblRadFemale1.setBounds(240,130,60,20);
		
		lblDepartment1=new JLabel("DEPARTMENT");
		lblDepartment1.setBounds(30,10,100,20);
		
		lblFacDesg1=new JLabel("DESIGNATION");
		lblFacDesg1.setBounds(30,130,170,20);
		
		lblQualification1=new JLabel("QUALIFICATION");
		lblQualification1.setBounds(30,70,170,20);
		
		
		//TEXT FIELDS
		txtFirstName1=new JTextField();
		txtFirstName1.setBounds(140,10,100,20);
		
		txtLastName1=new JTextField();
		txtLastName1.setBounds(360,10,100,20);
		
		txtAddress1=new JTextArea(200,10);
		txtAddress1.setBounds(140,190,200,50);
		txtAddress1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		txtContact1=new JTextField();
		txtContact1.setBounds(480,190,100,20);
		
		txtQualification1=new JTextField();
		txtQualification1.setBounds(150,70,150,20);
		
		txtDate=new JTextField();
		txtDate.setBounds(140,70,100,20);
		
		txtDoc = new JTextField();
		txtDoc.setBounds(490,50,100,30);
		
		
		//COMBO BOXES
		comboDept1=new JComboBox<>();
		comboDept1.setModel(new DefaultComboBoxModel<>(new String[] {"CSE", "ECE", "EEE", "IT","MBA", "BBA"}));
		comboDept1.setBounds(150,10,150,20);
		
		comboFacDesg1=new JComboBox<>();
		comboFacDesg1.setModel(new DefaultComboBoxModel<>(new String[] {"PRINCIPAL", "HOD", "PROF.", "ASSIS. PROF"}));
		comboFacDesg1.setBounds(150,130,170,20);
        
        
        //RADIO BUTTONS
        radMale1=new JRadioButton();
        radMale1.setBounds(130,130,20,20);
        
        radFemale1=new JRadioButton();
		radFemale1.setBounds(210,130,20,20);
		
		
		//BUTTON GROUP
		btnRadio=new ButtonGroup();
		btnRadio.add(radMale1);
		btnRadio.add(radFemale1);
		
		
		//BUTTONS
		btnSubmit1=new JButton("SUBMIT");
		btnSubmit1.setBounds(400,600,100,30);
		btnSubmit1.addActionListener(this);
		
		btnBack1=new JButton("BACK");
		btnBack1.setBounds(200,600,100,30);
		btnBack1.addActionListener(this);
		
		fb = new JFileChooser();
		btnBrowse=new JButton("BROWSE");
		btnBrowse.setBounds(490,120,100,30);
		btnBrowse.addActionListener(this);
		txtBrowse = new JTextField();
		
		
		//PHOTO
		lblPhoto=new JLabel("   PHOTO HERE ");
		lblPhoto.setBounds(490,10,100,100);
		lblPhoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//file chooser
		fd = new JFileChooser();
		btnDoc = new JButton("ADD DOC.");
		btnDoc.setBounds(490,10,100,30);
		btnDoc.addActionListener(this);
				
		
		//PANELS
		//Top Panel
		panelTop=new JPanel();
		panelTop.setLayout(null);
		panelTop.setBounds(10, 10, 650, 100);
		panelTop.setBackground(Color.white);
		panelTop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//Adding to Top Panel
		panelTop.add(lblTitle1);
		
		//Middle Panel
		panelMiddle=new JPanel();
		panelMiddle.setLayout(null);
		panelMiddle.setBounds(10, 130, 650, 270);
		panelMiddle.setBackground(Color.white);
		panelMiddle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//Adding to Middle Panel
		panelMiddle.add(lblFirstName1);panelMiddle.add(lblLastName1);
		panelMiddle.add(lblDob1);panelMiddle.add(lblAddress1);
		panelMiddle.add(lblContact1);panelMiddle.add(txtContact1);
		panelMiddle.add(lblGender1);panelMiddle.add(txtFirstName1);panelMiddle.add(txtLastName1);
		panelMiddle.add(radMale1);panelMiddle.add(radFemale1);panelMiddle.add(lblRadMale1);panelMiddle.add(lblRadFemale1);
		panelMiddle.add(txtAddress1);
		panelMiddle.add(txtDate);panelMiddle.add(lblDateFormat);
		panelMiddle.add(lblPhoto);panelMiddle.add(btnBrowse);
		
		//Bottom Panel
		panelBottom=new JPanel();
		panelBottom.setLayout(null);
		panelBottom.setBounds(10, 410, 650, 180);
		panelBottom.setBackground(Color.white);
		panelBottom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//Adding to Bottom panel
		panelBottom.add(lblDepartment1);panelBottom.add(comboDept1);
		panelBottom.add(lblQualification1);panelBottom.add(txtQualification1);
		panelBottom.add(lblFacDesg1);panelBottom.add(comboFacDesg1);
		panelBottom.add(btnDoc);panelBottom.add(txtDoc);
		
		
		//Adding to Frame
		add(panelTop);
		add(panelMiddle);
		add(panelBottom);
		add(btnSubmit1);
		add(btnBack1);
		//add(btnNew1);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSubmit1)
		{
			String ch=null;
			if(radMale1.isSelected())
			{
			    ch="M";
			}
			else if(radFemale1.isSelected())
			{
				ch="F";
			}
			int flag=0;
				try
				{
					String f="No";
					String date1=txtDate.getText();
					SimpleDateFormat fr=new SimpleDateFormat("MM/dd/yyyy");
					java.util.Date myDate=fr.parse(date1);
					java.sql.Date sqlDate=new java.sql.Date(myDate.getTime());
		        
				
		        TeacherBean tb=new TeacherBean();
		        tb.setfName(txtFirstName1.getText());
				tb.setlName(txtLastName1.getText());
				tb.setDob(sqlDate);	
				tb.setAddr(txtAddress1.getText());
				tb.setDept((String) comboDept1.getSelectedItem());
				tb.setGender(ch);
				tb.setContact(txtContact1.getText());
				tb.setQual(txtQualification1.getText());
				tb.setDesig((String) comboFacDesg1.getSelectedItem());
				tb.setImg(file);
				
				Validate validate = new Validate();
				if( txtDoc.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Upload documents");
				}
				else if(validate.teacherValidation(tb) && flag==0){
							
				TeacherDaoImpl timpl=new TeacherDaoImpl();
				int rowAffected =timpl.addTeacher(tb);
				if(rowAffected==1)
				{
					
					JOptionPane.showMessageDialog(null, "Teacher with id : "+tb.getTid()+" successfully Saved");
					this.setVisible(false);
					new Admin().setVisible(true);
				}
				}}
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

		if(e.getSource()==btnBack1)
		{
			new Admin().setVisible(true);
			this.setVisible(false);
		}
		
		if(e.getSource()==btnDoc){
			int retval = fd.showOpenDialog(this);
			if(retval== JFileChooser.APPROVE_OPTION){
				java.io.File file= fd.getSelectedFile();
				txtDoc.setText(file.getName());
			}
		}
		
		if(e.getSource()==btnBrowse){
			int retval = fb.showOpenDialog(null);
			if(retval== JFileChooser.APPROVE_OPTION){
				file= fb.getSelectedFile();
				lblPhoto.setIcon(new ImageIcon(file.getAbsolutePath()));
			}
		}
		
		
	}

}
