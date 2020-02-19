package com.cg.hcs.dao;

import java.util.List;

import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.AppointmentException;

public class DiaognosticCenterDaoImpl implements DiagnosticCenterDao{


	@Override
	public boolean approveAppointment(User user) throws AppointmentException {
		// TODO Auto-generated method stub
		List<DiagnosticCenter> l=user.getCenterList();
		for(DiagnosticCenter dc:l)
		{
			List<Appointment> a=dc.getAppointmentList();
			for(Appointment s:a)
			{
				if(s.isApproved()==false)
					s.setApproved(true);
				else
					throw new AppointmentException("Appointment already approved");
			}
			dc.setAppointmentList(a);
		}
		user.setCenterList(l);
		
		return true;
	}
	
}
