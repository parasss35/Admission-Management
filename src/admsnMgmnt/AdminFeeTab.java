package admsnMgmnt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;

import beans.StudentBean;
import dao.StudentDaoImpl;

public class AdminFeeTab extends JFrame implements ActionListener{
    
    JPanel panel, panel1;
    JLabel lblTitle, lblFirstYear, lblSecondYear, lblThirdYear, lblFourthYear, lblEnrolNo,lblYear;
    JComboBox<String>  comboFirstYear, comboSecondYear, comboThirdYear, comboFourthYear;
    JTextField txtEnrolNo,txtYear;
    JButton btnSubmit, btnBack,btnSearch;
    
    public AdminFeeTab(){
	setBounds(10,10,700,700);
	setLayout(null);
        setResizable(true);
        
        lblTitle = new JLabel("FEE RECEIPT DETAILS");
        lblFirstYear = new JLabel("FIRST YEAR");
        lblSecondYear = new JLabel("SECOND YEAR");
        lblThirdYear = new JLabel("THIRD YEAR");
        lblFourthYear = new JLabel("FOURTH YEAR");
        lblYear=new JLabel("YEAR");
        lblEnrolNo = new JLabel("ENROLLMENT NO");
        
        comboFirstYear = new JComboBox<>();
        comboFirstYear.setModel(new DefaultComboBoxModel<>(new String[] { "NO","YES"}));

        comboSecondYear = new JComboBox<>();
        comboSecondYear.setModel(new DefaultComboBoxModel<>(new String[] { "NO","YES"}));

        comboThirdYear = new JComboBox<>();
        comboThirdYear.setModel(new DefaultComboBoxModel<>(new String[] { "NO","YES"}));

        comboFourthYear = new JComboBox<>();
        comboFourthYear.setModel(new DefaultComboBoxModel<>(new String[] { "NO","YES"}));

        
        btnSubmit = new JButton("SUBMIT");
        btnBack = new JButton("BACK");
        btnSearch=new JButton("SEARCH");
        
        txtEnrolNo = new JTextField("");
        txtYear=new JTextField("");
        
        
        
        panel=new JPanel();
	panel.setLayout(null);
	panel.setBounds(10, 10, 650, 100);
	panel.setBackground(Color.white);
        
	Font titleFont = new Font("Courier New",Font.BOLD,34);
        
        panel.add(lblTitle);
	lblTitle.setBounds(130,20,500,70);
	lblTitle.setFont(titleFont);
        
        
        Font labelFont = new Font("Arial Black",Font.BOLD,12);
        
        panel1=new JPanel();
        panel1.setLayout(null);
		panel1.setBounds(10, 150, 650, 450);
		panel1.setBackground(Color.white);
        
		lblYear.setBounds(170,80,130,20);
		lblYear.setFont(labelFont);
		txtYear.setBounds(320,80,130,20);
		txtYear.setEditable(false);
		
        lblFirstYear.setBounds(170,110,130,20);
        lblFirstYear.setFont(labelFont);
        comboFirstYear.setBounds(320,110,130,20);
        
        lblSecondYear.setBounds(170,140,130,20);
        lblSecondYear.setFont(labelFont);
        comboSecondYear.setBounds(320,140,130,20);
        
        lblThirdYear.setBounds(170,170,130,20);
        lblThirdYear.setFont(labelFont);
        comboThirdYear.setBounds(320,170,130,20);
        
        lblFourthYear.setBounds(170,200,130,20);
        lblFourthYear.setFont(labelFont);
        comboFourthYear.setBounds(320,200,130,20);
        
        txtEnrolNo.setBounds(320,20,130,20);
        txtEnrolNo.setFont(labelFont);
        
        lblEnrolNo.setBounds(170,20,130,20);
        lblEnrolNo.setFont(labelFont);
        lblEnrolNo.setFont(labelFont);
        
        btnSubmit.setBounds(500,400,100,20);
        btnSubmit.setFont(labelFont);
        
        btnBack.setBounds(50,400,100,20);
        btnBack.setFont(labelFont);
        
        btnSearch.setBounds(510,20,100,30);
        
        panel1.add(lblFirstYear);   
        panel1.add(lblSecondYear); 
        panel1.add(lblThirdYear);      
        panel1.add(lblFourthYear);       
        panel1.add(comboFirstYear); 
        panel1.add(comboSecondYear); 
        panel1.add(comboThirdYear); 
        panel1.add(comboFourthYear);
		panel1.add(btnSubmit);
		panel1.add(btnBack);
		panel1.add(btnSearch);
        panel1.add(txtEnrolNo);
        panel1.add(lblEnrolNo);
        panel1.add(lblYear);
        panel1.add(txtYear);
        
        btnBack.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnSearch.addActionListener(this);
        
        add(panel);
	add(panel1);
	setVisible(true);
       
    }
     public void actionPerformed(ActionEvent e)
     {
    	if(e.getSource()==btnBack){
            setVisible(false);
        }
        if(e.getSource()==btnSubmit){
        	int enrollno=Integer.parseInt(txtEnrolNo.getText());
        	StudentBean stb=new StudentBean();
        	stb.setFee1((String)comboFirstYear.getSelectedItem());
        	stb.setFee2((String)comboSecondYear.getSelectedItem());
        	stb.setFee3((String)comboThirdYear.getSelectedItem());
        	stb.setFee4((String)comboFourthYear.getSelectedItem());
        	StudentDaoImpl stdi=new StudentDaoImpl();
        	try {
				int rowAffected=stdi.feeUpdateStudent(enrollno, stb);
				if(rowAffected>0)
				{
					JOptionPane.showMessageDialog(null, "Fees Status Updated");
					this.setVisible(false);
				}
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        if(e.getSource()==btnSearch)
        {
        	int enrollno=Integer.parseInt(txtEnrolNo.getText());
        	StudentBean stb=new StudentBean();
        	StudentDaoImpl stdi=new StudentDaoImpl();
        	try {
				stb=stdi.displayStudent(enrollno);
				if(stb.getfName()!=null)
				{
				comboFirstYear.setSelectedItem(stb.getFee1());
				if(comboFirstYear.getSelectedItem()=="YES")
					comboFirstYear.setEnabled(false);
				comboSecondYear.setSelectedItem(stb.getFee2());
				if(comboSecondYear.getSelectedItem()=="YES")
					comboSecondYear.setEnabled(false);
	        	comboThirdYear.setSelectedItem(stb.getFee3());
	        	if(comboThirdYear.getSelectedItem()=="YES")
					comboThirdYear.setEnabled(false);
	        	comboFourthYear.setSelectedItem(stb.getFee4());
	        	if(comboFourthYear.getSelectedItem()=="YES")
					comboFourthYear.setEnabled(false);
	        	txtYear.setText(String.valueOf(stb.getYear()));
			}
        	else
        	{
        		JOptionPane.showMessageDialog(null, "Enrollment Number not Found");
        		txtEnrolNo.setText("");
        	}}
        	catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    
  
}
}