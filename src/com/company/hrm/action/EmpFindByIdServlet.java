package com.company.hrm.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.hrm.common.ErrMsg;
import com.company.hrm.common.SpringIOC;
import com.company.hrm.dao.pojo.Emp;
import com.company.hrm.service.iService.IEmpService;

@WebServlet("/EmpFindByIdServlet")
public class EmpFindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		IEmpService empservice = (IEmpService) SpringIOC.getContext().getBean("empService");
		Emp emp = null;
		HttpSession session = request.getSession();

		if (empservice.findById(empno) != null) {
			emp = empservice.findById(empno);
			session.setAttribute("emp", emp);
			request.getRequestDispatcher("/WEB-INF/update_emp.jsp").forward(request, response);
		}else {
			session.setAttribute("errmsg", ErrMsg.empErr.FIND_BY_ID_ERROR);
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		IEmpService empservice =  (IEmpService)SpringIOC.getContext().getBean("empService");
		Emp emp = null;
		HttpSession session = request.getSession();
		if (empservice.findById(empno) != null) {
			List<Emp> emplist = new ArrayList<Emp>();
			emp = empservice.findById(empno);
			emplist.add(emp);
			session.setAttribute("empListFromFindAllServlet", emplist);
			request.getRequestDispatcher("/WEB-INF/emp_main.jsp").forward(request, response);
		}else {
			session.setAttribute("errmsg", ErrMsg.empErr.FIND_BY_ID_ERROR);
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}

}
