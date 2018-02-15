package dao;

import java.io.IOException;
import java.sql.SQLException;

import beans.StudentBean;
import beans.TeacherBean;

public interface TeacherDao {
	public int addTeacher(TeacherBean teacher) throws SQLException,IOException;
	public int updateTeacher(int enrollno,TeacherBean teacher) throws SQLException,IOException;
	public int deleteTeacher(int enrollno) throws SQLException,IOException;
	public TeacherBean displayTeacher(int enrollno) throws SQLException,IOException;
	public TeacherBean validateTeacher(int tid,String name) throws SQLException,IOException;
}
