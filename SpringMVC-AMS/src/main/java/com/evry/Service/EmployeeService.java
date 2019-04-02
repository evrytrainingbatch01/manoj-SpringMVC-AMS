package com.evry.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evry.Beans.Employee;
import com.evry.Dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	

	/******************************* Add Employee ***********************************/
	@Transactional
	public Map<String, Object> addEmployee(Map<String, Object> employeeData) {
		// TODO Auto-generated method stub
		//System.out.println("employeeData in service-- "+employeeData);
		Map<String, Object> map = new HashMap<String, Object>();
		Employee employee=new Employee();
		employee.setName(employeeData.get("name").toString());
		employee.setPassword(employeeData.get("password").toString());
		employee.setEmailId(employeeData.get("emailId").toString());
		employee.setPhone(employeeData.get("phone").toString());
		employee.setAddress(employeeData.get("address").toString());
		
		map=dao.addEmployee(employee);
		return map;
	}
	@Transactional
	public Map<String, Object> getAllEmployeesDetails() {
		
		return dao.getAllEmployeesDetails();
	}

	
	@Transactional
	public Map<String, Object> getEmployee(int param) {

		Employee employee=new Employee();
		employee.setId(param);
		return dao.getEmployee(employee);
	}
	
	@Transactional
	public Map<String, Object> updateEmployee(Map<String, Object> updateData) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Employee employee=new Employee();
		employee.setId(Integer.parseInt(updateData.get("EmployeeId").toString()));
		String updateQuery="";
		
		if(updateData.containsKey("name")) {
			
			updateQuery="update employee set name='"+updateData.get("name")+"' where id="+employee.getId()+" ";
			
		}else if(updateData.containsKey("password")) {
			updateQuery="update employee set name='"+updateData.get("password")+"' where id="+employee.getId()+" ";
			
		}else if(updateData.containsKey("emailId")) {
			updateQuery="update employee set name='"+updateData.get("emailId")+"' where id="+employee.getId()+" ";
			
		}else if(updateData.containsKey("address")) {
			updateQuery="update employee set name='"+updateData.get("address")+"' where id="+employee.getId()+" ";
			
		}else if(updateData.containsKey("phone")) {
			updateQuery="update employee set name='"+updateData.get("phone")+"' where id="+employee.getId()+" ";
			
		}
		map=dao.updateEmployee(updateData,updateQuery);
		
		return map;
	}
	public Map<String, Object> deleteEmployee(Map<String, Object> deleteData) {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		employee.setId(Integer.parseInt(deleteData.get("EmployeeId").toString()) );
		return dao.deleteEmployee(employee);
	}

}
