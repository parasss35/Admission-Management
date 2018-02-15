package admsnMgmnt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import beans.StudentBean;
import beans.TeacherBean;

public class Teacher extends JFrame implements ActionListener{
	
	JPanel panel1;
	JLabel lTop,lTop1, back ,lPic, lName;
	JButton blog;
	JLabel lblID,lblDob,lblAddress,lblGender,lblContact,lblDept,lblQualif,lblDesign,lblDateFormat;
    JTextField txtID,txtContact, txtGender, txtDOB, txtDept,txtQualif,txtDesign;
    JTextArea  txtAddress;
	
	public Teacher(){}
	public Teacher(TeacherBean tb) {
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

	private void initComponents() {
		
getContentPane();
setBounds(10, 10, 1300, 700);
setResizable(false);
setLayout(null);
setTitle("Welcome TO BPIT");

Font f = new Font("SansSerif",Font.BOLD,28);
Icon i = new ImageIcon("b2.jpg");
back = new JLabel(i);
setContentPane(back);                          //                   background image


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
lName.setForeground(Color.BLUE);;
add(lName);


blog = new JButton("LOG OUT");
blog.setBounds(1150,170,90,30);
add(blog);
blog.addActionListener(this);

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
lblDateFormat=new JLabel("* MM/dd/yyyy");

txtID = new JTextField();
txtDept = new JTextField();
txtDOB= new JTextField();
txtGender = new JTextField();
txtAddress=new JTextArea(200,10);
txtContact=new JTextField();
txtQualif=new JTextField();
txtDesign=new JTextField();

Font labelFont = new Font("Georgia",Font.BOLD,14);
panel1.add(lblID);panel1.add(txtID);
panel1.add(lblDob);panel1.add(txtDOB);
panel1.add(lblContact);panel1.add(txtContact);
panel1.add(lblGender);panel1.add(txtGender);
panel1.add(lblAddress);panel1.add(txtAddress);
panel1.add(lblDept);panel1.add(txtDept);
panel1.add(lblDesign);panel1.add(txtDesign);
panel1.add(lblQualif);panel1.add(txtQualif);
panel1.add(lblDateFormat);

 lblID.setBounds(30,10,150,20);
    lblID.setFont(labelFont);
	txtID.setBounds(230,10,150,20);
    txtID.setEditable(false);
    txtID.setFont(labelFont);

    Font font = new Font("Georgia",Font.BOLD,12);
	lblDob.setBounds(30,50,150,20);
    lblDob.setFont(labelFont);
    txtDOB.setBounds(230,50,150,20);
    txtDOB.setEditable(false);
    txtDOB.setFont(labelFont);
    lblDateFormat.setBounds(390,50,150,20);
    lblDateFormat.setFont(font);

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
		if(a.getSource()==blog){			
			new Loginform().setVisible(true);
			setVisible(false);
			
		}
		
	}
}



