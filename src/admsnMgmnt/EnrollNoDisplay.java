package admsnMgmnt;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import beans.StudentBean;
import beans.TeacherBean;
import dao.StudentDaoImpl;
import dao.TeacherDaoImpl;

import java.sql.*;
public class EnrollNoDisplay extends JFrame implements ActionListener {

	JTextField txtEnroll;
	JLabel lblEnroll;
	JButton btnSubmit,btnBack;
	JPanel pan;
	
	public EnrollNoDisplay(){
		
		getContentPane();
		setBounds(400,180,350,200);
		setResizable(false);
		setLayout(null);
		Font font=new Font("Courier New",Font.BOLD,16);
		
		txtEnroll=new JTextField();
		txtEnroll.setBounds(170,30,100,25);
		txtEnroll.setFont(font);
		
		lblEnroll=new JLabel("ID");
		lblEnroll.setBounds(40,30,100,30);
		lblEnroll.setFont(font);
		
		btnSubmit=new JButton("SUBMIT");
		btnSubmit.setBounds(60,100,100,40);
		btnSubmit.addActionListener(this);
		
		btnBack=new JButton("BACK");
		btnBack.setBounds(200,100,100,40);
		btnBack.addActionListener(this);
		
		pan=new JPanel();
		pan.setLayout(null);
		pan.setBounds(0,0,350,200);
		pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pan.setBackground(Color.WHITE);
		
		pan.add(lblEnroll);
		pan.add(txtEnroll);
		pan.add(btnSubmit);
		pan.add(btnBack);
		
		add(pan);
		
		setVisible(true);	
	}
		@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnSubmit)
			{
			int n=Integer.parseInt(txtEnroll.getText());
				if(n<800)
				{	
					StudentDaoImpl stdi=new StudentDaoImpl();
					try {
						
						StudentBean st=stdi.displayStudent(n);
						if(st.getfName()==null){
							JOptionPane.showMessageDialog(null, "Student details doesn't exist");
							this.setVisible(false);
						}
						else
						{
						this.setVisible(false);	
						new AdminSD(st);
						}
					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
					}
				}
				else if(n>800)
				{	
					TeacherDaoImpl tdi=new TeacherDaoImpl();
					try {
						TeacherBean tb=tdi.displayTeacher(n);
						if(tb.getfName()==null)
						{
							JOptionPane.showMessageDialog(null, "Teacher details doesn't exist");
							this.setVisible(false);
						}
						else
						{
							this.setVisible(false);
						new AdminTD(tb);
						}
					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}	
				
		if(e.getSource()==btnBack)
		{			
			this.setVisible(false);
		}
	}
	}
