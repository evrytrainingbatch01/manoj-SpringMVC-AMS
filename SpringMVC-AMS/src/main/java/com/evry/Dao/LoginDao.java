package com.evry.Dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.evry.Beans.Employee;

@Repository
public class LoginDao {
	@Resource(name = "appJdbcTempalte")
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> Login(Employee employee) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
			String getQuery = "select id,name,password,emailId,phone,address from employee where name='" +employee.getName()+ "' and password='"+employee.getPassword()+"'";

			Map<String, Object> employeeInfo = jdbcTemplate.queryForMap(getQuery);
			if (employeeInfo.isEmpty()) {
				map.put("massege", "Invalid data");
			} else {
				map.put("massege", "Success");
				map.put("employeeInfo", employeeInfo);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}

	
}
