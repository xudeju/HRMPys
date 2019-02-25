package com.company.hrm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.hrm.service.iService.IDeptService;
import com.company.hrm.service.iService.IUserService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext();
		
		IDeptService deptService = (IDeptService) ctx.getBean("deptService");
		System.out.println(deptService);
	}
}
