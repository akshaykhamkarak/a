package com.mindtree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mindtree.entity.Patient;
import com.mindtree.exception.MyException;
import com.mindtree.utilitty.JdbcConnection;

public class PatientDao {

	public static boolean insertPatientData(Patient patient) throws SQLException {
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into patientss values(?,?,?)");

			ps.setString(1, patient.getName());
			ps.setInt(2, patient.getAge());
			ps.setInt(3, patient.getCenterid());
			int row = ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			
		} finally {
			con.close();
		}
		return false;
	}

}
