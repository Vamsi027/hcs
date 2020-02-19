package com.cg.hcs.bean;

import java.time.LocalDate;
import java.util.Date;

public class Appointment {
private User user;
private int appointmentId;
private Test test;
private LocalDate datetime;
private boolean approved;
public Appointment(User user, int appointmentId, Test test, LocalDate datetime, boolean approved) {
	super();
	this.user = user;
	this.appointmentId = appointmentId;
	this.test = test;
	this.datetime = datetime;
	this.approved = approved;
}

public Appointment() {
	super();
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getAppointmentId() {
	return appointmentId;
}
public void setAppointmentId(int appointmentId) {
	this.appointmentId = appointmentId;
}
public Test getTest() {
	return test;
}
public void setTest(Test test) {
	this.test = test;
}
public LocalDate getDatetime() {
	return datetime;
}
public void setDatetime(LocalDate datetime) {
	this.datetime = datetime;
}
public boolean isApproved() {
	return approved;
}
public void setApproved(boolean approved) {
	this.approved = approved;
}


}
