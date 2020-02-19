package com.cg.hcs.bean;

import java.util.List;

public class DiagnosticCenter {
	private int centerId;
	private String centerName;
	private List<String> listOfTests;
	private List<Appointment> appointmentList;
	public DiagnosticCenter(int centerId, String centerName, List<String> listOfTests,
			List<Appointment> appointmentList) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.listOfTests = listOfTests;
		this.appointmentList = appointmentList;
	}
	public DiagnosticCenter() {
		super();
	}
	public int getCenterId() {
		return centerId;
	}
	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public List<String> getListOfTests() {
		return listOfTests;
	}
	public void setListOfTests(List<String> listOfTests) {
		this.listOfTests = listOfTests;
	}
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
