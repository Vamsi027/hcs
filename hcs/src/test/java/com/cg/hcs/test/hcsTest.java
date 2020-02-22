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
import com.cg.hcs.dao.DiaognosticCenterDaoImpl;

class hcsTest {
	DiaognosticCenterDaoImpl dao=null;
	Test test=null;
	
	@BeforeEach
	void setUp()
	{
		dao=new DiaognosticCenterDaoImpl();
		User user1=new User(1,diagnosticCenters,"abcd","efgh",857438291,"admin","16211@gmail.com");
		 test=new Test("1","Blood Sugar");
		
		List<Appointment> appointments1=new ArrayList<Appointment>(); 
		LocalDateTime datetime=LocalDateTime.now();
		Appointment a1=new Appointment(user1,1,test,datetime,false);

		appointments1.add(a1);
		appointments1.add(a2);
		appointments1.add(a3);
		DiagnosticCenter center1=new DiagnosticCenter("1","Hyderabad",null,appointments1);
		
	}
	
	@Test
	void testApproveAppointment() {
		
		boolean flag=dao.approveAppointment(user1, center1, 1);
		assertEquals(true, flag);
		
		
		
	}

}
