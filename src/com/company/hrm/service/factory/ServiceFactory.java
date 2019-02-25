package com.company.hrm.service.factory;

import com.company.hrm.common.DaoConst;
import com.company.hrm.service.impl.DeptServiceImpl;
import com.company.hrm.service.impl.EmpServiceImpl;
import com.company.hrm.service.impl.UserServiceImpl;

public class ServiceFactory {
	public static Object getServiceInstance(String serviceName) {
		switch (serviceName) {
		case DaoConst.EMP :
			return new EmpServiceImpl();
		case DaoConst.DEPT :
			return new DeptServiceImpl();
		case DaoConst.USER :
			return new UserServiceImpl();
		default :
			return null;
		}
	}
}
