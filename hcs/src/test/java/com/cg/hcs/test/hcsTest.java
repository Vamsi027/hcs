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
	
	
	@BeforeEach
	void setUp()
	{
		
	}
	
	@Test
	void testApproveAppointment() {
		
		boolean flag=dao.approveAppointment(user1, center1, 1);
		assertEquals(true, flag);
		
		
		
	}

}
