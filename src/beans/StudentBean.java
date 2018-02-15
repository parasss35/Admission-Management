package beans;

import java.io.File;
import java.sql.Date;

public class StudentBean {
	int enrollNo;
	String fName;
	String lName;
	Date dob;
	String addr;
	String branch;
	String gender;
	String contact;
	String faName;
	String moName;
	String faOcc;
	String moOcc;
	String faContact;
	String moContact;
	File img;
	File docs;
	public File getDocs() {
		return docs;
	}
	public void setDocs(File docs) {
		this.docs = docs;
	}
	String Fee1,Fee2,Fee3,Fee4;
	int year;

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public String getFee1() {
		return Fee1;
	}
	public void setFee1(String fee1) {
		Fee1 = fee1;
	}
	public String getFee2() {
		return Fee2;
	}
	public void setFee2(String fee2) {
		Fee2 = fee2;
	}
	public String getFee3() {
		return Fee3;
	}
	public void setFee3(String fee3) {
		Fee3 = fee3;
	}
	public String getFee4() {
		return Fee4;
	}
	public void setFee4(String fee4) {
		Fee4 = fee4;
	}
	public int getEnrollNo() {
		return enrollNo;
	}
	public void setEnrollNo(int enrollNo) {
		this.enrollNo = enrollNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getFaName() {
		return faName;
	}
	public void setFaName(String faName) {
		this.faName = faName;
	}
	public String getMoName() {
		return moName;
	}
	public void setMoName(String moName) {
		this.moName = moName;
	}
	public String getFaOcc() {
		return faOcc;
	}
	public void setFaOcc(String faOcc) {
		this.faOcc = faOcc;
	}
	public String getMoOcc() {
		return moOcc;
	}
	public void setMoOcc(String moOcc) {
		this.moOcc = moOcc;
	}
	public String getFaContact() {
		return faContact;
	}
	public void setFaContact(String faContact) {
		this.faContact = faContact;
	}
	public String getMoContact() {
		return moContact;
	}
	public void setMoContact(String moContact) {
		this.moContact = moContact;
	}

}
