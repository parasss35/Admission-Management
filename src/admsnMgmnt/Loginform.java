package admsnMgmnt;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import beans.AdminBean;
import beans.StudentBean;
import beans.TeacherBean;
import dao.AdminDaoImpl;
import dao.StudentDaoImpl;
import dao.TeacherDaoImpl;

import java.sql.*;

public class Loginform extends JFrame implements ActionListener,MouseListener {
	
	JFrame f;
	JLabel lUser, lPwd,back, logo,name,date; 
	JTextField tUser;
	JPasswordField tPwd;
	JButton bLogin, bReset, bCancel;
	JButton bStudent, bTeacher, bAdmin ,bStudent1,bTeacher1,bAdmin1;
	Font font;
	JPanel panel,pStudent,pLoginS,pLoginT,pLoginA,head,pTeacher,pAdmin,pAbout,pPic,panelContact;
	JMenuBar menuBar;
    JMenu home, aboutUs, contactUs, login;
    JMenuItem vission, pillars, gallery, medical;
    JLabel mapIcon, title, detailIcon,lHome;
    ImageIcon map, details;
    
    String s;
    CheckSlider checkSlider;
    int flagCheck = 0;
    
//////////////////////////////////////////////////////////////////////////////////////////////////////

	public  Loginform(){
		
		getContentPane().setBackground(Color.white);
		setBounds(10, 10, 1300, 700);
		setResizable(false);
		setLayout(null);
		setTitle("Welcome TO BPIT");
		
		Icon i = new ImageIcon("b10.jpg");
		back = new JLabel(i);
		setContentPane(back);
		
		
		
		
		//                   background image
	
		font = new Font("castellar",Font.BOLD,28);	
		head = new JPanel();
		head.setLayout(null);
		head.setBounds(0, 0, 1300, 100);
		
		Icon l = new ImageIcon("logo.jpeg");
		logo = new JLabel(l);
		logo.setBounds(0, 0, 150, 100);
		
		name =new JLabel("BHAGWAN PARSHURAM INSTITUTE OF TECHNOLOGY");
		name.setBounds(200,0,1000,100);
		name.setFont(font);

		head.add(logo);
		head.add(name);
		
		add(head);
////////////////////////////////////////////////////////////////////////////////////////	
			menuBar = new JMenuBar();
        
        //build first heading 
        home = new JMenu("HOME");
        menuBar.add(home);
        
        aboutUs = new JMenu("ABOUT US");
        menuBar.add(aboutUs);
        
        contactUs = new JMenu("CONTACT US");
        menuBar.add(contactUs);
        
        login = new JMenu("LOGIN");
        menuBar.add(login);
        
        //add the menu bar and the label to the frame
        setJMenuBar(menuBar);
///////////////////////////////////////////////////////////////////////////////////////////////
      	home.addMouseListener(this);
        login.addMouseListener(this);
        
        panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(50, 300, 1200, 350);
		
		Icon i1 = new ImageIcon("studen.jpg");
		bStudent = new JButton(i1);
		bStudent.setText("STUDENT");
	    bStudent.setHorizontalTextPosition(JLabel.CENTER);
		bStudent.setVerticalTextPosition(JLabel.BOTTOM);
		bStudent.setBounds(75, 25, 300, 300);
		
		Icon i2 = new ImageIcon("teacher.jpg");
		bTeacher = new JButton(i2);
		bTeacher.setText("TEACHER");
		bTeacher.setHorizontalTextPosition(JLabel.CENTER);
		bTeacher.setVerticalTextPosition(JLabel.BOTTOM);
		bTeacher.setBounds(450, 25, 300, 300);
		
		Icon i3 = new ImageIcon("admin.jpg");
		bAdmin = new JButton(i3);
		bAdmin.setText("ADMIN");
	    bAdmin.setHorizontalTextPosition(JLabel.CENTER);
		bAdmin.setVerticalTextPosition(JLabel.BOTTOM);
		bAdmin.setBounds(825, 25, 300, 300);
		
		panel.add(bStudent);
		panel.add(bTeacher);
		panel.add(bAdmin);		
		panel.setVisible(false);
		panel.setOpaque(false);
	    add(panel);
	/////////////////////////////////////////////////////////////////////////////////////////////
	    contactUs.addMouseListener(this);
		panelContact=new JPanel();
		panelContact.setLayout(null);
		panelContact.setBounds(50,150, 1200, 450);
		panelContact.setBackground(new Color(0,0,102));
		panelContact.setOpaque(false);
		panelContact.setVisible(false);
		
	
        
        Font font=new Font("Courier New",Font.BOLD,28);
        
        title = new JLabel("CONTACT US");
        title.setBounds(450,5,200,30);
        title.setFont(font);
        title.setForeground(Color.white);
        
        map = new ImageIcon("map.png");  
        mapIcon = new JLabel(map);       
        mapIcon.setBounds(10,40,717,347);
        
        details = new ImageIcon("contactDetails.png");
        detailIcon = new JLabel(details);
        detailIcon.setBounds(650,40,619,395);
        
        panelContact.add(mapIcon);
        panelContact.add(detailIcon);
        panelContact.add(title);
        
        add(panelContact);
	
		/////////////////////////////////////////////////////////////////////////////////////////
	    
	    checkSlider = new CheckSlider();
	    add(checkSlider);
	    
	    Icon ic = new ImageIcon("blah.PNG");
	    lHome = new JLabel(ic);
	    lHome.setBounds(800,125,400,425);
	    add(lHome);
	    	
	   /////////////////////////////////////////////////////////////////////////////////////////
		bStudent.addActionListener(this);
			
		pStudent = new JPanel();
		pStudent.setLayout(null);
		pStudent.setBounds(50, 300, 1200, 350);
		
		Icon i4 = new ImageIcon("studen.jpg");
		bStudent1 = new JButton(i4);
		bStudent1.setText("STUDENT");
	    bStudent1.setHorizontalTextPosition(JLabel.CENTER);
		bStudent1.setVerticalTextPosition(JLabel.BOTTOM);
		bStudent1.setBounds(75, 25, 300, 300);
			
		pLoginS  = new JPanel();
		pLoginS.setLayout(null);
		pLoginS.setBounds(600, 25, 450, 300);
		//pLoginS.setForeground(Color.orange);
		pLoginS.setOpaque(false);
		
		font = new Font("castellar",Font.BOLD,28);	
		
		lUser = new JLabel("LOGIN ID");
		lPwd =  new JLabel("PASSWORD");
		tUser = new JTextField();
		tPwd =  new JPasswordField();
		lUser.setFont(font);
		lPwd.setFont(font);
		bLogin = new JButton("LOGIN");
		bCancel = new  JButton("CANCEL");
		
		bReset = new JButton("RESET");
		
		lUser.setBounds(50, 30, 200, 30);
		lPwd.setBounds(50, 90, 200, 30);
		tUser.setBounds(260, 30, 100, 25);
		tPwd.setBounds(260, 90, 100, 25);
		bLogin.setBounds(25,180,100,50);
		bReset.setBounds(175,180,100,50);
		bCancel.setBounds(325,180,100,50);
		lUser.setForeground(Color.orange);
		lPwd.setForeground(Color.orange);
		bReset.addActionListener(this);
		bLogin.addActionListener(this);
        bCancel.addActionListener(this);
				
		pLoginS.add(lUser);
		pLoginS.add(lPwd);
		pLoginS.add(tUser);
		pLoginS.add(tPwd);
		pLoginS.add(bCancel);
		pLoginS.add(bLogin);
		pLoginS.add(bReset);
		
		pLoginS.setVisible(false);
		pStudent.setVisible(false);
		pStudent.setOpaque(false);
	
		pStudent.add(bStudent1);

		add(pStudent);
		
	///////////////////////////////////////////////////////////////////////////////////////
	
		bTeacher.addActionListener(this);
		
		pTeacher = new JPanel();
		pTeacher.setLayout(null);
		pTeacher.setBounds(50, 300, 1200, 350);
		
		Icon i5 = new ImageIcon("teacher.jpg");
		bTeacher1 = new JButton(i5);
		bTeacher1.setText("TEACHER");
		bTeacher1.setHorizontalTextPosition(JLabel.CENTER);
		bTeacher1.setVerticalTextPosition(JLabel.BOTTOM);
		bTeacher1.setBounds(75, 25, 300, 300);
		
		pTeacher.setVisible(false);
		pTeacher.setOpaque(false);	
		pTeacher.add(bTeacher1);
		add(pTeacher);
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		
		bAdmin.addActionListener(this);
		
		pAdmin = new JPanel();
		pAdmin.setLayout(null);
		pAdmin.setBounds(50, 300, 1200, 350);
		
		Icon i6 = new ImageIcon("admin.jpg");
		bAdmin1 = new JButton(i6);
		bAdmin1.setText("ADMIN");
		bAdmin1.setHorizontalTextPosition(JLabel.CENTER);
		bAdmin1.setVerticalTextPosition(JLabel.BOTTOM);
		bAdmin1.setBounds(75, 25, 300, 300);
		
		pAdmin.setVisible(false);
		pAdmin.setOpaque(false);
		pAdmin.add(bAdmin1);
		add(pAdmin);
//////////////////////////////////////////////////////////////////////////////////////////////////////////
		aboutUs.addMouseListener(this);
		
		pAbout = new JPanel();
		pAbout.setLayout(null);
		pAbout.setBounds(50, 150, 1200,450);
		JLabel heading, pic, sidetext;
		heading = new JLabel("College Profile");
		Icon iCollege = new ImageIcon("parshuram.jpg");
		pic = new JLabel(iCollege);
		String text = "<html>In view of the national and international"
				+ " scenario of the growing demand of qualified technical personnel "
				+ "in different streams of engineering technology and management, Bhartiya"
				+ " Brahmin Charitable Trust in 2005 laid the foundation of Bhagwan Parshuram"
				+ " Institute of Technology (BPIT). BPIT is approved by the Ministry of Human"
				+ " Resource Development, Government of India and the Directorate of Training"
				+ " and Technical Education, Government of National Capital Territory, Delhi."
				+ " It is affiliated to Guru Gobind Singh Indraprastha University, Delhi and "
				+ "offers courses of Bachelor of Technology (B.Tech) and Master of"
				+ " Business Administration (MBA), which are approved by the All India Council"
				+ " of Technical Education (AICTE).<br> BPIT is spread in an area of about 5.7 acres "
				+ "and has four storey building of academic and office complex with lifts. "
				+ "A girl student's Hostel having 64 double occupancy rooms, with "
				+ "all modern amenities has been constructed and furnished and it will be functional"
				+ " from the session 2011-12.<br>There are well equipped spacious classrooms, drawing halls, "
				+ "laboratories, workshops and conference/seminar halls. A well stacked large library having "
				+ "state of art facilities has been developed. Laboratories and workshops have the best quality "
				+ "of equipments commensurate with the requirements of the curriculum of IP University and beyond."
				+ " There are eight computer laboratories, each equipped with the required number of computers, having"
				+ " latest hardware configuration and the latest software's. All the computers are networked through"
				+ " formatted LAN. Wi-Fi connectivity with a "
				+ "high speed RF link of 2 Mbps provide excellent internet facility in the entire campus.</html>";
		Font f2 = new Font("Times New Roman",0,18);
		
		sidetext = new JLabel(text);
		sidetext.setBackground(Color.white);
		sidetext.setFont(f2);
		
		Font f1= new Font("times new roman",Font.BOLD,24);
		heading.setBounds(500,10,350,50);
		heading.setFont(f1);
		pic.setBounds(10,50,200,350);
		sidetext.setBounds(230,50,900,350);
		
		pAbout.add(heading);
		pAbout.add(pic);
		pAbout.add(sidetext);
		
		pAbout.setVisible(false);
		add(pAbout);
		
		setVisible(true);
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource()==bStudent){
			
			bStudent.setVisible(false);	
			bTeacher.setVisible(false);
			bAdmin.setVisible(false);
			pLoginS.setVisible(true);
			pStudent.setVisible(true);
			pStudent.add(pLoginS);
			s="student";
			flagCheck=1;
		}
		
