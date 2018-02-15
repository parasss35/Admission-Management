package admsnMgmnt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CheckSlider extends JPanel{
	private static final long serialVersionUID = 1L;
	private int counter = 0;
	private ImageIcon[] image = new ImageIcon[6];
	private JLabel label;

  public CheckSlider(){

	  setBounds(100,150,600,400);
	  setLayout(null);
	  setBackground(Color.BLACK);
   for(int i = 1; i <= 6; ++ i)
       image[counter++] = new ImageIcon("img" + i + ".jpg");

   label = new JLabel();
   label.setBounds(0,0,600,400);
   add(label);
   Timer timer = new Timer(1000, new TimerListener());
   timer.start();
  }
  
  void visibility(int flag)
  {
	  if(flag==1)
	  {
		  setVisible(true);
	  }
	  else
	  {
		  setVisible(false);
	  }
  }
   class TimerListener implements ActionListener{
       
    @Override
    public void actionPerformed(ActionEvent e){

      counter++;
      counter %= image.length;
      label.setIcon(image[counter]); 

    }
   }
}

