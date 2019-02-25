package com.company.hrm.action;

import java.io.IOException;
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

@WebServlet("/EmpFindByNameServlet")
public class EmpFindByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename = request.getParameter("ename");
		IEmpService empservice =  (IEmpService)SpringIOC.getContext().getBean("empService");
		List<Emp> emplist = empservice.findByName(ename);
		HttpSession session = request.getSession();
		
		if (!emplist.isEmpty() && emplist.size()>0) {
			session.setAttribute("empListFromFindAllServlet", emplist);
			request.getRequestDispatcher("/WEB-INF/emp_main.jsp").forward(request, response);
		}else {
			session.setAttribute("errmsg",ErrMsg.empErr.FIND_BY_NAME_ERROR );
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}

}
