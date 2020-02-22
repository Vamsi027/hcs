package com.cg.hcs.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.AppointmentException;
import com.cg.hcs.service.DiagnosticCenterService;
import com.cg.hcs.service.DiagnosticCenterServiceImpl;

class HcsTest {
	DiagnosticCenterService daoservice=null;
	User user1=null;
	User user2=null;
	DiagnosticCenter center1=null;
	DiagnosticCenter center2=null;
	
	@BeforeEach
	void setUp()
	{
		 daoservice=new DiagnosticCenterServiceImpl();
		
		List<String> tests=new ArrayList<String>();
		tests.add("Blood sugar");
		tests.add("Blood pressure");
		tests.add("Blood group");
		
		com.cg.hcs.bean.Test test=new com.cg.hcs.bean.Test();
		
		List<DiagnosticCenter> diagnosticCenters=new ArrayList<DiagnosticCenter>();
		
		List<Appointment> appointments1=new ArrayList<Appointment>(); 
		List<Appointment> appointments2=new ArrayList<Appointment>();
		List<Appointment> appointments3=new ArrayList<Appointment>(); 
		
		 center1=new DiagnosticCenter("1","Hyderabad",null,appointments1);
		 center2=new DiagnosticCenter("2","Bengaluru",null,appointments2);
		DiagnosticCenter center3=new DiagnosticCenter("3","Chennai",null,appointments3);
		
		diagnosticCenters.add(center1);
		diagnosticCenters.add(center2);
		diagnosticCenters.add(center3);
		
		user1=new User(1,diagnosticCenters,"abcd","efgh",857438291,"admin","16211@gmail.com");
		user2=new User(2,null,"abcde","eefgh",857438291,"admin","16211@gmail.com");
		User user3=new User(3,null,"abcdef","fefgh",857438291,"customer","16211@gmail.com");
		
		LocalDateTime datetime=LocalDateTime.now();
		
		Appointment a1=new Appointment(user1,1,test,datetime,false);
		Appointment a2=new Appointment(user2,2,test,datetime,false);
		Appointment a3=new Appointment(user3,3,test,datetime,false);
		
		
		appointments1.add(a1);
		appointments1.add(a2);
		appointments1.add(a3);
		
		appointments2.add(a1);
		appointments2.add(a3);
		appointments2.add(a2);

			
		
		appointments3.add(a2);
		appointments3.add(a1);
		appointments3.add(a3);
	}
	
	@Test
	void testApproveAppointment() throws AppointmentException {
		
		
		boolean flag=daoservice.approveAppointment(user1, center1, 1);
		boolean flag2=daoservice.approveAppointment(user2, center2, 2);
		assertEquals(true, flag);
		assertEquals(true, flag2);
		
		
	}

}
