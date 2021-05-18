package com.mindtree.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.mindtree.dao.CenterDao;
import com.mindtree.dao.PatientDao;
import com.mindtree.entity.Patient;
import com.mindtree.exception.MyException;

public class PatientData {

	public static boolean patientRecordInsert() throws MyException, SQLException {
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		int cid=0;
		byte age=0;
		String name="";
		System.out.println("Enter the patient name:");
		name=sc.next();
		System.out.println("Enter the age of the patient:");
		age=sc.nextByte();
		System.out.println("Enter the center id where this patient is admit");
		cid=sc.nextInt();
		Patient patient=new Patient(name,age,cid);
		
		flag=PatientDao.insertPatientData(patient);
		if(!flag) {
			throw new MyException("please provide Patient id is unique:");
		}

		return flag;
	}

}
