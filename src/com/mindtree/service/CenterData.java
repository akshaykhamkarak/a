package com.mindtree.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.dao.CenterDao;
import com.mindtree.entity.Center;
import com.mindtree.entity.Special;
import com.mindtree.exception.MyException;
import com.mindtree.utilitty.JdbcConnection;

public class CenterData {
	static Scanner sc = new Scanner(System.in);

	public static boolean centerRecordInsert() throws SQLException, MyException {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int strength = 0, cid = 0;
		String cname = "";
		
		System.out.println("Enter the center name:");
		cname = sc.next();
		System.out.println("Enter the strength:");
		strength = sc.nextInt();
		System.out.println("Enter the center id:");
		cid = sc.nextInt();
		Center center = new Center(cname, strength, cid);

		flag = CenterDao.insertCenterData(center);
		if(!flag) {
			throw new MyException("Insert correct details");
		}
		
//		catch (InputMismatchException e) {
//		System.out.println("Enter the correct input");
//		}
		return flag;
	}

	public static boolean deleteCenter(int cid) throws SQLException, MyException{
		Center center = new Center();
		boolean flag = false;
		
		center.setCenterid(cid);
		flag = CenterDao.deleteRecord(center);
		
		return flag;
	}

	public static boolean updateCenter(int cid) throws SQLException {
		Center center = new Center();
		String centername = "";
		System.out.println("Enter the new center name");
		centername = sc.next();
		boolean flag = false;
		center.setCenterid(cid);
		center.setPlacename(centername);
		flag = CenterDao.updateRecord(center);
		return flag;
	}

//	public static void getCenterRecord() throws SQLException, ClassNotFoundException {
//		ArrayList<Center> customerList = CenterDao.getAllCustomer();
//		 
//		for (Center center : customerList) {
//			System.out.println("=============================");
//			System.out.println("Name: " + center.getPlacename());
//			System.out.println("Center Id: " + center.getCenterid());
//			System.out.println("Strength: " + center.getStrength());
//
//		}
//	}

	
	public static void getCenterRecord() throws SQLException {
		
		Set<Center>c=CenterDao.getAllCustomer();
		for(Center center:c) {
			
			System.out.println("=============================");
			System.out.println("Name: " + center.getPlacename());
			System.out.println("Center Id: " + center.getCenterid());
			System.out.println("Strength: " + center.getStrength());

		}
		}
		
	
	public static void getBigRecord() throws SQLException {

		ArrayList<Special> customerList = CenterDao.getAllCustomerBig();
		System.out.println("=========GET PATIENT RECORD WITH CENTER DETAILS============");
		for (Special center : customerList) {

			System.out.println("Name: " + center.getName());
			System.out.println("age: " + center.getAge());

			System.out.println("CENTER-ID: " + center.getId());
			System.out.println("Center Name: " + center.getCname());
			System.out.println("Total Capacity: " + center.getStrength());
			System.out.println("=====================");
		}

	}

}
