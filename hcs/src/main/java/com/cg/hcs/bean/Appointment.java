package com.cg.hcs.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Appointment {
private User user;
private int appointmentId;
private Test test;
private LocalDateTime datetime;
private boolean approved;
public Appointment(User user, int appointmentId, Test test, LocalDateTime d, boolean approved) {
	super();
	this.user = user;
	this.appointmentId = appointmentId;
	this.test = test;
	this.datetime = d;
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
public LocalDateTime getDatetime() {
	return datetime;
}
public void setDatetime(LocalDateTime datetime) {
	this.datetime = datetime;
}
public boolean isApproved() {
	return approved;
}
public void setApproved(boolean approved) {
	this.approved = approved;
}


}
