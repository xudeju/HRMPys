package com.company.hrm.dao.factory;

import com.company.hrm.common.DaoConst;
import com.company.hrm.dao.impl.DeptDaoImpl;
import com.company.hrm.dao.impl.EmpDaoImpl;
import com.company.hrm.dao.impl.UserDaoImpl;

public class DaoFactory {
	public static Object getDaoInstance(String daoName) {
		switch(daoName) {
		case DaoConst.EMP :
			return new EmpDaoImpl();
		case DaoConst.DEPT :
			return new DeptDaoImpl();
		case DaoConst.USER :
			return new UserDaoImpl();
		default :
			return null;
		}
	}
}
