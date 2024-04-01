package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

/*
 * 1)loading driver class
 * 2)getting connection with DB
 * 3)prepare Query
 * 4)create statement 
 * 5)submit query
 * 6)getting result set
 * 
 * 7) optional: Transaction management
 * */
public class EmployeeController {

	public void addEmployee() {

		Connection conn = DBConnection.getDBConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee name");
		String name = sc.next();

		System.out.println("enter employee email");
		String email = sc.next();

		System.out.println("enter employee password");
		String password = sc.next();

		System.out.println("enter employee age");
		int age = sc.nextInt();

		// String INSERTSQL = "insert into
		// employee(ename,eemail,epassword,eage)values('raj','raj@gmail.com','raj123',23)";
		String INSERTSQL = "insert into employee(ename,eemail,epassword,eage)values('" + name + "','" + email + "','"
				+ password + "'," + age + ")";
		// submit -->

		try {
			Statement stmt = conn.createStatement(); // compile --> db protocol -->
			// executeUpdate() -->int --> DML
			// executeQuery()-->ResultSet -->DDL
			// execute() -->boolean -->

			int res = stmt.executeUpdate(INSERTSQL);
			if (res > 0) {
				System.out.println(res + " employee inserted...");
			}

			else {
				System.out.println("No emp inserted...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // statment

	}

	public void deleteEmployee() {

		Connection conn = DBConnection.getDBConnection();
		if (conn != null) {

			String DELETESQL = "delete from employee where eid = 1";

			try {
				Statement stmt = conn.createStatement();
				int res = stmt.executeUpdate(DELETESQL);
				if (res > 0) {

					System.out.println(res + " employee deleted...");
				} else {
					System.out.println("no employee deleted..");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public void updateEmplpoyee() {
		
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			String UPDATESQL = "update employee set ename = 'PARTH' ,eemail = 'parth@gmail.co.in', eage = 25 where eid =2";
			Statement stmt;
			try {
				stmt = conn.createStatement();
				int res = stmt.executeUpdate(UPDATESQL);
				
				if(res>0) {
					
					System.out.println("employee updated...");
				}
				else {
					System.out.println("no employee updated...");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
			
			
		}
		
		
		
	}

	public static void main(String[] args) {

		EmployeeController employeeController = new EmployeeController();
		/// employeeController.addEmployee();
		//employeeController.deleteEmployee();
		employeeController.updateEmplpoyee();

	}
}
