package admsnMgmnt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

import beans.StudentBean;
import dao.StudentDaoImpl;

public class FeeDetails extends JFrame implements ActionListener {
	
	JLabel head,l1,l2,l3,l4,lf,ls,lt,lfo;
	JButton back;
	JPanel panel,panel1;
	
	public FeeDetails(){}
	public FeeDetails(int enrollno) throws SQLException, IOException {
		initComponents();
		StudentBean stb=new StudentBean();
		StudentDaoImpl stdi=new StudentDaoImpl();
		stb=stdi.displayStudent(enrollno);
		lf.setText(stb.getFee1());
		ls.setText(stb.getFee2());
		lt.setText(stb.getFee3());
		lfo.setText(stb.getFee4());
		add(panel);
        add(panel1);

setVisible(true);
	}
	private void initComponents() {
		getContentPane();
		setBounds(10, 10, 400, 400);
		setResizable(false);
		setLayout(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 385, 50);
        panel.setBackground(Color.white);
                
        Font titleFont = new Font("Courier New",Font.BOLD,28);

        head = new JLabel("FEE DETAILS");
        head.setBounds(100, 10, 200, 30);
        head.setForeground(Color.black);
                
        panel.add(head);
        head.setFont(titleFont);

		
        Font f1 = new Font("Courier New",Font.BOLD,16);
                
        panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 75, 385, 290);
      	panel1.setBackground(Color.white);
                
		back = new JButton("BACK");
		back.setBounds(145,220,100,20);
		add(back);
		
		l1 = new JLabel("FIRST YEAR");
		l1.setBounds(80, 20, 120, 30);
		l1.setFont(f1);
		add(l1);
		
		lf = new JLabel("First Sem.");
		lf.setBounds(210, 20, 120, 30);
		lf.setFont(f1);
		add(lf);
			
		l2 = new JLabel("SECOND YEAR");
		l2.setBounds(80, 70, 120, 30);
		l2.setFont(f1);
		add(l2);
		
		ls = new JLabel("Second Sem.");
		ls.setBounds(210, 70, 120, 30);
		ls.setFont(f1);
		add(ls);

		l3 = new JLabel("THIRD YEAR");
		l3.setBounds(80, 120, 120, 30);
		l3.setFont(f1);
		add(l3);

		lt = new JLabel("Third Sem.");
		lt.setBounds(210, 120, 120, 30);
		lt.setFont(f1);
		add(lt);

		l4 = new JLabel("FOURTH YEAR");
		l4.setBounds(80, 170, 120, 30);
		l4.setFont(f1);
		add(l4);
		
		lfo = new JLabel("Fourth Sem.");
		lfo.setBounds(210, 170, 120, 30);
		lfo.setFont(f1);
		add(lfo);
		back.addActionListener(this);
                
                panel1.add(l1);
                panel1.add(l2);
                panel1.add(l3);
                panel1.add(l4);
                panel1.add(lf);
                panel1.add(ls);
                panel1.add(lt);
                panel1.add(lfo);
                panel1.add(back);
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==back){
			setVisible(false);
		}
	}
}
