package com.cg.hcs.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.AppointmentException;

public class DiaognosticCenterDaoImpl implements DiagnosticCenterDao{

	@Override
	public boolean approveAppointment(User user,DiagnosticCenter selectedDiagnosticCenter,int selectedappointmentid) throws AppointmentException {
		// TODO Auto-generated method stub
		

		boolean flag=false;
			List<Appointment> appointments=selectedDiagnosticCenter.getAppointmentList();
			
			for(Appointment temporaryappointment:appointments)
			{
				
				if((temporaryappointment.isApproved()==false)  && (temporaryappointment.getAppointmentId()==selectedappointmentid))
				{
					temporaryappointment.setApproved(true);
					flag=true;
				   	break;
				}
				
			}
			if(flag==false)
					throw new AppointmentException("Appointment already approved");
			selectedDiagnosticCenter.setAppointmentList(appointments);
		
		
		return true;
	}
	
}
