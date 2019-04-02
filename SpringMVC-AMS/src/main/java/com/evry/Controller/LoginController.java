package com.evry.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evry.Service.EmployeeService;
import com.evry.Service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired(required=true)
	LoginService service;
	
	/******************************* log In ***********************************/
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Object> login(@RequestBody Map<String, Object> EmployeeData) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("EmployeeData--- "+EmployeeData);
		try {
			
			map = service.login(EmployeeData);
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "error");
		}
		return map;
	}
}
