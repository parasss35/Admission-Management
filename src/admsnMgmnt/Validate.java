package admsnMgmnt;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import beans.StudentBean;
import beans.TeacherBean;

public class Validate {
	public boolean studentValidation(StudentBean sb){
		java.util.Date date= null;
		
		if(sb.getAddr().trim().length()==0||sb.getfName().trim().length()==0 ||sb.getlName().trim().length()==0||
				sb.getBranch()=="--BRANCH--"||sb.getContact().trim().length()==0|| sb.getGender().trim().length()==0||
				sb.getFaContact().trim().length()==0||sb.getFaName().trim().length()==0||sb.getFaOcc().trim().length()==0 ||
				sb.getMoContact().trim().length()==0 || sb.getMoName().trim().length()==0||sb.getMoOcc().trim().length()==0  ){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!!!");
		return false;
		}
		if(sb.getContact().trim().length()!=10 || sb.getFaContact().trim().length()!=10 || sb.getMoContact().trim().length()!=10)
		{
			JOptionPane.showMessageDialog(null,"Enter Valid Contact No.!!!");
			return false;
		}
		
		return true;
	}
	
	public boolean teacherValidation(TeacherBean tb){
		java.util.Date date= null;
		
		if(tb.getAddr().trim().length()==0||tb.getfName().trim().length()==0 ||tb.getlName().trim().length()==0||
				tb.getDept()==""||tb.getContact().trim().length()==0|| tb.getGender().trim().length()==0||
				tb.getQual().trim().length()==0||tb.getDesig().trim().length()==0){
			JOptionPane.showMessageDialog(null,"Please fill all the fields!!!");
		return false;
		}
		if(tb.getContact().trim().length()!=10)
		{
			JOptionPane.showMessageDialog(null,"Enter Valid Contact No.!!!");
			return false;
		}
		return true;
	}
}
