package com.company.hrm.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.hrm.common.ErrMsg;
import com.company.hrm.common.ServiceConst;
import com.company.hrm.common.SpringIOC;
import com.company.hrm.dao.pojo.User;
import com.company.hrm.service.iService.IUserService;

@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpassword1 = request.getParameter("userpassword1");
		String userpassword2 = request.getParameter("userpassword2");
		IUserService userservice = (IUserService) SpringIOC.getContext().getBean("userService");
		HttpSession session = request.getSession();
		if (userservice.isExist(username)) {
			session.setAttribute("errmsg", ErrMsg.userErr.DUPLICATE_USERNAME);
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}else if (username.isEmpty() || userpassword1.isEmpty() || userpassword1.isEmpty()) {
			session.setAttribute("errmsg", ErrMsg.userErr.REGIST_EMPTY_ERROR);
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}else if (userpassword1.equals(userpassword2)) {
			User user = new User(username,userpassword1,ServiceConst.DEFAULT_PRIORITY);
			String msg = userservice.regist(user);
			if (msg.indexOf(ServiceConst.SUCCESS) != -1) {
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			} else {
				session.setAttribute("errmsg", ErrMsg.userErr.REGIST_ERROR);
				response.sendRedirect(request.getContextPath()+"/error.jsp");
			}
		}else {
			session.setAttribute("errmsg", ErrMsg.userErr.REGIST_PASSWORD_ERROR);
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
				
	}

}
