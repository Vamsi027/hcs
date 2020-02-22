package com.cg.hcs.service;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.User;
import com.cg.hcs.dao.DiagnosticCenterDao;
import com.cg.hcs.dao.DiaognosticCenterDaoImpl;
import com.cg.hcs.exception.AppointmentException;

public class DiagnosticCenterServiceImpl implements DiagnosticCenterService,DiagnosticCenterDao{

	private DiagnosticCenterDao diagnosticcenterdao=null;
	public DiagnosticCenterServiceImpl()
	{
		diagnosticcenterdao=new DiaognosticCenterDaoImpl();
	}
	
	public boolean validateUser(User user)
	{
		if(user.getUserRole().equals("admin"))
			return true;
		else
			return false;
	}
	@Override
	public boolean approveAppointment(User user,DiagnosticCenter selectedDiagnosticCenter,int selectedappointmentid) throws AppointmentException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(validateUser(user))
		{
			flag=diagnosticcenterdao.approveAppointment(user,selectedDiagnosticCenter,selectedappointmentid);
		}
		else
		{
			throw new AppointmentException("User is not admin");
		}
		
		return flag;
	}

}
