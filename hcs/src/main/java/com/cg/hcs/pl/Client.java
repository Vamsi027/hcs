package com.cg.hcs.pl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.AppointmentException;
import com.cg.hcs.service.DiagnosticCenterService;
import com.cg.hcs.service.DiagnosticCenterServiceImpl;

public class Client {

	public static void main(String[] args) throws AppointmentException {
		// TODO Auto-generated method stub
		
		DiagnosticCenterService daoservice=new DiagnosticCenterServiceImpl();
		
		Test test=new Test();
		List<DiagnosticCenter> dcl=new ArrayList<DiagnosticCenter>();
		List<String> tests=new ArrayList<String>();
		tests.add("Blood sugar");
		tests.add("Blood pressure");
		tests.add("Blood group");
		List<Appointment> ap=new ArrayList<Appointment>(); 
		List<Appointment> ap1=new ArrayList<Appointment>();
		List<Appointment> ap3=new ArrayList<Appointment>(); 
		DiagnosticCenter dc1=new DiagnosticCenter("1","A1",null,ap);
		DiagnosticCenter dc2=new DiagnosticCenter("2","A2",null,ap1);
		DiagnosticCenter dc3=new DiagnosticCenter("3","A3",null,ap3);
		
		dcl.add(dc1);
		dcl.add(dc2);
		dcl.add(dc3);
		
		User user1=new User(1,dcl,"abcd","efgh",857438291,"admin","16211@gmail.com");
		User user2=new User(2,null,"abcde","eefgh",857438291,"customer","16211@gmail.com");
		User user3=new User(3,null,"abcdef","fefgh",857438291,"customer","16211@gmail.com");
		
		LocalDateTime datetime=LocalDateTime.now();
		
		Appointment a1=new Appointment(user1,1,test,datetime,false);
		Appointment a2=new Appointment(user2,2,test,datetime,false);
		Appointment a3=new Appointment(user3,3,test,datetime,false);
		
		
		ap.add(a1);
		ap.add(a3);
		ap.add(a2);
		 
		ap1.add(a1);
		ap1.add(a2);
		ap1.add(a3);	
		
		ap3.add(a2);
		ap3.add(a1);
		ap3.add(a3);
		
				
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Select the Diagnostic Center by id");
		for(DiagnosticCenter dcl1:dcl)
		{
			System.out.println(dcl1.getCenterId()+" "+dcl1.getCenterName());
		}
		String centerid=sc.nextLine();
		
		boolean flag=false;
		DiagnosticCenter dupl=null;
		
		for(DiagnosticCenter q:dcl)
		{	
			dupl=q;
			if(centerid.equals(q.getCenterId()))
			{
				System.out.println("Here is the list of Appointments to be approved.Select an Appointment to approve");
				for(Appointment a:q.getAppointmentList())
				{
					System.out.println(a.getAppointmentId()+" "+a.getUser().getUserName());
				}
				flag=true;
				break;
			}
		}
		if(flag==false)
			System.out.println("Selected Center id does not exist");
		int alone=sc.nextInt();
		for(Appointment apl:dupl.getAppointmentList())
		{
			
			if(alone==apl.getAppointmentId())
			{
				if(daoservice.approveAppointment(user1,dupl,alone))
					System.out.println("Appointment Approved");
					
			}
		}
		System.out.println("Appointments remaining to be approved are:");
		for(Appointment apl:dupl.getAppointmentList())
		{
			
			if(apl.isApproved()==false)
			{
					System.out.println(apl.getAppointmentId()+" "+apl.getUser().getUserName());
			}
		}
			
		
	}

}
