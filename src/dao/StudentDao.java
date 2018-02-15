package dao;

import java.io.IOException;
import java.sql.SQLException;

import beans.AdminBean;
import beans.StudentBean;

public interface StudentDao {
	public int addStudent(StudentBean student) throws SQLException,IOException;
	public int updateStudent(int enrollno,StudentBean student) throws SQLException,IOException;
	public int deleteStudent(int enrollno) throws SQLException,IOException;
	public StudentBean displayStudent(int enrollno) throws SQLException,IOException;
	public int feeUpdateStudent(int enrollno,StudentBean student) throws SQLException,IOException;	
	public StudentBean validateStudent(int enrollno,String name) throws SQLException,IOException;
	
}
