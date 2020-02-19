package com.cg.hcs.pl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
		List<DiagnosticCenter> dcl=new ArrayList<DiagnosticCenter>();
		List<String> tests=new ArrayList<String>();
		tests.add("Blood sugar");
		tests.add("Blood pressure");
		tests.add("Blood group");
		
		User user1=new User(1,dcl,"abcd","efgh",857438291,"admin","16211@gmail.com");
		User user2=new User(2,dcl,"abcde","eefgh",857438291,"admin","16211@gmail.com");
		User user3=new User(3,dcl,"abcdef","fefgh",857438291,"admin","16211@gmail.com");
		
		LocalDate d=LocalDate.now();
		
		Appointment a1=new Appointment(user1,1,test,d,false);
		Appointment a2=new Appointment(user2,2,test,d,false);
		Appointment a3=new Appointment(user3,3,test,d,false);
		
		List<Appointment> ap=new ArrayList<Appointment>(); 
		ap.add(a1);
		ap.add(a2);
		ap.add(a3);
		
		List<Appointment> ap1=new ArrayList<Appointment>(); 
		ap1.add(a1);
		ap1.add(a2);
		ap1.add(a3);
		
		List<Appointment> ap3=new ArrayList<Appointment>(); 
		ap3.add(a1);
		ap3.add(a2);
		ap3.add(a3);
		
		DiagnosticCenter dc1=new DiagnosticCenter(1,"A1",tests,ap);
		DiagnosticCenter dc2=new DiagnosticCenter(2,"A2",tests,ap1);
		DiagnosticCenter dc3=new DiagnosticCenter(3,"A3",tests,ap3);
		
		dcl.add(dc1);
		dcl.add(dc2);
		dcl.add(dc3);
	}

}
