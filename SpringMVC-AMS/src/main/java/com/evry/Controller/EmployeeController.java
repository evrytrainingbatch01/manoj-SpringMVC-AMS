package com.evry.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evry.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired(required=true)
	EmployeeService service;
	
	/******************************* Add Employee ***********************************/
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> addEmployee(@RequestBody Map<String, Object> EmployeeData) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("EmployeeData--- "+EmployeeData);
		try {
			
			map = service.addEmployee(EmployeeData);
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "error");
		}
		return map;
	}
	
	
	@RequestMapping(value = "/getAllEmployeesDetails", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> getAllEmployeesDetails() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//object = new JSONObject(productData);
			map = service.getAllEmployeesDetails();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "error");
		}
		return map;
	}
	

	// ------------------------Get Employee by ID-------------------------//
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> getEmployee(@RequestParam(value=  "EmployeeId")int param) {
		Map<String, Object> users = new HashMap<String, Object>();
		System.out.println("get Employee.... "+ param);
		try {
			if (param == 0) {
				users.put("status", "error");
				return users;
			}
			users = service.getEmployee(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public Map<String, Object> updateEmployee(@RequestBody Map<String, Object> updateData) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			map = service.updateEmployee(updateData);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "error");
		}
		return map;
	}
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public Map<String, Object> deleteEmployee(@RequestBody Map<String, Object> deleteData) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			map = service.deleteEmployee(deleteData);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "error");
		}
		return map;
	}
	
}
