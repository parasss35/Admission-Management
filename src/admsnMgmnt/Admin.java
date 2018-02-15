package admsnMgmnt;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.peer.MenuItemPeer;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;


public class Admin extends JFrame implements ActionListener,MouseListener{
    
    JMenuBar adminMenuBar;
    JMenu  details, fee, delete;
    JMenuItem  studentDetails, teacherDetails,studentDelete,teacherDelete;
    JButton bStudent, bTeacher,blog;
    JPanel panel;
    JLabel lTop,lTop1, back ,lPic, lname,lReg;
    
  ///////////////////////////////////////////////////////////////////////////////////////
    public Admin(){
    	getContentPane();
		setBounds(10, 10, 1300, 700);
		setResizable(false);
		setLayout(null);
		
		Icon i = new ImageIcon("b2.jpg");
		back = new JLabel(i);
		setContentPane(back);                          //                   background image
	
		
	    Icon i1 = new ImageIcon("b1.jpg");
		lTop = new JLabel(i1);
		lTop.setBounds(0, 0, 1300, 150);
		add(lTop);
	
		Font f = new Font("SansSerif",Font.BOLD,44);
		lname= new JLabel("Registration");
		lname.setBounds(500, 170, 300, 60);
		lname.setFont(f);
		lname.setForeground(Color.BLUE);
		add(lname);
	
        Icon i3 = new ImageIcon("studen.jpg");
		bStudent = new JButton(i3);
		bStudent.setText("STUDENT");
	    bStudent.setHorizontalTextPosition(JLabel.CENTER);
		bStudent.setVerticalTextPosition(JLabel.BOTTOM);
		bStudent.setBounds(250, 300, 300, 300);
		add(bStudent);
		
		Icon i4 = new ImageIcon("teacher.jpg");
		bTeacher = new JButton(i4);
		bTeacher.setText("TEACHER");
		bTeacher.setHorizontalTextPosition(JLabel.CENTER);
		bTeacher.setVerticalTextPosition(JLabel.BOTTOM);
		bTeacher.setBounds(700, 300, 300, 300);
		add(bTeacher);
		

		blog = new JButton("LOG OUT");
		blog.setBounds(1150,170,90,30);
		add(blog);
		blog.addActionListener(this);
		
		bStudent.addActionListener(this);
		bTeacher.addActionListener(this);
		
		
    /////////////////////////////////////////////////////////////////////////////////////
        adminMenuBar = new JMenuBar();
        
        //build first heading 
        
        details = new JMenu("DETAILS");
        adminMenuBar.add(details);
        
        fee = new JMenu("FEE");
        adminMenuBar.add(fee);
        fee.addMouseListener(this);
        
        delete = new JMenu("DELETE");
        adminMenuBar.add(delete);
        
        //add a sub menu 
        
        teacherDetails = new JMenu("Teacher");
        details.add(teacherDetails);
        teacherDetails.addMouseListener(this);
        
        studentDetails = new JMenu("Student");  
        details.add(studentDetails);
        studentDetails.addMouseListener(this);
        
        teacherDelete = new JMenu("Teacher");
        delete.add(teacherDelete);
        teacherDelete.addMouseListener(this);
        
        studentDelete = new JMenu("Student");  
        delete.add(studentDelete);
        studentDelete.addMouseListener(this);
        
        //add the menu bar and the label to the frame
        this.setJMenuBar(adminMenuBar);
        
		setVisible(true);
    }
///////////////////////////////////////////////////////////////////////////
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bStudent){
			new StudentAdmission().setVisible(true);
			setVisible(false);	
		}
		
		if(e.getSource()==bTeacher){
			new TeacherAdmsn().setVisible(true);
			setVisible(false);	
		}
		
		if(e.getSource()==blog){			
			new Loginform().setVisible(true);
			setVisible(false);			
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String s="";
		if(e.getSource()==studentDetails){
			new EnrollNoDisplay().setVisible(true);
		}
		
		if(e.getSource()==teacherDetails){
			new EnrollNoDisplay().setVisible(true);
		}
		
		if(e.getSource()==fee){
			new AdminFeeTab().setVisible(true);
		}
		
		if(e.getSource()==teacherDelete){
			new EnrollNoDelete().setVisible(true);
		}
		
		if(e.getSource()==studentDelete){
			new EnrollNoDelete().setVisible(true);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}	
/////////////////////////////////////////////////////////////////////////////
	