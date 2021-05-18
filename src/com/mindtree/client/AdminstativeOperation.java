package com.mindtree.client;

import java.sql.SQLException;

import java.util.Scanner;

import com.mindtree.exception.MyException;
import com.mindtree.service.*;

public class AdminstativeOperation {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, ClassNotFoundException, MyException {
		// we need to get choice from the user...
		int choice = 0;
		// with choice we go to perform that operation.
		do {
			Menu.displayMenu();
			System.out.println("Enter your choice:");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				// Center details add
				if (CenterData.centerRecordInsert()) {
					System.out.println("Center details successful added");

				} else
					System.out.println("Fail to insert");
				break;
			case 2:

				try {
					PatientData.patientRecordInsert();
				} catch (MyException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				// Center details update
				System.out.println("Enter the center id which center name is update");
				int cid = sc.nextInt();
				if (CenterData.updateCenter(cid))
					System.out.println("update center name successful");
				else
					System.out.println("id not match");

				break;
			case 4:
				// Center details delete
				System.out.println("Enter the center id which center name is deleted");
				int cid1 = sc.nextInt();
			try {	if (CenterData.deleteCenter(cid1))
					System.out.println("Record deleted successful");
			}
			catch (MyException e) {
			System.err.println(e);
			}
//				else
//					System.out.println("id not match");
				break;
			case 5:
				 CenterData.getCenterRecord();  

				//CenterData.getBigRecord();
				break;
			case 6:
				System.out.println("Successful exit....");
				break;

			default:
				System.out.println("You enter wrong choice..");
				break;

			}
		
		} while (choice != 6);

	}

}
