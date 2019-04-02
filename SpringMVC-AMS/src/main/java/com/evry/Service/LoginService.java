package com.evry.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.Beans.Employee;
import com.evry.Dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	LoginDao dao;

	public Map<String, Object> login(Map<String, Object> employeeData) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Employee employee=new Employee();
		employee.setName(employeeData.get("name").toString());
		employee.setPassword(employeeData.get("password").toString());
		
		map=dao.Login(employee);
		
		return map;
	}

}
