package admsnMgmnt;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import beans.StudentBean;
import dao.StudentDaoImpl;
import dao.TeacherDaoImpl;

import java.sql.*;
public class EnrollNoDelete extends JFrame implements ActionListener {

	JTextField txtEnroll1;
	JLabel lblEnroll1,lblTitle;
	JButton btnSubmit1,btnBack1;
	JPanel pan1;
	
	public EnrollNoDelete(){
		
		getContentPane();
		setBounds(400,180,400,360);
		setResizable(false);
		setLayout(null);
		Font font=new Font("Courier New",Font.BOLD,16);
		
		txtEnroll1=new JTextField();
		txtEnroll1.setBounds(170,30,100,25);
		txtEnroll1.setFont(font);
		
		lblEnroll1=new JLabel("ID");
		lblEnroll1.setBounds(40,30,100,30);
		lblEnroll1.setFont(font);
		
		Font f=new Font("Algerian",Font.BOLD,28);
		lblTitle=new JLabel("Delete");
		lblTitle.setBounds(150,20,150,40);
		lblTitle.setFont(f);
		
		btnSubmit1=new JButton("SUBMIT");
		btnSubmit1.setBounds(60,100,100,40);
		btnSubmit1.addActionListener(this);
		
		btnBack1=new JButton("BACK");
		btnBack1.setBounds(200,100,100,40);
		btnBack1.addActionListener(this);
		
		pan1=new JPanel();
		pan1.setLayout(null);
		pan1.setBounds(10,100,350,200);
		pan1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pan1.setBackground(Color.WHITE);
		
		pan1.add(lblEnroll1);pan1.add(txtEnroll1);pan1.add(btnSubmit1);pan1.add(btnBack1);
		add(pan1);add(lblTitle);
		
		setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnSubmit1)
		{
			int n=Integer.parseInt(txtEnroll1.getText());
			if(n<800)
			{	
				StudentDaoImpl stdi=new StudentDaoImpl();
				try {
					int st=stdi.deleteStudent(n);
					if(st>0){
						JOptionPane.showMessageDialog(null, "Successfully deleted");
						this.setVisible(false);
						
					}
					
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}
			if(n>800)
			{
				TeacherDaoImpl tdi=new TeacherDaoImpl();
				try {
					int t=tdi.deleteTeacher(n);
					if(t>0){
						JOptionPane.showMessageDialog(null, "Successfully deleted");
						this.setVisible(false);
						
					}
					
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}
		
	}
		
		if(e.getSource()==btnBack1)
		{			
			this.setVisible(false);
		}
}
}