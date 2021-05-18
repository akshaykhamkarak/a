package com.mindtree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.mindtree.entity.Center;
import com.mindtree.entity.Special;
import com.mindtree.exception.MyException;
import com.mindtree.utilitty.JdbcConnection;

public class CenterDao {

	public static boolean insertCenterData(Center center) throws SQLException, MyException {
		Connection con = null;
		PreparedStatement ps = null;
		try {

			ps = con.prepareStatement("insert into Center (cid,name,strength) values(?,?,?)");

			ps.setInt(1, center.getCenterid());
			ps.setString(2, center.getPlacename());
			ps.setInt(3, center.getStrength());
			int row = ps.executeUpdate();
			if (row < 0) {
				throw new MyException("Id is duplicate..");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
		}
		return false;

	}

	public static boolean deleteRecord(Center center) throws SQLException, MyException {
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
			String query = "delete from Center where cid=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, center.getCenterid());

			int res = ps.executeUpdate();
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("");
		}
		return true;

	}

	public static boolean updateRecord(Center center) throws SQLException {

		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
			String query = "update Center set name=? where cid=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, center.getPlacename());
			ps.setInt(2, center.getCenterid());

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return false;
	}

//	public static ArrayList<Center> getAllCustomer() throws ClassNotFoundException, SQLException {
//		Connection conn = JdbcConnection.getConnection();
//		Statement stm;
//		stm = conn.createStatement();
//		String sql = "Select * From Center";
//		ResultSet rst;
//		rst = stm.executeQuery(sql);
//		ArrayList<Center> customerList = new ArrayList<>();
//		while (rst.next()) {
//			Center customer = new Center(rst.getString("name"), rst.getInt("cid"), rst.getInt("strength"));
//			customerList.add(customer);
//		}
//
//		return customerList;
//	}

	public static Set<Center> getAllCustomer() throws SQLException {
		Connection con = JdbcConnection.getConnection();
		Statement stm;
		stm = con.createStatement();
		String sql = "Select * From Center";
		ResultSet rst;
		rst = stm.executeQuery(sql);
		Set<Center> set = new HashSet<>();
		while (rst.next()) {
			Center c1 = new Center(rst.getString("name"), rst.getInt("cid"), rst.getInt("strength"));
			set.add(c1);
		}
		return set;
	}

	public static ArrayList<Special> getAllCustomerBig() throws SQLException {
		Connection conn = JdbcConnection.getConnection();
		Statement stm;
		stm = conn.createStatement();
		String sql = "select patientss.cid,patientss.name,patientss.age,Center.name,Center.strength\r\n"
				+ "from patientss join Center on patientss.cid=Center.cid;";
		ResultSet rst;
		rst = stm.executeQuery(sql);
		ArrayList<Special> customerList = new ArrayList<>();
		while (rst.next()) {
			Special customer = new Special(rst.getString("name"), rst.getString("name"), rst.getInt("cid"),
					rst.getInt("strength"), rst.getInt("age"));
			customerList.add(customer);

		}
		return customerList;
	}

}
