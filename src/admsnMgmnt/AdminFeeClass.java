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

public class AdminFeeClass extends JFrame implements ActionListener{
    
    	JPanel panel, panel1;
    	JLabel lblTitle, lblFirstYear, lblSecondYear, lblThirdYear, lblFourthYear, lblInstruction,lblEnrollNo;
    	JComboBox<String>  comboFirstYear, comboSecondYear, comboThirdYear, comboFourthYear;
    	JTextField txtUploadedFile,txtEnrollNo;
    	JButton btnSubmit, btnBack, btnUpload;
    	JFileChooser fc;
    	 
    	public AdminFeeClass(StudentBean stb){

        setBounds(10,10,700,700);
        setLayout(null);
        setResizable(true);
        
        lblTitle = new JLabel("FEES DETAILS");
        lblEnrollNo=new JLabel("ENROLLMENT NO.");
        lblFirstYear = new JLabel("FIRST YEAR");
        lblSecondYear = new JLabel("SECOND YEAR");
        lblThirdYear = new JLabel("THIRD YEAR");
        lblFourthYear = new JLabel("FOURTH YEAR");
        txtEnrollNo=new JTextField();
        comboFirstYear = new JComboBox<>();
        comboFirstYear.setModel(new DefaultComboBoxModel<>(new String[] { "NO","YES"}));
        
        btnSubmit = new JButton("SUBMIT");
        btnUpload = new JButton("UPLOAD");
        btnBack = new JButton("BACK");
        
        txtUploadedFile = new JTextField("");
        
        lblInstruction = new JLabel("* Kindly upload your 12th mark sheet in pdf format");
        
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
        
        lblEnrollNo.setBounds(170,20,180,20);
        lblEnrollNo.setFont(labelFont);
        txtEnrollNo.setBounds(320,20,130,20);
        
        lblFirstYear.setBounds(170,100,130,20);
        lblFirstYear.setFont(labelFont);
        comboFirstYear.setBounds(320,100,130,20);
        
        lblSecondYear.setBounds(170,80,130,20);
        lblSecondYear.setFont(labelFont);
        
        lblThirdYear.setBounds(170,110,130,20);
        lblThirdYear.setFont(labelFont);
        
        lblFourthYear.setBounds(170,140,130,20);
        lblFourthYear.setFont(labelFont);
        
        btnUpload.setBounds(170,200,130,20);
        btnUpload.setFont(labelFont);
        
        txtUploadedFile.setBounds(320,200,200,20);
        txtUploadedFile.setFont(labelFont);
        
        lblInstruction.setBounds(160,230,500,20);
        lblInstruction.setFont(labelFont);
        
        btnSubmit.setBounds(500,400,100,20);
        btnSubmit.setFont(labelFont);
        btnSubmit.addActionListener(this);
        
        btnBack.setBounds(50,400,100,20);
        btnBack.setFont(labelFont);
        btnBack.addActionListener(this);
        
        fc = new JFileChooser();
        
        btnUpload.setBounds(170,200,130,20);
        btnUpload.setFont(labelFont);
        btnUpload.addActionListener(this);
        
        txtUploadedFile.setBounds(320,200,200,20);
        txtUploadedFile.setFont(labelFont);

        panel1.add(lblEnrollNo);
        panel1.add(txtEnrollNo);
        panel1.add(lblFirstYear);   
            
        panel1.add(comboFirstYear); 
        panel1.add(btnSubmit);
		panel1.add(btnBack);
        panel1.add(btnUpload);
        panel1.add(txtUploadedFile);
        panel1.add(lblInstruction);
        
        add(panel);
        add(panel1);
        
        txtEnrollNo.setText(Integer.toString(stb.getEnrollNo()));
        txtEnrollNo.setEditable(false);
        setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==btnSubmit)
    	{
    		StudentBean stb=new StudentBean();
    		int enrollNo=Integer.parseInt(txtEnrollNo.getText());
    		stb.setEnrollNo(enrollNo);
    		stb.setFee1((String)comboFirstYear.getSelectedItem());
    		stb.setFee2("NO");
    		stb.setFee3("NO");
    		stb.setFee4("NO");
    		StudentDaoImpl stdi=new StudentDaoImpl();
    		try {
				int rowAffected=stdi.feeUpdateStudent(enrollNo, stb);
				if( txtUploadedFile.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Upload documents");
				}
				else if(rowAffected>0)
				{
					JOptionPane.showMessageDialog(null, "Inserted Successfully");
					new Admin().setVisible(true);
					setVisible(false);
				}
			} catch (SQLException | IOException e1) {
				e1.printStackTrace();
			}
    		}
    	if(e.getSource()==btnBack)
    	{
    		this.setVisible(false);
    	}
    	
    	if(e.getSource()==btnUpload){
			int retval = fc.showOpenDialog(null);
			if(retval== JFileChooser.APPROVE_OPTION){
				java.io.File file= fc.getSelectedFile();
				txtUploadedFile.setText(file.getName());
			}
		}
         
    }
 }
