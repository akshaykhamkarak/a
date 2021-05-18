package com.mindtree.utilitty;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.exception.DaoException;
import com.mindtree.exception.MyException;

public class JdbcConnection {	
		private static	String URL = "jdbc:mysql://localhost:3307/Adminstative";
		private static	String USER_NAME = "root";
		private static	String PASSWORD = "Trishali@1999";
		public static Connection getConnection()throws DaoException {
			Connection con = null;

			try {
			
				con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			} catch (SQLException e) {
				throw new DaoException("Please check con");
			}
			return con;
		}
		
	}


