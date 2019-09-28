package com.payrollsystem.dao;    
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.payrollsystem.dbutil.MyConnection;
import com.payrollsystem.model.Salary;

public class SalaryDAOImpl implements SalaryDAO {

	private Connection conn = new MyConnection().getConn();

	@Override
	public Salary getSalarybyempid(String emp_id) {
		Salary s = null;
		String sql = "SELECT * FROM TBL_SALARY WHERE EMP_ID=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				String Id = rs.getString("id");
				String Emp_id = rs.getString("emp_id");
				String Name = rs.getString("name");
				int BasicSalary = rs.getInt("basicSalary");
				int OtherSavings = rs.getInt("otherSavings");
				Date date = rs.getDate("date");
				
				s=new Salary(Id, Emp_id, Name, BasicSalary, OtherSavings, date);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return s;
	}

	@Override
	public List<Salary> getAll() {
		List<Salary> list = new ArrayList<Salary>();
		String sql = "Select * from TBL_SALARY";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Create the statement ---2
			stmt = conn.createStatement();
			// Execute the statement ---3
			rs = stmt.executeQuery(sql);
			// Process the result
			while (rs.next()) {
				String Id = rs.getString("id");
				String Emp_id = rs.getString("emp_id");
				String Name = rs.getString("name");
				double BasicSalary = rs.getDouble("basic_Salary");
				double OtherSavings = rs.getDouble("otherSavings");
				Date Date = rs.getDate("date");

				// Create user
				Salary s = new Salary(Id, Emp_id, Name, BasicSalary, OtherSavings, Date);
				// Add to the list
				list.add(s);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public Salary generatePayslip(String emp_id, String month) {
		Salary s=null;
		String sql="SELECT * FROM TBL_SALARY WHERE EMP_ID=? AND  monthname(date)=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, emp_id);
			ps.setString(2, month);
			if (rs.next()) {
				String Id = rs.getString("id");
				String Emp_id = rs.getString("emp_id");
				String Name = rs.getString("name");
				int BasicSalary = rs.getInt("basicSalary");
				int OtherSavings = rs.getInt("otherSavings");
				Date date = rs.getDate("date");
				
				s=new Salary(Id, Emp_id, Name, BasicSalary, OtherSavings, date);
			}
			
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return s;
	}

	

}

        
