package com.cg.hcs.dao;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.AppointmentException;

public interface DiagnosticCenterDao  {
	boolean approveAppointment(User user,DiagnosticCenter selectedDiagnosticCenter,int selectedappointmentid) throws AppointmentException;
	//public boolean addCenter(DiagnosticCenter center) throws AppointmentException;
	//public boolean removeCenter(DiagnosticCenter center) throws AppointmentException;
	//public boolean approveAppointment() throws AppointmentException;
	
}
