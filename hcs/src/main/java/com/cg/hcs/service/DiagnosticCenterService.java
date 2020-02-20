package com.cg.hcs.service;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.AppointmentException;

public interface DiagnosticCenterService {
	//public boolean addCenter(DiagnosticCenter center) throws AppointmentException;
	//public boolean removeCenter(DiagnosticCenter center) throws AppointmentException;
	//public boolean approveAppointment() throws AppointmentException;
	public boolean approveAppointment(User user, DiagnosticCenter center,int a) throws AppointmentException;
}
