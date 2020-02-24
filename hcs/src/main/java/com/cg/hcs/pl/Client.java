package com.cg.hcs.pl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
		
		List<DiagnosticCenter> diagnosticCenters=new ArrayList<DiagnosticCenter>();
		
		List<String> tests=new ArrayList<String>();
		tests.add("Blood sugar");
		tests.add("Blood pressure");
		tests.add("Blood group");
		
		List<Appointment> appointments1=new ArrayList<Appointment>(); 
		List<Appointment> appointments2=new ArrayList<Appointment>();
		List<Appointment> appointments3=new ArrayList<Appointment>(); 
		
		DiagnosticCenter center1=new DiagnosticCenter("1","Hyderabad",null,appointments1);
		DiagnosticCenter center2=new DiagnosticCenter("2","Bengaluru",null,appointments2);
		DiagnosticCenter center3=new DiagnosticCenter("3","Chennai",null,appointments3);
		
		diagnosticCenters.add(center1);
		diagnosticCenters.add(center2);
		diagnosticCenters.add(center3);
		
		User user1=new User(1,diagnosticCenters,"abcd","efgh",857438291,"admin","16211@gmail.com");
		User user2=new User(2,null,"abcde","eefgh",857438291,"customer","16211@gmail.com");
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
		
				
		Scanner scanner=new Scanner(System.in);
		try
		{
		boolean loop=true;
		while(loop)
		{
			System.out.println("Please choose an option:");
			System.out.println("1.Approve Appointments");
			System.out.println("2.Exit");
			
			int option=scanner.nextInt();
			scanner.nextLine();
			switch(option) {
			case 1:
				try
				{
				System.out.println("Please Select the Diagnostic Center by id");
				for(DiagnosticCenter diagnosticcenter:diagnosticCenters)
				{
					System.out.println(diagnosticcenter.getCenterId()+"."+diagnosticcenter.getCenterName());
				}
				String selectedcenterid=scanner.nextLine();
		
				boolean flag=false,internalflag=false;
				DiagnosticCenter selecteddiagnosticCenter=null;
		
				for(DiagnosticCenter diagnosticcenter:diagnosticCenters)
				{	
					selecteddiagnosticCenter=diagnosticcenter;
					if(selectedcenterid.equals(diagnosticcenter.getCenterId()))
					{
						
						System.out.println("Here is the list of Appointments to be approved.Select an Appointment to approve");
						for(Appointment appointment:diagnosticcenter.getAppointmentList())
						{
							if(appointment.isApproved()==false) {
								System.out.println(appointment.getAppointmentId()+"."+appointment.getUser().getUserName());
								internalflag=true;
							}
						}
						flag=true;
						break;
					}
				}
				if(flag==false)
					System.out.println("Selected Center id does not exist");
				if(internalflag) {
					
				
				int selectedappointmentid=scanner.nextInt();
				
				boolean flag1=false;
				for(Appointment appointment:selecteddiagnosticCenter.getAppointmentList())
				{
					if(selectedappointmentid==appointment.getAppointmentId())
					{
						if(daoservice.approveAppointment(user1,selecteddiagnosticCenter,selectedappointmentid)) {
							System.out.println("Appointment Approved");
						}
						flag1=true;
						break;
					}
				}
				if(flag1==false)
					System.out.println("Selected Appointment id does not exist");
		
				System.out.println("Appointments remaining to be approved are:");
				for(Appointment selectedAppointment:selecteddiagnosticCenter.getAppointmentList())
				{
			
					if(selectedAppointment.isApproved()==false)
					{
						System.out.println(selectedAppointment.getAppointmentId()+"."+selectedAppointment.getUser().getUserName());
					}
				}
				}
				else
					System.out.println("No appointments left to approve.");
				}
				catch(AppointmentException e) {
					System.err.println(e.getMessage());
				}
	
				break;
			case 2:
				loop=false;
				break;
			default:
				System.out.println("Choose a correct option");
			}
			}
		}
		catch(InputMismatchException e)
		{
			System.err.println("Input Mismatch");
		}
		
	}

}