		if(a.getSource()==bTeacher){
			bStudent.setVisible(false);	
			bTeacher.setVisible(false);
			bAdmin.setVisible(false);
			pLoginS.setVisible(true);
			pTeacher.setVisible(true);
			pTeacher.add(pLoginS);
			s="teacher";
			flagCheck = 1;
			
		}
		
		if(a.getSource()==bAdmin){
			bStudent.setVisible(false);	
			bTeacher.setVisible(false);
			bAdmin.setVisible(false);
			pLoginS.setVisible(true);
			pAdmin.setVisible(true);
			pAdmin.add(pLoginS);
			s="admin";
			flagCheck = 1;
			
		}
		if(a.getSource()==bCancel){
			pStudent.setVisible(false);	
			pTeacher.setVisible(false);
			pAdmin.setVisible(false);
			pLoginS.setVisible(false);
			bStudent.setVisible(true);	
			bTeacher.setVisible(true);
			bAdmin.setVisible(true);
			tUser.setText(null);
			tPwd.setText(null);

			flagCheck = 0;
			
		}
		
		if(a.getSource()==bLogin){
			
			if(s=="teacher"){
				TeacherBean tb=new TeacherBean();
				TeacherDaoImpl tdi=new TeacherDaoImpl();
				int flag=0;
				try {
					Integer.parseInt(tPwd.getText());
					if(flag==0){
					tb=tdi.validateTeacher(Integer.parseInt(tPwd.getText()), tUser.getText());
					if(tb.getfName()==null)
					{
						JOptionPane.showMessageDialog(null, "Teacher account doesn't exist");
						tPwd.setText("");
						tUser.setText("");
					}
					else
					{
						tb=tdi.displayTeacher(Integer.parseInt(tPwd.getText()));
					new Teacher(tb).setVisible(true);
					setVisible(false);
					}}
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Password must be number");
				}
		}
			if(s=="student"){
					StudentBean st=new StudentBean();
					
				//	st.setEnrollNo(Integer.parseInt(tPwd.getText()));
					
					StudentDaoImpl stdi=new StudentDaoImpl();
					int flag=0;
					try {
						Integer.parseInt(tPwd.getText());
						if(flag==0){
						st=stdi.validateStudent(Integer.parseInt(tPwd.getText()),tUser.getText());
						if(st.getfName()==null)
						{
							JOptionPane.showMessageDialog(null, "Student account doesn't exist");
							tPwd.setText("");
							tUser.setText("");
						}
						else
						{	
							st=stdi.displayStudent(Integer.parseInt(tPwd.getText()));
						new Student(st).setVisible(true);
						setVisible(false);
						}}
					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Password must be number");
						flag=1;
					}
			}
			if(s=="admin"){
				AdminBean adb=new AdminBean();
				AdminDaoImpl adi=new AdminDaoImpl();
				int flag=0;
				try {
					adb.setUsername(tUser.getText());
					adb.setPassword(tPwd.getText());
					if(flag==0)
					{
					adb=adi.displayAdmin(tUser.getText(),tPwd.getText());
					if(adb.getPassword()==null)
					{
						JOptionPane.showMessageDialog(null, "This account doesn't exist");
						tPwd.setText("");
						tUser.setText("");
					}
					else
					{
					new Admin().setVisible(true);
					setVisible(false);
					}
				} }
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Password mmust be a number");
					flag=1;
				}
				
				catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
			
		}

