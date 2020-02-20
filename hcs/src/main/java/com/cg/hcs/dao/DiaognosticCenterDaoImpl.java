package com.cg.hcs.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.AppointmentException;

public class DiaognosticCenterDaoImpl implements DiagnosticCenterDao{

	@Override
	public boolean approveAppointment(User user,DiagnosticCenter center,int a) throws AppointmentException {
		// TODO Auto-generated method stub
		
			List<Appointment> ap=center.getAppointmentList();
			boolean flag=false;
			for(Appointment s:ap)
			{
				
				if((s.isApproved()==false)  && (s.getAppointmentId()==a))
				{
					s.setApproved(true);
					flag=true;
					break;
				}
				
			}
			if(flag==false)
					throw new AppointmentException("Appointment already approved");
			center.setAppointmentList(ap);
		
		
		return true;
	}
	
}
