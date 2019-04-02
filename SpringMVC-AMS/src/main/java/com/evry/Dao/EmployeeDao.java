package com.evry.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.evry.Beans.Employee;

@Repository
public class EmployeeDao {
	@Resource(name = "appJdbcTempalte")
	private JdbcTemplate jdbcTemplate;

	/*******************************
	 * Add Employee
	 ***********************************/
	public Map<String, Object> addEmployee(Employee employeeData) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		String insertQuery = "insert into employee (name,password,emailId,phone,address) values('"
				+ employeeData.getName() + "','" + employeeData.getPassword() + "','" + employeeData.getEmailId()
				+ "','" + employeeData.getPhone() + "','" + employeeData.getAddress() + "')";
		try {

			int check = jdbcTemplate.update(insertQuery);

			if (check > 0) {
				map.put("message", "Employee Added Successfully ");
			} else {
				map.put("message", "Error");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return map;
	}

	public Map<String, Object> getAllEmployeesDetails() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {

			String getQuery = "select id,name,password,emailId,phone,address from employee";

			list = jdbcTemplate.queryForList(getQuery);
			if (list.isEmpty()) {
				map.put("massege", "No Data Found");
			} else {
				map.put("massege", "Success");
				map.put("list", list);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return map;
	}

	public Map<String, Object> getEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int employeeId = employee.getId();
		try {

			String getQuery = "select id,name,password,emailId,phone,address from employee where id=" + employeeId + "";

			Map<String, Object> employeeInfo = jdbcTemplate.queryForMap(getQuery);
			if (employeeInfo.isEmpty()) {
				map.put("massege", "No Data Found");
			} else {
				map.put("massege", "Success");
				map.put("employeeInfo", employeeInfo);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return map;

	}

	public Map<String, Object> updateEmployee(Map<String, Object> updateData, String updateQuery) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {

			int check = jdbcTemplate.update(updateQuery);

			if (check > 0) {
				map.put("message", "Employee Updated Successfully ");
			} else {
				map.put("message", "Error");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return map;
	}

	public Map<String, Object> deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		
		String deleteQuery="delete from employee where id="+employee.getId()+"";
		try {

			int check = jdbcTemplate.update(deleteQuery);

			if (check > 0) {
				map.put("message", "Employee Deleted Successfully ");
			} else {
				map.put("message", "Error");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}

}
