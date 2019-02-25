package com.company.hrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.company.hrm.common.ServiceConst;
import com.company.hrm.dao.idao.IDeptDao;
import com.company.hrm.dao.pojo.Dept;
import com.company.hrm.service.iService.IDeptService;

public class DeptServiceImpl implements IDeptService{
	IDeptDao deptdao;

	public IDeptDao getDeptdao() {
		return deptdao;
	}

	public void setDeptdao(IDeptDao deptdao) {
		this.deptdao = deptdao;
	}

	public DeptServiceImpl(IDeptDao deptdao) {
		super();
		this.deptdao = deptdao;
	}

	public DeptServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String save(Dept t) {
		try {
			deptdao.save(t);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceConst.ERROR;
		}
		return ServiceConst.SUCCESS;
	}

	@Override
	public String delete(Dept t) {
		try {
			deptdao.delete(t);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceConst.ERROR;
		}
		return ServiceConst.SUCCESS;
	}

	@Override
	public String update(Dept t) {
		try {
			deptdao.update(t);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceConst.ERROR;
		}
		return ServiceConst.SUCCESS;
	}

	@Override
	public Dept findById(Integer k) {
		Dept dept = null;
		try {
			dept = deptdao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
			return dept;
		}
		return dept;
	}

	@Override
	public List<Dept> findAll() {
		List<Dept> depts = new ArrayList<Dept>();
		try {
			depts = deptdao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return depts;
		}
		return depts;
	}

	@Override
	public List<Dept> findByPage(int page, int size) {
		List<Dept> depts = new ArrayList<Dept>();
		try {
			depts = deptdao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
			return depts;
		}
		return depts;
	}

}
