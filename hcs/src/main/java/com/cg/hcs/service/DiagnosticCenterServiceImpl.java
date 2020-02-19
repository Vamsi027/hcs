package com.cg.hcs.service;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.User;
import com.cg.hcs.dao.DiagnosticCenterDao;
import com.cg.hcs.exception.AppointmentException;

public class DiagnosticCenterServiceImpl implements DiagnosticCenterService{

	private DiagnosticCenterService diagnosticcenterdao=null;
	public DiagnosticCenterServiceImpl()
	{
		diagnosticcenterdao=new DiagnosticCenterServiceImpl();
	}
	
	public boolean validateUser(User user)
	{
		if(user.getUserRole().equals("admin"))
			return true;
		else
			return false;
	}
	@Override
	public boolean approveAppointment(User user) throws AppointmentException {
		// TODO Auto-generated method stub
		if(validateUser(user))
		{
			approveAppointment(user);
		}
		else
		{
			throw new AppointmentException("User is not admin");
		}
		
		return true;
	}

}
