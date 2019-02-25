package com.company.hrm.common;

import java.util.Arrays;
import java.util.List;

import com.company.hrm.dao.pojo.Dept;
import com.company.hrm.dao.pojo.Emp;
import com.company.hrm.dao.pojo.User;
import com.company.hrm.service.factory.ServiceFactory;
import com.company.hrm.service.iService.IDeptService;
import com.company.hrm.service.iService.IEmpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMockDB {
	public static void createJsonFromEmp() throws JsonProcessingException {
		List<Emp> emps = ((IEmpService) ServiceFactory.getServiceInstance(DaoConst.EMP)).findAll();
		String empsJson = new ObjectMapper().writeValueAsString(emps);
		System.out.println(empsJson);
	}
	
	public static void createJsonFromDept() throws JsonProcessingException{
		List<Dept> depts = ((IDeptService)ServiceFactory.getServiceInstance(DaoConst.DEPT)).findAll();
		String deptsJson = new ObjectMapper().writeValueAsString(depts);
		System.out.println(deptsJson);
	}

	public static void createJsonFromUser() throws JsonProcessingException{
		List<User> users = Arrays.asList(new User(1001,"root","root",1),new User(1002,"scott","tiger",1));
		String usersJson = new ObjectMapper().writeValueAsString(users);
		System.out.println(usersJson);
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		createJsonFromDept();
		createJsonFromEmp();
		createJsonFromUser();
	}
}