		if(a.getSource()==bReset){
			tUser.setText(null);
			tPwd.setText(null);
		}
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(flagCheck == 1)
		{
			pStudent.setVisible(false);	
			pTeacher.setVisible(false);
			pAdmin.setVisible(false);
			pLoginS.setVisible(false);
			bStudent.setVisible(true);	
			bTeacher.setVisible(true);
			bAdmin.setVisible(true);
			flagCheck = 0;
		}
		
		if(e.getSource()==home){
			panel.setVisible(false);
			pAbout.setVisible(false);
			pStudent.setVisible(false);
			pTeacher.setVisible(false);
			pAdmin.setVisible(false);
			panelContact.setVisible(false);
			checkSlider.visibility(1);
			lHome.setVisible(true);
		}
		
		if(e.getSource()==login){
			panel.setVisible(true);
			pAbout.setVisible(false);
			checkSlider.visibility(0);
			lHome.setVisible(false);
			panelContact.setVisible(false);
		}
		
		if(e.getSource()==aboutUs){
			pAbout.setVisible(true);
			panel.setVisible(false);
			pStudent.setVisible(false);
			pTeacher.setVisible(false);
			pAdmin.setVisible(false);
			checkSlider.visibility(0);
			lHome.setVisible(false);
			panelContact.setVisible(false);
		}
		if(e.getSource()==contactUs){
			panelContact.setVisible(true);
			pAbout.setVisible(false);
			panel.setVisible(false);
			pStudent.setVisible(false);
			pTeacher.setVisible(false);
			pAdmin.setVisible(false);
			lHome.setVisible(false);
			checkSlider.visibility(0);
		}
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
