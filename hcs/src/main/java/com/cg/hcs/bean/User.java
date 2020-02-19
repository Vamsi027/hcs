package com.cg.hcs.bean;

import java.util.List;

public class User {
private int userId;
private  List<DiagnosticCenter>centerList;
private String userPassword;
private String userName;
private int contactNumber;
private String userRole;
private String emailId;
public User(int userId, List<DiagnosticCenter> centerList, String userPassword, String userName, int contactNumber,
		String userRole, String emailId) {
	super();
	this.userId = userId;
	this.centerList = centerList;
	this.userPassword = userPassword;
	this.userName = userName;
	this.contactNumber = contactNumber;
	this.userRole = userRole;
	this.emailId = emailId;
}
public User() {
	super();
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public List<DiagnosticCenter> getCenterList() {
	return centerList;
}
public void setCenterList(List<DiagnosticCenter> centerList) {
	this.centerList = centerList;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getContactNumber() {
	return contactNumber;
}
public void setContactNumber(int contactNumber) {
	this.contactNumber = contactNumber;
}
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}	
}
