package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnection;

public class EmployeeController1 {

	// statment --> every time query will compile
	// prepared statment -> compile only oonce...

	public void addEmployee() {

		Connection conn = DBConnection.getDBConnection();
		if (conn != null) {

			// ? place holder...
			String insertSQL = "insert into employee(ename,eemail,epassword,eage)value(?,?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, "amit");
				pstmt.setString(2, "amit@gmail.com");
				pstmt.setString(3, "amit123");
				pstmt.setInt(4, 25);

				int res = pstmt.executeUpdate();
				if (res > 0) {

					System.out.println(res + " employee inserted...");
				} else {

					System.out.println("No employee inserted..");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public void updateEmployee()
	{
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			String updateSQL = "update employee set ename = ?,eage = ? where eid =?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, "AMIT");
				pstmt.setInt(2, 26);
				pstmt.setInt(3, 3);
				
				int res = pstmt.executeUpdate();
				if (res > 0) {

					System.out.println(res + " employee inserted...");
				} else {

					System.out.println("No employee inserted..");
				}
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}
	
	
	public void getEmployees() {
		
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			String SELECTSQL = "select * from employee where eid = ?";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(SELECTSQL);
				pstmt.setInt(1, 3);
				
				ResultSet rs = pstmt.executeQuery();
				System.out.println("EID ENAME EEMAIL EPASSWORD EAGE");
				while(rs.next()) {
					
					System.out.print(rs.getInt("eid"));
					System.out.print(rs.getString("ename"));
					System.out.print(rs.getString("eemail"));
					System.out.print(rs.getString("epassword"));
					System.out.print(rs.getInt("eage"));
					System.out.println();
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
	}
	
	
	
	public void addBulkEmployees () {
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			String insertSQL = "insert into employee(ename,eemail,epassword,eage)value(?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, "amit");
				pstmt.setString(2, "amit@gmail.com");
				pstmt.setString(3, "amit123");
				pstmt.setInt(4, 25);
				
				pstmt.addBatch();
				pstmt.setString(1, "kunal");
				pstmt.setString(2, "kunal@gmail.com");
				pstmt.setString(3, "kunal123");
				pstmt.setInt(4, 26);
				pstmt.addBatch();
				pstmt.setString(1, "priya");
				pstmt.setString(2, "priya@gmail.com");
				pstmt.setString(3, "priya123");
				pstmt.setInt(4, 23);
				pstmt.addBatch();
				
				int res[] = pstmt.executeBatch();
				if(res.length >0 ) {
					System.out.println(res.length + " employee added...");
				}
				else {
					System.out.println("No emplpoyee added...");
				}
				
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {

		EmployeeController1 employeeController = new EmployeeController1();
		//employeeController.addEmployee();
		//employeeController.updateEmployee();
		//employeeController.getEmployees();
		employeeController.addBulkEmployees();
	}

}
